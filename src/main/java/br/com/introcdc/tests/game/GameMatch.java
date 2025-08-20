package br.com.introcdc.tests.game;
/*
 * Written by IntroCDC, Bruno Coelho at 10/04/2024 - 15:44
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameMatch {

    private static volatile boolean FORCE_FOLLOW = false;
    public static void setForceFollow(boolean value) { FORCE_FOLLOW = value; }

    // ===== listeners =====
    private final List<GameMatchListener> listeners = new ArrayList<>();
    public void addListener(GameMatchListener l) { if (l != null && !listeners.contains(l)) listeners.add(l); }
    private void emit(GameEventType type, String text) {
        GameEvent e = new GameEvent(type, time, text, homePoints, visitorPoints);
        for (GameMatchListener l : new ArrayList<>(listeners)) try { l.onEvent(e); } catch (Throwable ignored) {}
    }

    // ===== dados básicos =====
    private final GameCup gameCup;
    private boolean matchExecuted = false;
    private int time = 0;

    private final GameTeam homeTeam;
    private final GameTeam visitorTeam;

    private int homePoints = 0;
    private int visitorPoints = 0;

    private final Random rng = new Random();

    // parâmetros de chance (derivados de rating)
    private double lambdaHome;  // gols esperados do mandante no jogo
    private double lambdaAway;  // gols esperados do visitante no jogo
    private double pGoalHome;   // prob. de gol do mandante por minuto
    private double pGoalAway;   // prob. de gol do visitante por minuto

    public GameMatch(GameCup gameCup, GameTeam homeTeam, GameTeam visitorTeam) {
        this.gameCup = gameCup;
        this.homeTeam = homeTeam;
        this.visitorTeam = visitorTeam;
    }

    public boolean isMatchExecuted() { return matchExecuted; }
    public void setMatchExecuted(boolean matchExecuted) { this.matchExecuted = matchExecuted; }
    public GameCup getGameCup() { return gameCup; }
    public GameTeam getHomeTeam() { return homeTeam; }
    public GameTeam getVisitorTeam() { return visitorTeam; }
    public int getHomePoints() { return homePoints; }
    public int getVisitorPoints() { return visitorPoints; }

    private String scoreLine() {
        return homeTeam.getName() + " " + homePoints + " x " + visitorPoints + " " + visitorTeam.getName();
    }

    // rating simples e estável (0.6..1.6)
    private double teamRating(GameTeam t) {
        double r = 0.85
                + (12 - Math.max(1, t.getDivision())) * 0.05
                + Math.min(0.4, t.getTitles() * 0.02)
                + Math.max(-0.2, (t.getVictories() - t.getLoses()) * 0.002);
        return Math.max(0.6, Math.min(1.6, r));
    }

    private void setupExpectedGoals() {
        double baseXG = 2.4 + (rng.nextDouble() - 0.5) * 0.4; // 2.2..2.6
        double rHome = teamRating(homeTeam) * 1.10; // leve mandante
        double rAway = teamRating(visitorTeam);

        lambdaHome = baseXG * (rHome / (rHome + rAway));
        lambdaAway = Math.max(0.1, baseXG - lambdaHome);

        // 95 min p/ compensar acréscimos
        pGoalHome = lambdaHome / 95.0;
        pGoalAway = lambdaAway / 95.0;
    }

    // ===== efeitos no placar e estatísticas =====
    private void goalHome() {
        homePoints++;
        homeTeam.addGoal(); homeTeam.addSg();
        visitorTeam.addGoalt(); visitorTeam.removeSg();
        gameCup.getPoints().put(homeTeam, gameCup.getPoints().getOrDefault(homeTeam,0)+1);
        gameCup.getGoals().put(homeTeam, gameCup.getGoals().getOrDefault(homeTeam,0)+1);
        gameCup.getGoalst().put(visitorTeam, gameCup.getGoalst().getOrDefault(visitorTeam,0)+1);
        gameCup.getSg().put(homeTeam, gameCup.getSg().getOrDefault(homeTeam,0)+1);
        gameCup.getSg().put(visitorTeam, gameCup.getSg().getOrDefault(visitorTeam,0)-1);
        emit(GameEventType.GOAL_HOME, "Gol do " + homeTeam.getName() + "!");
        emit(GameEventType.SCORE_CHANGE, scoreLine());
        log("GOL DO " + homeTeam.getName().toUpperCase() + "!!!!! (" + time + "')");
    }
    private void goalAway() {
        visitorPoints++;
        visitorTeam.addGoal(); visitorTeam.addSg();
        homeTeam.addGoalt(); homeTeam.removeSg();
        gameCup.getPoints().put(visitorTeam, gameCup.getPoints().getOrDefault(visitorTeam,0)+1);
        gameCup.getGoals().put(visitorTeam, gameCup.getGoals().getOrDefault(visitorTeam,0)+1);
        gameCup.getGoalst().put(homeTeam, gameCup.getGoalst().getOrDefault(homeTeam,0)+1);
        gameCup.getSg().put(visitorTeam, gameCup.getSg().getOrDefault(visitorTeam,0)+1);
        gameCup.getSg().put(homeTeam, gameCup.getSg().getOrDefault(homeTeam,0)-1);
        emit(GameEventType.GOAL_VISITOR, "Gol do " + visitorTeam.getName() + "!");
        emit(GameEventType.SCORE_CHANGE, scoreLine());
        log("GOL DO " + visitorTeam.getName().toUpperCase() + "!!!!! (" + time + "')");
    }

    public static int percent(long cur, long max) {
        if (max <= 0) return 0;
        long num = cur * 100;
        return (int) (num / max);
    }

    public void startMatch() {
        setupExpectedGoals();
        gameCup.setMatches(gameCup.getMatches() + 1);

        homeTeam.addMatch(); visitorTeam.addMatch();
        gameCup.getMatchs().put(homeTeam, gameCup.getMatchs().getOrDefault(homeTeam, 0) + 1);
        gameCup.getMatchs().put(visitorTeam, gameCup.getMatchs().getOrDefault(visitorTeam, 0) + 1);

        Random random = rng;
        int publicStadium = Math.max(1, random.nextInt(Math.max(homeTeam.getStadiumAmount(), 1)));
        int ticket = GameMain.MIN_TICKET + random.nextInt(Math.max(homeTeam.getVictories(), 1)) + random.nextInt(Math.max(1, visitorTeam.getVictories()));
        int total = ticket * publicStadium;
        long prevMoney = homeTeam.getMoney();
        homeTeam.setMoney(prevMoney + total);

        boolean follow = follow();
        emit(GameEventType.KICK_OFF, "Bola rolando!");
        log("=======");
        log("INICIANDO PARTIDA");
        log(gameCup.getName().toUpperCase() + " " + GameMain.YEAR + " - Partida: " + gameCup.getMatches() + "/" + gameCup.getMatchList().size() + " - " +
                percent(gameCup.getMatches(), gameCup.getMatchList().size()) + "%");
        log(homeTeam.getName() + " (" + homeTeam.getState() + ";" + homeTeam.division() + ";" + homeTeam.getCountry() + ") " + homePoints + " x "
                + visitorPoints + " " + visitorTeam.getName() + " (" + visitorTeam.getState() + ";" + visitorTeam.division() + ";" + visitorTeam.getCountry() + ")");
        log("Estádio: " + homeTeam.getStadium() + " (Público: " + publicStadium + "/" + homeTeam.getStadiumAmount() +
                " - " + percent(publicStadium, Math.max(homeTeam.getStadiumAmount(),1)) + "%) - Ingresso: R$ " + GameCup.formatNumber(ticket) +
                " (Renda: R$ " + GameCup.formatNumber(total) + " - R$ " + GameCup.formatNumber(prevMoney) + " => R$ " + GameCup.formatNumber(homeTeam.getMoney()) + ")");
        log("=======");

        if (follow) sleep(GameMain.TIME / 2);

        while (time <= 90) {
            time++;
            if (follow) sleep(GameMain.TICK);

            if (time == 45) {
                emit(GameEventType.HALF_TIME, "INTERVALO!!! " + scoreLine());
                continue;
            }

            // 1) micro-jogada sem gol (35% dos minutos)
            if (random.nextDouble() < 0.35) {
                boolean homeAttack = random.nextDouble() < (lambdaHome / (lambdaHome + lambdaAway));
                emit(homeAttack ? GameEventType.ATTACK_HOME : GameEventType.ATTACK_VISITOR,
                        homeAttack ? "Triangulação pela direita…" : "Acelera pela esquerda…");

                // 10% vira chute defendido, 10% vai pra fora
                double r = random.nextDouble();
                if (r < 0.10) emit(GameEventType.SHOT_SAVED, "Bateu forte! Goleiro espalma.");
                else if (r < 0.20) emit(GameEventType.SHOT_OFF_TARGET, "Chute cruzado… foi pra fora!");
                else if (r < 0.23) { // pênalti raro
                    emit(GameEventType.PENALTY, "PÊNALTI marcado!");
                    boolean scored = random.nextDouble() < 0.65;
                    if (scored) {
                        if (homeAttack) goalHome(); else goalAway();
                        emit(GameEventType.PENALTY_SCORED, "Convertido!");
                    } else {
                        emit(GameEventType.PENALTY_MISSED, "Perdeu o pênalti heuheuheu!");
                    }
                }
            }

            // 2) processo de gols (Poisson minuto a minuto)
            if (random.nextDouble() < pGoalHome) goalHome();
            else if (random.nextDouble() < pGoalAway) goalAway();
        }

        emit(GameEventType.FULL_TIME, "Fim de partida! " + scoreLine());
        log("=======");
        log("FIM DE PARTIDA — " + scoreLine());

        if (homePoints > visitorPoints) {
            homeTeam.addVictory(); visitorTeam.addLose();
            gameCup.getPoints().put(homeTeam, gameCup.getPoints().getOrDefault(homeTeam, 0) + 3000);
            gameCup.getVictories().put(homeTeam, gameCup.getVictories().getOrDefault(homeTeam, 0) + 1);
            gameCup.getLoses().put(visitorTeam, gameCup.getLoses().getOrDefault(visitorTeam, 0) + 1);
            emit(GameEventType.NARRATION, "Ganhador: " + homeTeam.getName());
        } else if (visitorPoints > homePoints) {
            visitorTeam.addVictory(); homeTeam.addLose();
            gameCup.getPoints().put(visitorTeam, gameCup.getPoints().getOrDefault(visitorTeam, 0) + 3000);
            gameCup.getVictories().put(visitorTeam, gameCup.getVictories().getOrDefault(visitorTeam, 0) + 1);
            gameCup.getLoses().put(homeTeam, gameCup.getLoses().getOrDefault(homeTeam, 0) + 1);
            emit(GameEventType.NARRATION, "Ganhador: " + visitorTeam.getName());
        } else {
            homeTeam.addDraw(); visitorTeam.addDraw();
            gameCup.getPoints().put(homeTeam, gameCup.getPoints().getOrDefault(homeTeam, 0) + 1000);
            gameCup.getPoints().put(visitorTeam, gameCup.getPoints().getOrDefault(visitorTeam, 0) + 1000);
            gameCup.getDraw().put(homeTeam, gameCup.getDraw().getOrDefault(homeTeam, 0) + 1);
            gameCup.getDraw().put(visitorTeam, gameCup.getDraw().getOrDefault(visitorTeam, 0) + 1);
            emit(GameEventType.NARRATION, "Empate.");
        }

        setMatchExecuted(true);
        if (follow) { sleep(GameMain.TIME / 2); }
    }

    private void sleep(long ms) { try { Thread.sleep(ms); } catch (InterruptedException ignored) {} }

    public void log(String message) {
        if (!follow()) return;
        System.out.println(message);
        emit(GameEventType.NARRATION, message);
    }

    public boolean follow() {
        if (FORCE_FOLLOW) return true;
        return homeTeam.isFollow() || visitorTeam.isFollow() || GameMain.FOLLOW_CUP.contains(gameCup.getName());
    }
}
