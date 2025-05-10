package br.com.introcdc.tests.game;
/*
 * Written by IntroCDC, Bruno Coelho at 10/12/2024 - 02:53
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameGUI {

    private JFrame frame;
    private JTextArea textArea;

    public GameGUI() {
        initialize();
    }

    private void initialize() {
        // Configuração principal da janela
        frame = new JFrame("Simulador de Futebol");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        // Painel principal
        JPanel panel = new JPanel(new BorderLayout());
        frame.getContentPane().add(panel);

        // Área de texto para exibição de informações
        textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        panel.add(scrollPane, BorderLayout.CENTER);

        // Painel de botões
        JPanel buttonPanel = new JPanel();
        panel.add(buttonPanel, BorderLayout.SOUTH);

        // Botões e ações
        JButton viewTeamsButton = new JButton("Visualizar Times");
        viewTeamsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewTeams();
            }
        });
        buttonPanel.add(viewTeamsButton);

        JButton newSeasonButton = new JButton("Nova Temporada");
        newSeasonButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startNewSeason();
            }
        });
        buttonPanel.add(newSeasonButton);

        JButton showResultsButton = new JButton("Exibir Resultados");
        showResultsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showResults();
            }
        });
        buttonPanel.add(showResultsButton);

        JButton exitButton = new JButton("Sair");
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        buttonPanel.add(exitButton);

        frame.setVisible(true);
    }

    private void viewTeams() {
        StringBuilder sb = new StringBuilder();
        sb.append("Lista de Times:\n");
        for (GameTeam team : GameTeam.getTeamList()) {
            sb.append(team.getName()).append(" - ").append(team.getState()).append(";").append(team.division()).append(";").append(team.getCountry()).append("\n");
        }
        textArea.setText(sb.toString());
    }

    private void startNewSeason() {
        textArea.setText("Iniciando nova temporada...\n");
        GameMain.newSeason();
        textArea.append("Temporada " + (GameMain.YEAR - 1) + " concluída com sucesso!\n");
    }

    private void showResults() {
        StringBuilder sb = new StringBuilder();
        sb.append("Resultados das Copas da Temporada ").append(GameMain.YEAR - 1).append(":\n");
        for (GameCup cup : GameCup.getCupList()) {
            if (cup.isExecuted()) {
                sb.append(cup.getName()).append(" - Campeão: ")
                        .append(cup.getWinner().getName()).append(" - ").append(cup.getWinner().getState()).append(";").append(cup.getWinner().division()).append(";").append(cup.getWinner().getCountry()).append(" | ").append(cup.getReason().get(cup.getWinner()))
                        .append("\n");
            }
        }
        textArea.setText(sb.toString());
    }

    public static void main(String[] args) {
        // Registro inicial de times e configuração do simulador
        GameRegister.registerTeams();

        // Inicialização da interface gráfica
        EventQueue.invokeLater(() -> new GameGUI());
    }
}
