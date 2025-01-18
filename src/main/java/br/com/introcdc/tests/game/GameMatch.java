package br.com.introcdc.tests.game;
/*
 * Written by IntroCDC, Bruno Coêlho at 10/04/2024 - 15:44
 */

import java.util.Random;

public class GameMatch {

    private final GameCup gameCup;
    private boolean matchExecuted = false;
    private int time = 0;

    private final GameTeam homeTeam;
    private final GameTeam visitorTeam;

    private int homeChances;
    private int drawChances;
    private int visitorChances;

    private int homePoints = 0;
    private int visitorPoints = 0;

    public GameMatch(GameCup gameCup, GameTeam homeTeam, GameTeam visitorTeam) {
        this.gameCup = gameCup;
        this.homeTeam = homeTeam;
        this.visitorTeam = visitorTeam;
    }

    public boolean isMatchExecuted() {
        return matchExecuted;
    }

    public void setMatchExecuted(boolean matchExecuted) {
        this.matchExecuted = matchExecuted;
    }

    public GameCup getGameCup() {
        return gameCup;
    }

    public GameTeam getHomeTeam() {
        return homeTeam;
    }

    public GameTeam getVisitorTeam() {
        return visitorTeam;
    }

    public double getHomeChances() {
        return homeChances;
    }

    public double getDrawChances() {
        return drawChances;
    }

    public double getVisitorChances() {
        return visitorChances;
    }

    public int getHomePoints() {
        return homePoints;
    }

    public void addHomePoints() {
        this.homePoints++;
        getHomeTeam().addGoal();
        getHomeTeam().addSg();
        getVisitorTeam().addGoalt();
        getVisitorTeam().removeSg();
        getGameCup().getPoints().put(getHomeTeam(), getGameCup().getPoints().getOrDefault(getHomeTeam(), 0) + 1);
        getGameCup().getGoals().put(getHomeTeam(), getGameCup().getGoals().getOrDefault(getHomeTeam(), 0) + 1);
        getGameCup().getGoalst().put(getVisitorTeam(), getGameCup().getGoalst().getOrDefault(getVisitorTeam(), 0) + 1);
        getGameCup().getSg().put(getHomeTeam(), getGameCup().getSg().getOrDefault(getHomeTeam(), 0) + 1);
        getGameCup().getSg().put(getVisitorTeam(), getGameCup().getSg().getOrDefault(getVisitorTeam(), 0) - 1);
        log("GOL DO " + getHomeTeam().getName().toUpperCase() + "!!!!! (" + time + "')");
        log(getHomeTeam().getName() + " " + getHomePoints() + " x " + getVisitorPoints() + " " + getVisitorTeam().getName());
    }

    public int getVisitorPoints() {
        return visitorPoints;
    }

    public void addVisitorPoints() {
        this.visitorPoints++;
        getVisitorTeam().addGoal();
        getVisitorTeam().addSg();
        getHomeTeam().addGoalt();
        getHomeTeam().removeSg();
        getGameCup().getPoints().put(getVisitorTeam(), getGameCup().getPoints().getOrDefault(getVisitorTeam(), 0) + 1);
        getGameCup().getGoals().put(getVisitorTeam(), getGameCup().getGoals().getOrDefault(getVisitorTeam(), 0) + 1);
        getGameCup().getGoalst().put(getHomeTeam(), getGameCup().getGoalst().getOrDefault(getHomeTeam(), 0) + 1);
        getGameCup().getSg().put(getVisitorTeam(), getGameCup().getSg().getOrDefault(getVisitorTeam(), 0) + 1);
        getGameCup().getSg().put(getHomeTeam(), getGameCup().getSg().getOrDefault(getHomeTeam(), 0) - 1);
        log("GOL DO " + getVisitorTeam().getName().toUpperCase() + "!!!!! (" + time + "')");
        log(getHomeTeam().getName() + " " + getHomePoints() + " x " + getVisitorPoints() + " " + getVisitorTeam().getName());
    }

    public void calculateChances() {
        int home = 11 - getHomeTeam().getDivision();
        int visitor = 11 - getVisitorTeam().getDivision();

        if (getHomeTeam().getGoals() > getVisitorTeam().getGoals()) {
            home += 5;
        } else {
            visitor += 5;
        }
        if (getHomeTeam().getVictories() > getVisitorTeam().getVictories()) {
            home += 5;
        } else {
            visitor += 5;
        }
        if (getHomeTeam().getDivision() > getVisitorTeam().getDivision()) {
            home += 5;
        } else {
            visitor += 5;
        }
        if (getHomeTeam().getTitles() > getVisitorTeam().getTitles()) {
            home += 10;
        } else {
            visitor += 10;
        }
        if (getHomeTeam().getLoses() > getVisitorTeam().getLoses()) {
            if (home > 2) {
                home -= 2;
            }
        } else {
            if (visitor > 2) {
                visitor -= 2;
            }
        }

        int draw = 100 - (home + visitor);

        homeChances = home;
        visitorChances = visitor;
        drawChances = draw;
    }

    public static int percent(long current, long max) {
        return max <= 0 ? 0 : (int) current * 100 / (int) max;
    }

    public void startMatch() {
        calculateChances();
        getGameCup().setMatches(getGameCup().getMatches() + 1);

        Random random = new Random();
        getHomeTeam().addMatch();
        getVisitorTeam().addMatch();
        getGameCup().getMatchs().put(getHomeTeam(), getGameCup().getMatchs().getOrDefault(getHomeTeam(), 0) + 1);
        getGameCup().getMatchs().put(getVisitorTeam(), getGameCup().getMatchs().getOrDefault(getVisitorTeam(), 0) + 1);
        int publicStadium = random.nextInt(getHomeTeam().getStadiumAmount());
        int ticket = GameMain.MIN_TICKET + random.nextInt(Math.max(getHomeTeam().getVictories(), 1)) + random.nextInt(Math.max(1, getVisitorTeam().getVictories()));
        int total = ticket * publicStadium;
        long prevMoney = getHomeTeam().getMoney();
        getHomeTeam().setMoney(getHomeTeam().getMoney() + total);

        boolean follow = follow();
        log("=======");
        log("INICIANDO PARTIDA");

        log(getGameCup().getName().toUpperCase() + " " + GameMain.YEAR + " - Partida: " + getGameCup().getMatches() + "/" + getGameCup().getMatchList().size() + " - " +
                percent(getGameCup().getMatches(), getGameCup().getMatchList().size()) + "%");
        log(getHomeTeam().getName() + " (" + getHomeTeam().getState() + ";" + getHomeTeam().division() + ";" + getHomeTeam().getCountry() + ") " + getHomePoints() + " x "
                + getVisitorPoints() + " " + getVisitorTeam().getName() + " (" + getVisitorTeam().getState() + ";" + getVisitorTeam().division() + ";" + getVisitorTeam().getCountry() + ")");
        log("Estádio: " + getHomeTeam().getStadium() + " (Público: " + publicStadium + "/" + getHomeTeam().getStadiumAmount() +
                " - " + percent(publicStadium, getHomeTeam().getStadiumAmount()) + "%) - Ingresso: R$ " + GameCup.formatNumber(ticket) +
                " (Renda: R$ " + GameCup.formatNumber(total) + " - R$ " + GameCup.formatNumber(prevMoney) + " => R$ " + GameCup.formatNumber(getHomeTeam().getMoney()) + ")");
        log("=======");
        if (follow) {
            try {
                Thread.sleep(GameMain.TIME);
            } catch (InterruptedException ignored) {
            }
        }

        while (time <= 90) {
            time++;
            if (follow) {
                try {
                    Thread.sleep(GameMain.TICK);
                } catch (InterruptedException ignored) {
                }
            }
            if (time == 45) {
                log("INTERVALO!!! " + getHomeTeam().getName() + " " + getHomePoints() + " x " + getVisitorPoints() + " " + getVisitorTeam().getName());
                continue;
            }

            if (random.nextInt(GameMain.GOAL_TICK) == 0) {
                if (random.nextBoolean()) {
                    addHomePoints();
                } else {
                    addVisitorPoints();
                }
                continue;
            }
            if (random.nextInt(GameMain.GOAL_TICK) != 0) {
                continue;
            }

            int value = random.nextInt(100) + 1;

            String resultado;
            if (value <= getHomeChances()) {
                addHomePoints();
            } else if (value >= (100 - getVisitorChances())) {
                addVisitorPoints();
            }
        }
        log("=======");
        log("FIM DE PARTIDA");
        log(getGameCup().getName().toUpperCase() + " " + GameMain.YEAR + " - Partida: " + getGameCup().getMatches() + "/" + getGameCup().getMatchList().size() + " - " +
                percent(getGameCup().getMatches(), getGameCup().getMatchList().size()) + "%");
        log("Estádio: " + getHomeTeam().getStadium() + " (Público: " + publicStadium + "/" + getHomeTeam().getStadiumAmount() +
                " - " + percent(publicStadium, getHomeTeam().getStadiumAmount()) + "%) - Ingresso: R$ " + GameCup.formatNumber(ticket) +
                " (Renda: R$ " + GameCup.formatNumber(total) + " - R$ " + GameCup.formatNumber(prevMoney) + " => R$ " + GameCup.formatNumber(getHomeTeam().getMoney()) + ")");
        log(getHomeTeam().getName() + " (" + getHomeTeam().getState() + ";" + getHomeTeam().division() + ";" + getHomeTeam().getCountry() + ") " + getHomePoints() + " x "
                + getVisitorPoints() + " " + getVisitorTeam().getName() + " (" + getVisitorTeam().getState() + ";" + getVisitorTeam().division() + ";" + getVisitorTeam().getCountry() + ")");

        if (getHomePoints() > getVisitorPoints()) {
            log("GANHADOR: " + getHomeTeam().getName().toUpperCase() + " (" + getHomeTeam().getState() + ";" + getHomeTeam().getCountry() + ")");
            getHomeTeam().addVictory();
            getVisitorTeam().addLose();
            getGameCup().getPoints().put(getHomeTeam(), getGameCup().getPoints().getOrDefault(getHomeTeam(), 0) + 3000);
            getGameCup().getVictories().put(getHomeTeam(), getGameCup().getVictories().getOrDefault(getHomeTeam(), 0) + 1);
            getGameCup().getLoses().put(getVisitorTeam(), getGameCup().getLoses().getOrDefault(getVisitorTeam(), 0) + 1);
        } else if (getVisitorPoints() > getHomePoints()) {
            log("GANHADOR: " + getVisitorTeam().getName().toUpperCase() + " (" + getVisitorTeam().getState() + ";" + getVisitorTeam().getCountry() + ")");
            getVisitorTeam().addVictory();
            getHomeTeam().addLose();
            getGameCup().getPoints().put(getVisitorTeam(), getGameCup().getPoints().getOrDefault(getVisitorTeam(), 0) + 3000);
            getGameCup().getVictories().put(getVisitorTeam(), getGameCup().getVictories().getOrDefault(getVisitorTeam(), 0) + 1);
            getGameCup().getLoses().put(getHomeTeam(), getGameCup().getLoses().getOrDefault(getHomeTeam(), 0) + 1);
        } else {
            log("EMPATE!!!!");
            getVisitorTeam().addDraw();
            getHomeTeam().addDraw();
            getGameCup().getPoints().put(getHomeTeam(), getGameCup().getPoints().getOrDefault(getHomeTeam(), 0) + 1000);
            getGameCup().getPoints().put(getVisitorTeam(), getGameCup().getPoints().getOrDefault(getVisitorTeam(), 0) + 1000);
            getGameCup().getDraw().put(getVisitorTeam(), getGameCup().getDraw().getOrDefault(getVisitorTeam(), 0) + 1);
            getGameCup().getDraw().put(getHomeTeam(), getGameCup().getDraw().getOrDefault(getHomeTeam(), 0) + 1);
        }

        log("=======");

        setMatchExecuted(true);
        if (follow) {
            try {
                Thread.sleep(GameMain.TIME);
            } catch (InterruptedException ignored) {
            }
        }
        getGameCup().showPoints(false, follow);
        if (follow) {
            try {
                Thread.sleep(GameMain.TIME);
            } catch (InterruptedException ignored) {
            }
        }
    }

    public void log(String message) {
        if (!follow()) {
            return;
        }
        System.out.println(message);
    }

    public boolean follow() {
        return getHomeTeam().isFollow() || getVisitorTeam().isFollow() || GameMain.FOLLOW_CUP.contains(getGameCup().getName());
    }

}
