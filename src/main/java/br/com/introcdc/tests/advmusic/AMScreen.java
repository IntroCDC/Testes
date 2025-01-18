package br.com.introcdc.tests.advmusic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AMScreen extends JFrame {

    private JTextField tryField;
    private JTextPane title = new JTextPane();
    public JTextPane authorText = new JTextPane();
    private JTextPane musicText = new JTextPane();
    private JTextPane percentText = new JTextPane();
    private JTextPane winsText = new JTextPane();
    private JTextPane percentBarText = new JTextPane();
    private JButton okButton = new JButton("OK");
    private JButton nextMusicButton = new JButton("Próxima Música");
    private JButton startButton = new JButton("Iniciar");
    private JLabel coverLabel = new JLabel();
    private GameLogic gameLogic;

    public AMScreen() {
        setTitle("AdvMusic");
        setResizable(false);
        setBounds(100, 100, 500, 295); // Aumentei a largura para acomodar a imagem do cover
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        initialize();
    }

    private void initialize() {
        title.setEditable(false);
        title.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
        title.setText("AdvMusic");
        title.setBounds(115, 0, 90, 28);
        getContentPane().add(title);

        JSeparator separator = new JSeparator();
        separator.setBounds(0, 30, 480, 1); // Ajustei a largura para 480
        getContentPane().add(separator);

        authorText.setEditable(false);
        authorText.setText("Autor: *");
        authorText.setBounds(10, 35, 294, 20);
        getContentPane().add(authorText);

        musicText.setEditable(false);
        musicText.setText("**");
        musicText.setBounds(10, 55, 294, 20);
        getContentPane().add(musicText);

        percentText.setEditable(false);
        percentText.setText("0%");
        percentText.setBounds(10, 75, 294, 20);
        getContentPane().add(percentText);

        JSeparator separator1 = new JSeparator();
        separator1.setBounds(0, 100, 320, 1); // Ajustei a largura para 480
        getContentPane().add(separator1);

        tryField = new JTextField();
        tryField.setEnabled(false);
        tryField.setBounds(10, 106, 294, 20);
        getContentPane().add(tryField);

        okButton.setEnabled(false);
        okButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent event) {
                if (tryField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Digite um nome...", "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                gameLogic.checkAnswer(tryField.getText());
            }
        });
        okButton.setBounds(10, 130, 145, 23);
        getContentPane().add(okButton);

        nextMusicButton.setEnabled(false);
        nextMusicButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent event) {
                gameLogic.skipMusic();
            }
        });
        nextMusicButton.setBounds(159, 130, 145, 23);
        getContentPane().add(nextMusicButton);

        JSeparator separator2 = new JSeparator();
        separator2.setBounds(0, 160, 320, 1); // Ajustei a largura para 480
        getContentPane().add(separator2);

        startButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent event) {
                tryField.setEnabled(true);
                okButton.setEnabled(true);
                nextMusicButton.setEnabled(true);
                startButton.setEnabled(false);
                gameLogic.startGame();
            }
        });
        startButton.setBounds(10, 170, 294, 23);
        getContentPane().add(startButton);

        JSeparator separator3 = new JSeparator();
        separator3.setBounds(0, 200, 480, 1); // Ajustei a largura para 480
        getContentPane().add(separator3);

        winsText.setText("Acertos: 0 - 0 ||| Erros: 0 - Falta: 0");
        winsText.setEditable(false);
        winsText.setBounds(10, 210, 294, 20);
        getContentPane().add(winsText);

        percentBarText.setText("[*********************************************]");
        percentBarText.setEditable(false);
        percentBarText.setBounds(10, 230, 294, 20);
        getContentPane().add(percentBarText);

        coverLabel.setBounds(320, 35, 150, 150); // Espaço reservado para a imagem do cover
        coverLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK)); // Adicionei uma borda para a imagem
        getContentPane().add(coverLabel);
    }

    public void setGameLogic(GameLogic gameLogic) {
        this.gameLogic = gameLogic;
    }

    public void updateUI(String author, String music, String percent, String wins, String bar, ImageIcon coverImage) {
        authorText.setText(author);
        musicText.setText(music);
        percentText.setText(percent);
        winsText.setText(wins);
        percentBarText.setText(bar);
        if (coverImage != null) {
            Image img = coverImage.getImage();
            Image scaledImg = img.getScaledInstance(150, 150, Image.SCALE_SMOOTH); // Redimensiona a imagem para caber no JLabel
            coverLabel.setIcon(new ImageIcon(scaledImg));
        } else {
            coverLabel.setIcon(null);
        }
    }

    public void disableInput() {
        tryField.setEnabled(false);
        okButton.setEnabled(false);
        nextMusicButton.setEnabled(false);
    }

    public void enableInput() {
        tryField.setEnabled(true);
        okButton.setEnabled(true);
        nextMusicButton.setEnabled(true);
    }

    public void clearInput() {
        tryField.setText("");
    }
}
