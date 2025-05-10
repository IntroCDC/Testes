package br.com.introcdc.tests.kindome;
/*
 * Written by IntroCDC, Bruno Coelho at 29/11/2024 - 02:32
 */

import br.com.introcdc.tests.database.DatabaseUtils;
import br.com.introcdc.tests.database.GlobalDatabase;
import br.com.introcdc.tests.database.StringComponents;
import br.com.introcdc.tests.database.query.OrderType;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

public class ChatReader {

    public static void main(String[] args) throws Exception {
        GlobalDatabase.reloadConnection();
        Map<String, String> kuidMap = StringComponents.hashMap();
        ResultSet resultSet = DatabaseUtils.selectFromTable("chatlog").orderBy(OrderType.ASC, "id").executeQuery();
        int total = 0;
        List<String> lines = StringComponents.arrayList();
        while (resultSet.next()) {
            total++;
            if (total % 1000 == 0) {
                System.out.println("Lendo... " + total);
            }
            String kuid = resultSet.getString("kuid");
            String username;
            if ((username = kuidMap.get(kuid)) == null) {
                ResultSet query = DatabaseUtils.selectFromTable("accounts").whereEquals("kuid", kuid).executeQuery();
                if (!query.next()) {
                    continue;
                }
                username = query.getString("name");
                if (username.equalsIgnoreCase("unseis")) {
                    username = "Seis";
                }
                if (username.equalsIgnoreCase("Introo")) {
                    username = "Intro";
                }
                if (username.equalsIgnoreCase("ysSete")) {
                    username = "Kirito";
                }
                if (username.equalsIgnoreCase("ysafiraa")) {
                    username = "Safira";
                }
                if (username.equalsIgnoreCase("xulhu")) {
                    username = "Jotah";
                }
                if (username.equalsIgnoreCase("undVicente")) {
                    username = "Vicente";
                }
                if (username.equalsIgnoreCase("SombraXD")) {
                    username = "Sombra";
                }
                if (username.equalsIgnoreCase("MeninoNeymar")) {
                    username = "Jaker";
                }
                kuidMap.put(kuid, username);
            }
            String message = resultSet.getString("message");
            if (message.startsWith("!SERVER") || message.startsWith("!QUIT") || message.startsWith("!JOINED") || (message.startsWith("/") && !message.startsWith("/g ") && !message.startsWith("/s ") && !message.startsWith("/tell ") && !message.startsWith("/r ") && !message.startsWith("/msg "))) {
                continue;
            }
            String text = username + ": " + message;
            lines.add(text);
        }
        Path outputFile = Paths.get("C:\\Users\\Bruno\\Desktop\\kindome.txt");
        Files.write(outputFile, lines);
    }

}
