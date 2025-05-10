package br.com.introcdc.tests.google;
/*
 * Written by IntroCDC, Bruno Coelho at 23/12/2022 - 23:18
 */

import br.com.introcdc.tests.database.StringComponents;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class GoogleVoter {

    public static VoteClient CLIENT = VoteClient.PC_SECONDARY;

    public static void init(boolean mouseInfo) throws Exception {
        for (MousePos pos : MousePos.values()) {
            pos.setConsumer(pos.getPosMap());
        }
        GoogleVoter voter = new GoogleVoter();
        voter.delay(5000L);
        for (; ; ) {
            if (mouseInfo) {
                voter.mouseGetter();
                voter.delay(2000);
                continue;
            }
            voter.start();
        }
    }

    private final Robot robot;
    private final int DELAY = 25;
    private final List<Long> voteHistory = StringComponents.arrayList();

    public GoogleVoter() throws Exception {
        this.robot = new Robot();
    }

    public int getDELAY() {
        return DELAY;
    }

    public Robot getRobot() {
        return robot;
    }

    public void moveMouse(int x, int y) {
        getRobot().mouseMove(x, y);
    }

    public List<Long> getVoteHistory() {
        return voteHistory;
    }

    public void click() throws Exception {
        getRobot().mousePress(InputEvent.BUTTON1_DOWN_MASK);
        delay(DELAY / 10);
        getRobot().mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
    }

    public void moveAndClick(MousePos info) throws Exception {
        if (CLIENT != VoteClient.PC_SECONDARY && stop()) {
            System.exit(0);
            return;
        }
        moveMouse(info.getX(CLIENT), info.getY(CLIENT));
        delay(DELAY);
        click();
        delay(DELAY);
    }

    public boolean stop() {
        return new File("F:/IntroCDC/stop").exists();
    }

    public void start() throws Exception {
        // Get hour in start vote
        long startingVote = System.currentTimeMillis();
        // #1 Vote (Staff mais ativo - Dolar)
        moveAndClick(MousePos.DOLAR);
        // #2 Vote (Novato que upou mais rápido - Safira)
        moveAndClick(MousePos.SAFIRA_1);
        // #3 Vote (Staff feminina mais ativa - Safira)
        moveAndClick(MousePos.SAFIRA_2);
        // #4 Vote (Staff mais amigável! (Amigo de todos) - Coxinha)
        moveAndClick(MousePos.COXINHA);
        // Send Vote
        moveAndClick(MousePos.SEND);
        delay(600);

        // Re-start vote
        moveAndClick(MousePos.RESTART);
        getRobot().keyPress(KeyEvent.VK_CONTROL);
        getRobot().keyPress(KeyEvent.VK_V);
        getRobot().keyRelease(KeyEvent.VK_V);
        getRobot().keyRelease(KeyEvent.VK_CONTROL);
        getRobot().keyPress(KeyEvent.VK_ENTER);
        getRobot().keyRelease(KeyEvent.VK_ENTER);
        // Statistics
        applyStatistics(startingVote);

        delay(850);
    }

    public void mouseGetter() {
        Point info = MouseInfo.getPointerInfo().getLocation();
        System.out.println(info.getX() + "/" + info.getY());
    }

    public void delay(long millis) throws Exception {
        Thread.sleep(millis);
    }

    public void move() throws Exception {
        getRobot().mouseWheel(100);
        delay(DELAY);
    }

    public void applyStatistics(long start) throws Exception {
        getVoteHistory().add(System.currentTimeMillis());

        List<String> lines = new ArrayList<>();
        addLine(lines, "Votos: " + getVoteHistory().size() + " (" + (getVoteHistory().size() * 2) + " votos por página de votação)");
        addLine(lines, "Segundos por voto: " + StringComponents.completeTime((System.currentTimeMillis() - start) / 1000));
        addLine(lines, "");
        addLine(lines, "Últimos " + Math.min(100, getVoteHistory().size()) + " votos:");
        if (getVoteHistory().size() > 100) {
            int size = getVoteHistory().size();
            for (int i = (size - 101); i < (size - 1); i++) {
                addLine(lines, " - " + StringComponents.toDate(getVoteHistory().get(i)));
            }
        } else {
            for (long hour : getVoteHistory()) {
                addLine(lines, " - " + StringComponents.toDate(hour));
            }
        }

        if (CLIENT == VoteClient.PC_SECONDARY) {
            return;
        }
        if (getVoteHistory().size() % 100 != 0) {
            return;
        }
        PrintWriter writer = new PrintWriter("F:\\IntroCDC\\google.vote", StandardCharsets.UTF_8);
        for (String line : lines) {
            writer.println(line);
        }
        writer.flush();
        writer.close();
    }

    public void addLine(List<String> lines, String line) {
        lines.add(line + "<br>");
        System.out.println(line);
    }

}
