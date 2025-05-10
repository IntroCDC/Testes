package br.com.introcdc.tests.conversor;
/*
 * Written by IntroCDC, Bruno Coelho at 13/11/2022 - 11:02
 */

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.List;
import java.util.*;

public class MapConversor {

    public static String[] SOLO = new String[]{"Solo-1: airshow", "Solo-2: amazon", "Solo-3: aquarius", "Solo-4: ashfire", "Solo-5: clearing", "Solo-6: crogorm", "Solo-7: crumble", "Solo-8: dessertedislands", "Solo-9: dragonstar", "Solo-10: easterbasket", "Solo-11: egghunt", "Solo-12: elven", "Solo-13: entangled", "Solo-14: fossil", "Solo-15: frostbite", "Solo-16: glacier", "Solo-17: hollow", "Solo-18: lighthouse", "Solo-19: onionring2", "Solo-20: orchestra", "Solo-21: overfall", "Solo-22: pernicious", "Solo-23: plateau", "Solo-24: railroad", "Solo-25: rooftop", "Solo-26: sanctum", "Solo-27: solace", "Solo-28: speedway", "Solo-29: tiki", "Solo-30: tundra", "Solo-31: waterfall", "Solo-32: zarzul"};

    public static String[] DOUBLES = new String[]{"Doubles-1: airshow", "Doubles-2: amazon", "Doubles-3: aquarius", "Doubles-4: ashfire", "Doubles-5: clearing", "Doubles-6: crogorm", "Doubles-7: crumble", "Doubles-8: dessertedislands", "Doubles-9: dragonstar", "Doubles-10: easterbasket", "Doubles-11: egghunt", "Doubles-12: elven", "Doubles-13: entangled", "Doubles-14: fossil", "Doubles-15: frostbite", "Doubles-16: glacier", "Doubles-17: hollow", "Doubles-18: lighthouse", "Doubles-19: onionring2", "Doubles-20: orchestra", "Doubles-21: overfall", "Doubles-22: pernicious", "Doubles-23: plateau", "Doubles-24: railroad", "Doubles-25: rooftop", "Doubles-26: sanctum", "Doubles-27: solace", "Doubles-28: speedway", "Doubles-29: tiki", "Doubles-30: tundra", "Doubles-31: waterfall", "Doubles-32: zarzul"};

    public static String[] V3 = new String[]{"3v3v3v3-1: aquarium", "3v3v3v3-2: ashore", "3v3v3v3-3: boletum", "3v3v3v3-4: carapace", "3v3v3v3-5: chained", "3v3v3v3-6: cryptic", "3v3v3v3-7: dreamgrove", "3v3v3v3-8: eastwood", "3v3v3v3-9: gardens", "3v3v3v3-10: lectus", "3v3v3v3-11: obelisk", "3v3v3v3-12: picnic", "3v3v3v3-13: ruins", "3v3v3v3-14: sandcastle", "3v3v3v3-15: stonekeep", "3v3v3v3-16: temple", "3v3v3v3-17: treenan", "3v3v3v3-18: unturned"};

    public static String[] V4 = new String[]{"4v4v4v4-1: aquarium", "4v4v4v4-2: ashore", "4v4v4v4-3: boletum", "4v4v4v4-4: carapace", "4v4v4v4-5: chained", "4v4v4v4-6: cryptic", "4v4v4v4-7: dreamgrove", "4v4v4v4-8: eastwood", "4v4v4v4-9: gardens", "4v4v4v4-10: lectus", "4v4v4v4-11: obelisk", "4v4v4v4-12: picnic", "4v4v4v4-13: ruins", "4v4v4v4-14: sandcastle", "4v4v4v4-15: stonekeep", "4v4v4v4-16: temple", "4v4v4v4-17: treenan", "4v4v4v4-18: unturned"};

    public static Map<String, String> mapNameMap(String type) {
        String[] base = type.equalsIgnoreCase("solo") ? SOLO : type.equalsIgnoreCase("doubles") ? DOUBLES : type.equalsIgnoreCase("3v3v3v3") ? V3 : type.equalsIgnoreCase("4v4v4v4") ? V4 : null;
        if (base == null) {
            System.exit(0);
            System.out.println("OCORREU UM ERRO AO REGISTRAR O MAPA TIPO " + type);
            return null;
        }
        Map<String, String> mapName = new HashMap();
        for (String string : base) {
            String[] split = string.split(": ");
            mapName.put(split[0], split[1]);
        }
        return mapName;
    }

    public static String fileName(String mapName, String type) {
        return mapName + (type.equalsIgnoreCase("Doubles") ? "-2" : type.equalsIgnoreCase("3v3v3v3") ? "-3" : "") + ".yml";
    }

    public static Robot robot;
    public static int delay = 600;
    public static java.util.List<String> colors = Arrays.asList("vermelho", "azul", "verde", "amarelo", "ciano", "branco", "rosa", "cinza");
    public static java.util.List<String> ignoreMaps = Arrays.asList("4v4v4v4-17", "4v4v4v4-16", "4v4v4v4-18", "4v4v4v4-13", "4v4v4v4-12",
            "4v4v4v4-15");

    public static MapInfo convertInfo(String worldName, String type) throws Exception {
        File file = new File("C:\\Users\\Bruno\\Desktop\\convert\\old\\" + fileName(worldName, type));
        if (!file.exists()) {
            return null;
        }
        Scanner scanner = new Scanner(file);
        String displayName = worldName;
        String lobbyLocation = null;
        String lobbyB1 = null;
        String lobbyB2 = null;

        String state = null;
        String currentTeam = null;
        String spawn = null;
        String bed = null;
        String shop = null;
        String generator = null;
        String subState = null;

        java.util.List<String> diamond = new ArrayList();
        java.util.List<String> emerald = new ArrayList();

        double up = 0.0;
        double down = 1000.0;
        double maxX = 0.0;
        double minX = 0.0;
        double maxZ = 0.0;
        double minZ = 0.0;

        Map<String, TeamInfo> teamList = new HashMap();

        while (scanner.hasNextLine()) {
            String rawLine = scanner.nextLine().replace(" ", "");
            System.out.println(rawLine);
            String line = rawLine.replace(":", "PPPPP");
            if (line.contains("PPPPP")) {

                String[] split = line.split("PPPPP");
                String setting = split[0].replace("PPPPP", "");
                String value = null;
                if (split.length > 1) {
                    value = split[1];
                }

                if (setting.equalsIgnoreCase("display-name")) {
                    displayName = value;
                } else if (setting.equalsIgnoreCase("waiting")) {
                    state = "lobby";
                } else if (setting.equalsIgnoreCase("Team")) {
                    state = "team";
                } else if (setting.equalsIgnoreCase("generator")) {
                    state = "generator";
                } else if (setting.equalsIgnoreCase("diamond") && state.equalsIgnoreCase("generator")) {
                    subState = "diamond";
                } else if (setting.equalsIgnoreCase("emerald") && state.equalsIgnoreCase("generator")) {
                    subState = "emerald";
                } else if (setting.equalsIgnoreCase("loc")) {
                    if (state.equalsIgnoreCase("lobby")) {
                        lobbyLocation = value.replace(",", " ");
                        double[] location = convertToArray(lobbyLocation);
                        up = location[1] + 10;
                    }
                } else if (setting.equalsIgnoreCase("pos1")) {
                    if (state.equalsIgnoreCase("lobby")) {
                        lobbyB1 = value.replace(",", " ");
                    }
                } else if (setting.equalsIgnoreCase("pos2")) {
                    if (state.equalsIgnoreCase("lobby")) {
                        lobbyB2 = value.replace(",", " ");
                    }
                } else if (setting.equalsIgnoreCase("spawn")) {
                    spawn = value.replace(",", " ");
                    double[] pos = convertToArray(spawn);

                    if ((pos[0] + 30) > maxX) {
                        maxX = (pos[0] + 30);
                    }
                    if ((pos[2] + 30) > maxZ) {
                        maxZ = (pos[2] + 30);
                    }
                    if ((pos[0] - 30) < minX) {
                        minX = (pos[0] - 30);
                    }
                    if ((pos[2] - 30) < minZ) {
                        minZ = (pos[2] - 30);
                    }
                    if ((pos[1] - 30) < down) {
                        down = Math.max((pos[1] - 30), 0);
                    }

                } else if (setting.equalsIgnoreCase("bed")) {
                    double[] pos = convertToArray(value.replace(",", " "));
                    bed = pos[0] + " " + pos[1] + " " + pos[2] + " 0 90.0";
                } else if (setting.equalsIgnoreCase("shop")) {
                    shop = value.replace(",", " ");
                } else if (setting.equalsIgnoreCase("upgrade")) {
                    teamList.put(currentTeam, new TeamInfo(currentTeam, spawn, bed, generator, shop, value.replace(",", " ")));
                }

                for (String color : colors) {
                    if (setting.equalsIgnoreCase(color)) {
                        state = "team";
                        currentTeam = color;
                    }
                }

            } else if (line.startsWith("-")) {
                if (state == null) {
                    continue;
                }
                if (state.equalsIgnoreCase("team")) {
                    generator = line.substring(1).replace(",", " ");
                } else if (state.equalsIgnoreCase("generator")) {
                    if (subState.equalsIgnoreCase("diamond")) {
                        diamond.add(line.substring(1).replace(",", " "));
                    } else if (subState.equalsIgnoreCase("emerald")) {
                        emerald.add(line.substring(1).replace(",", " "));
                    }
                }
            }

        }
        scanner.close();

        return new MapInfo(displayName, lobbyLocation, lobbyB1, lobbyB2, teamList, diamond, emerald, up, down, maxX, maxZ, minX, minZ);
    }

    public static void start() throws Exception {
        robot = new Robot();
        sleep(delay * 5L);
        startMapRegister();
    }

    public static void startMapRegister() throws Exception {
        for (String type : new String[]{"Solo", "Doubles", "3v3v3v3", "4v4v4v4"}) {
            if (type.equalsIgnoreCase("Solo")) {
                continue;
            }
            if (type.equalsIgnoreCase("Doubles")) {
                continue;
            }
            if (type.equalsIgnoreCase("3v3v3v3")) {
                continue;
            }

            System.out.println("INICIANDO REGISTRO DOS MAPAS: " + type);
            Map<String, String> originalName = mapNameMap(type);

            for (String worldName : originalName.keySet()) {
                String mapName = originalName.get(worldName);
                System.out.println("INICIANDO REGISTRO " + type + ": " + worldName + "/" + mapName);
                if (ignoreMaps.contains(worldName)) {
                    continue;
                }
                MapInfo mapInfo = convertInfo(mapName.toLowerCase(), type.toLowerCase());
                if (mapInfo == null) {
                    continue;
                }
                sleep(delay * 10L);
                startRegisterMap(mapInfo, worldName, type);
            }
        }

        Runtime.getRuntime().exec("cmd.exe /c shutdown /s /t 10");
    }

    public static void sleep(long milliseconds) throws Exception {
        if (milliseconds > (delay / 10)) {
            System.out.println("Aguardando: " + milliseconds + " milli-segundos");
        }
        Thread.sleep(milliseconds);
    }

    public static void startRegisterMap(MapInfo mapInfo, String worldName, String type) throws Exception {
        executeCommand("/gamemode creative");
        executeCommand("/fly on");
        sleep(delay);

        executeCommand("/mw create " + worldName);
        sleep(delay);
        executeCommand("/mw load " + worldName);
        sleep(delay * 30L);
        executeCommand("/mw move Introo " + worldName);
        for (int i = 0; i <= 10; i++) {
            sleep(delay);
            executeCommand("/gamemode creative");
            executeCommand("/tp 0 300 0");
        }
        replaceNear(true, mapInfo.getEmerald(), mapInfo.minLocation(), mapInfo.maxLocation());
        sleep(delay);
        replaceNear(false, mapInfo.getDiamond(), mapInfo.minLocation(), mapInfo.maxLocation());
        sleep(delay);
        executeCommand("/gamemode creative");
        executeCommand("/fly on");
        sleep(delay);
        executeCommand("/lbw create " + type.toLowerCase() + " " + mapInfo.getDisplayName());

        // First position
        sleep(delay);
        teleport(mapInfo.minLocation());
        sleep(delay * 3L);
        executeCommand("//up 1");
        sleep(delay);
        executeCommand("/minecraft:tp ~ ~ ~ 0 90");
        sleep(delay);
        changeSlot(2);
        sleep(delay);
        click(true);
        sleep(delay);
        executeCommand("/setblock ~ ~-1 ~ air");

        // Second position
        sleep(delay);
        teleport(mapInfo.maxLocation());
        sleep(delay * 3L);
        executeCommand("//up 1");
        sleep(delay);
        executeCommand("/minecraft:tp ~ ~ ~ 0 90");
        sleep(delay);
        click(false);
        sleep(delay);
        executeCommand("/setblock ~ ~-1 ~ air");

        // Lobby - ERROR: 4v4v4v4-15
        sleep(delay);
        changeSlot(3);
        sleep(delay);
        teleport(mapInfo.getLobbyB1());
        sleep(delay);
        executeCommand("//up 1");
        sleep(delay * 3L);
        executeCommand("/minecraft:tp ~ ~ ~ 0 90");
        sleep(delay);
        click(true);
        sleep(delay);
        executeCommand("/setblock ~ ~-1 ~ air");
        sleep(delay);
        teleport(mapInfo.getLobbyB2());
        sleep(delay);
        executeCommand("//up 1");
        sleep(delay);
        executeCommand("/minecraft:tp ~ ~ ~ 0 90");
        sleep(delay);
        click(false);
        sleep(delay);
        executeCommand("/setblock ~ ~-1 ~ air");
        sleep(delay);
        teleport(mapInfo.getLobbyLocation());
        sleep(delay);
        executeCommand("//paste");
        sleep(delay * 3L);
        changeSlot(4);
        sleep(delay);
        click(false);
        sleep(delay);
        changeSlot(7);
        sleep(delay);
        click(false);
        sleep(delay * 45L);

        // Team Spawns
        executeCommand("/gamemode creative");
        executeCommand("/fly on");

        int current = 0;
        for (String color : colors) {
            current++;
            boolean crash = current > mapInfo.getTeamInfoMap().size();
            if (!mapInfo.getTeamInfoMap().containsKey(color)) {
                crash = true;
            }
            if (crash) {
                sleep(delay);
                changeSlot(9);
                sleep(delay);
                click(false);
                sleep(delay * 2L);
                break;
            }
            TeamInfo teamInfo = mapInfo.getTeamInfoMap().get(color);

            // Spawn
            sleep(delay);
            teleport(teamInfo.getSpawn());
            sleep(delay);
            changeSlot(1);
            sleep(delay);
            click(false);

            // Generator
            sleep(delay);
            teleport(teamInfo.getGenerator());
            sleep(delay);
            changeSlot(2);
            sleep(delay);
            click(false);

            // Shop
            sleep(delay);
            teleport(teamInfo.getShop());
            sleep(delay);
            changeSlot(4);
            sleep(delay);
            click(false);

            // Upgrades
            sleep(delay);
            teleport(teamInfo.getUpgrades());
            sleep(delay);
            changeSlot(5);
            sleep(delay);
            click(false);

            // Bed
            sleep(delay);
            teleport(teamInfo.getBed());
            sleep(delay);
            changeSlot(3);
            sleep(delay);
            click(false);

            sleep(delay);
            changeSlot(8);
            sleep(delay);
            click(false);
            sleep(delay * 2L);
        }
    }

    public static void changeSlot(int slot) throws Exception {
        int keyCode = switch (slot) {
            case 1 -> KeyEvent.VK_1;
            case 2 -> KeyEvent.VK_2;
            case 3 -> KeyEvent.VK_3;
            case 4 -> KeyEvent.VK_4;
            case 5 -> KeyEvent.VK_5;
            case 6 -> KeyEvent.VK_6;
            case 7 -> KeyEvent.VK_7;
            case 8 -> KeyEvent.VK_8;
            case 9 -> KeyEvent.VK_9;
            default -> 0;
        };

        robot.keyPress(keyCode);
        sleep(20);
        robot.keyRelease(keyCode);
        sleep(delay);
    }


    public static void replaceNear(boolean emerald, List<String> locationList, String posOne, String posTwo) throws Exception {
        executeCommand("/gamemode spectator");
        sleep(delay);
        teleport(posOne);
        sleep(delay);
        executeCommand("//pos1");
        sleep(delay);
        teleport(posTwo);
        executeCommand("//pos2");
        sleep(delay);
        String from = emerald ? "emerald" : "diamond_block";
        String to = emerald ? "wool:5" : "wool:9";

        executeCommand("//replace " + from + " " + to);
        sleep(delay * 10L);

        for (String location : locationList) {
            sleep(delay);
            teleport(location);
            sleep(delay);
            executeCommand("//replacenear 1 " + to + " " + from);
        }
    }

    public static double[] convertToArray(String location) {
        return new double[]{Double.parseDouble(location.split(" ")[0]), Double.parseDouble(location.split(" ")[1]), Double.parseDouble(location.split(" ")[2])};
    }

    public static void teleport(String location) throws Exception {
        executeCommand("/minecraft:tp " + location);
    }

    public static void click(boolean leftClick) throws Exception {
        if (leftClick) {
            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            sleep(20);
            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        } else {
            robot.mousePress(InputEvent.BUTTON3_DOWN_MASK);
            sleep(20);
            robot.mouseRelease(InputEvent.BUTTON3_DOWN_MASK);
        }
    }

    public static void executeCommand(String command) throws Exception {
        // Set clipboard
        System.out.println("Executando comando: " + command);

        StringSelection selection = new StringSelection(command);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(selection, selection);

        // Open Chat
        robot.keyPress(KeyEvent.VK_T);
        sleep(10);
        robot.keyRelease(KeyEvent.VK_T);
        sleep(10);

        robot.keyPress(KeyEvent.VK_CONTROL);
        sleep(100);
        robot.keyPress(KeyEvent.VK_V);
        sleep(100);
        robot.keyRelease(KeyEvent.VK_V);
        sleep(100);
        robot.keyRelease(KeyEvent.VK_CONTROL);

        sleep(100);
        robot.keyPress(KeyEvent.VK_ENTER);
        sleep(10);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }

}
