package br.com.introcdc.tests.introcdc;
/*
 * Written by IntroCDC, Bruno Coelho at 21/12/2022 - 07:02
 */

import br.com.introcdc.tests.database.DatabaseUtils;
import br.com.introcdc.tests.database.GlobalDatabase;
import br.com.introcdc.tests.database.StringComponents;
import br.com.introcdc.tests.database.query.OrderType;
import com.google.common.collect.ImmutableMap;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.List;
import java.util.*;

public class ForumMethods {

    public static void main(String[] args) throws Exception {
        if (args.length != 1) {
            createMostMentionedTopic();
        } else {
            if (args[0].equalsIgnoreCase("mosttags")) {
                createMostMentionedTopic();
            } else if (args[0].equalsIgnoreCase("stats")) {
                forumStatistics();
            } else if (args[0].equalsIgnoreCase("export")) {
                exportForum();
            }
        }
    }

    public static void initializeForum() throws Exception {
        GlobalDatabase.DATABASE = "icdcboard";
        DatabaseUtils.reloadConnection();
    }

    public static final List<String> TOTAL = StringComponents.arrayList();
    public static final List<String> LINES = StringComponents.arrayList();

    public static void createMostMentionedTopic() throws Exception {
        System.out.println("INICIANDO...");
        initializeForum();
        startingTopic();
        mostUsedWithTag("canal");
        eachYearTags();
        totalMostUsedTags();
        System.out.println("PRONTO!!!!!!!");

        PrintWriter writer = new PrintWriter("F:/Documentos/Random/mosttags.txt");
        for (String line : TOTAL) {
            writer.println(line);
        }
        for (String line : LINES) {
            writer.println(line);
        }
        writer.flush();
        writer.close();
        System.out.println("ARQUIVO CRIADO!");
    }

    public static void exportForum() throws Exception {
        initializeForum();
        Map<Integer, String> title = StringComponents.hashMap();
        List<String> lines = StringComponents.arrayList();
        ResultSet resultSet = DatabaseUtils.selectFromTable("forums_topics").orderBy(OrderType.ASC, "tid").executeQuery();
        while (resultSet.next()) {
            title.put(resultSet.getInt("tid"), resultSet.getString("title"));
        }
        ResultSet set = DatabaseUtils.selectFromTable("forums_posts").orderBy(OrderType.ASC, "pid").executeQuery();
        while (set.next()) {
            int id = set.getInt("pid");
            lines.add("Tópico #" + id + " - " + title.get(id) + " - " + StringComponents.toDate(set.getLong("post_date") * 1000));
            lines.add(set.getString("post"));
            lines.add("");
        }
        Path outputFile = Paths.get("topics.txt");
        Files.write(outputFile, lines);
    }

    public static void totalMostUsedTags() throws Exception {
        Map<String, Integer> usedTags = StringComponents.hashMap();

        System.out.print("Processando: TOTAL");

        ResultSet resultSet = DatabaseUtils.selectFromTable("core_tags").executeQuery();
        while (resultSet.next()) {
            String tag = resultSet.getString("tag_text");
            usedTags.put(tag, usedTags.getOrDefault(tag, 0) + 1);
        }

        createList(usedTags, "TOTAL", 100);
    }

    public static void eachYearTags() throws Exception {
        for (int year = 2025; year >= 1999; year--) {
            mostUsedWithTag(String.valueOf(year));
        }
    }

    public static final Map<String, String> lastYear = StringComponents.hashMap();
    public static final Map<String, String> firstYear = StringComponents.hashMap();

    public static void mostUsedWithTag(String search) throws Exception {
        System.out.print("Processando: " + search.toUpperCase());

        ResultSet topicSet = DatabaseUtils.selectFromTable("core_tags").whereEquals("tag_text", search).executeQuery();
        List<Integer> topicList = StringComponents.arrayList();
        while (topicSet.next()) {
            int topic = topicSet.getInt("tag_meta_id");
            if (!topicList.contains(topic)) {
                topicList.add(topic);
            }
        }

        Map<String, Integer> usedTags = StringComponents.hashMap();
        for (int topic : topicList) {
            ResultSet resultSet = DatabaseUtils.selectFromTable("core_tags").whereEquals("tag_meta_id", topic).executeQuery();
            while (resultSet.next()) {
                String tag = resultSet.getString("tag_text");
                if (!search.equalsIgnoreCase("canal")) {
                    if (!lastYear.containsKey(tag)) {
                        lastYear.put(tag, search);
                    }
                    firstYear.put(tag, search);
                }
                usedTags.put(tag, usedTags.getOrDefault(tag, 0) + 1);
            }
        }

        createList(usedTags, search, 10);
    }

    public static void createList(Map<String, Integer> usedTags, String title, int limit) throws Exception {
        boolean totall = title.equalsIgnoreCase("TOTAL");
        System.out.println(" PRONTO! (" + title + ")");
        if (totall) {
            TOTAL.add("<hr width=\"100%\">");
            TOTAL.add("<p>");
            TOTAL.add("\t<span style=\"font-size:26px;\"><strong>" + title.toUpperCase() + "</strong></span>");
            TOTAL.add("</p>");
        } else {
            LINES.add("<hr width=\"100%\">");
            LINES.add("<p>");
            LINES.add("\t<span style=\"font-size:26px;\"><strong>" + title.toUpperCase() + "</strong></span>");
            LINES.add("</p>");
        }

        int total = 0;
        stateTag(title, true);
        int current = 0;
        while (!usedTags.isEmpty()) {
            current++;
            if (current > limit) {
                break;
            }

            String bigger = null;
            int biggerNumber = -1;
            for (String key : usedTags.keySet()) {
                int number = usedTags.get(key);
                if (number > biggerNumber) {
                    bigger = key;
                    biggerNumber = number;
                }
            }

            if (bigger == null) {
                break;
            }
            usedTags.remove(bigger);
            if (!printTagInfo(title, bigger + ": " + biggerNumber)) {
                current--;
            }
            total += biggerNumber;
        }
        stateTag(title, false);
    }

    public static boolean filterTag(String tag) {
        if (StringComponents.isInt(tag.replace("bs", "").replace("ib", "").replace("v", "").replace("b", "").replace("a", "").replace("...", "").replace("..", "").replace(".", ""))) {
            return false;
        }
        return !IGNORE_TAGS.contains(StringComponents.removeAcents(tag).toLowerCase());
    }

    public static boolean printTagInfo(String title, String tagInfo) throws Exception {
        boolean totall = title.equalsIgnoreCase("TOTAL");
        String tag = tagInfo.split(": ")[0];
        String number = tagInfo.split(": ")[1];
        StringBuilder builder = new StringBuilder();
        for (String word : tag.split(" ")) {
            builder.append(word.toUpperCase().toCharArray()[0]).append(word.substring(1)).append(" ");
        }
        if (!filterTag(tag)) {
            return false;
        }
        boolean simple = false;
        if (simple) {
            if (totall) {
                TOTAL.add(tagInfo);
            } else {
                LINES.add(tagInfo);
            }
        } else {
            String plus = "";
            ResultSet set = DatabaseUtils.selectFromTable("core_members").whereEquals("name", tag).executeQuery();
            if (set.next()) {
                plus = " <i><a href=\"http://forum.introcdc.com/profile/" + set.getInt("member_id") + "-" + set.getString("members_seo_name") + "/?tab=field_core_pfield_1\" target=\"+blank\">(perfil)</i></a>";
            }
            String tagString = String.valueOf(builder.toString().subSequence(0, builder.toString().length() - 1));
            if (totall) {
                int years = Integer.parseInt(lastYear.get(tagString.toLowerCase())) - Integer.parseInt(firstYear.get(tagString.toLowerCase()));
                plus += " <i>[Primeira menção: " + firstYear.get(tagString.toLowerCase()) + " - Última menção: " + lastYear.get(tagString.toLowerCase()) + " - Tempo: " +
                        years + " " + StringComponents.plus("ano", "s", years) + "]</i>";
                TOTAL.add("\t<li>");
                TOTAL.add("\t\t<strong><a href=\"http://forum.introcdc.com/tags/" + tag.replace(" ", "%20") + "\" target=\"_blank\">" + tagString + "</a></strong><span><strong>:</strong> " + number + " menções" + (TAG_DESCRIPTION.containsKey(StringComponents.removeAcents(tagString.toLowerCase())) ? " // " + TAG_DESCRIPTION.get(StringComponents.removeAcents(tagString.toLowerCase())) : "") + plus);
                TOTAL.add("\t</li>");
            } else {
                LINES.add("\t<li>");
                LINES.add("\t\t<strong><a href=\"http://forum.introcdc.com/tags/" + tag.replace(" ", "%20") + "\" target=\"_blank\">" + tagString + "</a></strong><span><strong>:</strong> " + number + " menções" + (TAG_DESCRIPTION.containsKey(StringComponents.removeAcents(tagString.toLowerCase())) ? " // " + TAG_DESCRIPTION.get(StringComponents.removeAcents(tagString.toLowerCase())) : "") + plus);
                LINES.add("\t</li>");
            }
        }
        return true;
    }

    public static void stateTag(String title, boolean open) {
        boolean totall = title.equalsIgnoreCase("total");
        if (open) {
            if (totall) {
                TOTAL.add("<ol>");
            } else {
                LINES.add("<ol>");
            }
        } else {
            if (totall) {
                TOTAL.add("</ol>");
            } else {
                LINES.add("</ol>");
            }
        }
    }

    public static void startingTopic() {
        TOTAL.add("<p>");
        TOTAL.add("\t<span style=\"font-size:36px;\"><strong>OFF-TOPIC</strong></span>");
        TOTAL.add("</p>");
        TOTAL.add("");
        TOTAL.add("<hr width=\"100%\">");
        TOTAL.add("<ul>");
        TOTAL.add("\t<li>");
        TOTAL.add("\t\tTipo: Estat&iacute;stica");
        TOTAL.add("\t</li>");
        TOTAL.add("\t<li>");
        TOTAL.add("\t\t&Uacute;ltima Atualiza&ccedil;&atilde;o: " + StringComponents.currentDate());
        TOTAL.add("\t</li>");
        TOTAL.add("</ul>");
    }

    public static void searchWithoutYearTopics() throws Exception {
        initializeForum();
        List<Integer> ignore = StringComponents.arrayList();
        System.out.println("Iniciando...");
        for (int year = 1999; year <= 2023; year++) {
            System.out.println("Listando " + year + "...");
            ResultSet resultSet = DatabaseUtils.selectFromTable("core_tags").whereEquals("tag_text", year).executeQuery();
            while (resultSet.next()) {
                int topic = resultSet.getInt("tag_meta_id");
                if (!ignore.contains(topic)) {
                    ignore.add(topic);
                }
            }
        }
        for (int i = 1; i <= 3282; i++) {
            if (ignore.contains(i)) {
                continue;
            }
            System.out.println("Tópico sem ano: http://forum.introcdc.com/topic/" + i + "-searching/");
        }
    }

    public static void forumStatistics() throws Exception {
        initializeForum();

        long topics = 0;
        long chars = 0;
        long fchars = 0;
        long words = 0;
        long letters = 0;
        ResultSet result = DatabaseUtils.selectFromTable("core_search_index").executeQuery();

        while (result.next()) {
            String rawContent = result.getString("index_content").replace("\n", " ");
            String content = rawContent.replace("  ", " ");
            topics++;
            fchars += rawContent.length();
            chars += content.length();
            letters += content.replace(" ", "").length();
            words += content.split(" ").length;
        }

        System.out.println("Estatísticas do fórum:");
        System.out.println("Tópicos: " + format(topics));
        System.out.println("Caracteres: " + format(fchars) + " (" + format(chars) + ")");
        System.out.println("Letras: " + format(letters) + " - Palavras: " + format(words));
    }

    public static void historicalTagUse() throws Exception {
        int top = 60;
        JTextArea label = new JTextArea("Inicializando...");
        label.setEditable(false);
        JFrame window = new JFrame("TOP " + top + " PESSOAS MAIS MENCIONADAS" + (paused ? " - " + CONTINUE : ""));
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLayout(new BorderLayout());
        window.setSize(500, 1030);
        window.add(label);
        window.setVisible(inJava);
        window.setLocationRelativeTo(null);

        initializeForum();
        List<Integer> forums = StringComponents.arrayList();
        System.out.println("Iniciando... Organizando fórums...");
        for (int year = 1999; year <= 2023; year++) {
            for (String month : new String[]{"janeiro", "fevereiro", "março", "abril", "maio", "junho", "julho", "agosto", "setembro", "outubro", "novembro", "dezembro"}) {
                ResultSet set = DatabaseUtils.selectFromTable("forums_forums").whereEquals("name_seo", month + year).executeQuery();
                if (set.next()) {
                    int id = set.getInt("id");
                    forumsName.put(id, month.toUpperCase() + "/" + year);
                    forums.add(id);
                }
            }
        }
        System.out.println("Criando mapa de tópicos...");
        List<String> tagHistory1 = StringComponents.arrayList();
        List<String> tagHistory2 = StringComponents.arrayList();
        Map<String, Integer> tagUses = StringComponents.hashMap();
        int current = 0;
        for (int forum : forums) {
            currentForum = forum;
            ResultSet set = DatabaseUtils.selectFromTable("core_tags").whereEquals("tag_meta_parent_id", forum).orderBy(OrderType.ASC, "tag_meta_id").executeQuery();
            tagHistory1.add(">>>> " + forumsName.get(forum));
            tagHistory2.add(">>>> " + forumsName.get(forum));
            topic = forumsName.get(forum);

            Map<String, Integer> uses = StringComponents.hashMap();
            while (set.next()) {
                String tag = set.getString("tag_text");
                if (!filterTag(tag)) {
                    continue;
                }
                int topic = set.getInt("tag_meta_id");
                if (!topics.contains(topic)) {
                    topics.add(topic);
                }
                if (perMember) {
                    uses.put(tag, uses.getOrDefault(tag, 0) + 1);
                } else {
                    tagHistory1.add(tag + "---" + new Random().nextInt(1_000_000));
                    tagUses.put(tag, tagUses.getOrDefault(tag, 0) + 1);
                    tagHistory2.add(tag + ":" + tagUses.get(tag));
                    updateLastText(tagUses, top, forumsName.get(forum), label);
                }
            }
            if (perMember) {
                for (String tag : uses.keySet()) {
                    for (int i = 1; i <= uses.get(tag); i++) {
                        tagHistory1.add(tag + "---" + new Random().nextInt(1_000_000));
                        tagUses.put(tag, tagUses.getOrDefault(tag, 0) + 1);
                        tagHistory2.add(tag + ":" + tagUses.get(tag));
                        if (inJava) {
                            updateLastText(tagUses, top, forumsName.get(forum), label);
                        }
                    }
                }
            }
            current++;
        }
        if (inJava) {
            System.out.println("ACABOU!");
            return;
        }

        System.out.println("PRONTO, CRIANDO ARQUIVOS...");
        PrintWriter writer1 = new PrintWriter("src/main/resources/forum/taghistory1.txt");
        for (String line : tagHistory1) {
            writer1.println(line.split("---")[0]);
        }
        writer1.flush();
        writer1.close();

        PrintWriter writer2 = new PrintWriter("src/main/resources/forum/taghistory2.txt");
        for (String line : tagHistory2) {
            writer2.println(line);
        }
        writer2.flush();
        writer2.close();
        System.out.println("ARQUIVOS CRIADOS!");
    }

    public static String format(long numero) {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setGroupingSeparator('.');
        DecimalFormat decimalFormat = new DecimalFormat("#,###", symbols);
        return decimalFormat.format(numero);
    }

    public static final boolean inJava = true;
    public static final boolean perMember = true;
    public static int currentForum = 0;
    public static String topic = "NÃO DEFINIDO";
    public static String lastText = "";
    public static final Map<String, Integer> lastPosition = StringComponents.hashMap();
    public static final Map<String, Integer> lastPoints = StringComponents.hashMap();
    public static final long started = System.currentTimeMillis();
    public static final String CONTINUE = null;
    public static boolean reach = false;
    public static final boolean paused = CONTINUE != null;
    public static final Map<Integer, String> forumsName = StringComponents.hashMap();
    public static String updated = "";
    public static final List<String> total = StringComponents.arrayList();
    public static final List<Integer> topics = StringComponents.arrayList();

    public static boolean updateLastText(Map<String, Integer> topMap, int top, String topic, JTextArea label) throws Exception {
        List<String> ignore = StringComponents.arrayList();
        List<String> mentioned = StringComponents.arrayList();
        boolean update = false;
        int point = 0;
        String lastUp = updated;
        int newPos = 0;
        boolean newAppear = false;
        boolean newest = false;
        List<String> lines = StringComponents.arrayList();
        boolean upgrade = false;
        for (int i = 1; i <= top; i++) {
            int bigger = 0;
            int invert = (top + 1) - i;
            String biggerText = null;
            for (String key : topMap.keySet()) {
                if (ignore.contains(key)) {
                    continue;
                }
                if (topMap.get(key) > bigger) {
                    bigger = topMap.get(key);
                    biggerText = key;
                }
            }

            if (biggerText == null) {
                lines.add("\n#" + i + ": ...");
                continue;
            }
            String plus;
            String suffix = "";
            if (lastPosition.containsKey(biggerText)) {
                if (lastPosition.get(biggerText) != invert) {
                    if (lastPosition.get(biggerText) < invert) {
                        plus = " [+" + (invert - lastPosition.get(biggerText)) + "]";
                        newPos = i;
                    } else {
                        plus = " [-" + (lastPosition.get(biggerText) - invert) + "] <<<<<<<<<<<<";
                        upgrade = true;
                    }
                    update = true;
                } else {
                    plus = "";
                }
            } else {
                update = true;
                newAppear = true;
                if (!total.contains(biggerText)) {
                    total.add(biggerText);
                    newest = true;
                    plus = " [***]";
                } else {
                    plus = " [*]";
                }
            }
            lastPosition.put(biggerText, invert);
            boolean subUpdate = false;
            if (lastPoints.containsKey(biggerText)) {
                if (lastPoints.get(biggerText) != bigger) {
                    suffix = " +++++++++++++++++++++++++";
                    update = true;
                    subUpdate = true;
                }
            } else {
                suffix = " +++++++++++++++++++++++++";
                update = true;
                subUpdate = true;
            }
            lastPoints.put(biggerText, bigger);

            if (subUpdate) {
                point = bigger;
                updated = biggerText;
            }
            mentioned.add(biggerText);
            ignore.add(biggerText);
            lines.add("\n#" + i + ": " + biggerText + ": " + (subUpdate ? "---" : bigger) + plus + suffix);
        }
        for (String key : new ArrayList<>(lastPosition.keySet())) {
            if (!mentioned.contains(key)) {
                lastPosition.remove(key);
                lastPoints.remove(key);
            }
        }

        if (!update) {
            return false;
        }

        if (paused) {
            if (!reach && forumsName.get(currentForum).equals(CONTINUE)) {
                reach = true;
            }
        }

        int invert = (top + 1) - lastPosition.getOrDefault(updated, top);
        String plus = ": ADICIONANDO PARA: " + updated + " (#" + invert + " - " + lastPoints.getOrDefault(updated, 0) + ") - " + topics.size() + " tópicos";
        boolean ignoreAudio = paused && !reach;
        int delay = ignoreAudio ? 2 : 500;
        boolean pause = false;
        if (perMember) {
            if (!Objects.equals(lastUp, updated)) {
                pause = true;
            }
        }
        if (pause) {
            if (!ignoreAudio) {
                new Thread(() -> playSound("src/main/resources/forum/end.wav")).start();
            }
            Thread.sleep(delay * 2);
        }

        StringBuilder stringBuilder = new StringBuilder(topic + plus);
        for (String line : lines) {
            stringBuilder.append(line);
        }
        if (!lastText.equals(stringBuilder.toString())) {
            stringBuilder.append("\nTempo executando: ").append(StringComponents.completeTime((System.currentTimeMillis() - started) / 1000));
            label.setText(stringBuilder.toString().replace(updated + ": ---", updated + ": " + (point - 1)));

            Thread.sleep(delay / 2);
            if (!ignoreAudio) {
                if (upgrade || newest) {
                    int np = newPos;
                    if (np == 1) {
                        new Thread(() -> playSound("src/main/resources/forum/first.wav")).start();
                    }
                    new Thread(() -> playSound("src/main/resources/forum/" + (np > 0 && np <= 30 ? np : "level") + ".wav")).start();
                    if (np <= 30 && np > 1) {
                        new Thread(() -> playSound("src/main/resources/forum/level.wav")).start();
                    }
                }
                new Thread(() -> playSound("src/main/resources/forum/orb.wav")).start();
                if (newAppear) {
                    if (newest) {
                        new Thread(() -> playSound("src/main/resources/forum/newest.wav")).start();
                    } else {
                        new Thread(() -> playSound("src/main/resources/forum/new.wav")).start();
                    }
                }
            }

            label.setText(stringBuilder.toString().replace(updated + ": ---", updated + ": " + point));
            lastText = stringBuilder.toString();
            Thread.sleep(delay / 2);
            return true;
        }
        return false;
    }

    public static void renameProfileName(String oldName, String newName, int id) throws Exception {
        initializeForum();
        String oldSeoName = oldName.toLowerCase().replace(" ", "-");
        String newSeoName = newName.toLowerCase().replace(" ", "-");

        ResultSet resultSet = DatabaseUtils.selectFromTable("core_members").whereEquals("name", oldName).executeQuery();
        if (resultSet.next()) {
            id = resultSet.getInt("member_id");
        } else if (id == -1) {
            System.out.println("PERFIL NÃO ENCONTRADO!");
            return;
        }

        System.out.println("Alterando nome do perfil '" + oldName + "' para '" + newName + "'...");
        DatabaseUtils.updateTable("core_admin_logs").replace("note", oldName, newName).whereLike("note", oldName).executeUpdate();
        DatabaseUtils.updateTable("core_members").set("name", newName).whereEquals("name", oldName).executeUpdate();
        DatabaseUtils.updateTable("core_members").set("members_seo_name", newSeoName).whereEquals("members_seo_name", oldSeoName).executeUpdate();
        for (int field : new int[]{1, 6}) {
            DatabaseUtils.updateTable("core_pfields_content").replace("field_" + field, id + "-" + oldSeoName, id + "-" + newSeoName).whereLike("field_" + field, id + "-" + oldSeoName).executeUpdate();
            DatabaseUtils.updateTable("core_pfields_content").replace("field_" + field, "@" + oldName, "@" + newName).whereLike("field_" + field, "@" + oldName).executeUpdate();
        }
        updateInTopics(oldName, newName, id);
        updateTag(oldName.toLowerCase(), newName.toLowerCase());
        System.out.println("Alteração do nome de perfil realizada!");
    }

    public static void updateInTopics(String oldName, String newName, int id) {
        String oldSeoName = oldName.toLowerCase().replace(" ", "-");
        String newSeoName = newName.toLowerCase().replace(" ", "-");

        // core_edit_history
        DatabaseUtils.updateTable("core_edit_history").replace("old", "@" + oldName, "@" + newName).whereLike("old", "@" + oldName).executeUpdate();
        DatabaseUtils.updateTable("core_edit_history").replace("old", id + "-" + oldSeoName, id + "-" + newSeoName).whereLike("old", id + "-" + oldSeoName).executeUpdate();
        DatabaseUtils.updateTable("core_edit_history").replace("new", "@" + oldName, "@" + newName).whereLike("new", "@" + oldName).executeUpdate();
        DatabaseUtils.updateTable("core_edit_history").replace("new", id + "-" + oldSeoName, id + "-" + newSeoName).whereLike("new", id + "-" + oldSeoName).executeUpdate();

        // forums_posts
        DatabaseUtils.updateTable("forums_posts").replace("post", "@" + oldName, "@" + newName).whereLike("post", "@" + oldName).executeUpdate();
        DatabaseUtils.updateTable("forums_posts").replace("post", id + "-" + oldSeoName, id + "-" + newSeoName).whereLike("post", id + "-" + oldSeoName).executeUpdate();

        // core_output_cache
        DatabaseUtils.updateTable("core_output_cache").replace("cache_value", "@" + oldName, "@" + newName).whereLike("cache_value", "@" + oldName).executeUpdate();
        DatabaseUtils.updateTable("core_output_cache").replace("cache_value", id + "-" + oldSeoName, id + "-" + newSeoName).whereLike("cache_value", id + "-" + oldSeoName).executeUpdate();

        // core_search_index
        DatabaseUtils.updateTable("core_search_index").replace("index_content", "@" + oldName, "@" + newName).whereLike("index_content", "@" + oldName).executeUpdate();

        // core_sys_lang_words
        DatabaseUtils.updateTable("core_sys_lang_words").replace("word_default", "@" + oldName, "@" + newName).whereLike("word_default", "@" + oldName).executeUpdate();
        DatabaseUtils.updateTable("core_sys_lang_words").replace("word_default", id + "-" + oldSeoName, id + "-" + newSeoName).whereLike("word_default", id + "-" + oldSeoName).executeUpdate();
        DatabaseUtils.updateTable("core_sys_lang_words").replace("word_custom", "@" + oldName, "@" + newName).whereLike("word_custom", "@" + oldName).executeUpdate();
        DatabaseUtils.updateTable("core_sys_lang_words").replace("word_custom", id + "-" + oldSeoName, id + "-" + newSeoName).whereLike("word_custom", id + "-" + oldSeoName).executeUpdate();

        // gallery_albums
        DatabaseUtils.updateTable("gallery_albums").replace("album_description", "@" + oldName, "@" + newName).whereLike("album_description", "@" + oldName).executeUpdate();
        DatabaseUtils.updateTable("gallery_albums").replace("album_description", id + "-" + oldSeoName, id + "-" + newSeoName).whereLike("album_description", id + "-" + oldSeoName).executeUpdate();
    }

    public static void updateTag(String oldTag, String newTag) throws Exception {
        initializeForum();
        System.out.println("Atualizando tag '" + oldTag + "' para '" + newTag + "'...");
        DatabaseUtils.updateTable("core_search_index_tags").set("index_tag", newTag).whereEquals("index_tag", oldTag).executeUpdate();
        DatabaseUtils.updateTable("core_tags").set("tag_text", newTag).whereEquals("tag_text", oldTag).executeUpdate();
        System.out.println("Tag '" + oldTag + "' atualizada para '" + newTag + "'!");
    }

    public static final List<String> IGNORE_TAGS = Arrays.asList(
            // Eu e meu
            "bruno coelho", "introcdc", "mister ia", "mano brownilha", "principe branco", "macaco azul", "base61", "base62", "afuleponcio", "topolinos", "omegon gamer", "base64", "maricotta", "macaco verde",

            // Meus Projetos
            "kindome", "introcraft", "mapmeel", "mapmeel v1", "mapmeel v2", "mapmeel v3", "mapmeel v4", "mapmeel v5",

            // Meus veiculos
            "megalodon", "aurora boreal", "serjona berrante", "magrillete", "jorjao guanabara", "carlinhos markinhos", "betonia venenosa", "titanica", "bicicleta houston", "cristiano ronaldo",

            // Meses
            "janeiro", "fevereiro", "marco", "abril", "maio", "junho", "julho", "agosto", "setembro", "outubro", "novembro", "dezembro",

            // Sequência de tópicos
            "historia clarissa", "historia google", "historia ib64", "historia corvum", "historia introcraft", "historia kindome",

            // Pets
            "billy", "mel", "dinha", "melissa cachorra", "gato", "leoa gabrielle", "zarah", "jude", "derick", "brutos", "mel bruna", "brutus",

            // Veiculos
            "fanpira", "hilux pai", "ruivinha", "palio adalgesio", "negona", "buggy pai", "zinedine zidane", "sorento luciano", "marcos alaranjado", "bluejet", "nebulosa", "xre 300 pai", "jobislene", "siena alison", "loirinha", "mt07 epitacio", "s1000", "jeniffer", "ranger pai", "l200", "sharkboy hb20",

            // Ignorar
            "bolsonaro", "lula", "tronix10", "bruno sabino",

            // Localização
            "casa", "fortaleza", "ceara", "brasil", "croata", "sao goncalo do amarante", "casa pai", "casa lenon", "smart fit", "casa luciano", "casa vo", "ilha de itamaraca", "natal", "joao pessoa", "pernambuco", "paraiba", "rio grande do norte", "faculdade lourenco filho", "benfica", "sitio pai", "caucaia", "motel ilha", "colegio equipe", "iguatemi", "riomar fortaleza", "riomar kennedy", "praia de iracema", "br-116", "sitio pindoretama", "casa bruna", "pindoretama", "casa alison", "eusebio", "farias brito junior", "north shopping", "shopping benfica", "universal park", "barra do ceara", "castelao", "ce-040", "beach park", "palhano", "via motos", "carmel cumbuco resort", "juvenal motors", "fisioterapia", "aeroporto fortaleza", "estados unidos", "aquiraz", "hospital unimed", "clube da aeronautica", "casa joao pedro", "guajiru", "colegio master", "lajes", "capela de santa filomena", "motel ele e ela", "hotel golfinho", "via sul", "itacaranha parque", "veu das noivas", "br-222", "cemiterio sao joao batista", "mercadinho a dada", "posto conv benfica", "colegio antares", "maracanau", "guaramiranga", "shopping midway mall", "br-304", "espaco seguro", "lapis colorido", "sanitas academia", "antares", "clinica unimed", "barraca terra brasilis", "mcdonalds", "boutique do carro", "edificio sao pedro", "cauhipe", "rio de janeiro", "la maison", "casa bisavo", "benfica buffet", "porto das dunas", "hospital sao matheus", "paracuru", "baratao", "santa luzia", "plus", "detran", "extra", "hospital caucaia", "morada nova", "genesis", "centro", "rapidex", "centro de eventos", "niteroi", "cristo redentor", "pao de acucar", "shopping plaza", "copacabana", "north shopping joquei", "orbita", "dentista", "aracati", "paroquia nossa senhora dos remedios", "edificio estoril", "itaicaba", "atacadao", "juazeiro", "icarai", "super frangolandia", "casa samile", "tabuleiro do norte", "ipaumirim",

            // Tipos de tópicos
            "video", "diario", "historia", "live", "acontecimento", "mapa", "anotacao", "off-topic", "publicacao", "musica", "instagram", "audio", "roteiro",

            // Sub-tipos de tópicos
            "rock", "metal", "reaggue", "cinematografica", "forro", "sertanejo", "gameplay", "minecraft", "vlog", "motovlog", "hd interno", "conteudo perdido", "netbook bruno", "galaxy s22", "galaxy j8", "galaxy a71", "galaxy a72", "canon", "iphone 4", "ipad", "gopro", "unreleased", "powerpack", "galaxy j1", "galaxy s4", "assunto", "bruno show", "canal", "bikevlog", "call", "spy pen", "destruicao", "meu setup", "50 fatos", "parodia", "nokia 5230", "desafio", "oferecimentos", "unboxing", "bruno e alguém news", "nokia lumia", "ipod", "notebook bruno", "samsung shark", "review", "chatgpt",

            // Sub-sub-tipos de tópicos
            "skywars", "survival", "creative", "minecraftgames", "hypixel", "mushmc", "pandora", "likekits", "edicao", "edição", "carvlog", "hd externo", "livro de memorias 1", "pc", "remasterizacao", "amnesia", "skype", "discord", "react", "qik", "intro", "csgo", "darkness", "brightness", "whatsapp", "tntrun", "hardcoregames", "windows", "kitpvp", "pvp", "fpi", "single-player", "hardcore", "hardcore 1", "hardcore 2", "conteudo externo", "sonho", "especiais", "spleef", "super mario 64", "mensagem", "parkourrace", "unfinished", "planet cry baby", "mineplex", "melanie daily brasil", "historia safira", "historia eduarda", "fullpvp", "tag", "xracing", "denuncia", "corvum", "item", "colors", "tutorial", "a treta com o kid", "livreto de memorias", "introbase64", "ataque", "trailer", "thearchon", "rocket league", "java", "programa", "pvm", "apresentacoes", "dragons", "ctf", "paintball", "troll", "bossbattle", "oitc", "among us", "logicmc", "advmusic", "fnaf", "fnaf 1", "fnaf 2", "fnaf 3", "fnaf 4", "survival games", "homem macho", "creeper boss", "source", "fppdb", "making off", "diversity", "neutro", "pc meel", "jogo do ano", "relato", "piano digital", "hotpotato", "gta 5", "spyvsspy", "thebridges", "lulu fight", "fall guys", "sac", "mc-central", "fortaleza ec", "ceara sc", "resident evil 4", "megaluckyblock", "the bases", "gta san andreas", "cubaoluckyblock", "anvilstorm", "minechange", "slender", "microbattles", "enderhunters", "its jerry and harry", "titanic", "evolucao", "pandorahg", "chairdance", "texto", "cover", "bombgame", "caderno hotwheels", "angelz", "buildbattle", "trote", "bowspleef", "grupo dos aventureiros", "platform", "turfwars", "cacador", "luckydoors", "deathtag", "labirinto do creeper", "black friday", "herobrines chamber", "castlesiege", "machinima", "camera pai", "teste de inteligencia", "programa do bruno", "hideandseek", "xvideos", "leiti", "producao", "disponivel", "playstation 2", "piglinshop", "creeperlabirinty", "laboratorio quimico", "drawit", "dropper", "orespawn", "splegg", "dust network", "leeaf", "party", "dragonbattle", "cd", "realmcraft", "gungame", "staircase", "melaniemzone", "mickeygang", "guerra", "ultraskywars", "skyrace", "skyblock", "orerace", "dominate", "superjokenpo", "multiplayer", "jumper", "comum", "raro", "sac 2011", "runner", "blockingdead", "cookingmama", "scp087b", "playervshunters", "sheepquest", "fabrica de show", "dublagem", "bedwars", "natureza", "crossroad", "uhc", "netheriterace", "supersmashmobs", "bridgesrace", "climbinggame", "servidor bruno correa", "corridonapvp", "enderman", "desenho", "coloredwalls", "villagers atropeladores", "mapintro", "terminatorpvp", "luckyblockrace", "paintarena", "bolt", "ddos", "firekits", "cat mario", "engracados", "atrio", "mlgrace", "entrevista", "ezmc", "thechunk", "rewind", "evolution", "doodle jump", "theflag", "flappybird", "microbattle", "murder", "battle simulator", "testando staff", "quemdorme", "destroyed", "tnttag", "roblox", "aniversario", "banco imobiliario", "normal", "email", "newfox", "vaidarnamoro", "sheeprace", "milkthecow", "mithcraft", "br", "wordgame", "lavachallenge", "futebol", "dragonescape", "garrys mod", "year registry", "diamoneye seeverything", "metalex", "mineparty", "ageofmine", "bridgegame", "maze", "facebook", "comunidade melanie", "mzcraft", "skyminigames", "webcam", "lavaworld", "need for speed", "quiz", "mario kart 64", "teck", "horsevlog", "god of war", "worms armagedon", "flashpoint", "cuphead", "crystalwars", "free fire", "tntbase", "hacking", "criativo", "akinator", "cartao", "towerwars", "realmparty", "patins", "espirro", "thewalls", "as paredes movem", "battleclick", "boatrace", "dev battle", "fortnite", "dev", "titanic 2", "brigas", "cubecraft", "megaskywars", "tntrain", "server", "criacoes de redstone", "meme", "luckyblockworld", "theraid", "sheepgame", "lavagame", "fotos", "the sims 3", "glassgame", "queensroad", "blitz", "happy wheels", "encontro", "sac 2018", "hivemc", "sac 2012", "ednstelabiidu", "sac 2017", "sac 2015", "kartvlog", "xgamerpvp", "bordergame", "boatbattle", "dripfight", "luccas netoland", "cubaoluckyblock", "cubaoluckyworld", "survivalgames", "original", "torneiopvp", "viagem", "guitar hero", "nado no la", "tntwizard", "tntwizards", "vampirez", "tekkit", "woolpvp", "minigames", "mentro", "homenagem a minha vo", "vrchat", "apsintro", "livro", "vai aguentar", "cbr1000rr", "rede sky", "slammings", "mortal kombat 11", "valorant", "mc-hype", "chill podcast", "rewind 2020", "the last of us 2", "the last of us", "fifa 2020", "tntwizards", "the forest", "craftpvp", "content", "dodgeball", "fisherman", "horserace", "icefloor", "killtheglowsquid", "lavasurvival", "mobbattle", "lamacraft", "glassbridge", "obsidianhunt", "tv assembleia", "futurium", "creeperboss", "beewars", "rdm", "signalrace", "skygrid", "xj6", "celular", "buildit", "bungeejump", "deathrace", "jumpgame", "devour", "round 6", "primeira comunhao", "art attack", "top 10", "cabelo", "strike");

    public static final Map<String, String> TAG_DESCRIPTION = ImmutableMap.<String, String>builder()
            .put("roberta coelho", "Mãe").put("lenon maximiano", "Primo por parte de Pai").put("reginaldo sabino", "Pai")
            .put("rafael araujo", "Ex-Amigo, conhecido pela amiga de Roberta em 2015").put("pedro maximiano", "Primo por parte de Pai")
            .put("alison azevedo", "Amigo conhecido pelo Colégio Equipe em 2011").put("luciano segundo", "Irmão por parte de Mãe")
            .put("maria eduarda", "Sobrinha, filha de Luciano").put("meel", "Ex-amiga, conhecida em chamada de grupo no Skype em 2014")
            .put("juliana segundo", "Cunhada, esposa de Luciano em 2011").put("sofia joca", "Sobrinha, filha de Luciano")
            .put("maria lucia segundo", "Sobrinha, filha de Luciano").put("seis", "Amigo, conhecido pelo Corvum em 2021")
            .put("maria julia", "Sobrinha, filha de Luciano").put("diegosvp", "Amigo, conhecido pelo MinecraftGames em 2015")
            .put("jose renan", "Sobrinho, filho de Gabrielle").put("felipe barreto", "Primo por parte de Pai").put("sandra", "Mãe de Felipe")
            .put("google rodrigues", "Amiga, conhecida pelo Kindome em 2020").put("melanie martinez", "Cantora conhecida")
            .put("adalgesio barreto", "Tio por parte de Pai").put("calebe segundo", "Sobrinho, filho de Luciano")
            .put("elenilda cipriano", "Tia por parte de Pai").put("mariaum", "Amigo, conhecido pelo IntroCraft em 2015")
            .put("ivan hermann", "Amigo, conhecido pelo Kindome em 2021").put("neta neves", "Ex-madrasta de Reginaldo, conhecida em 2008")
            .put("sombra", "Amigo, conhecido pelo IntroCraft em 2014").put("kiritolc", "Amigo, conhecido pelo Kindome em 2020")
            .put("gabrielle coelho", "Irmã por parte de Mãe").put("biidu", "Amigo, conhecido por chamada de grupo no Skype em 2014")
            .put("jotah", "Amigo, conhecido pelo IntroCraft em 2015").put("sarah beatriz", "Ex-amiga, conhecida pelo Colégio Equipe em 2011")
            .put("keroch", "Ex-amigo, conhecido pelo Biidu, Meel, MinecraftGames em 2015").put("safira rodrigues", "Amiga, conhecida pelo Kindome em 2021")
            .put("clarissa ellen", "Ex-amiga, conhecida pela amiga de Roberta em 2008").put("victor bezerra", "Ex-amigo, conhecido pelo Newton em 2014")
            .put("joao breno", "Primo por parte Mãe").put("nicolas davi", "Amigo, conhecido pelo Kindome em 2021").put("felipe neto", "Youtuber conhecido")
            .put("newton bezerra", "Vô por parte de Mãe").put("joao pedro", "Amigo, conhecido no Condomínio Maranata em 2011")
            .put("lucas coelho", "Primo por parte de Mãe").put("snifpvp", "Youtuber, Amigo, conhecido pelo IntroCraft em 2015")
            .put("netinha araujo", "Amiga, conhecida por Roberta em 2015").put("branca", "Gata, conhecida pela Mãe em 2022")
            .put("bruna altamira", "Tia por parte de Mãe").put("andrei", "Ex-amigo, conhecido no Condomínio Grandvernissage em 2007")
            .put("celioneide maia", "Mãe de Juliana, conhecida em 2014").put("logan", "Amigo, conhecido pelo IntroCraft em 2015")
            .put("preta", "Gata, conhecida pela Gabrielle em 2022").put("stela", "Gata, conhecida pela Mãe em 2022").put("lucas moreira", "Amigo, irmão de Eduarda Souza")
            .put("helena", "Ex-amiga, conhecida pelo Facebook em 2017").put("epitacio sabino", "Tio por parte de Pai").put("gabriel moreira", "Amigo, irmão de Eduarda Souza")
            .put("ninja", "Amigo, conhecido pelo IntroCraft em 2014").put("aurora aksnes", "Cantora conhecida").put("josi nascimento", "Cunhada, esposa de Lenon")
            .put("fabio rocha", "Amigo, conhecido pelo Colégio Equipe em 2016").put("maahkiihgamer", "Ex-amiga, conhecida pelo IntroCraft em 2014")
            .put("stela ferreira", "Ex-amiga, conhecida pelo IntroCraft em 2015").put("larissa gomes", "Amiga, conhecida pela Faculdade Lourenço Filho em 2017")
            .put("andre azevedo", "Amigo, conhecido pelo Alison em 2017").put("joao victor camargo", "Ex-amigo, conhecido pelo Colégio Equipe em 2017")
            .put("denis leonardo", "Esposo de Bruna, conhecido em 2016").put("maria lucia", "Vó por parte de Mãe").put("spoteff", "YouTuber, conhecido pelo Kindome em 2020")
            .put("crazyxd", "Ex-amigo, conhecido pelo IntroCraft em 2015").put("beatriz sousa", "Amiga, conhecida pelo Kindome em 2017")
            .put("claudia fernandes", "Mãe de Clarissa, conhecida pela Igreja de Santa Luzia em 2008").put("kayo", "Ex-amigo, conhecido pelo Blast em 2014")
            .put("igor souza", "Ex-amigo, conhecido pelo Colégio Equipe em 2011").put("gabrielle", "Ex-amiga, conhecido pelo Colégio Equipe em 2011")
            .put("jose ribeiro", "Ex-amigo, conhecido pelo Colégio Equipe em 2012").put("carol", "Ex-amiga, conhecido pelo Colégio Equipe em 2012")
            .put("zeneida", "Ex-amigo, conhecido pela Igreja de Santa Luzia em 2008").put("wagner saboia", "Padre, conhecido pela Igreja de Santa Luzia em 2008")
            .put("marcia gata", "Gata, conhecida em 2008").put("marcela gata", "Gata, conhecida em 2008").put("jefferson", "Ex-amigo, conhecido em Caucaia em 2008")
            .put("alisson", "Ex-amigo, conhecido em Caucaia em 2008").put("andressa", "Ex-amiga, conhecida em Caucaia em 2008")
            .put("lucivania moreira", "Tia de Eduarda, conhecida em São Gonçalo do Amarante em 2024").put("luciene moreira", "Mãe de Eduarda, conhecida em São Gonçalo do Amarante em 2024")
            .put("martin", "Ex-amigo, conhecido no Condomínio Grandvernissage em 2007").put("jeffersson", "Ex-amigo, conhecido em Caucaia em 2008")
            .put("helio fb", "Ex-amigo, conhecido pelo Fárias Brito em 2008").put("raul sabino", "Ex-amigo, conhecido pelo Fárias Brito em 2008")
            .put("leo fb", "Ex-amigo, conhecido pelo Fárias Brito em 2008").put("caio fb", "Ex-amigo, conhecido pelo Fárias Brito em 2008")
            .put("tomaz fb", "Ex-amigo, conhecido pelo Fárias Brito em 2008").put("adriana azevedo", "Mãe de Alison, conhecida em 2017")
            .put("reaating", "Ex-amigo, conhecido pelo IntroCraft em 2016").put("blast", "Ex-amigo, conhecido pelo IntroCraft em 2014")
            .put("marcos roberto", "Pai de José Renan").put("luciana zingareli", "Amiga, conhecida pelo Planet Cry Baby em 2019")
            .put("marcia", "Amiga de Gabrielle").put("marcela", "Amiga de Gabrielle").put("maria eduarda barreto", "Prima de 2º Grau, conhecida pela Dada em 2022")
            .put("crashpacman", "Ex-amigo, conhecido pelo IntroCraft em 2014").put("panda", "Ex-amigo, conhecido por chamada em grupo no Skype em 2016")
            .put("leticia shadow", "Ex-amiga, conhecida pelo Melanie Daily Brasil em 2019").put("tiago barreto", "Primo por parte de Pai")
            .put("matheus gonvez", "Amigo, conhecido pelo Melanie Zone Brasil em 2019").put("furia", "Ex-amigo, conhecido pelo MinecraftGames em 2014")
            .put("gabriel christian", "Amigo, conhecido no Norte Shopping em 2020").put("lelahel", "Amigo, conhecido pelo Kindome em 2021")
            .put("maath", "Amigo, conhecido pelo Kindome em 2019").put("oriongplays", "Youtuber, ex-amigo, conhecido pelo IntroCraft em 2015")
            .put("isa maria", "Ex-amiga, conhecida pelo Melanie Daily Brasil em 2019").put("max alves", "Ex-amigo, conhecido pelo Colégio Equipe em 2012")
            .put("nelson castelo", "Bisavô por parte de Vó por parte de Mãe").put("raymeki", "Ex-amigo, conhecido pelo IntroCraft em 2015")
            .put("flora", "Gata, conhecida pela Gabrielle em 2023").put("eduarda souza", "Amiga, conhecida em São Gonçalo do Amarante em 2023")
            .put("ingrid machado", "Youtuber conhecida").put("kelly sousa", "Vendedora em Juvenal Motors").put("matheus bezerra", "Amigo, conhecido por João Breno e Lucas em 2019")
            .put("josh", "Ex-amigo, conhecido pelo IntroCraft em 2014").put("poppy", "Cantora conhecida").put("yago", "Sobrinho de 2º grau por parte de Primo por parte de Pai")
            .put("flash", "Ex-amigo, conhecido pelo IntroCraft em 2015").put("batata gamer", "Amigo, conhecido pelo Kindome em 2021")
            .put("lasser", "Ex-amiga, conhecida pelo IntroCraft em 2014").put("wgbrasil", "Amigo, conhecido pelo MushMC em 2016")
            .put("joao miguel", "Primo por parte de Mãe, filho de Dênis").put("luan moura", "Ex-amigo, conhecido no Condomínio Maranata em 2011")
            .put("dada", "Namorada de Reginaldo, conhecida em 2021").put("luiz andrade", "Ex-amigo, conhecido pelo Lenon em 2019")
            .put("ultra", "Ex-amiga, conhecida pela Meel em 2016").put("ana caroline", "Amiga, conhecida pelo Reginaldo em Palhano em 2022")
            .put("ana celia", "Ex-amiga, conhecida pela Juliana em 2018").put("bruno correa", "YouTuber conhecido").put("sopa quente", "Amigo, conhecido pelo TeckPvP em 2015")
            .put("discord", "Amigo, conhecido pelo Kindome em 2020").put("jesuino diogo", "Ex-amigo, conhecido pelo Colégio Equipe em 2011")
            .put("felipeheroplay", "Ex-amigo, conhecido pelo Biidu em 2015").put("alexandre souza", "Ex-amigo, conhecido pela Faculdade Lourenço Filho em 2017")
            .put("srriaan", "Ex-amigo, conhecido pelo Corvum em 2021").put("cangasso", "Ex-amigo, conhecido pelo MinecraftGames em 2014")
            .put("beatrizxd", "Ex-amiga, conhecida pelo Servidor do Skoper em 2014").put("gahby tina", "Ex-amiga, conhecida pelo Tina no Rio de Janeiro em 2013")
            .put("edvaldo", "Motorista de Roberta, conhecido em 2013").put("rafael ce", "Ex-amigo, conhecida pelo Colégio Equipe em 2011")
            .put("kaio katso", "Ex-amigo, conhecida pelo Colégio Equipe em 2011").build();

    /**
     * @param filename the name of the file that is going to be played
     */
    public static void playSound(String filename) {
        File soundFile;
        AudioFormat audioFormat;
        SourceDataLine sourceLine = null;
        AudioInputStream audioStream = null;
        int BUFFER_SIZE = 128000;
        try {
            soundFile = new File(filename);
        } catch (Exception e) {
            return;
        }

        try {
            audioStream = AudioSystem.getAudioInputStream(soundFile);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }

        audioFormat = audioStream.getFormat();

        DataLine.Info info = new DataLine.Info(SourceDataLine.class, audioFormat);
        try {
            sourceLine = (SourceDataLine) AudioSystem.getLine(info);
            sourceLine.open(audioFormat);
        } catch (Exception ignored) {
        }

        sourceLine.start();

        int nBytesRead = 0;
        byte[] abData = new byte[BUFFER_SIZE];
        while (nBytesRead != -1) {
            try {
                nBytesRead = audioStream.read(abData, 0, abData.length);
            } catch (Exception ignored) {
            }
            if (nBytesRead >= 0) {
                sourceLine.write(abData, 0, nBytesRead);
            }
        }

        sourceLine.drain();
        sourceLine.close();
    }

}
