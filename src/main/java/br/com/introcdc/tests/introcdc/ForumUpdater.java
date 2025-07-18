package br.com.introcdc.tests.introcdc;

import br.com.introcdc.tests.database.StringComponents;
import club.minnced.discord.webhook.WebhookClient;
import club.minnced.discord.webhook.send.WebhookMessageBuilder;
import com.google.gson.JsonObject;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ForumUpdater {

    private static String TOKEN;
    private static WebhookClient forumWebhook;

    public static WebhookClient getForumWebhook() {
        return forumWebhook;
    }

    public static void main(String[] args) {
        loadDiscordBot();
    }

    public static void loadDiscordBot() {
        Thread.currentThread().setName("DiscordBot Thread");
        try {
            setupAccountSetting();
            forumWebhook = WebhookClient.withUrl(
                    StringComponents.readJson("http://localhost/config/forum")
                            .getAsJsonObject()
                            .get("text").getAsString()
            );
            ForumUpdater.startUpdater();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    // Configurações de conexão com o banco
    private static final String DB_URL =
            "jdbc:mysql://localhost:3306/icdcboard?dontTrackOpenResources=true&useSSL=false&serverTimezone=America/Fortaleza";
    private static final String DB_USER = "root";

    private static String password() {
        return "Op9927198041";
    }

    // Arquivo para persistir estados
    private static final String STATE_FILE = "monitor_state.txt";
    private static int lastTopicId = -1;
    private static long lastEditTime = -1;
    private static int lastMemberId = -1;

    public static void startUpdater() {
        loadState();
        Timer timer = new Timer();
        // Executa a cada 60 segundos
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                checkForUpdates();
            }
        }, 0, 60000);
    }

    private static void checkForUpdates() {
        checkNewTopic();
        checkEditedTopic();
        checkNewMember();
    }

    private static void checkNewTopic() {
        String queryNewTopic =
                "SELECT tid, title, title_seo FROM forums_topics ORDER BY tid DESC LIMIT 1";
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, password());
             PreparedStatement stmt = conn.prepareStatement(queryNewTopic);
             ResultSet rs = stmt.executeQuery()) {

            if (rs.next()) {
                int currentTopicId = rs.getInt("tid");
                String title = rs.getString("title");
                String slug = rs.getString("title_seo");
                String url = "https://forum.introcdc.com/topic/" + currentTopicId + "-" + slug + "/";

                if (currentTopicId > lastTopicId) {
                    // Recupera tags
                    String tags = "";
                    String queryTags =
                            "SELECT tag_text FROM core_tags WHERE tag_meta_app = 'forums' AND tag_meta_id = ?";
                    try (PreparedStatement stmtTags = conn.prepareStatement(queryTags)) {
                        stmtTags.setInt(1, currentTopicId);
                        try (ResultSet rsTags = stmtTags.executeQuery()) {
                            StringBuilder tagBuilder = new StringBuilder();
                            while (rsTags.next()) {
                                if (tagBuilder.length() > 0) tagBuilder.append(", ");
                                tagBuilder.append(rsTags.getString("tag_text"));
                            }
                            tags = tagBuilder.toString();
                        }
                    }

                    // Recupera conteúdo do post
                    String postContent = "";
                    String queryPost =
                            "SELECT index_content FROM core_search_index WHERE index_class = ? AND index_object_id = ?";
                    try (PreparedStatement stmtPost = conn.prepareStatement(queryPost)) {
                        stmtPost.setString(1, "IPS\\forums\\Topic\\Post");
                        stmtPost.setInt(2, currentTopicId);
                        try (ResultSet rsPost = stmtPost.executeQuery()) {
                            if (rsPost.next()) {
                                postContent = rsPost.getString("index_content");
                            }
                        }
                    }

                    // Busca múltiplos vídeos do YouTube
                    List<String> youtubeLinks = new ArrayList<>();
                    String queryYoutube = "SELECT post FROM forums_posts WHERE pid = ?";
                    try (PreparedStatement stmtYoutube = conn.prepareStatement(queryYoutube)) {
                        stmtYoutube.setInt(1, currentTopicId);
                        try (ResultSet rsYoutube = stmtYoutube.executeQuery()) {
                            if (rsYoutube.next()) {
                                String postHtml = rsYoutube.getString("post");
                                Pattern pattern = Pattern.compile(
                                        "src\\s*=\\s*\"https://(?:www\\.)?(youtube(?:-nocookie)?\\.com)/embed/([^\"?]+)(\\?[^\"]*)?\""
                                );
                                Matcher matcher = pattern.matcher(postHtml);
                                while (matcher.find()) {
                                    String videoId = matcher.group(2);
                                    youtubeLinks.add("https://youtu.be/" + videoId);
                                }
                            }
                        }
                    }

                    // Limpa quebras de linha repetidas
                    postContent = postContent.replaceAll("(\\r?\\n){2,}", "\n").trim();

                    // Monta a mensagem
                    String message = "\uD83C\uDD95 Novo Tópico no Fórum IntroCDC:\n"
                            + "Título: " + title + "\n"
                            + "Tags: " + tags + "\n"
                            + "Post: " + postContent + "\n"
                            + "URL: " + url;
                    // Adiciona todos os links do YouTube
                    for (String link : youtubeLinks) {
                        message += "\nYoutube: " + link;
                    }

                    lastTopicId = currentTopicId;
                    saveState();
                    sendForumWebhookSplit(message);
                }
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    private static void checkEditedTopic() {
        String queryLastEdit =
                "SELECT pid, edit_time FROM forums_posts ORDER BY edit_time DESC LIMIT 1";
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, password());
             PreparedStatement stmtEdit = conn.prepareStatement(queryLastEdit);
             ResultSet rsEdit = stmtEdit.executeQuery()) {

            if (rsEdit.next()) {
                int pid = rsEdit.getInt("pid");
                long currentEditTime = rsEdit.getLong("edit_time");

                if (currentEditTime != lastEditTime) {
                    // Recupera dados do tópico editado
                    String queryTopic =
                            "SELECT title, title_seo FROM forums_topics WHERE tid = ?";
                    try (PreparedStatement stmtTopic = conn.prepareStatement(queryTopic)) {
                        stmtTopic.setInt(1, pid);
                        try (ResultSet rsTopic = stmtTopic.executeQuery()) {
                            if (rsTopic.next()) {
                                String title = rsTopic.getString("title");
                                String slug = rsTopic.getString("title_seo");
                                String url = "https://forum.introcdc.com/topic/" + pid + "-" + slug + "/";
                                if (pid == 3278) {
                                    lastEditTime = currentEditTime;
                                    saveState();
                                    return;
                                }

                                // Tags
                                String tags = "";
                                String queryTags =
                                        "SELECT tag_text FROM core_tags WHERE tag_meta_app = 'forums' AND tag_meta_id = ?";
                                try (PreparedStatement stmtTags = conn.prepareStatement(queryTags)) {
                                    stmtTags.setInt(1, pid);
                                    try (ResultSet rsTags = stmtTags.executeQuery()) {
                                        StringBuilder tagBuilder = new StringBuilder();
                                        while (rsTags.next()) {
                                            if (tagBuilder.length() > 0) tagBuilder.append(", ");
                                            tagBuilder.append(rsTags.getString("tag_text"));
                                        }
                                        tags = tagBuilder.toString();
                                    }
                                }

                                // Conteúdo editado
                                String postContent = "";
                                String queryPost =
                                        "SELECT index_content FROM core_search_index WHERE index_class = ? AND index_object_id = ?";
                                try (PreparedStatement stmtPost = conn.prepareStatement(queryPost)) {
                                    stmtPost.setString(1, "IPS\\forums\\Topic\\Post");
                                    stmtPost.setInt(2, pid);
                                    try (ResultSet rsPost = stmtPost.executeQuery()) {
                                        if (rsPost.next()) {
                                            postContent = rsPost.getString("index_content");
                                        }
                                    }
                                }

                                // Links múltiplos do YouTube
                                List<String> youtubeLinks = new ArrayList<>();
                                String queryYoutube = "SELECT post FROM forums_posts WHERE pid = ?";
                                try (PreparedStatement stmtYoutube = conn.prepareStatement(queryYoutube)) {
                                    stmtYoutube.setInt(1, pid);
                                    try (ResultSet rsYoutube = stmtYoutube.executeQuery()) {
                                        if (rsYoutube.next()) {
                                            String postHtml = rsYoutube.getString("post");
                                            Pattern pattern = Pattern.compile(
                                                    "src\\s*=\\s*\"https://(?:www\\.)?(youtube(?:-nocookie)?\\.com)/embed/([^\"?]+)(\\?[^\"]*)?\""
                                            );
                                            Matcher matcher = pattern.matcher(postHtml);
                                            while (matcher.find()) {
                                                String videoId = matcher.group(2);
                                                youtubeLinks.add("https://youtu.be/" + videoId);
                                            }
                                        }
                                    }
                                }

                                postContent = postContent.replaceAll("(\\r?\\n){2,}", "\n").trim();

                                // Monta a mensagem
                                String message = "\u270F\uFE0F Tópico Editado no Fórum IntroCDC:\n"
                                        + "Título: " + title + "\n"
                                        + "Tags: " + tags + "\n"
                                        + "Post: " + postContent + "\n"
                                        + "URL: " + url;
                                for (String link : youtubeLinks) {
                                    message += "\nYoutube: " + link;
                                }

                                lastEditTime = currentEditTime;
                                saveState();
                                sendForumWebhookSplit(message);
                            }
                        }
                    }
                }
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    private static void checkNewMember() {
        String queryNewMember =
                "SELECT member_id, name, members_seo_name FROM core_members ORDER BY member_id DESC LIMIT 1";
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, password());
             PreparedStatement stmt = conn.prepareStatement(queryNewMember);
             ResultSet rs = stmt.executeQuery()) {

            if (rs.next()) {
                int currentMemberId = rs.getInt("member_id");
                String name = rs.getString("name");
                String seoName = rs.getString("members_seo_name");
                String url = "https://forum.introcdc.com/profile/" + currentMemberId + "-" + seoName + "/?tab=field_core_pfield_1";

                if (currentMemberId > lastMemberId) {
                    String message = "\uD83D\uDC64 Novo membro adicionado no Fórum IntroCDC: "
                            + name + " - " + url;
                    sendForumWebhookSplit(message);
                    lastMemberId = currentMemberId;
                    saveState();
                }
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    private static void sendForumWebhook(String content) {
        WebhookMessageBuilder builder = new WebhookMessageBuilder();
        builder.setUsername("Forum IntroCDC");
        builder.setAvatarUrl(
                "http://forum.introcdc.com/uploads/monthly_2022_03/Webp.net-resizeimage.png.d3a49320fdcce4de59f2d9b9cfb6d91e.png"
        );
        builder.setContent(content);
        getForumWebhook().send(builder.build());
    }

    private static void sendForumWebhookSplit(String content) {
        final int maxLength = 2000;
        if (content.length() <= maxLength) {
            sendForumWebhook(content);
            return;
        }
        int start = 0;
        while (start < content.length()) {
            int end = Math.min(start + maxLength, content.length());
            int lastNewline = content.lastIndexOf('\n', end);
            if (lastNewline <= start) lastNewline = end;
            String part = content.substring(start, lastNewline);
            sendForumWebhook(part);
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            start = lastNewline;
            if (start < content.length() && content.charAt(start) == '\n') {
                start++;
            }
        }
    }

    private static void loadState() {
        File file = new File(STATE_FILE);
        if (file.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line = reader.readLine();
                if (line != null) lastTopicId = Integer.parseInt(line.trim());
                line = reader.readLine();
                if (line != null && !line.trim().equals("null")) lastEditTime = Long.parseLong(line.trim());
                line = reader.readLine();
                if (line != null && !line.trim().equals("null")) lastMemberId = Integer.parseInt(line.trim());
                System.out.println("Estado carregado: lastTopicId=" + lastTopicId
                        + ", lastEditTime=" + lastEditTime
                        + ", lastMemberId=" + lastMemberId);
            } catch (IOException | IllegalArgumentException e) {
                System.err.println("Erro ao carregar o estado: " + e.getMessage());
            }
        } else {
            System.out.println("Nenhum estado salvo encontrado. Iniciando com valores padrão.");
        }
    }

    private static void saveState() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(STATE_FILE))) {
            writer.println(lastTopicId);
            writer.println(lastEditTime);
            writer.println(lastMemberId);
            System.out.println("Estado salvo: lastTopicId=" + lastTopicId
                    + ", lastEditTime=" + lastEditTime
                    + ", lastMemberId=" + lastMemberId);
        } catch (IOException e) {
            System.err.println("Erro ao salvar o estado: " + e.getMessage());
        }
    }

    public static void setupAccountSetting() throws IOException {
        if (System.getProperty("discordToken") == null) {
            JsonObject object = StringComponents.readJson("http://localhost/passwords").getAsJsonObject();
            TOKEN = object.get("discordToken").getAsString();
        } else {
            TOKEN = System.getProperty("discordToken");
        }
    }

}
