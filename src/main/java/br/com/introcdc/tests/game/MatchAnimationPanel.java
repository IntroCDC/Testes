package br.com.introcdc.tests.game;
/*
 * Written by IntroCDC, Bruno Coelho at 17/08/2025 - 05:42
 */

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.ArrayDeque;
import java.util.Deque;

public class MatchAnimationPanel extends JPanel implements GameMatchListener {

    private String homeName = "Mandante";
    private String visitorName = "Visitante";
    private int homeScore = 0, visitorScore = 0, minute = 0;

    private double ballX = 0.5, ballY = 0.5;
    private final Deque<double[]> path = new ArrayDeque<>();
    private final Timer timer;
    private final Random rng = new Random();
    private boolean goalFlash = false; private long goalFlashUntil = 0L;

    public MatchAnimationPanel() {
        setPreferredSize(new Dimension(900, 480));
        setBackground(new Color(17, 18, 22));
        timer = new Timer(1000 / 60, e -> { tick(); repaint(); });
        timer.start();
    }

    public void setTeams(String home, String visitor) {
        this.homeName = home;
        this.visitorName = visitor;
        // >>>> RESET total do estado visual
        this.homeScore = 0;
        this.visitorScore = 0;
        this.minute = 0;
        this.goalFlash = false;
        ballX = 0.5; ballY = 0.5; path.clear();
        repaint();
    }

    private void tick() {
        if (!path.isEmpty()) {
            double[] t = path.peekFirst();
            double dx = t[0] - ballX, dy = t[1] - ballY;
            double dist = Math.hypot(dx, dy);
            double speed = 0.012;
            if (dist < 0.006) path.pollFirst();
            else { ballX += dx / dist * speed; ballY += dy / dist * speed; }
        } else {
            ballX += (rng.nextDouble() - 0.5) * 0.0008;
            ballY += (rng.nextDouble() - 0.5) * 0.0008;
        }
        ballX = Math.max(0.04, Math.min(0.96, ballX));
        ballY = Math.max(0.08, Math.min(0.92, ballY));
        if (goalFlash && System.currentTimeMillis() > goalFlashUntil) goalFlash = false;
    }

    private void queue(List<double[]> pts) { path.clear(); path.addAll(pts); }

    // ===== eventos =====
    @Override public void onEvent(GameEvent e) {
        minute = e.getMinute();
        switch (e.getType()) {
            case KICK_OFF -> queue(List.of(new double[]{0.50,0.50}));
            case ATTACK_HOME -> queue(attack(true));
            case ATTACK_VISITOR -> queue(attack(false));
            case SHOT_SAVED -> queue(save(ballX < 0.5));
            case SHOT_OFF_TARGET -> queue(off(ballX < 0.5));
            case PENALTY -> queue(List.of(new double[]{ballX < 0.5 ? 0.15 : 0.85, 0.5}));
            case PENALTY_SCORED -> { queue(goal(ballX < 0.5)); flash(); }
            case GOAL_HOME -> { homeScore=e.getHomeScore(); visitorScore=e.getVisitorScore(); queue(goal(true)); flash(); }
            case GOAL_VISITOR -> { homeScore=e.getHomeScore(); visitorScore=e.getVisitorScore(); queue(goal(false)); flash(); }
            case SCORE_CHANGE -> { homeScore=e.getHomeScore(); visitorScore=e.getVisitorScore(); }
            case HALF_TIME, FULL_TIME -> queue(List.of(new double[]{0.50,0.50}));
            default -> { /* ignore */ }
        }
    }

    private void flash() { goalFlash = true; goalFlashUntil = System.currentTimeMillis()+600; }

    // trajetórias
    private List<double[]> attack(boolean home) {
        List<double[]> pts = new ArrayList<>();
        double x = ballX, y = ballY;
        int steps = 3 + rng.nextInt(3);
        for (int i=0;i<steps;i++){
            x += (home ? +1 : -1) * (0.07 + rng.nextDouble()*0.07);
            y += (rng.nextDouble()-0.5) * 0.18;
            x = Math.max(0.06, Math.min(0.94, x));
            y = Math.max(0.10, Math.min(0.90, y));
            pts.add(new double[]{x,y});
        }
        return pts;
    }
    private List<double[]> goal(boolean home) {
        double gx = home ? 0.97 : 0.03;
        return List.of(
                new double[]{home ? 0.90 : 0.10, 0.40 + rng.nextDouble()*0.20},
                new double[]{gx, 0.50 + (rng.nextDouble()-0.5)*0.10}
        );
    }
    private List<double[]> save(boolean homeAttackSide) {
        List<double[]> pts = new ArrayList<>(goal(homeAttackSide));
        pts.add(new double[]{homeAttackSide ? 0.92 : 0.08, 0.20 + rng.nextDouble()*0.60});
        return pts;
    }
    private List<double[]> off(boolean homeAttackSide) {
        List<double[]> pts = new ArrayList<>(goal(homeAttackSide));
        pts.add(new double[]{homeAttackSide ? 1.00 : 0.00, 0.20 + rng.nextDouble()*0.60});
        return pts;
    }

    @Override protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2=(Graphics2D)g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int w=getWidth(), h=getHeight(), pad=14; int fx=pad, fy=pad, fw=w-pad*2, fh=h-pad*2;

        // gramado
        for (int i=0;i<12;i++){ float t=i/11f;
            g2.setColor(new Color(22+(int)(t*6), 102+(int)(t*24), 32+(int)(t*6)));
            int sh=fh/12; g2.fillRect(fx, fy+i*sh, fw, sh);
        }
        g2.setColor(new Color(235,235,235));
        g2.setStroke(new BasicStroke(2f)); g2.drawRect(fx,fy,fw,fh);
        g2.drawLine(fx+fw/2, fy, fx+fw/2, fy+fh);
        int circle = Math.min(fw,fh)/6; g2.drawOval(fx+fw/2-circle/2, fy+fh/2-circle/2, circle, circle);

        if (goalFlash){ Composite old=g2.getComposite();
            g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,0.32f));
            g2.setColor(new Color(255,236,80)); g2.fillRect(fx,fy,fw,fh); g2.setComposite(old);
        }

        // cartela superior
        g2.setColor(new Color(12,12,14,230));
        g2.fillRoundRect(pad,pad, w-pad*2, 44, 14,14);
        g2.setColor(Color.WHITE);
        g2.setFont(getFont().deriveFont(Font.BOLD,18f));
        String score = homeName+"  "+homeScore+"  x  "+visitorScore+"  "+visitorName;
        int sw=g2.getFontMetrics().stringWidth(score); g2.drawString(score, (w-sw)/2, pad+28);
        g2.setFont(getFont().deriveFont(Font.PLAIN,14f));
        String t = minute+"'";
        g2.drawString(t, w-pad-8-g2.getFontMetrics().stringWidth(t), pad+26);

        // bola
        double px = fx+ballX*fw, py=fy+ballY*fh, r=Math.max(8, Math.min(fw,fh)*0.02);
        Shape ball = new Ellipse2D.Double(px-r/2, py-r/2, r, r);
        g2.setColor(Color.WHITE); g2.fill(ball);
        g2.setColor(new Color(40,40,40)); g2.draw(ball);

        g2.dispose();
    }
}
