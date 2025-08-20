package br.com.introcdc.tests.game;
/*
 * Written by IntroCDC, Bruno Coelho at 10/12/2024 - 02:53
 */

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.text.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameGUI {

    private JFrame frame;
    private JTextPane feedPane;
    private MatchAnimationPanel animationPanel;
    private JComboBox<GameTeam> homeCombo, visitorCombo;
    private JCheckBox printCheck, chkOnlyFollow;
    private JButton btnPlayNext, btnBuildSeason;

    private final GameSeasonEngine season = new GameSeasonEngine();

    public GameGUI() { initialize(); }

    private void initialize() {
        UIManager.put("Panel.background", new Color(21,22,25));
        UIManager.put("TextPane.background", new Color(28,29,34));
        UIManager.put("TextPane.foreground", Color.WHITE);

        frame = new JFrame("Simulador de Futebol — Visual Edition");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1100, 760);
        frame.setLocationRelativeTo(null);

        JPanel root = new JPanel(new BorderLayout());
        root.setBorder(new EmptyBorder(12,12,12,12));
        frame.setContentPane(root);

        // TOPO
        JPanel top = new JPanel(new GridBagLayout()); top.setOpaque(false);
        GridBagConstraints c = new GridBagConstraints(); c.insets=new Insets(6,6,6,6); c.fill=GridBagConstraints.HORIZONTAL;

        homeCombo = new JComboBox<>(teamModel());
        visitorCombo = new JComboBox<>(teamModel());
        ListCellRenderer<? super GameTeam> renderer = new DefaultListCellRenderer(){
            @Override public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus){
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if (value instanceof GameTeam t) setText(t.getName());
                return this;
            }
        };
        homeCombo.setRenderer(renderer); visitorCombo.setRenderer(renderer);
        selectByName(homeCombo, "Fortaleza");
        visitorCombo.setSelectedIndex((homeCombo.getSelectedIndex()+1) % visitorCombo.getItemCount());

        JButton btnFriendly = new JButton("Amistoso Visual");
        btnFriendly.addActionListener(e -> simulateFriendly());

        printCheck = new JCheckBox("Imprimir narração no console");
        printCheck.setForeground(Color.WHITE); printCheck.setOpaque(false); printCheck.setSelected(true);

        chkOnlyFollow = new JCheckBox("Somente jogos seguidos");
        chkOnlyFollow.setForeground(Color.WHITE); chkOnlyFollow.setOpaque(false); chkOnlyFollow.setSelected(true);

        btnBuildSeason = new JButton("Iniciar Temporada (ordem correta)");
        btnBuildSeason.addActionListener(e -> {
            clearFeed();
            appendFeedTitle("Temporada " + GameMain.YEAR + " — Estaduais primeiro, visse?");
            season.setOnlyFollowed(chkOnlyFollow.isSelected());
            season.startSeason();

            // Sempre habilita o Play; se a fila estiver vazia, o clique tenta avançar de fase
            btnPlayNext.setEnabled(true);

            int size = season.queueSize();
            if (size > 0) {
                appendFeedSuccess("Fila criada com " + size + " jogos. Clica em Play!");
            } else {
                appendFeedWarn("Por enquanto sem jogos na fila (talvez nenhum com follow ativo). Clica em Play que eu tento montar a próxima fase.");
            }
        });

        btnPlayNext = new JButton("Play Próximo Jogo");
        btnPlayNext.setEnabled(false);
        btnPlayNext.addActionListener(e -> playNextFromSeason());

        int col=0;
        c.gridx=col++; c.gridy=0; top.add(new JLabel("Mandante:"), c);
        c.gridx=col++; top.add(homeCombo, c);
        c.gridx=col++; top.add(new JLabel("Visitante:"), c);
        c.gridx=col++; top.add(visitorCombo, c);
        c.gridx=col++; top.add(btnFriendly, c);
        c.gridx=0; c.gridy=1; c.gridwidth=col; top.add(printCheck, c);
        c.gridy=2; top.add(chkOnlyFollow, c);

        JPanel row2 = new JPanel(new FlowLayout(FlowLayout.LEFT, 8, 0)); row2.setOpaque(false);
        row2.add(btnBuildSeason); row2.add(btnPlayNext);
        c.gridx=0; c.gridy=3; c.gridwidth=col; top.add(row2, c);

        root.add(top, BorderLayout.NORTH);

        // CENTRO
        JSplitPane center = new JSplitPane(JSplitPane.VERTICAL_SPLIT); center.setResizeWeight(0.66);
        animationPanel = new MatchAnimationPanel();
        center.setTopComponent(wrapCard(animationPanel));

        feedPane = new JTextPane(); feedPane.setEditable(false); feedPane.setMargin(new Insets(10,10,10,10));
        feedPane.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 14));
        center.setBottomComponent(wrapCard(new JScrollPane(feedPane)));
        root.add(center, BorderLayout.CENTER);

        // RODAPÉ
        JPanel bottom = new JPanel(new FlowLayout(FlowLayout.RIGHT, 8, 8)); bottom.setOpaque(false);
        JButton exit = new JButton("Sair"); exit.addActionListener(e -> System.exit(0));
        bottom.add(exit); root.add(bottom, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    private void simulateFriendly() {
        GameTeam home = (GameTeam) homeCombo.getSelectedItem();
        GameTeam visitor = (GameTeam) visitorCombo.getSelectedItem();
        if (home == null || visitor == null || home == visitor) {
            appendFeedError("Escolhe dois times diferentes, homi! x-x");
            return;
        }
        playMatchVisual(home, visitor, "Amistoso Visual");
    }

    private void playNextFromSeason() {
        GameMatch next = season.pollNext();
        if (next == null) {
            if (season.hasNext()) {
                next = season.pollNext();
            }
        }
        if (next == null) {
            appendFeedWarn("Sem jogos na fila agora. Se iniciou temporada, talvez tenha acabado essa fase. Tenta Play de novo ou inicia outra temporada.");
            btnPlayNext.setEnabled(season.hasNext());
            return;
        }
        playMatchVisual(next.getHomeTeam(), next.getVisitorTeam(), next.getGameCup().getName());
    }

    private void playMatchVisual(GameTeam home, GameTeam visitor, String cupName) {
        animationPanel.setTeams(home.getName(), visitor.getName()); // >>> zera placar aqui
        clearFeed();
        appendFeedTitle("Partida ao vivo — " + cupName + ": " + home.getName() + " vs " + visitor.getName());

        int oldTick = GameMain.TICK, oldTime = GameMain.TIME;
        try {
            GameMain.TICK = 300; // ritmo bom de transmissão
            GameMain.TIME = 800;

            GameMatch.setForceFollow(true);

            GameCup cup = new GameCup(cupName, "AMIST", 0, GameCupType.POINTS, t -> false, 0, GameCupRegionType.COUNTRY, false);
            cup.getTeams().add(home); cup.getTeams().add(visitor);
            cup.getPoints().put(home,0); cup.getPoints().put(visitor,0);
            cup.getMatchs().put(home,0); cup.getMatchs().put(visitor,0);
            cup.getGoals().put(home,0); cup.getGoals().put(visitor,0);
            cup.getGoalst().put(home,0); cup.getGoalst().put(visitor,0);
            cup.getVictories().put(home,0); cup.getVictories().put(visitor,0);
            cup.getLoses().put(home,0); cup.getLoses().put(visitor,0);
            cup.getDraw().put(home,0); cup.getDraw().put(visitor,0);
            cup.getSg().put(home,0); cup.getSg().put(visitor,0);

            GameMatch match = new GameMatch(cup, home, visitor);
            match.addListener(animationPanel::onEvent);
            match.addListener(this::onFeedEvent);

            // não travar a UI
            new Thread(match::startMatch, "match-thread").start();

        } catch (Throwable t) {
            appendFeedError("Deu ruim: " + t.getMessage());
        } finally {
            GameMain.TICK = oldTick; GameMain.TIME = oldTime;
        }
    }

    private JPanel wrapCard(JComponent c) {
        JPanel card = new JPanel(new BorderLayout());
        card.setBackground(new Color(28,29,34));
        card.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(60,61,70)), new EmptyBorder(8,8,8,8)));
        card.add(c, BorderLayout.CENTER);
        return card;
    }

    private DefaultComboBoxModel<GameTeam> teamModel() {
        List<GameTeam> list = new ArrayList<>(GameTeam.getTeamList());
        Collections.sort(list, (a,b)->a.getName().compareToIgnoreCase(b.getName()));
        DefaultComboBoxModel<GameTeam> m = new DefaultComboBoxModel<>();
        for (GameTeam t: list) m.addElement(t);
        return m;
    }

    private void selectByName(JComboBox<GameTeam> combo, String name) {
        for (int i=0;i<combo.getItemCount();i++)
            if (combo.getItemAt(i).getName().equalsIgnoreCase(name)) { combo.setSelectedIndex(i); return; }
    }

    // ==== feed estilizado =====
    private void clearFeed() { feedPane.setText(""); }
    private StyledDocument doc() { return feedPane.getStyledDocument(); }
    private AttributeSet style(Color fg, int bold, int size) {
        SimpleAttributeSet s = new SimpleAttributeSet();
        StyleConstants.setForeground(s, fg); StyleConstants.setBold(s, bold>0); StyleConstants.setFontSize(s, size); return s;
    }
    private void appendLine(String t, AttributeSet st) { try { doc().insertString(doc().getLength(), t+"\n", st); feedPane.setCaretPosition(doc().getLength()); } catch (BadLocationException ignored) {} }
    private void appendFeedTitle(String t)   { appendLine("? "+t, style(new Color(180,160,255),1,16)); }
    private void appendFeedInfo(String t)    { appendLine("• "+t, style(new Color(150,200,255),0,14)); }
    private void appendFeedWarn(String t)    { appendLine("• "+t, style(new Color(255,220,160),1,14)); }
    private void appendFeedError(String t)   { appendLine("• "+t, style(new Color(255,120,120),1,14)); }
    private void appendFeedScore(String t)   { appendLine("• "+t, style(new Color(200,255,200),1,14)); }
    private void appendFeedGoal(String t)    { appendLine("? "+t, style(new Color(255,255,140),1,16)); }
    private void appendFeedSuccess(String t) { appendLine("? "+t, style(new Color(160,255,180),1,14)); }
    private void appendFeedText(String t)    { appendLine(t, style(Color.WHITE,0,13)); }

    private void onFeedEvent(GameEvent ev) {
        SwingUtilities.invokeLater(() -> {
            switch (ev.getType()) {
                case KICK_OFF -> appendFeedInfo("Bola rolando! " + ev.getMinute()+"'");
                case ATTACK_HOME -> appendFeedText("Mandante avança…");
                case ATTACK_VISITOR -> appendFeedText("Visitante avança…");
                case SHOT_SAVED -> appendFeedWarn("DEFENDEU!");
                case SHOT_OFF_TARGET -> appendFeedWarn("Pra fora!");
                case PENALTY -> appendFeedTitle("PÊNALTI!");
                case PENALTY_SCORED -> appendFeedGoal("Pênalti convertido! Placar: "+ev.getHomeScore()+" x "+ev.getVisitorScore());
                case PENALTY_MISSED -> appendFeedWarn("Perdeu o pênalti ksksksksksks");
                case GOAL_HOME, GOAL_VISITOR -> appendFeedGoal("GOOOOOOL! "+ev.getMinute()+"'");
                case SCORE_CHANGE -> appendFeedScore("Placar: "+ev.getHomeScore()+" x "+ev.getVisitorScore());
                case HALF_TIME -> appendFeedWarn("Intervalo — "+ev.getText());
                case FULL_TIME -> appendFeedTitle("Fim — "+ev.getText());
                case NARRATION -> appendFeedText(ev.getText());
            }
        });
    }

    public static void main(String[] args) {
        GameRegister.registerTeams();
        EventQueue.invokeLater(GameGUI::new);
    }

}
