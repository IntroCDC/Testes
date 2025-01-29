package br.com.introcdc.tests.conversor;
/*
 * Written by IntroCDC, Bruno Coêlho at 27/01/2025 - 03:42
 */

import br.com.introcdc.tests.database.DatabaseUtils;
import br.com.introcdc.tests.database.GlobalDatabase;
import br.com.introcdc.tests.database.query.DatabaseQuery;
import br.com.introcdc.tests.database.query.OrderType;

import java.io.File;
import java.sql.ResultSet;
import java.util.*;

public class DatabaseConversor {

    public static void main(String[] args) throws Exception {
        GlobalDatabase.reloadConnection();
        ResultSet resultSet = DatabaseUtils.selectFromTable("mgmaps").executeQuery();
        while (resultSet.next()) {
            File test = new File("C:\\Kindome\\site\\assets\\images\\maps\\" + resultSet.getString("mapBase").toLowerCase() + ".png");
            if (!test.exists()) {
                System.out.println("mapa: " + test.getName());
            }
        }
    }

    public static void convertPackages() throws Exception {
        ArrayList<String> multiple = new ArrayList<>(Arrays.asList("hardcore_homes", "used_key", "pet_", "creative_worlds", "friends",
                "friend_requests_sent", "friend_requests", "blocked_friends", "_kit", "tag_list", "permissions", "content_worlds"));

        GlobalDatabase.reloadConnection();

        List<String> already = new ArrayList<>();
        System.out.println("Processando...");

        System.out.println("Processando...");
        DatabaseQuery newQuery = DatabaseUtils.selectFromTable("packages_new");
        newQuery.orderBy(OrderType.ASC, "id");
        ResultSet newResult = newQuery.executeQuery();
        while (newResult.next()) {
            String kuid = newResult.getString("kuid");
            String id = newResult.getString("package_type");
            String value = newResult.getString("package_name");
            String key;
            boolean found = false;
            for (String mul : multiple) {
                if (id.contains(mul)) {
                    found = true;
                    break;
                }
            }
            if (found) {
                key = kuid + id + value;
            } else {
                key = kuid + id;
            }
            already.add(key);
            DatabaseQuery.insertIntoTable("packages")
                    .openArrays()
                    .setInArray("kuid", kuid)
                    .setInArray("package_type", id)
                    .setInArray("package_name", value)
                    .closeArrays().executeUpdate();
        }
        DatabaseQuery oldQuery = DatabaseUtils.selectFromTable("packages_old");
        oldQuery.orderBy(OrderType.ASC, "id");
        ResultSet oldResult = oldQuery.executeQuery();
        while (oldResult.next()) {
            String kuid = oldResult.getString("kuid");
            String id = oldResult.getString("package_type");
            String value = oldResult.getString("package_name");
            String key;
            boolean found = false;
            for (String mul : multiple) {
                if (id.contains(mul)) {
                    found = true;
                    break;
                }
            }
            if (found) {
                key = kuid + id + value;
            } else {
                key = kuid + id;
            }
            DatabaseQuery.insertIntoTable("packages")
                    .openArrays()
                    .setInArray("kuid", kuid)
                    .setInArray("package_type", id)
                    .setInArray("package_name", value)
                    .closeArrays().executeUpdate();
        }
        System.out.println("PRONTO!");
    }

    public static void convertStatistics() throws Exception {
        ArrayList<String> keepOld = new ArrayList<>(Arrays.asList(
                "firstjoin", "minigames_first_login", "firstLogin", "creative", "leavemealone",
                "fullpvp_first_login", "skywar", "makeup", "thebestversion", "casual", "socialize",
                "tnt", "luckygames", "pvp", "kitpvp", "kitpvp_last_login", "joinmessage",
                "dropper0errors", "agility", "clan", "fast", "exclusives", "strategy",
                "newversions", "teams", "removed", "spleef", "adventure", "partynpc",
                "tntrunnojump", "botPitch", "luckyblock0", "fullpvp", "kitpvp_first_login",
                "projectile", "%hardcore_city%", "heads", "fullpvpfirstbuy",
                "fullpvpfirstsell", "fullpvpownstore", "fullpvpplot", "harcore",
                "hardcore_first_login", "customcage", "creativeplot", "clothes", "accessory",
                "deathmessage", "quitmessage", "winsound", "wintotem", "killmessage",
                "wintitle", "winsubtitle", "hardcoreevent", "pets", "viewDistance",
                "particles", "emojis", "hardcorequiz", "parkourrace0errors", "skyrace0errors",
                "hardcorecoliseum", "hardcorebiblioteca", "hardcorehades", "hardcoremina",
                "hardcorealquimia", "hardcorehiddencity", "hardcorefarm", "hardcore",
                "pvmlastlevel", "creativeworld", "musicquest0errors", "morph",
                "piglinshopwronggame", "blocked_report", "hardcoremarket", "hardcoremarketbuy",
                "hardcoremarketsell", "hardcoremarketpublish", "hardcoredraw", "hardcoresafe",
                "hardcoreboss", "hardcoreallcities", "hardcorenethertend", "hardcoreendcastle",
                "hardcoredisco", "hardcoreatlantida", "hardcorefarm", "parkourracetheimpossible"
        ));

        ArrayList<String> keepNew = new ArrayList<>(Arrays.asList(
                "minigames_last_login", "last_version", "lastLogin", "fullpvp_last_login",
                "kitpvp_last_login", "%feed_mg_%", "%feed_map_%", "whenReceivedGroup",
                "form_cooldown", "hardcore_last_login", "report_times", "%fullpvp_cooldown_%",
                "%hardcore_daily_%", "%hardcore_weekly_%", "%hardcore_monthly_%",
                "hardcore_last_death", "tempGroup"
        ));

        ArrayList<String> add = new ArrayList<>(Arrays.asList(
                "online_time", "logins", "%_coins%", "%_rank%", "%_partidas%", "%_mortes%",
                "%_matou%", "%_vitorias%", "%_pulos%", "%_pontos%", "%_deaths%", "%_luckyblocks%",
                "%_totens%", "%_erros%", "%_passou%", "%_votos%", "%_tarefas%", "%_kills%",
                "%_fails%", "%_camas%", "%_dinheiro%", "%_bombas%", "%_doublejumps%", "%_blocos%",
                "%_marcado%", "%_lama%", "%_used%", "%_poder%", "%_totems%", "%_nível%",
                "%_velocidade%", "%_vidros%", "%_base%", "%_acertos%", "report_times",
                "reported_times", "bannedlogintries", "mutedchattries", "kitpvp_wins_1v1",
                "kitpvp_loses_1v1", "%mlg_wins%", "%kitpvp_lc_%", "%_bombstate%", "%_botões%",
                "%_obsidians%", "%_tickstoexplode%", "%_almas%", "%_kangaroouses%", "%_vida%",
                "creative_plus"
        ));

        ArrayList<String> newItems = new ArrayList<>(List.of("%mgr_%"));

        GlobalDatabase.reloadConnection();

        System.out.println("Processando os KEEPOLD");
        for (String string : keepOld) {
            System.out.println("Processando old: " + string + "...");
            DatabaseQuery oldQuery = DatabaseUtils.selectFromTable("statistics_old");
            if (string.startsWith("%")) {
                String info = string.substring(1, string.length() - 1);
                oldQuery.whereLike("statistic_id", info);
            } else {
                oldQuery.whereEquals("statistic_id", string);
            }
            oldQuery.orderBy(OrderType.ASC, "id");
            ResultSet oldResult = oldQuery.executeQuery();
            while (oldResult.next()) {
                String kuid = oldResult.getString("kuid");
                String id = oldResult.getString("statistic_id");
                long value = oldResult.getLong("value");
                String key = kuid + id;
                DatabaseQuery.insertIntoTable("statistics")
                        .openArrays()
                        .setInArray("kuid", kuid)
                        .setInArray("statistic_id", id)
                        .setInArray("value", value)
                        .closeArrays().executeUpdate();
            }
            DatabaseQuery newQuery = DatabaseUtils.selectFromTable("statistics_new");
            if (string.startsWith("%")) {
                String info = string.substring(1, string.length() - 1);
                newQuery.whereLike("statistic_id", info);
            } else {
                newQuery.whereEquals("statistic_id", string);
            }
            newQuery.orderBy(OrderType.ASC, "id");
            ResultSet newResult = newQuery.executeQuery();
            while (newResult.next()) {
                String kuid = newResult.getString("kuid");
                String id = newResult.getString("statistic_id");
                long value = newResult.getLong("value");
                String key = kuid + id;
                DatabaseQuery.insertIntoTable("statistics")
                        .openArrays()
                        .setInArray("kuid", kuid)
                        .setInArray("statistic_id", id)
                        .setInArray("value", value)
                        .closeArrays().executeUpdate();
            }
        }
        System.out.println("PRONTO!");

        System.out.println("Processando os KEEPNEW");
        for (String string : keepNew) {
            System.out.println("Processando new: " + string + "...");
            DatabaseQuery newQuery = DatabaseUtils.selectFromTable("statistics_new");
            if (string.startsWith("%")) {
                String info = string.substring(1, string.length() - 1);
                newQuery.whereLike("statistic_id", info);
            } else {
                newQuery.whereEquals("statistic_id", string);
            }
            newQuery.orderBy(OrderType.ASC, "id");
            ResultSet newResult = newQuery.executeQuery();
            while (newResult.next()) {
                String kuid = newResult.getString("kuid");
                String id = newResult.getString("statistic_id");
                long value = newResult.getLong("value");
                String key = kuid + id;
                DatabaseQuery.insertIntoTable("statistics")
                        .openArrays()
                        .setInArray("kuid", kuid)
                        .setInArray("statistic_id", id)
                        .setInArray("value", value)
                        .closeArrays().executeUpdate();
            }
            DatabaseQuery oldQuery = DatabaseUtils.selectFromTable("statistics_old");
            if (string.startsWith("%")) {
                String info = string.substring(1, string.length() - 1);
                oldQuery.whereLike("statistic_id", info);
            } else {
                oldQuery.whereEquals("statistic_id", string);
            }
            oldQuery.orderBy(OrderType.ASC, "id");
            ResultSet oldResult = oldQuery.executeQuery();
            while (oldResult.next()) {
                String kuid = oldResult.getString("kuid");
                String id = oldResult.getString("statistic_id");
                long value = oldResult.getLong("value");
                String key = kuid + id;
                DatabaseQuery.insertIntoTable("statistics")
                        .openArrays()
                        .setInArray("kuid", kuid)
                        .setInArray("statistic_id", id)
                        .setInArray("value", value)
                        .closeArrays().executeUpdate();
            }
        }
        System.out.println("PRONTO!");

        System.out.println("Processando os ADD");
        for (String string : add) {
            Map<String, Long> map = new HashMap<>();
            System.out.println("Processando add: " + string + "...");
            DatabaseQuery oldQuery = DatabaseUtils.selectFromTable("statistics_old");
            if (string.startsWith("%")) {
                String info = string.substring(1, string.length() - 1);
                oldQuery.whereLike("statistic_id", info);
            } else {
                oldQuery.whereEquals("statistic_id", string);
            }
            oldQuery.orderBy(OrderType.ASC, "id");
            ResultSet oldResult = oldQuery.executeQuery();
            while (oldResult.next()) {
                String kuid = oldResult.getString("kuid");
                String id = oldResult.getString("statistic_id");
                long value = oldResult.getLong("value");
                String key = kuid + id;
                map.put(key, value);
            }
            DatabaseQuery newQuery = DatabaseUtils.selectFromTable("statistics_new");
            if (string.startsWith("%")) {
                String info = string.substring(1, string.length() - 1);
                newQuery.whereLike("statistic_id", info);
            } else {
                newQuery.whereEquals("statistic_id", string);
            }
            newQuery.orderBy(OrderType.ASC, "id");
            ResultSet newResult = newQuery.executeQuery();
            while (newResult.next()) {
                String kuid = newResult.getString("kuid");
                String id = newResult.getString("statistic_id");
                long value = newResult.getLong("value");
                String key = kuid + id;
                if (map.containsKey(key)) {
                    DatabaseQuery.insertIntoTable("statistics")
                            .openArrays()
                            .setInArray("kuid", kuid)
                            .setInArray("statistic_id", id)
                            .setInArray("value", map.remove(key) + value)
                            .closeArrays().executeUpdate();
                    continue;
                }
                DatabaseQuery.insertIntoTable("statistics")
                        .openArrays()
                        .setInArray("kuid", kuid)
                        .setInArray("statistic_id", id)
                        .setInArray("value", value)
                        .closeArrays().executeUpdate();
            }

            if (!map.isEmpty()) {
                for (String key : new ArrayList<>(map.keySet())) {
                    String kuid = key.substring(0, 24);
                    String id = key.substring(24);
                    long value = map.get(key);
                    DatabaseQuery.insertIntoTable("statistics")
                            .openArrays()
                            .setInArray("kuid", kuid)
                            .setInArray("statistic_id", id)
                            .setInArray("value", value)
                            .closeArrays().executeUpdate();
                }
            }
            map.clear();
        }
        System.out.println("PRONTO!");

        System.out.println("Processando os NEWITEMS:");
        for (String string : newItems) {
            DatabaseQuery newQuery = DatabaseUtils.selectFromTable("statistics_new");
            if (string.startsWith("%")) {
                String info = string.substring(1, string.length() - 1);
                newQuery.whereLike("statistic_id", info);
            } else {
                newQuery.whereEquals("statistic_id", string);
            }
            newQuery.orderBy(OrderType.ASC, "id");
            ResultSet newResult = newQuery.executeQuery();
            while (newResult.next()) {
                String kuid = newResult.getString("kuid");
                String id = newResult.getString("statistic_id");
                long value = newResult.getLong("value");
                String key = kuid + id;
                DatabaseQuery.insertIntoTable("statistics")
                        .openArrays()
                        .setInArray("kuid", kuid)
                        .setInArray("statistic_id", id)
                        .setInArray("value", value)
                        .closeArrays().executeUpdate();
            }
            DatabaseQuery oldQuery = DatabaseUtils.selectFromTable("statistics_old");
            if (string.startsWith("%")) {
                String info = string.substring(1, string.length() - 1);
                oldQuery.whereLike("statistic_id", info);
            } else {
                oldQuery.whereEquals("statistic_id", string);
            }
            oldQuery.orderBy(OrderType.ASC, "id");
            ResultSet oldResult = oldQuery.executeQuery();
            while (oldResult.next()) {
                String kuid = oldResult.getString("kuid");
                String id = oldResult.getString("statistic_id");
                long value = oldResult.getLong("value");
                String key = kuid + id;
                DatabaseQuery.insertIntoTable("statistics")
                        .openArrays()
                        .setInArray("kuid", kuid)
                        .setInArray("statistic_id", id)
                        .setInArray("value", value)
                        .closeArrays().executeUpdate();
            }
        }
        System.out.println("PRONTO!");
    }

}
