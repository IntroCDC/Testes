package br.com.introcdc.tests.remote;
/*
 * Written by IntroCDC, Bruno Coelho at 29/10/2025 - 06:10
 * Atualizado: buffer dos últimos 5s (F8), Burst no F10, janela mais estreita, sem "Kindome" no título.
 */

import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.MemoryCacheImageOutputStream;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EvidenceSnap extends JFrame {

    // ====== Config ======
    private static final Path BASE_DIR = Paths.get("F:\\Documentos\\Random\\EvidenceSnap");
    private static final Path PRINTS_DIR = BASE_DIR.resolve("prints");
    private static final Path NOTES_DIR = BASE_DIR.resolve("notas");
    private static final Path LOG_CSV = BASE_DIR.resolve("log.csv");
    private static final DateTimeFormatter TS = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss_SSS");

    // ====== UI ======
    private JLabel previewLabel;
    private JCheckBox hideOnCaptureCheck;
    private JButton btnFull, btnArea, btnBurst, btnSaveLast5s, btnNote, btnMark, btnOpen, btnCopyPath;
    private volatile Path lastSaved;

    private final ExecutorService pool = Executors.newCachedThreadPool();

    // ====== Rolling buffer (últimos 5s em memória @ ~20fps) ======
    private static class Frame {
        final long ts;
        final byte[] jpeg;

        Frame(long ts, byte[] jpeg) {
            this.ts = ts;
            this.jpeg = jpeg;
        }
    }

    private final Deque<Frame> rollingBuffer = new ArrayDeque<>();
    private volatile boolean rollingRunning = true;

    // ====== Notes ======
    enum NoteType {
        AGRESSAO_GATA("Agressão à gata"),
        PUXAO_RABO("Puxão no rabo"),
        GRITO("Grito/hostilidade"),
        OBJETO_ARREMESSADO("Objeto arremessado"),
        SUSPEITA("Comportamento suspeito"),
        OUTRO("Outro");

        private final String label;

        NoteType(String l) {
            this.label = l;
        }

        @Override
        public String toString() {
            return label;
        }
    }

    public EvidenceSnap() {
        super("Snap de Provas");
        ensureDirs();

        // ====== Look básico ======
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(720, 800)); // mais estreito, cabe bem em 1366×768
        setLocationRelativeTo(null);

        var content = new JPanel(new BorderLayout(12, 12));
        content.setBorder(new EmptyBorder(12, 12, 12, 12));
        setContentPane(content);

        // Header
        var title = new JLabel("Snap de Provas");
        title.setFont(title.getFont().deriveFont(Font.BOLD, 22f));
        title.setBorder(new EmptyBorder(4, 4, 4, 4));
        content.add(title, BorderLayout.NORTH);

        // Preview
        previewLabel = new JLabel("Pré-visualização aparecerá aqui após a primeira captura", SwingConstants.CENTER);
        previewLabel.setOpaque(true);
        previewLabel.setBackground(new Color(24, 24, 28));
        previewLabel.setForeground(new Color(220, 220, 230));
        previewLabel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(80, 80, 90)),
                new EmptyBorder(10, 10, 10, 10)
        ));
        content.add(new JScrollPane(previewLabel), BorderLayout.CENTER);

        // Buttons
        var panelButtons = new JPanel(new GridLayout(0, 2, 10, 10));

        btnFull = new JButton("Tira Print (Tela Cheia) [F9]");
        btnArea = new JButton("Tira Print (Área)");
        btnBurst = new JButton("Burst 5s (20 fps) [F10]");
        btnSaveLast5s = new JButton("Salvar Últimos 5s [F8]");
        btnNote = new JButton("Adicionar Anotação");
        btnMark = new JButton("Marcar Evento Rápido");
        btnOpen = new JButton("Abrir Pasta de Evidências");
        btnCopyPath = new JButton("Copiar caminho do último arquivo");

        styleButton(btnFull);
        styleButton(btnArea);
        styleButton(btnBurst);
        styleButton(btnSaveLast5s);
        styleButton(btnNote);
        styleButton(btnMark);
        styleButton(btnOpen);
        styleButton(btnCopyPath);

        panelButtons.add(btnFull);
        panelButtons.add(btnArea);
        panelButtons.add(btnBurst);
        panelButtons.add(btnSaveLast5s);
        panelButtons.add(btnNote);
        panelButtons.add(btnMark);
        panelButtons.add(btnOpen);
        panelButtons.add(btnCopyPath);

        hideOnCaptureCheck = new JCheckBox("Esconder a janela ao capturar (recomendado)");
        hideOnCaptureCheck.setSelected(true);

        var south = new JPanel(new BorderLayout(10, 10));
        south.add(panelButtons, BorderLayout.CENTER);
        south.add(hideOnCaptureCheck, BorderLayout.SOUTH);
        content.add(south, BorderLayout.SOUTH);

        // Actions
        btnFull.addActionListener(e -> runAsync(this::captureFullScreenFlow));
        btnArea.addActionListener(e -> runAsync(this::captureAreaFlow));
        btnBurst.addActionListener(e -> runAsync(this::captureBurstFlow));
        btnSaveLast5s.addActionListener(e -> runAsync(this::saveLast5sFlow));
        btnNote.addActionListener(e -> runAsync(this::addNoteFlow));
        btnMark.addActionListener(e -> runAsync(this::quickMarkFlow));
        btnOpen.addActionListener(e -> openFolder(BASE_DIR));
        btnCopyPath.addActionListener(e -> copyLastPath());

        // Atalhos (quando focado)
        var im = content.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        var am = content.getActionMap();
        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_F9, 0), "quickShot");
        am.put("quickShot", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                runAsync(EvidenceSnap.this::captureFullScreenFlow);
            }
        });
        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_F10, 0), "burst5s");
        am.put("burst5s", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                runAsync(EvidenceSnap.this::captureBurstFlow);
            }
        });
        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_F8, 0), "saveLast5s");
        am.put("saveLast5s", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                runAsync(EvidenceSnap.this::saveLast5sFlow);
            }
        });

        // System Tray
        setupSystemTray();

        // Rolling buffer loop
        startRollingCapture();

        // Encerrar rolling ao fechar
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                rollingRunning = false;
                pool.shutdownNow();
            }
        });

        setVisible(true);

        // Carrega a última print (assíncrono pra não travar a UI)
        runAsync(this::loadLastPrintOnStartup);
    }

    // ====== Flows ======
    private void captureFullScreenFlow() {
        try {
            Runnable action = () -> {
                try {
                    Rectangle bounds = getPrimaryScreenBounds();
                    BufferedImage img = new Robot().createScreenCapture(bounds);
                    Path file = saveImage(img, "PRINT_full_");
                    updatePreview(img);
                    lastSaved = file;
                    logAction("PRINT_FULL", file, null, "");
                } catch (Exception ex) {
                    showError("Falha ao capturar tela cheia: " + ex.getMessage());
                }
            };
            captureWithOptionalHide(action);
        } catch (Exception ex) {
            showError("Erro inesperado: " + ex.getMessage());
        }
    }

    private void captureAreaFlow() {
        try {
            Rectangle sel = SelectionOverlay.selectArea(this);
            if (sel == null || sel.width <= 0 || sel.height <= 0) return;

            Runnable action = () -> {
                try {
                    BufferedImage img = new Robot().createScreenCapture(sel);
                    Path file = saveImage(img, "PRINT_area_");
                    updatePreview(img);
                    lastSaved = file;
                    logAction("PRINT_AREA", file, null, rectToString(sel));
                } catch (Exception ex) {
                    showError("Falha ao capturar área: " + ex.getMessage());
                }
            };
            captureWithOptionalHide(action);
        } catch (Exception ex) {
            showError("Erro inesperado: " + ex.getMessage());
        }
    }

    private void quickMarkFlow() {
        try {
            String stamp = LocalDateTime.now().format(TS);
            Path file = NOTES_DIR.resolve("MARK_" + stamp + ".txt");
            Files.write(file, List.of("Marca de tempo: " + LocalDateTime.now()), StandardOpenOption.CREATE_NEW);
            lastSaved = file;
            logAction("MARK", file, null, "");
            showInfo("Evento marcado!\n" + file);
        } catch (Exception ex) {
            showError("Falha ao marcar evento: " + ex.getMessage());
        }
    }

    private void addNoteFlow() {
        NoteType type = (NoteType) JOptionPane.showInputDialog(
                this,
                "Selecione o tipo de anotação:",
                "Adicionar Anotação",
                JOptionPane.QUESTION_MESSAGE,
                null,
                NoteType.values(),
                NoteType.SUSPEITA
        );
        if (type == null) return;

        String extra = JOptionPane.showInputDialog(this, "Observações (opcional):");
        if (extra == null) extra = "";

        try {
            String stamp = LocalDateTime.now().format(TS);
            Path file = NOTES_DIR.resolve("NOTE_" + stamp + ".txt");
            List<String> lines = List.of(
                    "Data/Hora: " + LocalDateTime.now(),
                    "Tipo: " + type,
                    "Obs: " + extra
            );
            Files.write(file, lines, StandardOpenOption.CREATE_NEW);
            lastSaved = file;
            logAction("NOTE", file, type, extra);
            showInfo("Anotação salva!\n" + file);
        } catch (Exception ex) {
            showError("Falha ao salvar anotação: " + ex.getMessage());
        }
    }

    private void captureBurstFlow() {
        Runnable action = () -> {
            try {
                Rectangle bounds = getPrimaryScreenBounds();
                String stamp = LocalDateTime.now().format(TS);
                Path burstDir = PRINTS_DIR.resolve("burst_" + stamp);
                Files.createDirectories(burstDir);

                long start = System.currentTimeMillis();
                long durationMs = 5000;
                long frameInterval = 50; // ~20 fps

                int idx = 0;
                Robot robot = new Robot();
                while (System.currentTimeMillis() - start < durationMs) {
                    BufferedImage img = robot.createScreenCapture(bounds);
                    String name = String.format("frame_%04d.png", idx++);
                    Path file = burstDir.resolve(name);
                    ImageIO.write(img, "png", file.toFile());
                    Thread.sleep(frameInterval);
                }

                BufferedImage last = ImageIO.read(burstDir.resolve(String.format("frame_%04d.png", idx - 1)).toFile());
                updatePreview(last);
                lastSaved = burstDir;
                logAction("BURST_5S_20FPS", burstDir, null, "frames=" + idx);

                showInfo("Burst finalizado!\nPasta: " + burstDir);
            } catch (Exception ex) {
                showError("Falha no burst: " + ex.getMessage());
            }
        };
        try {
            captureWithOptionalHide(action);
        } catch (Exception exception) {
            showError("Erro inesperado: " + exception.getMessage());
        }
    }

    private void saveLast5sFlow() {
        // Salva os frames já capturados nos últimos ~5000ms em JPG
        try {
            List<Frame> frames;
            long cutoff = System.currentTimeMillis() - 5000;
            synchronized (rollingBuffer) {
                frames = new ArrayList<>();
                for (Frame f : rollingBuffer) {
                    if (f.ts >= cutoff) frames.add(f);
                }
            }
            if (frames.isEmpty()) {
                showInfo("Buffer vazio nos últimos 5s (tente novamente).");
                return;
            }
            String stamp = LocalDateTime.now().format(TS);
            Path dir = PRINTS_DIR.resolve("last5s_" + stamp);
            Files.createDirectories(dir);

            int idx = 0;
            for (Frame f : frames) {
                Path out = dir.resolve(String.format("frame_%04d.jpg", idx++));
                Files.write(out, f.jpeg, StandardOpenOption.CREATE_NEW);
            }

            BufferedImage last = ImageIO.read(dir.resolve(String.format("frame_%04d.jpg", idx - 1)).toFile());
            updatePreview(last);
            lastSaved = dir;
            logAction("SAVE_LAST5S_20FPS", dir, null, "frames=" + idx);
            showInfo("Últimos 5s salvos!\nPasta: " + dir);
        } catch (Exception ex) {
            showError("Falha ao salvar últimos 5s: " + ex.getMessage());
        }
    }

    // ====== Rolling buffer loop ======
    private void startRollingCapture() {
        pool.submit(() -> {
            try {
                Robot robot = new Robot();
                long interval = 50L; // ~20 fps
                while (rollingRunning) {
                    Rectangle bounds = getPrimaryScreenBounds();
                    BufferedImage img = robot.createScreenCapture(bounds);
                    byte[] bytes = encodeJpeg(img, 0.9f); // JPEG alta qualidade pra não explodir RAM
                    long now = System.currentTimeMillis();
                    synchronized (rollingBuffer) {
                        rollingBuffer.addLast(new Frame(now, bytes));
                        // remove mais antigos que 5s
                        while (!rollingBuffer.isEmpty() && rollingBuffer.peekFirst().ts < now - 5000) {
                            rollingBuffer.removeFirst();
                        }
                        // salvaguarda: evita estourar se FPS variar
                        while (rollingBuffer.size() > 150) {
                            rollingBuffer.removeFirst();
                        }
                    }
                    Thread.sleep(interval);
                }
            } catch (Exception ignored) {
            }
        });
    }

    // ====== Helpers ======
    private void captureWithOptionalHide(Runnable action) throws Exception {
        if (hideOnCaptureCheck.isSelected()) {
            SwingUtilities.invokeAndWait(() -> setVisible(false));
            Thread.sleep(300); // dar tempo de sumir da tela
            try {
                action.run();
            } finally {
                SwingUtilities.invokeLater(() -> setVisible(true));
            }
        } else {
            action.run();
        }
    }

    private Rectangle getPrimaryScreenBounds() {
        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        return gd.getDefaultConfiguration().getBounds();
    }

    private Path saveImage(BufferedImage img, String prefix) throws IOException {
        Files.createDirectories(PRINTS_DIR);
        String name = prefix + LocalDateTime.now().format(TS) + ".png";
        Path file = PRINTS_DIR.resolve(name);
        ImageIO.write(img, "png", file.toFile());
        return file;
    }

    private void updatePreview(BufferedImage img) {
        SwingUtilities.invokeLater(() -> {
            int maxW = Math.max(360, previewLabel.getWidth() - 20);
            int maxH = Math.max(260, previewLabel.getHeight() - 20);
            Image scaled = scaleToFit(img, maxW, maxH);
            previewLabel.setIcon(new ImageIcon(scaled));
            previewLabel.setText("");
        });
    }

    private Image scaleToFit(BufferedImage img, int maxW, int maxH) {
        double rw = (double) maxW / img.getWidth();
        double rh = (double) maxH / img.getHeight();
        double r = Math.min(rw, rh);
        int w = (int) Math.max(1, Math.round(img.getWidth() * r));
        int h = (int) Math.max(1, Math.round(img.getHeight() * r));
        return img.getScaledInstance(w, h, Image.SCALE_SMOOTH);
    }

    private void logAction(String action, Path path, NoteType type, String extra) {
        try {
            Files.createDirectories(BASE_DIR);
            boolean exists = Files.exists(LOG_CSV);
            try (var out = Files.newBufferedWriter(LOG_CSV, StandardOpenOption.CREATE, StandardOpenOption.APPEND)) {
                if (!exists) {
                    out.write("timestamp;action;path;noteType;extra\n");
                }
                out.write(LocalDateTime.now() + ";" + action + ";" + path + ";" + (type == null ? "" : type) + ";" + (extra == null ? "" : extra) + "\n");
            }
        } catch (IOException ignored) {
        }
    }

    // === Carregar última print na inicialização ===
    private void loadLastPrintOnStartup() {
        try {
            Optional<Path> last = findMostRecentImage(PRINTS_DIR, 5); // procura até 5 níveis
            if (last.isPresent()) {
                BufferedImage img = ImageIO.read(last.get().toFile());
                if (img != null) {
                    updatePreview(img);
                    lastSaved = last.get();
                    logAction("LOAD_LAST_PRINT_ON_START", lastSaved, null, "");
                }
            }
        } catch (Exception ignored) {
            // Mantém o preview padrão se nada for encontrado
        }
    }

    private Optional<Path> findMostRecentImage(Path root, int maxDepth) throws IOException {
        if (!Files.exists(root)) return Optional.empty();
        // Aceita PNG/JPG/JPEG em qualquer subpasta (ex.: burst, last5s)
        try (var stream = Files.walk(root, Math.max(1, maxDepth))) {
            return stream
                    .filter(Files::isRegularFile)
                    .filter(this::isImageFile)
                    .max(Comparator.comparingLong(p -> {
                        try {
                            return Files.getLastModifiedTime(p).toMillis();
                        } catch (IOException e) {
                            return Long.MIN_VALUE;
                        }
                    }));
        }
    }

    private boolean isImageFile(Path p) {
        String n = p.getFileName().toString().toLowerCase(Locale.ROOT);
        return n.endsWith(".png") || n.endsWith(".jpg") || n.endsWith(".jpeg");
    }

    private void openFolder(Path dir) {
        try {
            Desktop.getDesktop().open(dir.toFile());
        } catch (Exception ex) {
            showError("Não foi possível abrir a pasta: " + ex.getMessage());
        }
    }

    private void copyLastPath() {
        if (lastSaved == null) {
            showInfo("Ainda não há arquivos salvos nesta sessão.");
            return;
        }
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(new StringSelection(lastSaved.toString()), null);
        showInfo("Caminho copiado:\n" + lastSaved);
    }

    private void styleButton(JButton b) {
        b.setFocusPainted(false);
        b.setFont(b.getFont().deriveFont(Font.BOLD, 14f));
        b.setBackground(new Color(88, 62, 120));
        b.setForeground(Color.WHITE);
        b.setBorder(BorderFactory.createEmptyBorder(10, 12, 10, 12));
        b.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }

    private void ensureDirs() {
        try {
            Files.createDirectories(PRINTS_DIR);
            Files.createDirectories(NOTES_DIR);
        } catch (IOException e) {
            showError("Não foi possível criar as pastas de evidências: " + e.getMessage());
        }
    }

    private void runAsync(Runnable r) {
        pool.submit(r);
    }

    private void setupSystemTray() {
        if (!SystemTray.isSupported()) return;
        try {
            SystemTray tray = SystemTray.getSystemTray();
            Image img = buildTrayIconImage();
            PopupMenu menu = new PopupMenu();

            MenuItem miSnap = new MenuItem("Tirar Print (Tela Cheia)");
            miSnap.addActionListener(e -> runAsync(this::captureFullScreenFlow));

            MenuItem miBurst = new MenuItem("Burst 5s (20 fps)");
            miBurst.addActionListener(e -> runAsync(this::captureBurstFlow));

            MenuItem miSaveLast = new MenuItem("Salvar Últimos 5s");
            miSaveLast.addActionListener(e -> runAsync(this::saveLast5sFlow));

            MenuItem miOpen = new MenuItem("Abrir Pasta de Evidências");
            miOpen.addActionListener(e -> openFolder(BASE_DIR));

            MenuItem miShow = new MenuItem("Mostrar Janela");
            miShow.addActionListener(e -> SwingUtilities.invokeLater(() -> {
                setVisible(true);
                setExtendedState(JFrame.NORMAL);
                toFront();
            }));

            MenuItem miExit = new MenuItem("Sair");
            miExit.addActionListener(e -> {
                rollingRunning = false;
                pool.shutdownNow();
                System.exit(0);
            });

            menu.add(miSnap);
            menu.add(miBurst);
            menu.add(miSaveLast);
            menu.add(miOpen);
            menu.addSeparator();
            menu.add(miShow);
            menu.add(miExit);

            TrayIcon icon = new TrayIcon(img, "Snap de Provas", menu);
            icon.setImageAutoSize(true);
            icon.addActionListener(e -> SwingUtilities.invokeLater(() -> {
                setVisible(true);
                setExtendedState(JFrame.NORMAL);
                toFront();
            }));

            tray.add(icon);
        } catch (Exception ignored) {
        }
    }

    private Image buildTrayIconImage() {
        int s = 16;
        BufferedImage img = new BufferedImage(s, s, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = img.createGraphics();
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setColor(new Color(88, 62, 120));
        g.fillOval(0, 0, s, s);
        g.setColor(Color.WHITE);
        g.setFont(new Font("SansSerif", Font.BOLD, 12));
        FontMetrics fm = g.getFontMetrics();
        String t = "S"; // Snap
        int x = (s - fm.stringWidth(t)) / 2;
        int y = (s - fm.getHeight()) / 2 + fm.getAscent();
        g.drawString(t, x, y);
        g.dispose();
        return img;
    }

    private void showInfo(String msg) {
        SwingUtilities.invokeLater(() ->
                JOptionPane.showMessageDialog(this, msg, "Info", JOptionPane.INFORMATION_MESSAGE));
    }

    private void showError(String msg) {
        SwingUtilities.invokeLater(() ->
                JOptionPane.showMessageDialog(this, msg, "Erro", JOptionPane.ERROR_MESSAGE));
    }

    private static String rectToString(Rectangle r) {
        return "x=" + r.x + ",y=" + r.y + ",w=" + r.width + ",h=" + r.height;
    }

    private static byte[] encodeJpeg(BufferedImage src, float quality) throws IOException {
        // Converte pra RGB (JPEG não tem alpha)
        BufferedImage rgb = new BufferedImage(src.getWidth(), src.getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics2D g = rgb.createGraphics();
        g.drawImage(src, 0, 0, null);
        g.dispose();

        var writers = ImageIO.getImageWritersByFormatName("jpg");
        ImageWriter w = writers.hasNext() ? writers.next() : null;
        if (w == null) {
            // fallback simples
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(rgb, "jpg", baos);
            return baos.toByteArray();
        }
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try (MemoryCacheImageOutputStream ios = new MemoryCacheImageOutputStream(baos)) {
            w.setOutput(ios);
            ImageWriteParam p = w.getDefaultWriteParam();
            if (p.canWriteCompressed()) {
                p.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
                p.setCompressionQuality(Math.max(0.1f, Math.min(1f, quality)));
            }
            w.write(null, new javax.imageio.IIOImage(rgb, null, null), p);
            w.dispose();
        }
        return baos.toByteArray();
    }

    // ====== Selection Overlay (arrastar para selecionar) ======
    static class SelectionOverlay extends JWindow {
        private Point start, current;
        private Rectangle selection;

        private SelectionOverlay() {
            setAlwaysOnTop(true);
            setBackground(new Color(0, 0, 0, 0)); // transparente
            Rectangle b = GraphicsEnvironment.getLocalGraphicsEnvironment()
                    .getDefaultScreenDevice().getDefaultConfiguration().getBounds();
            setBounds(b);

            MouseAdapter ma = new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    start = e.getPoint();
                    current = start;
                    repaint();
                }

                @Override
                public void mouseDragged(MouseEvent e) {
                    current = e.getPoint();
                    repaint();
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    current = e.getPoint();
                    selection = toRect(start, current);
                    dispose();
                }
            };
            addMouseListener(ma);
            addMouseMotionListener(ma);

            setVisible(true);
        }

        @Override
        public void paint(Graphics g) {
            Graphics2D g2 = (Graphics2D) g;
            Rectangle b = getBounds();
            // véu
            g2.setColor(new Color(0, 0, 0, 80));
            g2.fillRect(0, 0, b.width, b.height);

            if (start != null && current != null) {
                Rectangle r = toRect(start, current);
                // recorte
                g2.setComposite(AlphaComposite.Clear);
                g2.fillRect(r.x, r.y, r.width, r.height);
                g2.setComposite(AlphaComposite.SrcOver);

                // borda
                g2.setColor(new Color(88, 62, 120));
                float[] dash = {6f, 6f};
                g2.setStroke(new BasicStroke(2f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 1f, dash, 0f));
                g2.draw(r);

                // dica
                g2.setColor(Color.WHITE);
                g2.setFont(new Font("SansSerif", Font.BOLD, 14));
                String hint = r.width + "×" + r.height;
                FontMetrics fm = g2.getFontMetrics();
                int tx = r.x + 6;
                int ty = r.y - 8 < 18 ? r.y + r.height + fm.getAscent() + 6 : r.y - 8;
                g2.drawString(hint, tx, ty);
            }
        }

        private static Rectangle toRect(Point a, Point b) {
            int x = Math.min(a.x, b.x);
            int y = Math.min(a.y, b.y);
            int w = Math.abs(a.x - b.x);
            int h = Math.abs(a.y - b.y);
            return new Rectangle(x, y, w, h);
        }

        static Rectangle selectArea(Component parent) {
            SelectionOverlay so = new SelectionOverlay();
            final Object lock = new Object();
            so.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    synchronized (lock) {
                        lock.notify();
                    }
                }
            });
            synchronized (lock) {
                try {
                    lock.wait();
                } catch (InterruptedException ignored) {
                }
            }
            return so.selection;
        }
    }

    public static void main(String[] args) {
        // Deixa com fonte “normal” no Windows sem DPI zoado
        System.setProperty("sun.java2d.uiScale", "1.0");
        SwingUtilities.invokeLater(EvidenceSnap::new);
    }
}
