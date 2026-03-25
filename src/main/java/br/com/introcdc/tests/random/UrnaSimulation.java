package br.com.introcdc.tests.random;
/*
 * Written by IntroCDC, Bruno Coelho at 24/03/2026 - 03:48
 */

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class UrnaSimulation {

    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    private static final int CANDIDATE_NUMBER_LENGTH = 2;

    private final JFrame frame = new JFrame("Simulador de Urna - Kindome");
    private final JTextArea headerArea = new JTextArea();
    private final JLabel numberLabel = new JLabel("", SwingConstants.LEFT);
    private final JLabel officeLabel = new JLabel("Promoção de Staff", SwingConstants.LEFT);
    private final JLabel candidateNameLabel = new JLabel("", SwingConstants.LEFT);
    private final JLabel candidateRoleLabel = new JLabel("", SwingConstants.LEFT);
    private final JLabel statusLabel = new JLabel("Digite o número do staffer", SwingConstants.LEFT);
    private final JTextArea receiptArea = new JTextArea();

    private final List<Candidate> candidates = List.of(
            new Candidate("11", "Safira", "TrialMod ? Moderadora", "A staff mais chik chik"),
            new Candidate("22", "Ivan", "Moderador ? Administrador", "Organização e presença"),
            new Candidate("33", "Severo", "Suporte ? TrialMod", "Atendimento consistente"),
            new Candidate("44", "Jotah", "Builder ? Builder+", "Capricho nos mapas"),
            new Candidate("55", "Rafael", "Marketing ? Gerente", "Comunicação e ideias")
    );

    private final Map<String, Candidate> candidateByNumber = new LinkedHashMap<>();
    private final Map<String, Integer> tallyByNumber = new LinkedHashMap<>();

    private final StringBuilder currentInput = new StringBuilder();
    private final VoteLedger voteLedger = new VoteLedger();
    private final TonePlayer tonePlayer = new TonePlayer();
    private final AtomicBoolean locked = new AtomicBoolean(false);

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new UrnaSimulation().start());
    }

    private void start() {
        for (Candidate candidate : candidates) {
            candidateByNumber.put(candidate.number(), candidate);
            tallyByNumber.put(candidate.number(), 0);
        }
        buildInterface();
        tonePlayer.playStartupTone();
    }

    private void buildInterface() {
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(1080, 720);
        frame.setMinimumSize(new Dimension(980, 620));
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout(16, 16));

        JPanel rootPanel = new JPanel(new BorderLayout(16, 16));
        rootPanel.setBorder(new EmptyBorder(16, 16, 16, 16));
        rootPanel.setBackground(new Color(218, 214, 204));

        rootPanel.add(buildScreenPanel(), BorderLayout.CENTER);
        rootPanel.add(buildKeyboardPanel(), BorderLayout.EAST);

        frame.setContentPane(rootPanel);
        frame.setVisible(true);
        resetScreenForNextVote();
    }

    private JPanel buildScreenPanel() {
        JPanel panel = new JPanel(new BorderLayout(12, 12));
        panel.setBackground(new Color(232, 239, 223));
        panel.setBorder(new CompoundBorder(new LineBorder(new Color(90, 90, 90), 2), new EmptyBorder(18, 18, 18, 18)));

        headerArea.setEditable(false);
        headerArea.setLineWrap(true);
        headerArea.setWrapStyleWord(true);
        headerArea.setOpaque(false);
        headerArea.setFont(new Font("SansSerif", Font.PLAIN, 18));
        headerArea.setText("JUSTIÇA KINDOMAL\nSimulador de votação interna\nNão oficial. Apenas para brincadeira e testes.");

        JPanel centerPanel = new JPanel();
        centerPanel.setOpaque(false);
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));

        officeLabel.setFont(new Font("SansSerif", Font.BOLD, 32));
        numberLabel.setFont(new Font("Monospaced", Font.BOLD, 52));
        candidateNameLabel.setFont(new Font("SansSerif", Font.BOLD, 28));
        candidateRoleLabel.setFont(new Font("SansSerif", Font.PLAIN, 22));
        statusLabel.setFont(new Font("SansSerif", Font.BOLD, 22));

        centerPanel.add(headerArea);
        centerPanel.add(Box.createVerticalStrut(20));
        centerPanel.add(officeLabel);
        centerPanel.add(Box.createVerticalStrut(18));
        centerPanel.add(numberLabel);
        centerPanel.add(Box.createVerticalStrut(18));
        centerPanel.add(candidateNameLabel);
        centerPanel.add(Box.createVerticalStrut(8));
        centerPanel.add(candidateRoleLabel);
        centerPanel.add(Box.createVerticalGlue());

        receiptArea.setEditable(false);
        receiptArea.setLineWrap(true);
        receiptArea.setWrapStyleWord(true);
        receiptArea.setFont(new Font("Monospaced", Font.PLAIN, 15));
        receiptArea.setBackground(new Color(248, 248, 248));
        receiptArea.setBorder(new CompoundBorder(new LineBorder(new Color(120, 120, 120), 1), new EmptyBorder(10, 10, 10, 10)));
        receiptArea.setText(buildCandidatesText());

        JPanel southPanel = new JPanel(new BorderLayout(10, 10));
        southPanel.setOpaque(false);
        southPanel.add(statusLabel, BorderLayout.NORTH);
        southPanel.add(new JScrollPane(receiptArea), BorderLayout.CENTER);

        panel.add(centerPanel, BorderLayout.CENTER);
        panel.add(southPanel, BorderLayout.SOUTH);
        return panel;
    }

    private JPanel buildKeyboardPanel() {
        JPanel panel = new JPanel(new BorderLayout(12, 12));
        panel.setPreferredSize(new Dimension(340, 0));
        panel.setBackground(new Color(71, 71, 71));
        panel.setBorder(new CompoundBorder(new LineBorder(Color.DARK_GRAY, 2), new EmptyBorder(16, 16, 16, 16)));

        JLabel titleLabel = new JLabel("TECLADO", SwingConstants.CENTER);
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 28));
        panel.add(titleLabel, BorderLayout.NORTH);

        JPanel numberGrid = new JPanel(new GridLayout(4, 3, 10, 10));
        numberGrid.setOpaque(false);
        for (String text : List.of("1", "2", "3", "4", "5", "6", "7", "8", "9", "", "0", "")) {
            if (text.isBlank()) {
                numberGrid.add(Box.createGlue());
            } else {
                numberGrid.add(createButton(text, new Color(30, 30, 30), Color.WHITE, e -> appendDigit(text)));
            }
        }

        JPanel actionPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        actionPanel.setOpaque(false);
        actionPanel.add(createButton("BRANCO", new Color(240, 240, 240), Color.BLACK, e -> castBlank()));
        actionPanel.add(createButton("CORRIGE", new Color(213, 93, 35), Color.BLACK, e -> resetInput()));
        actionPanel.add(createButton("CONFIRMA", new Color(56, 170, 75), Color.BLACK, e -> confirmVote()));
        actionPanel.add(createButton("RESULTADOS", new Color(92, 112, 230), Color.WHITE, e -> showResultsDialog()));

        JPanel utilityPanel = new JPanel(new GridLayout(2, 1, 10, 10));
        utilityPanel.setOpaque(false);
        utilityPanel.add(createButton("SALVAR RDV DEMO", new Color(110, 77, 186), Color.WHITE, e -> exportRdvDemo()));
        utilityPanel.add(createButton("ZERAR VOTAÇÃO", new Color(140, 35, 35), Color.WHITE, e -> clearElection()));

        JPanel centerPanel = new JPanel(new BorderLayout(12, 12));
        centerPanel.setOpaque(false);
        centerPanel.add(numberGrid, BorderLayout.CENTER);
        centerPanel.add(actionPanel, BorderLayout.SOUTH);

        panel.add(centerPanel, BorderLayout.CENTER);
        panel.add(utilityPanel, BorderLayout.SOUTH);
        return panel;
    }

    private JButton createButton(String text, Color background, Color foreground, ActionListener actionListener) {
        JButton button = new JButton(text);
        button.setFocusPainted(false);
        button.setBackground(background);
        button.setForeground(foreground);
        button.setFont(new Font("SansSerif", Font.BOLD, 20));
        button.addActionListener(actionListener);
        return button;
    }

    private String buildCandidatesText() {
        StringBuilder builder = new StringBuilder();
        builder.append("Candidatos disponíveis:\n\n");
        for (Candidate candidate : candidates) {
            builder.append(candidate.number())
                    .append(" - ")
                    .append(candidate.name())
                    .append(" | ")
                    .append(candidate.role())
                    .append("\n    ")
                    .append(candidate.slogan())
                    .append("\n\n");
        }
        builder.append("Dica: RESULTADOS mostra o boletim e SALVAR RDV DEMO exporta os votos embaralhados e cifrados.");
        return builder.toString();
    }

    private void appendDigit(String digit) {
        if (locked.get()) {
            return;
        }
        if (currentInput.length() >= CANDIDATE_NUMBER_LENGTH) {
            tonePlayer.playErrorTone();
            statusLabel.setText("Número completo. Confirme ou corrija.");
            return;
        }
        currentInput.append(digit);
        tonePlayer.playKeyTone();
        refreshCurrentVotePreview();
    }

    private void castBlank() {
        if (locked.get()) {
            return;
        }
        currentInput.setLength(0);
        tonePlayer.playKeyTone();
        numberLabel.setText("BRANCO");
        candidateNameLabel.setText("Voto em branco");
        candidateRoleLabel.setText("Sem candidato selecionado");
        statusLabel.setText("Pressione CONFIRMA para votar em branco.");
    }

    private void resetInput() {
        if (locked.get()) {
            return;
        }
        tonePlayer.playErrorTone();
        resetScreenForNextVote();
    }

    private void confirmVote() {
        if (locked.get()) {
            return;
        }

        try {
            if ("BRANCO".equals(numberLabel.getText())) {
                voteLedger.recordVote("BRANCO", null);
                tonePlayer.playConfirmTone();
                showSuccessAndScheduleReset("Voto em branco confirmado.");
                return;
            }

            if (currentInput.length() != CANDIDATE_NUMBER_LENGTH) {
                tonePlayer.playErrorTone();
                statusLabel.setText("Número incompleto. Digite dois números.");
                return;
            }

            Candidate candidate = candidateByNumber.get(currentInput.toString());
            if (candidate == null) {
                voteLedger.recordVote("NULO", null);
                tonePlayer.playConfirmTone();
                showSuccessAndScheduleReset("Voto nulo confirmado.");
                return;
            }

            tallyByNumber.compute(candidate.number(), (key, value) -> value == null ? 1 : value + 1);
            voteLedger.recordVote(candidate.number(), candidate.name());
            tonePlayer.playConfirmTone();
            showSuccessAndScheduleReset("Voto confirmado para " + candidate.name() + ".");
        } catch (Exception exception) {
            tonePlayer.playErrorTone();
            statusLabel.setText("Erro ao registrar o voto: " + exception.getMessage());
            exception.printStackTrace();
        }
    }

    private void refreshCurrentVotePreview() {
        String inputValue = currentInput.toString();
        numberLabel.setText(inputValue);

        if (inputValue.length() < CANDIDATE_NUMBER_LENGTH) {
            candidateNameLabel.setText("...");
            candidateRoleLabel.setText("Digite " + (CANDIDATE_NUMBER_LENGTH - inputValue.length()) + " número(s) a mais");
            statusLabel.setText("Confira o número antes de confirmar.");
            return;
        }

        Candidate candidate = candidateByNumber.get(inputValue);
        if (candidate == null) {
            candidateNameLabel.setText("VOTO NULO");
            candidateRoleLabel.setText("Número não cadastrado");
            statusLabel.setText("Pressione CONFIRMA para votar nulo ou CORRIGE para reiniciar.");
            return;
        }

        candidateNameLabel.setText(candidate.name());
        candidateRoleLabel.setText(candidate.role() + " | " + candidate.slogan());
        statusLabel.setText("Pressione CONFIRMA para confirmar este voto.");
    }

    private void showSuccessAndScheduleReset(String message) {
        locked.set(true);
        headerArea.setText("FIM\n\nSeu voto para a brincadeira interna foi registrado com sucesso.");
        numberLabel.setText("");
        candidateNameLabel.setText("");
        candidateRoleLabel.setText("");
        statusLabel.setText(message);

        javax.swing.Timer timer = new javax.swing.Timer(1400, event -> {
            locked.set(false);
            resetScreenForNextVote();
        });
        timer.setRepeats(false);
        timer.start();
    }

    private void resetScreenForNextVote() {
        currentInput.setLength(0);
        headerArea.setText("JUSTIÇA KINDOMAL\nSimulador de votação interna\nNão oficial. Apenas para brincadeira e testes.");
        numberLabel.setText("");
        candidateNameLabel.setText("");
        candidateRoleLabel.setText("");
        statusLabel.setText("Digite o número do staffer");
    }

    private void showResultsDialog() {
        StringBuilder builder = new StringBuilder();
        builder.append("Boletim da Simulação\n");
        builder.append("Gerado em: ").append(LocalDateTime.now().format(DATE_FORMAT)).append("\n\n");

        int totalValidVotes = 0;
        Candidate winner = null;
        int winnerVotes = -1;

        for (Candidate candidate : candidates) {
            int votes = tallyByNumber.getOrDefault(candidate.number(), 0);
            totalValidVotes += votes;
            builder.append(candidate.number())
                    .append(" - ")
                    .append(candidate.name())
                    .append(": ")
                    .append(votes)
                    .append(" voto(s)\n");
            if (votes > winnerVotes) {
                winnerVotes = votes;
                winner = candidate;
            }
        }

        long blankVotes = voteLedger.countVotesByPlainValue("BRANCO");
        long nullVotes = voteLedger.countVotesByPlainValue("NULO");

        builder.append("\nBrancos: ").append(blankVotes).append("\n");
        builder.append("Nulos: ").append(nullVotes).append("\n");
        builder.append("Válidos: ").append(totalValidVotes).append("\n");
        builder.append("Total geral: ").append(voteLedger.size()).append("\n\n");

        if (winner != null) {
            builder.append("Líder atual: ").append(winner.name()).append(" com ").append(winnerVotes).append(" voto(s).\n\n");
        }

        builder.append("Integridade da simulação\n");
        builder.append("Hash encadeado final: ").append(voteLedger.getLastChainHash()).append("\n");
        builder.append("Hash do boletim: ").append(voteLedger.computeTallyHash(tallyByNumber)).append("\n");

        JTextArea textArea = new JTextArea(builder.toString());
        textArea.setEditable(false);
        textArea.setFont(new Font("Monospaced", Font.PLAIN, 15));

        JOptionPane.showMessageDialog(frame, new JScrollPane(textArea), "Resultados", JOptionPane.INFORMATION_MESSAGE);
    }

    private void exportRdvDemo() {
        try {
            Path outputPath = Path.of("rdv-demo-kindome-" + System.currentTimeMillis() + ".json");
            Files.writeString(outputPath, voteLedger.buildRdvJson(), StandardCharsets.UTF_8);
            JOptionPane.showMessageDialog(frame,
                    "Arquivo salvo em:\n" + outputPath.toAbsolutePath(),
                    "RDV demo exportado",
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception exception) {
            JOptionPane.showMessageDialog(frame,
                    "Não foi possível salvar o RDV demo:\n" + exception.getMessage(),
                    "Erro",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void clearElection() {
        int confirm = JOptionPane.showConfirmDialog(
                frame,
                "Tem certeza que deseja zerar todos os votos da simulação?",
                "Confirmar limpeza",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE
        );

        if (confirm != JOptionPane.YES_OPTION) {
            return;
        }

        for (Candidate candidate : candidates) {
            tallyByNumber.put(candidate.number(), 0);
        }
        voteLedger.clear();
        resetScreenForNextVote();
        JOptionPane.showMessageDialog(frame, "Votação zerada.", "Limpeza concluída", JOptionPane.INFORMATION_MESSAGE);
    }

    private record Candidate(String number, String name, String role, String slogan) {
    }

    private static final class VoteLedger {
        private final List<EncryptedVoteRecord> records = new ArrayList<>();
        private final SecureRandom secureRandom = new SecureRandom();
        private SecretKey secretKey;
        private String lastChainHash = repeat('0', 64);

        private VoteLedger() {
            try {
                KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
                keyGenerator.init(128);
                this.secretKey = keyGenerator.generateKey();
            } catch (Exception exception) {
                throw new IllegalStateException("Não foi possível iniciar a chave de cifragem", exception);
            }
        }

        private void recordVote(String plainValue, String candidateName) throws Exception {
            byte[] iv = new byte[12];
            secureRandom.nextBytes(iv);

            Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey, new GCMParameterSpec(128, iv));

            String payload = plainValue + "|" + (candidateName == null ? "-" : candidateName) + "|" + LocalDateTime.now().format(DATE_FORMAT);
            byte[] cipherText = cipher.doFinal(payload.getBytes(StandardCharsets.UTF_8));

            long shuffleKey = secureRandom.nextLong();
            String recordHash = sha256Hex(lastChainHash + Base64.getEncoder().encodeToString(iv) + Base64.getEncoder().encodeToString(cipherText) + shuffleKey);
            records.add(new EncryptedVoteRecord(
                    UUID.randomUUID().toString(),
                    Base64.getEncoder().encodeToString(iv),
                    Base64.getEncoder().encodeToString(cipherText),
                    shuffleKey,
                    LocalDateTime.now().format(DATE_FORMAT),
                    recordHash,
                    plainValue
            ));
            lastChainHash = recordHash;
        }

        private long countVotesByPlainValue(String plainValue) {
            return records.stream().filter(record -> Objects.equals(record.plainValue(), plainValue)).count();
        }

        private int size() {
            return records.size();
        }

        private String getLastChainHash() {
            return lastChainHash;
        }

        private String computeTallyHash(Map<String, Integer> tallyByNumber) {
            StringBuilder builder = new StringBuilder();
            tallyByNumber.forEach((key, value) -> builder.append(key).append('=').append(value).append(';'));
            builder.append("branco=").append(countVotesByPlainValue("BRANCO")).append(';');
            builder.append("nulo=").append(countVotesByPlainValue("NULO")).append(';');
            builder.append("total=").append(size());
            return sha256Hex(builder.toString());
        }

        private String buildRdvJson() {
            List<EncryptedVoteRecord> shuffledRecords = new ArrayList<>(records);
            shuffledRecords.sort(Comparator.comparingLong(EncryptedVoteRecord::shuffleKey));

            StringBuilder builder = new StringBuilder();
            builder.append("{\n");
            builder.append("  \"generatedAt\": \"").append(LocalDateTime.now().format(DATE_FORMAT)).append("\",\n");
            builder.append("  \"description\": \"Simulação inspirada no RDV: votos cifrados, encadeados por hash e exportados em ordem embaralhada.\",\n");
            builder.append("  \"chainHash\": \"").append(lastChainHash).append("\",\n");
            builder.append("  \"votes\": [\n");
            for (int index = 0; index < shuffledRecords.size(); index++) {
                EncryptedVoteRecord record = shuffledRecords.get(index);
                builder.append("    {\n");
                builder.append("      \"recordId\": \"").append(record.recordId()).append("\",\n");
                builder.append("      \"timestamp\": \"").append(record.timestamp()).append("\",\n");
                builder.append("      \"shuffleKey\": ").append(record.shuffleKey()).append(",\n");
                builder.append("      \"iv\": \"").append(record.ivBase64()).append("\",\n");
                builder.append("      \"cipherText\": \"").append(record.cipherTextBase64()).append("\",\n");
                builder.append("      \"recordHash\": \"").append(record.recordHash()).append("\"\n");
                builder.append("    }");
                if (index + 1 < shuffledRecords.size()) {
                    builder.append(',');
                }
                builder.append('\n');
            }
            builder.append("  ]\n");
            builder.append("}\n");
            return builder.toString();
        }

        private void clear() {
            records.clear();
            lastChainHash = repeat('0', 64);
            try {
                KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
                keyGenerator.init(128);
                this.secretKey = keyGenerator.generateKey();
            } catch (Exception exception) {
                throw new IllegalStateException("Não foi possível recriar a chave de cifragem", exception);
            }
        }

        private static String sha256Hex(String value) {
            try {
                MessageDigest digest = MessageDigest.getInstance("SHA-256");
                byte[] hash = digest.digest(value.getBytes(StandardCharsets.UTF_8));
                StringBuilder builder = new StringBuilder();
                for (byte current : hash) {
                    builder.append(String.format("%02x", current));
                }
                return builder.toString();
            } catch (Exception exception) {
                throw new IllegalStateException("Não foi possível calcular o hash", exception);
            }
        }

        private static String repeat(char character, int count) {
            StringBuilder builder = new StringBuilder();
            for (int index = 0; index < count; index++) {
                builder.append(character);
            }
            return builder.toString();
        }
    }

    private record EncryptedVoteRecord(
            String recordId,
            String ivBase64,
            String cipherTextBase64,
            long shuffleKey,
            String timestamp,
            String recordHash,
            String plainValue
    ) {
    }

    private static final class TonePlayer {
        private static final float SAMPLE_RATE = 44_100f;

        private void playStartupTone() {
            playAsync(() -> {
                playTone(740, 70, 0.45);
                sleep(25);
                playTone(880, 90, 0.50);
            });
        }

        private void playKeyTone() {
            playAsync(() -> playTone(880, 55, 0.40));
        }

        private void playConfirmTone() {
            playAsync(() -> {
                playTone(880, 70, 0.50);
                sleep(30);
                playTone(1175, 120, 0.50);
            });
        }

        private void playErrorTone() {
            playAsync(() -> {
                playTone(220, 110, 0.55);
                sleep(35);
                playTone(180, 120, 0.55);
            });
        }

        private void playAsync(Runnable runnable) {
            Thread soundThread = new Thread(runnable, "tone-player");
            soundThread.setDaemon(true);
            soundThread.start();
        }

        private void playTone(double frequency, int durationMs, double volume) {
            try {
                javax.sound.sampled.AudioFormat format = new javax.sound.sampled.AudioFormat(SAMPLE_RATE, 16, 1, true, false);
                javax.sound.sampled.DataLine.Info info = new javax.sound.sampled.DataLine.Info(javax.sound.sampled.SourceDataLine.class, format);
                try (javax.sound.sampled.SourceDataLine line = (javax.sound.sampled.SourceDataLine) javax.sound.sampled.AudioSystem.getLine(info)) {
                    line.open(format);
                    line.start();
                    byte[] buffer = new byte[2];
                    int totalSamples = (int) ((durationMs / 1000.0) * SAMPLE_RATE);
                    for (int sampleIndex = 0; sampleIndex < totalSamples; sampleIndex++) {
                        double angle = 2.0 * Math.PI * sampleIndex * frequency / SAMPLE_RATE;
                        short sampleValue = (short) (Math.sin(angle) * Short.MAX_VALUE * volume);
                        buffer[0] = (byte) (sampleValue & 0xff);
                        buffer[1] = (byte) ((sampleValue >> 8) & 0xff);
                        line.write(buffer, 0, buffer.length);
                    }
                    line.drain();
                }
            } catch (Exception ignored) {
                Toolkit.getDefaultToolkit().beep();
            }
        }

        private void sleep(long milliseconds) {
            try {
                Thread.sleep(milliseconds);
            } catch (InterruptedException ignored) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
