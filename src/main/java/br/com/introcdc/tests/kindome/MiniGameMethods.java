package br.com.introcdc.tests.kindome;
/*
 * Written by IntroCDC, Bruno Coelho at 27/04/2024 - 15:56
 */

import br.com.introcdc.tests.game.GameMatch;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.FileReader;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;

public class MiniGameMethods {

    public static void main(String[] args) throws Exception {
        actionPerMiniGame();
    }

    public static void actionPerMiniGame() throws Exception {
        JsonParser parser = new JsonParser();
        JsonArray jsonArray = parser.parse(new FileReader("C:/Kindome/config/minigames.json")).getAsJsonArray();

        PrintWriter writer = new PrintWriter("C:/Users/Bruno/Desktop/result.txt");

        List<String> done = List.of("MegaLuckyBlock", "LuckyBlockRace", "OneLuckyBlock", "LuckyBlockWorld", "UNO", "LuckyDoors", "SheepRace",
                "CastleSiege", "DeathTag", "SuperJokenpo", "TrapRace", "OITC", "ObsidianHunt", "GunGame", "SpeedBuilders", "ContinentalWar", "MobWar",
                "Football", "BeeWars", "MazeGame", "RavagerGame", "YellowClock", "BlockDash", "SkyGrid", "Spleef", "Splegg", "BowSpleef", "Leeaf",
                "GlassGame", "PaintArena", "Fisherman", "GlassBridge", "IceFloor", "MiniGolf", "DripFight", "WallGame");
        System.out.println("MINIGAMES: " + done.size() + "/200 (" + GameMatch.percent(done.size(), 200) + "%)");

        Scanner scanner = new Scanner(System.in);
        for (JsonElement jsonElement : jsonArray) {
            JsonObject jsonObject = jsonElement.getAsJsonObject();
            for (JsonElement element : jsonObject.get("minigames").getAsJsonArray()) {
                JsonObject object = element.getAsJsonObject();
                if (done.contains(object.get("name").getAsString())) {
                    continue;
                }

                writer.println(object.get("name").getAsString());
                writer.println("poderia fazer sub-tópicos para um documento para este minigame \"" + object.get("description").getAsString() + "\"?");
                writer.println();
                writer.println();
                writer.flush();
            }
        }

        writer.close();
    }

}
