package br.com.introcdc.tests.game;
/*
 * Written by IntroCDC, Bruno Coêlho at 10/04/2024 - 15:43
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameMain {

    public static void main(String[] args) {
        GameRegister.registerTeams();
        startGame();
    }

    // VARIABLES
    public static int YEAR = 2025;
    public static int MIN_TICKET = 10;
    public static int TICK = 100;
    public static int TIME = 5000;
    public static int GOAL_TICK = 30;
    public static boolean RANDOM = true;

    public static List<String> FOLLOW_CUP = List.of();
    public static List<String> PRINTS_ONLY = List.of("CEARÁ", "NORDESTE", "1", "BRASIL", "SUPERCOPA", "SULAMERICANA", "LIBERTADORES", "MUNDIAL");

    public static void startGame() {
        newSeason();
    }

    public static void newSeason() {
        GameCup.getCupList().clear();

        GameRegister.registerStateCups();
        List<GameCup> one = new ArrayList<>(GameCup.getCupList());
        if (RANDOM) {
            Collections.shuffle(one);
        }
        for (GameCup gameCup : one) {
            if (gameCup.isExecuted()) {
                continue;
            }
            gameCup.startCup();
        }

        GameRegister.registerRegionCups();
        List<GameCup> two = new ArrayList<>(GameCup.getCupList());
        if (RANDOM) {
            Collections.shuffle(two);
        }
        for (GameCup gameCup : two) {
            if (gameCup.isExecuted()) {
                continue;
            }
            gameCup.startCup();
        }

        GameRegister.registerBrasilCups();
        List<GameCup> three = new ArrayList<>(GameCup.getCupList());
        if (RANDOM) {
            Collections.shuffle(three);
        }
        for (GameCup gameCup : three) {
            if (gameCup.isExecuted()) {
                continue;
            }
            gameCup.startCup();
        }

        GameCup superCup = new GameCup("Supercopa do Brasil", "Supercopa", 10_000_000, GameCupType.ELIMINATION, team -> false, 0, GameCupRegionType.COUNTRY, false);
        List<GameTeam> brasilTeams = new ArrayList<>();
        for (GameCup gameCup : new GameCup[]{GameCup.get("Brasil"), GameCup.get("1")}) {
            int more = -1;
            GameTeam moreTeam = null;
            for (GameTeam gameTeam : gameCup.getTeams()) {
                if (superCup.getTeams().contains(gameTeam)) {
                    continue;
                }
                if (gameCup.getPoints().get(gameTeam) > more) {
                    more = gameCup.getPoints().get(gameTeam);
                    moreTeam = gameTeam;
                }
            }

            superCup.getTeams().add(moreTeam);
            superCup.getReason().put(moreTeam, "Campeão " + gameCup.getName());
            if (gameCup.getKey().equalsIgnoreCase("Brasil")) {
                brasilTeams.add(moreTeam);
            }
        }
        superCup.startCup();

        GameRegister.registerInternacionalCups();
        List<GameCup> four = new ArrayList<>(GameCup.getCupList());
        if (RANDOM) {
            Collections.shuffle(four);
        }
        for (GameCup gameCup : four) {
            if (gameCup.isExecuted()) {
                continue;
            }
            gameCup.startCup();
        }

        GameCup libertadores = new GameCup("Conmebol Libertadores", "Libertadores", 140_000_000, GameCupType.ELIMINATION, team -> false, 0, GameCupRegionType.CONTINENT, false);
        GameCup sulamericana = new GameCup("Conmebol Sul-americana", "Sulamericana", 40_000_000, GameCupType.ELIMINATION, team -> false, 0, GameCupRegionType.CONTINENT, false);
        libertadores.getTeams().add(brasilTeams.get(0));
        String plusOne = brasilTeams.get(0).getName();
        for (GameCup gameCup : new GameCup[]{GameCup.get("1"),
                GameCup.get("Argentina"), GameCup.get("Bolívia"), GameCup.get("Chile"), GameCup.get("Colômbia"),
                GameCup.get("Equador"), GameCup.get("Paraguai"), GameCup.get("Peru"), GameCup.get("Uruguai"), GameCup.get("Venezuela")}) {
            for (int i = 1; i <= 8; i++) {
                GameCup sel = i <= 4 ? libertadores : sulamericana;
                int more = -1;
                GameTeam moreTeam = null;
                for (GameTeam gameTeam : gameCup.getTeams()) {
                    if (gameTeam.getName().equalsIgnoreCase(plusOne)) {
                        continue;
                    }
                    if (sel.getTeams().contains(gameTeam)) {
                        continue;
                    }
                    if (gameCup.getPoints().get(gameTeam) > more) {
                        more = gameCup.getPoints().get(gameTeam);
                        moreTeam = gameTeam;
                    }
                }

                sel.getTeams().add(moreTeam);
                sel.getReason().put(moreTeam, i + "º lugar na " + gameCup.getName());
            }
        }
        for (GameTeam gameTeam : brasilTeams) {
            if (libertadores.getTeams().contains(gameTeam) || sulamericana.getTeams().contains(gameTeam)) {
                continue;
            }
            sulamericana.getTeams().add(gameTeam);
            break;
        }

        sulamericana.startCup();
        libertadores.startCup();

        GameRegister.registerOutsideCups();
        List<GameCup> five = new ArrayList<>(GameCup.getCupList());
        if (RANDOM) {
            Collections.shuffle(five);
        }
        for (GameCup gameCup : five) {
            if (gameCup.isExecuted()) {
                continue;
            }
            gameCup.startCup();
        }

        GameCup mundial = new GameCup("Mundial", "Mundial", 250_000_000, GameCupType.ELIMINATION, team -> false, 0, GameCupRegionType.MUNDIAL, false);
        for (GameCup gameCup : new GameCup[]{GameCup.get("Libertadores"), GameCup.get("América"), GameCup.get("Europa"), GameCup.get("Ásia"), GameCup.get("África")}) {
            for (int i = 1; i <= 2; i++) {
                int more = -1;
                GameTeam moreTeam = null;
                for (GameTeam gameTeam : gameCup.getTeams()) {
                    if (mundial.getTeams().contains(gameTeam)) {
                        continue;
                    }
                    if (gameCup.getPoints().get(gameTeam) > more) {
                        more = gameCup.getPoints().get(gameTeam);
                        moreTeam = gameTeam;
                    }
                }

                mundial.getTeams().add(moreTeam);
                mundial.getReason().put(moreTeam, (i == 1 ? "Campeão" : "Vice-Campeão") + " da " + gameCup.getName());
            }
        }
        mundial.startCup();

        if (GameCup.END_CODE) {
            System.exit(0);
        }

        try {
            Thread.sleep(TIME * 5L);
        } catch (InterruptedException ignored) {
        }

        YEAR++;
    }

}
