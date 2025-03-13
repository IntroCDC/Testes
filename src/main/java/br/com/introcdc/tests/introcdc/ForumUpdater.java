package br.com.introcdc.tests.introcdc;

import br.com.introcdc.tests.database.StringComponents;
import club.minnced.discord.webhook.WebhookClient;
import club.minnced.discord.webhook.send.WebhookMessageBuilder;
import com.google.gson.JsonObject;

import java.io.*;
import java.sql.*;
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
            forumWebhook = WebhookClient.withUrl(StringComponents.readJson("http://localhost/config/forum").getAsJsonObject().get("text").getAsString());
            ForumUpdater.startUpdater();
        } catch (Exception exception) {
        }
    }

    // Configurações de conexão com o banco
    private static final String DB_URL = "jdbc:mysql://localhost:3306/icdcboard?dontTrackOpenResources=true&useSSL=false&serverTimezone=America/Fortaleza";
    private static final String DB_USER = "root";

    private static String password() {
        return "Op9927198041";
    }

    // Arquivo para persistir os estados de novo tópico, edição e novo membro
    private static final String STATE_FILE = "monitor_state.txt";

    // Estados salvos:
    // - lastTopicId: último ID de tópico verificado (para novos tópicos)
    // - lastEditTime: último valor de edit_time (para edição)
    // - lastMemberId: último ID de membro verificado (para novos membros)
    private static int lastTopicId = -1;
    private static long lastEditTime = -1;
    private static int lastMemberId = -1;

    public static void startUpdater() {
        loadState();

        Timer timer = new Timer();
        // Agenda a verificação a cada 60 segundos
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                checkForUpdates();
            }
        }, 0, 60000);
    }

    /**
     * Chama os testes de novo tópico, tópico editado e novo membro.
     */
    private static void checkForUpdates() {
        checkNewTopic();
        checkEditedTopic();
        checkNewMember();
    }

    /**
     * Verifica se há um novo tópico na tabela forums_topics.
     * Se o ID do tópico for maior que o lastTopicId salvo,
     * consulta também as tags (tabela core_tags), o conteúdo do post (tabela core_search_index)
     * e verifica na tabela forums_posts se há um vídeo do YouTube.
     * Em caso afirmativo, adiciona o link do YouTube na mensagem do webhook.
     */
    private static void checkNewTopic() {
        String queryNewTopic = "SELECT tid, title, title_seo FROM forums_topics ORDER BY tid DESC LIMIT 1";
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, password());
             PreparedStatement stmt = conn.prepareStatement(queryNewTopic);
             ResultSet rs = stmt.executeQuery()) {

            if (rs.next()) {
                int currentTopicId = rs.getInt("tid");
                String title = rs.getString("title");
                String slug = rs.getString("title_seo");
                String url = "https://forum.introcdc.com/topic/" + currentTopicId + "-" + slug + "/";

                // Se houver um novo tópico
                if (currentTopicId > lastTopicId) {
                    // Recupera as tags do tópico
                    String tags = "";
                    String queryTags = "SELECT tag_text FROM core_tags WHERE tag_meta_app = 'forums' AND tag_meta_id = ?";
                    try (PreparedStatement stmtTags = conn.prepareStatement(queryTags)) {
                        stmtTags.setInt(1, currentTopicId);
                        try (ResultSet rsTags = stmtTags.executeQuery()) {
                            StringBuilder tagBuilder = new StringBuilder();
                            while (rsTags.next()) {
                                if (tagBuilder.length() > 0) {
                                    tagBuilder.append(", ");
                                }
                                tagBuilder.append(rsTags.getString("tag_text"));
                            }
                            tags = tagBuilder.toString();
                        }
                    }

                    // Recupera o conteúdo do post (core_search_index)
                    String postContent = "";
                    String queryPost = "SELECT index_content FROM core_search_index WHERE index_class = ? AND index_object_id = ?";
                    try (PreparedStatement stmtPost = conn.prepareStatement(queryPost)) {
                        stmtPost.setString(1, "IPS\\forums\\Topic\\Post");
                        stmtPost.setInt(2, currentTopicId);
                        try (ResultSet rsPost = stmtPost.executeQuery()) {
                            if (rsPost.next()) {
                                postContent = rsPost.getString("index_content");
                            }
                        }
                    }

                    // Verifica se há vídeo do YouTube na tabela forums_posts
                    String youtubeLink = "";
                    String queryYoutube = "SELECT post FROM forums_posts WHERE pid = ?";
                    try (PreparedStatement stmtYoutube = conn.prepareStatement(queryYoutube)) {
                        stmtYoutube.setInt(1, currentTopicId);
                        try (ResultSet rsYoutube = stmtYoutube.executeQuery()) {
                            if (rsYoutube.next()) {
                                String postHtml = rsYoutube.getString("post");
                                Pattern pattern = Pattern.compile("src\\s*=\\s*\"https://(?:www\\.)?(youtube(?:-nocookie)?\\.com)/embed/([^\"?]+)(\\?[^\"]*)?\"");
                                Matcher matcher = pattern.matcher(postHtml);
                                if (matcher.find()) {
                                    String videoId = matcher.group(2);
                                    youtubeLink = "https://youtu.be/" + videoId;
                                }
                            }
                        }
                    }

                    // Substitui quebras de linha repetidas (considerando \r\n ou \n)
                    postContent = postContent.replaceAll("(\\r?\\n){2,}", "\n");
                    postContent = postContent.trim();

                    // Monta a mensagem para o webhook
                    String message = "\uD83C\uDD95 Novo Tópico no Fórum IntroCDC:\n"
                            + "Título: " + title + "\n"
                            + "Tags: " + tags + "\n"
                            + "Post: " + postContent + "\n"
                            + "URL: " + url;
                    if (!youtubeLink.isEmpty()) {
                        message += "\nYoutube: " + youtubeLink;
                    }
                    sendForumWebhook(message);

                    lastTopicId = currentTopicId;
                    saveState();
                }
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    /**
     * Verifica se houve edição em algum tópico.
     * Consulta a tabela forums_posts para identificar a última edição e, caso haja alteração,
     * recupera os dados do tópico (incluindo tags e post) e envia o webhook.
     * Também verifica se há um vídeo do YouTube na tabela forums_posts e, se houver,
     * adiciona o link do YouTube na mensagem.
     */
    private static void checkEditedTopic() {
        String queryLastEdit = "SELECT pid, edit_time FROM forums_posts ORDER BY edit_time DESC LIMIT 1";
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, password());
             PreparedStatement stmtEdit = conn.prepareStatement(queryLastEdit);
             ResultSet rsEdit = stmtEdit.executeQuery()) {

            if (rsEdit.next()) {
                int pid = rsEdit.getInt("pid");
                long currentEditTime = rsEdit.getLong("edit_time");

                // Se o edit_time mudou, houve edição
                if (currentEditTime != lastEditTime) {
                    String queryTopic = "SELECT title, title_seo FROM forums_topics WHERE tid = ?";
                    try (PreparedStatement stmtTopic = conn.prepareStatement(queryTopic)) {
                        stmtTopic.setInt(1, pid);
                        try (ResultSet rsTopic = stmtTopic.executeQuery()) {
                            if (rsTopic.next()) {
                                String title = rsTopic.getString("title");
                                String slug = rsTopic.getString("title_seo");
                                String url = "https://forum.introcdc.com/topic/" + pid + "-" + slug + "/";

                                // Recupera as tags do tópico
                                String tags = "";
                                String queryTags = "SELECT tag_text FROM core_tags WHERE tag_meta_app = 'forums' AND tag_meta_id = ?";
                                try (PreparedStatement stmtTags = conn.prepareStatement(queryTags)) {
                                    stmtTags.setInt(1, pid);
                                    try (ResultSet rsTags = stmtTags.executeQuery()) {
                                        StringBuilder tagBuilder = new StringBuilder();
                                        while (rsTags.next()) {
                                            if (tagBuilder.length() > 0) {
                                                tagBuilder.append(", ");
                                            }
                                            tagBuilder.append(rsTags.getString("tag_text"));
                                        }
                                        tags = tagBuilder.toString();
                                    }
                                }

                                // Recupera o conteúdo do post (core_search_index)
                                String postContent = "";
                                String queryPost = "SELECT index_content FROM core_search_index WHERE index_class = ? AND index_object_id = ?";
                                try (PreparedStatement stmtPost = conn.prepareStatement(queryPost)) {
                                    stmtPost.setString(1, "IPS\\forums\\Topic\\Post");
                                    stmtPost.setInt(2, pid);
                                    try (ResultSet rsPost = stmtPost.executeQuery()) {
                                        if (rsPost.next()) {
                                            postContent = rsPost.getString("index_content");
                                        }
                                    }
                                }

                                // Verifica se há vídeo do YouTube na tabela forums_posts
                                String youtubeLink = "";
                                String queryYoutube = "SELECT post FROM forums_posts WHERE pid = ?";
                                try (PreparedStatement stmtYoutube = conn.prepareStatement(queryYoutube)) {
                                    stmtYoutube.setInt(1, pid);
                                    try (ResultSet rsYoutube = stmtYoutube.executeQuery()) {
                                        if (rsYoutube.next()) {
                                            String postHtml = rsYoutube.getString("post");
                                            Pattern pattern = Pattern.compile("src\\s*=\\s*\"https://(?:www\\.)?(youtube(?:-nocookie)?\\.com)/embed/([^\"?]+)(\\?[^\"]*)?\"");
                                            Matcher matcher = pattern.matcher(postHtml);
                                            if (matcher.find()) {
                                                String videoId = matcher.group(2);
                                                youtubeLink = "https://youtu.be/" + videoId;
                                            }
                                        }
                                    }
                                }

                                // Substitui quebras de linha repetidas (considerando \r\n ou \n)
                                postContent = postContent.replaceAll("(\\r?\\n){2,}", "\n");
                                postContent = postContent.trim();

                                // Monta a mensagem para o webhook
                                String message = "\u270F\uFE0F Tópico Editado no Fórum IntroCDC:\n"
                                        + "Título: " + title + "\n"
                                        + "Tags: " + tags + "\n"
                                        + "Post: " + postContent + "\n"
                                        + "URL: " + url;
                                if (!youtubeLink.isEmpty()) {
                                    message += "\nYoutube: " + youtubeLink;
                                }
                                sendForumWebhook(message);

                                lastEditTime = currentEditTime;
                                saveState();
                            }
                        }
                    }
                }
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    /**
     * Verifica se um novo membro foi adicionado na tabela core_members.
     * Se o member_id for maior que o lastMemberId salvo, envia o webhook e atualiza o estado.
     */
    private static void checkNewMember() {
        String queryNewMember = "SELECT member_id, name, members_seo_name FROM core_members ORDER BY member_id DESC LIMIT 1";
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, password());
             PreparedStatement stmt = conn.prepareStatement(queryNewMember);
             ResultSet rs = stmt.executeQuery()) {

            if (rs.next()) {
                int currentMemberId = rs.getInt("member_id");
                String name = rs.getString("name");
                String seoName = rs.getString("members_seo_name");
                String url = "https://forum.introcdc.com/profile/" + currentMemberId + "-" + seoName + "/?tab=field_core_pfield_1";

                if (currentMemberId > lastMemberId) {
                    String message = "\uD83D\uDC64 Novo membro adicionado no Fórum IntroCDC: " + name + " - " + url;
                    sendForumWebhook(message);

                    lastMemberId = currentMemberId;
                    saveState();
                }
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    /**
     * Envia o webhook com a mensagem informada.
     */
    private static void sendForumWebhook(String content) {
        WebhookMessageBuilder builder = new WebhookMessageBuilder();
        builder.setUsername("Forum IntroCDC");
        builder.setAvatarUrl("http://forum.introcdc.com/uploads/monthly_2022_03/Webp.net-resizeimage.png.d3a49320fdcce4de59f2d9b9cfb6d91e.png");
        builder.setContent(content);

        getForumWebhook().send(builder.build());
    }

    /**
     * Carrega o estado salvo a partir do arquivo STATE_FILE.
     * O arquivo deve ter até três linhas:
     * - Linha 1: lastTopicId
     * - Linha 2: lastEditTime
     * - Linha 3: lastMemberId
     */
    private static void loadState() {
        File file = new File(STATE_FILE);
        if (file.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line = reader.readLine();
                if (line != null) {
                    lastTopicId = Integer.parseInt(line.trim());
                }
                line = reader.readLine();
                if (line != null && !line.trim().equals("null")) {
                    lastEditTime = Long.parseLong(line.trim());
                }
                line = reader.readLine();
                if (line != null && !line.trim().equals("null")) {
                    lastMemberId = Integer.parseInt(line.trim());
                }
                System.out.println("Estado carregado: lastTopicId = " + lastTopicId
                        + ", lastEditTime = " + lastEditTime
                        + ", lastMemberId = " + lastMemberId);
            } catch (IOException | IllegalArgumentException e) {
                System.err.println("Erro ao carregar o estado: " + e.getMessage());
            }
        } else {
            System.out.println("Nenhum estado salvo encontrado. Iniciando com valores padrão.");
        }
    }

    /**
     * Salva o estado atual em um arquivo local.
     */
    private static void saveState() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(STATE_FILE))) {
            writer.println(lastTopicId);
            writer.println(lastEditTime);
            writer.println(lastMemberId);
            System.out.println("Estado salvo: lastTopicId = " + lastTopicId
                    + ", lastEditTime = " + lastEditTime
                    + ", lastMemberId = " + lastMemberId);
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
