package br.com.introcdc.tests.elevator;
/*
 * Written by IntroCDC, Bruno Coelho at 17/08/2025 - 06:54
 */

import javax.swing.*;
import javax.swing.Timer;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;

/**
 * Simulador de Elevadores — versão “Torres”
 * Correções e melhorias:
 * 1) Setas (direção) redesenhadas em vetor -> renderiza bonito em qualquer LAF.
 * 2) Botões dos andares abaixo do 1º (SS/P/M) funcionando de boas (? e ? sempre ativos).
 * 3) Modo Destino Inteligente agora SEMPRE pega na origem antes de enviar ao destino (usa Trip).
 * 4) Visual de “torres”: cabeçalho por elevador, poço, cabine com portas, LEDs e stop markers.
 * <p>
 * Strings PT-BR; nomes em inglês.
 * Feito pro Bruno (IntroCDC/Kindome). :D
 */
public class ElevatorSimulatorApp {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            setLookAndFeel();
            new ElevatorSimulatorApp().showUI();
        });
    }

    // ======= THEME =======
    static final Color KD_BG = new Color(18, 18, 23);
    static final Color KD_CARD = new Color(30, 30, 38);
    static final Color KD_SHAFT = new Color(24, 24, 30);
    static final Color KD_WALL = new Color(40, 40, 50);
    static final Color KD_ACCENT = new Color(136, 84, 208); // roxinho
    static final Color KD_ACCENT_SOFT = new Color(164, 120, 220);
    static final Color KD_LED = new Color(255, 214, 80);
    static final Color KD_TEXT = new Color(235, 235, 245);
    static final Color KD_SUB = new Color(180, 180, 195);
    static final Font KD_TITLE = new Font("Segoe UI", Font.BOLD, 18);
    static final Font KD_UI = new Font("Segoe UI", Font.PLAIN, 14);

    JFrame frame;
    ConfigPanel configPanel;
    BuildingPanel buildingPanel;
    KioskPanel kioskPanel;
    LogPanel logPanel;

    Controller controller;

    void showUI() {
        frame = new JFrame("Simulador de Elevador — Kindome Labs");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.getContentPane().setBackground(KD_BG);

        configPanel = new ConfigPanel(this::startSimulation, this::resetSimulation);
        buildingPanel = new BuildingPanel();
        kioskPanel = new KioskPanel(this::handleDestinationRequest);
        logPanel = new LogPanel();

        JPanel center = new JPanel(new BorderLayout());
        center.setBackground(KD_BG);
        center.add(buildingPanel, BorderLayout.CENTER);
        center.add(kioskPanel, BorderLayout.SOUTH);

        frame.add(configPanel, BorderLayout.NORTH);
        frame.add(center, BorderLayout.CENTER);
        frame.add(logPanel, BorderLayout.EAST);

        frame.setSize(1280, 820);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        configPanel.applyDefaults();
    }

    void startSimulation(Config cfg) {
        if (controller != null) controller.stop();
        controller = new Controller(cfg, buildingPanel, kioskPanel, logPanel);
        controller.start();
        buildingPanel.attachController(controller);
        kioskPanel.setEnabledMode(cfg.mode == Mode.DESTINATION);
        logPanel.log("Simulação iniciada: " + cfg);
    }

    void resetSimulation() {
        if (controller != null) controller.stop();
        buildingPanel.clear();
        kioskPanel.reset();
        logPanel.clear();
        logPanel.log("Pronto pra outra! ksksksksks");
    }

    void handleDestinationRequest(String originLabel, String destLabel) {
        if (controller == null) return;
        controller.handleDestinationRequest(originLabel, destLabel);
    }

    static void setLookAndFeel() {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
            UIManager.put("control", KD_CARD);
            UIManager.put("info", KD_CARD);
            UIManager.put("nimbusBase", KD_ACCENT.darker());
            UIManager.put("nimbusBlueGrey", new Color(58, 58, 68));
            UIManager.put("background", KD_BG);
            UIManager.put("text", KD_TEXT);
        } catch (Exception ignored) {
        }
    }

    // ======= MODELS =======
    enum Mode {CLASSIC, DESTINATION}

    enum Direction {UP, DOWN, IDLE}

    static class Config {
        int elevators;
        int floorsAbove; // 1..N
        int floorsBelow; // 0..N (SS/P/M scheme)
        int msPerFloor;
        int doorMs;
        Mode mode;

        List<String> buildFloorLabels() {
            List<String> labels = new ArrayList<>();
            if (floorsBelow <= 0) {
                // nada abaixo
            } else if (floorsBelow == 1) {
                labels.add("P");
            } else if (floorsBelow == 2) {
                labels.add("SS1");
                labels.add("P");
            } else {
                int ssCount = floorsBelow - 2;
                for (int i = ssCount; i >= 1; i--) labels.add("SS" + i);
                labels.add("P");
                labels.add("M");
            }
            for (int i = 1; i <= floorsAbove; i++) labels.add(i + "º");
            return labels;
        }

        int totalFloors() {
            return buildFloorLabels().size();
        }

        @Override
        public String toString() {
            return String.format(Locale.ROOT,
                    "%delev, acima=%d, abaixo=%d, %dms/andar, porta=%dms, modo=%s",
                    elevators, floorsAbove, floorsBelow, msPerFloor, doorMs, mode);
        }
    }

    // ======= CONTROLLER =======
    static class Controller {
        final Config cfg;
        final BuildingPanel building;
        final KioskPanel kiosk;
        final LogPanel log;

        final List<String> floors; // index 0 = mais baixo
        final java.util.Timer timer = new java.util.Timer("elevator-timer", true);
        final List<Elevator> elevators = new ArrayList<>();
        volatile boolean running = false;

        final boolean[] hallUp;
        final boolean[] hallDown;

        // Trips (modo destino): por elevador
        final Map<Elevator, List<Trip>> tripsByElevator = new HashMap<>();

        Controller(Config cfg, BuildingPanel building, KioskPanel kiosk, LogPanel log) {
            this.cfg = cfg;
            this.building = building;
            this.kiosk = kiosk;
            this.log = log;
            this.floors = cfg.buildFloorLabels();
            this.hallUp = new boolean[floors.size()];
            this.hallDown = new boolean[floors.size()];

            for (int i = 0; i < cfg.elevators; i++) {
                Elevator e = new Elevator(i, "E" + (char) ('A' + i), middleFloorIndex());
                elevators.add(e);
                tripsByElevator.put(e, new ArrayList<>());
            }
            building.setupGrid(floors, elevators, this::onHallButton, this::onCabinClick);
            kiosk.populateFloorChoices(floors);
        }

        int middleFloorIndex() {
            return Math.max(0, floors.size() / 2 - 1);
        }

        void start() {
            running = true;
            long tick = Math.max(50, cfg.msPerFloor / 2L);
            timer.scheduleAtFixedRate(new java.util.TimerTask() {
                @Override
                public void run() {
                    step();
                }
            }, 300, tick);
        }

        void stop() {
            running = false;
            timer.cancel();
        }

        // ======= EVENTS =======
        void onHallButton(int floorIdx, Direction dir) {
            if (!running) return;
            if (cfg.mode == Mode.DESTINATION) {
                JOptionPane.showMessageDialog(building, "No modo 'Destino Inteligente' use o totem (origem/destino).", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            if (dir == Direction.UP) hallUp[floorIdx] = true;
            else hallDown[floorIdx] = true;
            building.setHallLight(floorIdx, dir, true);
            assignHallCallToBestElevator(floorIdx, dir);
        }

        void onCabinClick(Elevator e) {
            if (!running) return;
            if (cfg.mode == Mode.DESTINATION) {
                JOptionPane.showMessageDialog(building, "No modo 'Destino Inteligente' não há painel interno. Use o totem (origem/destino).", "Info", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            String sel = FloorDialog.show(building, floors, floors.get(e.currentFloor));
            if (sel == null) return;
            int idx = floors.indexOf(sel);
            if (idx < 0 || idx == e.currentFloor) return;
            addStopToElevator(e, idx);
            building.markCarStop(e, idx, true);
            log.log(e.name + ": destino adicionado ? " + floors.get(idx));
        }

        // ======= DESTINATION DISPATCH (corrigido) =======
        void handleDestinationRequest(String originLabel, String destLabel) {
            if (!running) return;
            int originIdx = floors.indexOf(originLabel);
            int destIdx = floors.indexOf(destLabel);
            if (originIdx < 0 || destIdx < 0 || originIdx == destIdx) return;

            Elevator best = chooseBestElevatorForPickup(originIdx);
            // cria Trip: primeiro pega na origem, destino só entra depois do pickup
            Trip trip = new Trip(originIdx, destIdx);
            tripsByElevator.get(best).add(trip);

            addStopToElevator(best, originIdx);
            building.markCarStop(best, originIdx, true);
            building.flashAssign(best, originIdx);
            log.log(String.format("Totem: origem %s ? destino %s • Pegue o elevador %s",
                    originLabel, destLabel, best.name));
            kiosk.showAssignment(best.name, originLabel, destLabel);
        }

        // ======= DISPATCH (clássico) =======
        void assignHallCallToBestElevator(int floorIdx, Direction dir) {
            Elevator best = null;
            int bestScore = Integer.MAX_VALUE;
            for (Elevator e : elevators) {
                int score = costForHallCall(e, floorIdx, dir);
                if (score < bestScore) {
                    best = e;
                    bestScore = score;
                }
            }
            if (best != null) {
                addStopToElevator(best, floorIdx);
                building.markCarStop(best, floorIdx, true);
                log.log(String.format("Hall: %s %s ? atribuído a %s",
                        floors.get(floorIdx), (dir == Direction.UP ? "?" : "?"), best.name));
            }
        }

        int costForHallCall(Elevator e, int target, Direction dir) {
            int dist = Math.abs(e.currentFloor - target);
            int penalty = 0;
            if (e.direction == Direction.IDLE) penalty += 1;
            else if ((e.direction == Direction.UP && target < e.currentFloor) ||
                    (e.direction == Direction.DOWN && target > e.currentFloor)) {
                penalty += 6;
            }
            int queue = e.totalTargets();
            return dist * 2 + penalty + queue;
        }

        Elevator chooseBestElevatorForPickup(int originIdx) {
            Elevator best = null;
            int bestScore = Integer.MAX_VALUE;
            for (Elevator e : elevators) {
                int score = Math.abs(e.currentFloor - originIdx) + e.totalTargets() * 2;
                if (e.direction == Direction.IDLE) score -= 1;
                if (score < bestScore) {
                    best = e;
                    bestScore = score;
                }
            }
            return best != null ? best : elevators.get(0);
        }

        void addStopToElevator(Elevator e, int floorIdx) {
            if (floorIdx == e.currentFloor) return;
            if (floorIdx > e.currentFloor) e.targetsUp.add(floorIdx);
            else e.targetsDown.add(floorIdx);
        }

        // ======= TICK =======
        void step() {
            if (!running) return;
            boolean anyUpdate = false;
            for (Elevator e : elevators) {
                anyUpdate |= e.step(this);
            }
            if (anyUpdate) SwingUtilities.invokeLater(building::repaintGrid);
        }

        // ======= CALLBACKS FROM ELEVATOR =======
        void onArrive(Elevator e, int floorIdx) {
            // Hall lights off no clássico
            if (hallUp[floorIdx] || hallDown[floorIdx]) {
                hallUp[floorIdx] = false;
                hallDown[floorIdx] = false;
                building.setHallLight(floorIdx, Direction.UP, false);
                building.setHallLight(floorIdx, Direction.DOWN, false);
            }
            building.markCarStop(e, floorIdx, false);
            log.log(e.name + " abriu as portas em " + floors.get(floorIdx));

            // Se for Modo Destino: ao pegar na origem, agenda o destino
            if (cfg.mode == Mode.DESTINATION) {
                List<Trip> list = tripsByElevator.getOrDefault(e, List.of());
                for (Trip t : list) {
                    if (!t.pickedUp && t.origin == floorIdx) {
                        t.pickedUp = true;
                        addStopToElevator(e, t.dest);
                        building.markCarStop(e, t.dest, true);
                        log.log(e.name + " embarque concluído. Próximo destino: " + floors.get(t.dest));
                    }
                }
                // remove trips concluídas (chegou no destino)
                list.removeIf(t -> t.pickedUp && t.dest == floorIdx);
            }
        }
    }

    // ======= ELEVATOR =======
    static class Elevator {
        final int id;
        final String name;
        int currentFloor;
        Direction direction = Direction.IDLE;

        final TreeSet<Integer> targetsUp = new TreeSet<>();
        final TreeSet<Integer> targetsDown = new TreeSet<>(Comparator.reverseOrder());

        boolean doorOpen = false;
        long doorUntilMs = 0;
        long moveCooldownMs = 0;

        Elevator(int id, String name, int startFloor) {
            this.id = id;
            this.name = name;
            this.currentFloor = startFloor;
        }

        int totalTargets() {
            return targetsUp.size() + targetsDown.size();
        }

        boolean step(Controller ctx) {
            long now = System.currentTimeMillis();
            boolean updated = false;

            if (doorOpen) {
                if (now >= doorUntilMs) doorOpen = false;
                return false;
            }
            if (moveCooldownMs > now) return false;

            if (consumeStopAtCurrent()) {
                doorOpen = true;
                doorUntilMs = now + ctx.cfg.doorMs;
                ctx.onArrive(this, currentFloor);
                updated = true;
                if (direction == Direction.IDLE) direction = chooseDirectionAfterIdle();
                return updated;
            }

            if (direction == Direction.IDLE) direction = chooseDirectionAfterIdle();
            if (direction == Direction.IDLE && totalTargets() == 0) return false;

            if (direction == Direction.UP) {
                Integer nextUp = targetsUp.ceiling(currentFloor + 1);
                if (nextUp == null) {
                    if (!targetsDown.isEmpty()) direction = Direction.DOWN;
                    else direction = Direction.IDLE;
                }
            } else if (direction == Direction.DOWN) {
                Integer nextDown = targetsDown.floor(currentFloor - 1);
                if (nextDown == null) {
                    if (!targetsUp.isEmpty()) direction = Direction.UP;
                    else direction = Direction.IDLE;
                }
            }

            if (direction == Direction.UP) {
                currentFloor++;
                moveCooldownMs = now + ctx.cfg.msPerFloor;
                updated = true;
            } else if (direction == Direction.DOWN) {
                currentFloor--;
                moveCooldownMs = now + ctx.cfg.msPerFloor;
                updated = true;
            }
            return updated;
        }

        boolean consumeStopAtCurrent() {
            boolean had = false;
            if (targetsUp.remove(currentFloor)) had = true;
            if (targetsDown.remove(currentFloor)) had = true;
            return had;
        }

        Direction chooseDirectionAfterIdle() {
            if (!targetsUp.isEmpty() && !targetsDown.isEmpty()) {
                int nearestUp = Math.abs(targetsUp.first() - currentFloor);
                int nearestDown = Math.abs(targetsDown.first() - currentFloor);
                return nearestUp <= nearestDown ? Direction.UP : Direction.DOWN;
            } else if (!targetsUp.isEmpty()) return Direction.UP;
            else if (!targetsDown.isEmpty()) return Direction.DOWN;
            return Direction.IDLE;
        }
    }

    static class Trip {
        final int origin;
        final int dest;
        boolean pickedUp = false;

        Trip(int origin, int dest) {
            this.origin = origin;
            this.dest = dest;
        }
    }

    // ======= UI: CONFIG =======
    static class ConfigPanel extends JPanel {
        final JSpinner spElev, spAbove, spBelow, spMs, spDoor;
        final JComboBox<String> cbMode;
        final JButton btStart, btReset;
        Config current;

        interface StartHandler {
            void start(Config cfg);
        }

        interface ResetHandler {
            void reset();
        }

        ConfigPanel(StartHandler onStart, ResetHandler onReset) {
            setLayout(new BorderLayout());
            setBackground(KD_BG);
            setBorder(new EmptyBorder(10, 10, 10, 10));

            JPanel card = new JPanel(new GridBagLayout());
            card.setBackground(KD_CARD);
            card.setBorder(new CompoundBorder(new LineBorder(KD_ACCENT, 1, true), new EmptyBorder(10, 10, 10, 10)));
            GridBagConstraints c = new GridBagConstraints();
            c.insets = new Insets(4, 6, 4, 6);
            c.fill = GridBagConstraints.HORIZONTAL;
            c.gridy = 0;

            JLabel title = label("Simulador de Elevador", KD_TITLE, KD_TEXT);
            c.gridwidth = 6;
            c.gridx = 0;
            card.add(title, c);
            c.gridwidth = 1;

            c.gridy++;
            card.add(label("Elevadores", KD_UI, KD_SUB), c);
            c.gridx = 1;
            spElev = spinner(4, 1, 8, 1);
            card.add(spElev, c);
            c.gridx = 2;
            card.add(label("Acima do 1º", KD_UI, KD_SUB), c);
            c.gridx = 3;
            spAbove = spinner(8, 1, 50, 1);
            card.add(spAbove, c);
            c.gridx = 4;
            card.add(label("Abaixo do 1º", KD_UI, KD_SUB), c);
            c.gridx = 5;
            spBelow = spinner(3, 0, 10, 1);
            card.add(spBelow, c);

            c.gridx = 0;
            c.gridy++;
            card.add(label("Velocidade (ms/andar)", KD_UI, KD_SUB), c);
            c.gridx = 1;
            spMs = spinner(400, 100, 3000, 50);
            card.add(spMs, c);
            c.gridx = 2;
            card.add(label("Porta (ms)", KD_UI, KD_SUB), c);
            c.gridx = 3;
            spDoor = spinner(700, 200, 4000, 50);
            card.add(spDoor, c);
            c.gridx = 4;
            card.add(label("Modo", KD_UI, KD_SUB), c);
            c.gridx = 5;
            cbMode = new JComboBox<>(new String[]{"Clássico", "Destino Inteligente"});
            style(cbMode);
            card.add(cbMode, c);

            c.gridx = 0;
            c.gridy++;
            btStart = button("Iniciar", e -> onStart.start(readConfig()));
            btReset = button("Resetar", e -> onReset.reset());
            JPanel actions = new JPanel(new FlowLayout(FlowLayout.LEFT, 8, 0));
            actions.setBackground(KD_CARD);
            actions.add(btStart);
            actions.add(btReset);
            c.gridwidth = 6;
            card.add(actions, c);

            add(card, BorderLayout.CENTER);
        }

        void applyDefaults() {
            spElev.setValue(4);
            spAbove.setValue(8);
            spBelow.setValue(3);
            spMs.setValue(400);
            spDoor.setValue(700);
            cbMode.setSelectedIndex(0);
        }

        Config readConfig() {
            Config cfg = new Config();
            cfg.elevators = (int) spElev.getValue();
            cfg.floorsAbove = (int) spAbove.getValue();
            cfg.floorsBelow = (int) spBelow.getValue();
            cfg.msPerFloor = (int) spMs.getValue();
            cfg.doorMs = (int) spDoor.getValue();
            cfg.mode = cbMode.getSelectedIndex() == 0 ? Mode.CLASSIC : Mode.DESTINATION;
            current = cfg;
            return cfg;
        }

        static JLabel label(String s, Font f, Color c) {
            JLabel l = new JLabel(s);
            l.setFont(f);
            l.setForeground(c);
            return l;
        }

        static void style(JComponent c) {
            c.setFont(KD_UI);
            c.setForeground(KD_TEXT);
            c.setBackground(KD_CARD);
        }

        static JSpinner spinner(int value, int min, int max, int step) {
            JSpinner sp = new JSpinner(new SpinnerNumberModel(value, min, max, step));
            style(sp);
            return sp;
        }

        static JButton button(String text, ActionListener al) {
            JButton b = new JButton(text);
            style(b);
            b.setBorder(new CompoundBorder(new LineBorder(KD_ACCENT, 1, true), new EmptyBorder(6, 12, 6, 12)));
            b.setFocusPainted(false);
            b.addActionListener(al);
            return b;
        }
    }

    // ======= UI: BUILDING (Torres) =======
    static class BuildingPanel extends JPanel {
        List<String> floors = List.of();
        List<Elevator> elevators = List.of();
        HallListener hallListener;
        CabinListener cabinListener;

        JPanel header;   // cabeçalho por elevador
        JPanel halls;    // botões de hall por andar
        JPanel shafts;   // grade dos poços

        Map<Integer, FloorRow> floorRows = new HashMap<>();
        Map<Integer, Map<Integer, Cell>> cells = new HashMap<>();

        interface HallListener {
            void onCall(int floorIdx, Direction dir);
        }

        interface CabinListener {
            void onCabinClick(Elevator e);
        }

        BuildingPanel() {
            setLayout(new BorderLayout());
            setBackground(KD_BG);
            setBorder(new EmptyBorder(10, 10, 10, 10));
        }

        void attachController(Controller ctrl) {
            this.hallListener = ctrl::onHallButton;
            this.cabinListener = ctrl::onCabinClick;
        }

        void setupGrid(List<String> floorLabels, List<Elevator> elevators, HallListener hall, CabinListener cabin) {
            this.floors = floorLabels;
            this.elevators = elevators;
            this.hallListener = hall;
            this.cabinListener = cabin;

            removeAll();
            floorRows.clear();
            cells.clear();

            // Cabeçalho (nomes dos elevadores)
            header = new JPanel(new BorderLayout());
            header.setBackground(KD_BG);

            JPanel headerRow = new JPanel(new GridLayout(1, elevators.size(), 6, 0));
            headerRow.setBackground(KD_BG);
            headerRow.setBorder(new EmptyBorder(0, 120, 6, 0)); // desloca por causa dos halls
            for (Elevator e : elevators) {
                JLabel lbl = new JLabel(" " + e.name + " ");
                lbl.setHorizontalAlignment(SwingConstants.CENTER);
                lbl.setOpaque(true);
                lbl.setBackground(KD_WALL);
                lbl.setForeground(KD_TEXT);
                lbl.setBorder(new CompoundBorder(new LineBorder(KD_ACCENT, 1, true), new EmptyBorder(6, 6, 6, 6)));
                lbl.setFont(KD_UI);
                headerRow.add(lbl);
            }
            header.add(headerRow, BorderLayout.CENTER);
            add(header, BorderLayout.NORTH);

            // Conteúdo (halls + poços)
            JPanel container = new JPanel(new BorderLayout());
            container.setBackground(KD_BG);

            halls = new JPanel(new GridLayout(floors.size(), 1, 6, 6));
            halls.setBackground(KD_BG);
            halls.setBorder(new EmptyBorder(0, 0, 0, 8));

            shafts = new JPanel(new GridLayout(floors.size(), elevators.size(), 6, 6));
            shafts.setBackground(KD_BG);

            // monta do topo pro térreo
            for (int fi = floors.size() - 1; fi >= 0; fi--) {
                FloorRow row = new FloorRow(fi, floors.get(fi), (idx, dir) -> hallListener.onCall(idx, dir));
                halls.add(row);
                floorRows.put(fi, row);

                Map<Integer, Cell> rowMap = new HashMap<>();
                for (Elevator e : elevators) {
                    Cell cell = new Cell(e, fi, () -> cabinListener.onCabinClick(e));
                    shafts.add(cell);
                    rowMap.put(e.id, cell);
                }
                cells.put(fi, rowMap);
            }

            container.add(halls, BorderLayout.WEST);
            container.add(shafts, BorderLayout.CENTER);
            add(container, BorderLayout.CENTER);
            revalidate();
            repaint();

            // pinta posição inicial
            for (Elevator e : elevators) {
                getCell(e.currentFloor, e.id).setCar(true);
            }
        }

        void setHallLight(int floorIdx, Direction dir, boolean on) {
            FloorRow row = floorRows.get(floorIdx);
            if (row != null) row.setLight(dir, on);
        }

        void markCarStop(Elevator e, int floorIdx, boolean on) {
            getCell(floorIdx, e.id).setStop(on);
        }

        void repaintGrid() {
            for (Map<Integer, Cell> row : cells.values()) for (Cell c : row.values()) c.updateVisual();
        }

        void flashAssign(Elevator e, int originIdx) {
            getCell(originIdx, e.id).flash();
        }

        void clear() {
            removeAll();
            revalidate();
            repaint();
        }

        Cell getCell(int floor, int elevId) {
            return cells.getOrDefault(floor, Map.of()).get(elevId);
        }

        // ===== subcomponents =====
        static class FloorRow extends JPanel {
            final int index;
            final JLabel label;
            final JButton up;
            final JButton down;
            final HallPressListener listener;

            interface HallPressListener {
                void press(int floorIdx, Direction dir);
            }

            FloorRow(int index, String floorLabel, HallPressListener l) {
                this.index = index;
                this.listener = l;
                setLayout(new FlowLayout(FlowLayout.LEFT, 6, 2));
                setBackground(KD_BG);

                JPanel card = new JPanel(new FlowLayout(FlowLayout.LEFT, 6, 2));
                card.setBackground(KD_CARD);
                card.setBorder(new CompoundBorder(new LineBorder(KD_ACCENT, 1, true), new EmptyBorder(6, 10, 6, 10)));

                label = new JLabel(floorLabel);
                label.setForeground(KD_TEXT);
                label.setFont(KD_UI);

                up = makeButton("?");
                down = makeButton("?");

                card.add(label);
                card.add(up);
                card.add(down);
                add(card);
            }

            JButton makeButton(String t) {
                JButton b = new JButton(t);
                b.setFocusPainted(false);
                b.setFont(KD_UI);
                b.setForeground(KD_TEXT);
                b.setBackground(KD_CARD);
                b.setBorder(new CompoundBorder(new LineBorder(KD_ACCENT, 1, true), new EmptyBorder(4, 10, 4, 10)));
                b.addActionListener(e -> {
                    Direction d = (t.equals("?") ? Direction.UP : Direction.DOWN);
                    listener.press(index, d);
                    // feedback LEDzinho:
                    setLight(d, true);
                    Timer tm = new Timer(250, ev -> setLight(d, false));
                    tm.setRepeats(false);
                    tm.start();
                });
                return b;
            }

            void setLight(Direction d, boolean on) {
                if (d == Direction.UP) {
                    up.setForeground(on ? KD_LED : KD_TEXT);
                    up.setBorder(new CompoundBorder(new LineBorder(on ? KD_LED : KD_ACCENT, 1, true), new EmptyBorder(4, 10, 4, 10)));
                } else {
                    down.setForeground(on ? KD_LED : KD_TEXT);
                    down.setBorder(new CompoundBorder(new LineBorder(on ? KD_LED : KD_ACCENT, 1, true), new EmptyBorder(4, 10, 4, 10)));
                }
            }
        }

        static class Cell extends JPanel {
            final Elevator elev;
            final int floorIdx;
            boolean isCar = false;
            boolean hasStop = false;
            long flashUntil = 0L;

            Cell(Elevator elev, int floorIdx, Runnable onCabinClick) {
                this.elev = elev;
                this.floorIdx = floorIdx;
                setBackground(KD_SHAFT);
                setBorder(new CompoundBorder(new LineBorder(new Color(55, 55, 70), 1, true),
                        new EmptyBorder(6, 6, 6, 6)));
                setPreferredSize(new Dimension(90, 36));
                enableEvents(AWTEvent.MOUSE_EVENT_MASK);

                addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        boolean here = elev.currentFloor == floorIdx;
                        if (here) onCabinClick.run();
                    }
                });
            }

            void setCar(boolean car) {
                isCar = car;
                repaint();
            }

            void setStop(boolean on) {
                hasStop = on;
                repaint();
            }

            void flash() {
                flashUntil = System.currentTimeMillis() + 650;
                repaint();
            }

            void updateVisual() {
                repaint();
            }

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                // Paredes do poço
                int w = getWidth(), h = getHeight();
                g2.setColor(KD_SHAFT);
                g2.fillRoundRect(0, 0, w, h, 8, 8);

                // “trilho” leve
                g2.setColor(new Color(70, 70, 90, 120));
                g2.fillRect(w / 2 - 2, 4, 4, h - 8);

                // LED de chamada (marker de stop)
                if (hasStop) {
                    g2.setColor(KD_LED);
                    g2.fillOval(6, h / 2 - 5, 10, 10);
                }

                boolean here = elev.currentFloor == floorIdx;
                if (here) {
                    // Cabine
                    Color cab = (flashUntil > System.currentTimeMillis()) ? KD_ACCENT : KD_ACCENT.darker();
                    g2.setColor(cab);
                    int cx = 18, cy = 6, cw = w - 36, ch = h - 12;
                    g2.fillRoundRect(cx, cy, cw, ch, 10, 10);

                    // Porta (indicador)
                    g2.setColor(new Color(255, 255, 255, 40));
                    int doorGap = elev.doorOpen ? 10 : 2;
                    g2.fillRoundRect(cx + cw / 2 - doorGap, cy + 2, doorGap, ch - 4, 6, 6);
                    g2.fillRoundRect(cx + cw / 2 + 2, cy + 2, doorGap, ch - 4, 6, 6);

                    // Nome do elevador
                    g2.setFont(new Font("Segoe UI", Font.BOLD, 12));
                    g2.setColor(KD_TEXT);
                    String name = elev.name;
                    FontMetrics fm = g2.getFontMetrics();
                    g2.drawString(name, cx + 8, cy + ch / 2 + fm.getAscent() / 2 - 3);

                    // Seta de direção (vetorial)
                    Direction d = elev.direction;
                    if (d != Direction.IDLE) {
                        g2.setColor(KD_LED);
                        int ax = cx + cw - 18;
                        int ay = cy + ch / 2;
                        Polygon tri = new Polygon();
                        if (d == Direction.UP) {
                            tri.addPoint(ax, ay - 8);
                            tri.addPoint(ax - 6, ay + 6);
                            tri.addPoint(ax + 6, ay + 6);
                        } else {
                            tri.addPoint(ax, ay + 8);
                            tri.addPoint(ax - 6, ay - 6);
                            tri.addPoint(ax + 6, ay - 6);
                        }
                        g2.fillPolygon(tri);
                    }
                } else {
                    // sinal de stop já desenhado; sem cabine
                }

                g2.dispose();
            }
        }
    }

    // ======= UI: KIOSK (Destino Inteligente) =======
    static class KioskPanel extends JPanel {
        final JComboBox<String> cbOrigin = new JComboBox<>();
        final JComboBox<String> cbDest = new JComboBox<>();
        final JButton btCall = new JButton("Chamar");
        final JLabel lbInfo = new JLabel("—");

        interface KioskHandler {
            void onRequest(String origin, String dest);
        }

        KioskPanel(KioskHandler handler) {
            setLayout(new BorderLayout());
            setBackground(KD_BG);
            setBorder(new EmptyBorder(10, 10, 10, 10));

            JPanel card = new JPanel(new GridBagLayout());
            card.setBackground(KD_CARD);
            card.setBorder(new CompoundBorder(new LineBorder(KD_ACCENT, 1, true), new EmptyBorder(10, 10, 10, 10)));
            GridBagConstraints c = new GridBagConstraints();
            c.insets = new Insets(6, 6, 6, 6);
            c.fill = GridBagConstraints.HORIZONTAL;

            JLabel title = new JLabel("Totem — Destino Inteligente");
            title.setFont(KD_TITLE);
            title.setForeground(KD_TEXT);
            c.gridx = 0;
            c.gridy = 0;
            c.gridwidth = 4;
            card.add(title, c);
            c.gridwidth = 1;

            JLabel l1 = new JLabel("Origem");
            JLabel l2 = new JLabel("Destino");
            for (JLabel l : new JLabel[]{l1, l2}) {
                l.setFont(KD_UI);
                l.setForeground(KD_SUB);
            }

            style(cbOrigin);
            style(cbDest);
            style(btCall);
            style(lbInfo);
            btCall.setBorder(new CompoundBorder(new LineBorder(KD_ACCENT, 1, true), new EmptyBorder(6, 12, 6, 12)));
            btCall.setFocusPainted(false);

            c.gridy = 1;
            c.gridx = 0;
            card.add(l1, c);
            c.gridx = 1;
            card.add(cbOrigin, c);
            c.gridx = 2;
            card.add(l2, c);
            c.gridx = 3;
            card.add(cbDest, c);

            c.gridy = 2;
            c.gridx = 1;
            card.add(btCall, c);
            c.gridx = 2;
            c.gridwidth = 2;
            lbInfo.setForeground(KD_TEXT);
            card.add(lbInfo, c);

            btCall.addActionListener(e -> {
                String o = (String) cbOrigin.getSelectedItem();
                String d = (String) cbDest.getSelectedItem();
                if (o != null && d != null && !o.equals(d)) handler.onRequest(o, d);
            });

            add(card, BorderLayout.CENTER);
        }

        void populateFloorChoices(List<String> floors) {
            cbOrigin.removeAllItems();
            cbDest.removeAllItems();
            for (String f : floors) {
                cbOrigin.addItem(f);
                cbDest.addItem(f);
            }
        }

        void setEnabledMode(boolean enabled) {
            setVisible(true);
            cbOrigin.setEnabled(enabled);
            cbDest.setEnabled(enabled);
            btCall.setEnabled(enabled);
            lbInfo.setEnabled(enabled);
            lbInfo.setForeground(enabled ? KD_TEXT : KD_SUB);
            if (!enabled) lbInfo.setText("Modo Clássico ativo (use os botões de cada andar e os painéis internos).");
            revalidate();
            repaint();
        }

        void showAssignment(String elevName, String origin, String dest) {
            lbInfo.setText(String.format("Vá para o elevador %s — Origem %s ? Destino %s", elevName, origin, dest));
        }

        void reset() {
            lbInfo.setText("—");
        }

        static void style(JComponent c) {
            c.setFont(KD_UI);
            c.setForeground(KD_TEXT);
            c.setBackground(KD_CARD);
        }
    }

    // ======= UI: LOG =======
    static class LogPanel extends JPanel {
        final JTextArea area = new JTextArea();

        LogPanel() {
            setLayout(new BorderLayout());
            setBackground(KD_BG);
            setBorder(new EmptyBorder(10, 10, 10, 10));

            JPanel card = new JPanel(new BorderLayout());
            card.setBackground(KD_CARD);
            card.setBorder(new CompoundBorder(new LineBorder(KD_ACCENT, 1, true), new EmptyBorder(6, 6, 6, 6)));

            JLabel title = new JLabel("Eventos");
            title.setFont(KD_TITLE);
            title.setForeground(KD_TEXT);
            card.add(title, BorderLayout.NORTH);

            area.setEditable(false);
            area.setLineWrap(true);
            area.setWrapStyleWord(true);
            area.setFont(new Font("Consolas", Font.PLAIN, 12));
            area.setBackground(new Color(28, 28, 34));
            area.setForeground(KD_TEXT);

            JScrollPane sp = new JScrollPane(area);
            sp.setBorder(null);
            card.add(sp, BorderLayout.CENTER);
            add(card, BorderLayout.CENTER);
            log("Pronto. Inicie a simulação.");
        }

        void log(String s) {
            area.append("• " + s + "\n");
            area.setCaretPosition(area.getDocument().getLength());
        }

        void clear() {
            area.setText("");
        }
    }

    // ======= DIALOG: CABIN FLOOR SELECT =======
    static class FloorDialog {
        static String show(Component parent, List<String> floors, String current) {
            JPanel p = new JPanel(new BorderLayout(6, 6));
            p.setBackground(KD_CARD);
            p.setBorder(new EmptyBorder(10, 10, 10, 10));
            JLabel l = new JLabel("Escolha o destino (painel interno):");
            l.setForeground(KD_TEXT);
            l.setFont(KD_UI);
            p.add(l, BorderLayout.NORTH);

            JPanel grid = new JPanel(new GridLayout(0, 6, 6, 6));
            grid.setBackground(KD_CARD);

            final String[] result = {null};
            for (String f : floors) {
                JButton b = new JButton(f);
                b.setFocusPainted(false);
                b.setBorder(new CompoundBorder(new LineBorder(KD_ACCENT, 1, true), new EmptyBorder(6, 6, 6, 6)));
                b.setBackground(KD_BG);
                b.setForeground(KD_TEXT);
                b.setFont(KD_UI);
                b.setEnabled(!f.equals(current));
                b.addActionListener(e -> {
                    result[0] = f;
                    SwingUtilities.getWindowAncestor(p).dispose();
                });
                grid.add(b);
            }
            p.add(new JScrollPane(grid), BorderLayout.CENTER);

            JDialog d = new JDialog(SwingUtilities.getWindowAncestor(parent), "Painel do Elevador", Dialog.ModalityType.APPLICATION_MODAL);
            d.setContentPane(p);
            d.setSize(480, 360);
            d.setLocationRelativeTo(parent);
            d.setVisible(true);
            return result[0];
        }
    }
}
