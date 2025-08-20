package br.com.introcdc.tests.game;
/*
 * Written by IntroCDC, Bruno Coelho at 17/08/2025 - 06:05
 */

import java.util.*;

public class GameSeasonEngine {

    private final Deque<GameMatch> queue = new ArrayDeque<>();

    // 0=Estaduais, 1=Regionais, 2=Brasileirão, 3=Copa do Brasil, 4=Sul-Americana, 5=Libertadores, 6=Mundial, 7=fim
    private int phase = 0;

    // Para respeitar a ordem, por padrão enfileiro TODOS os jogos (não só followed).
    private boolean onlyFollowed = false;

    public void setOnlyFollowed(boolean onlyFollowed) { this.onlyFollowed = onlyFollowed; }

    public void startSeason() {
        GameCup.getCupList().clear();
        queue.clear();
        phase = 0;
        buildNextPhase();
    }

    public boolean hasNext() {
        while (queue.isEmpty() && phase < 7) {
            buildNextPhase();
        }
        return !queue.isEmpty();
    }

    public GameMatch peekNext() { return hasNext() ? queue.peekFirst() : null; }

    public GameMatch pollNext() { return hasNext() ? queue.pollFirst() : null; }

    public int queueSize() { return queue.size(); }

    /* ========================= Anti-NPE / util ========================= */

    private void hydrateAllStats() {
        List<GameTeam> all = GameTeam.getTeamList();
        for (GameCup cup : GameCup.getCupList()) hydrateCupStats(cup, all);
    }

    private void hydrateCupStats(GameCup cup, List<GameTeam> universe) {
        if (cup == null) return;
        for (GameTeam t : universe) {
            cup.getPoints().putIfAbsent(t, 0);
            cup.getMatchs().putIfAbsent(t, 0);
            cup.getGoals().putIfAbsent(t, 0);
            cup.getGoalst().putIfAbsent(t, 0);
            cup.getVictories().putIfAbsent(t, 0);
            cup.getLoses().putIfAbsent(t, 0);
            cup.getDraw().putIfAbsent(t, 0);
            cup.getSg().putIfAbsent(t, 0);
        }
    }

    private List<GameTeam> sortByPointsDesc(GameCup cup) {
        List<GameTeam> list = new ArrayList<>(cup.getTeams());
        list.sort((a, b) -> Integer.compare(cup.getPoints().getOrDefault(b, 0),
                cup.getPoints().getOrDefault(a, 0)));
        return list;
    }

    /* ========================= Fases ========================= */

    private void buildNextPhase() {
        switch (phase) {
            case 0 -> { buildStatePhase(); phase++; }
            case 1 -> { buildRegionPhase(); phase++; }
            case 2 -> { buildBrasileiraoPhase(); phase++; }
            case 3 -> { buildCopaDoBrasilPhase(); phase++; }
            case 4 -> { buildSulamericanaPhase(); phase++; }
            case 5 -> { buildLibertadoresPhase(); phase++; }
            case 6 -> { buildMundialPhase(); phase++; }
            default -> phase = 7;
        }
    }

    private void enqueueCupMatches(GameCup cup) {
        if (cup == null) return;
        if (cup.getMatchList().isEmpty()) cup.randomize();
        for (GameMatch m : cup.getMatchList()) {
            if (!onlyFollowed || m.follow()) queue.addLast(m);
        }
    }

    private interface RegFn { void run(); }

    private List<GameCup> createdBy(RegFn fn) {
        int before = GameCup.getCupList().size();
        fn.run();
        return new ArrayList<>(GameCup.getCupList().subList(before, GameCup.getCupList().size()));
    }

    /* ---------- 0) Estaduais ---------- */

    private void buildStatePhase() {
        hydrateAllStats();
        int qBefore = queue.size();

        // Tenta via registrador oficial
        List<GameCup> created = createdBy(GameRegister::registerStateCups);
        // Filtra só estaduais (STATE)
        created.removeIf(c -> c.getRegionType() != GameCupRegionType.STATE);

        if (created.isEmpty()) {
            // Fallback: agrupa por estado e cria copas estaduais simples
            Map<String, List<GameTeam>> byState = new HashMap<>();
            for (GameTeam t : GameTeam.getTeamList()) {
                if (!"Brasil".equalsIgnoreCase(t.getCountry())) continue;
                byState.computeIfAbsent(t.getState(), k -> new ArrayList<>()).add(t);
            }
            for (Map.Entry<String, List<GameTeam>> e : byState.entrySet()) {
                String state = e.getKey();
                GameCup cup = new GameCup(state, state, 1_000_000, GameCupType.POINTS,
                        t -> "Brasil".equalsIgnoreCase(t.getCountry()) && state.equalsIgnoreCase(t.getState()),
                        0, GameCupRegionType.STATE, true);
                cup.randomize();
                created.add(cup);
            }
        }

        for (GameCup c : created) enqueueCupMatches(c);

        // Garante que não passa adiante sem estaduais na fila
        if (queue.size() == qBefore) {
            // se por algum motivo ainda não tem, constrói fallback duro e enfileira
            buildStateFallbackHard();
        }
    }

    private void buildStateFallbackHard() {
        Map<String, List<GameTeam>> byState = new HashMap<>();
        for (GameTeam t : GameTeam.getTeamList()) {
            if (!"Brasil".equalsIgnoreCase(t.getCountry())) continue;
            byState.computeIfAbsent(t.getState(), k -> new ArrayList<>()).add(t);
        }
        for (String state : byState.keySet()) {
            GameCup c = GameCup.get(state);
            if (c == null) {
                c = new GameCup(state, state, 1_000_000, GameCupType.POINTS,
                        t -> "Brasil".equalsIgnoreCase(t.getCountry()) && state.equalsIgnoreCase(t.getState()),
                        0, GameCupRegionType.STATE, true);
            }
            enqueueCupMatches(c);
        }
    }

    /* ---------- 1) Regionais ---------- */

    private void buildRegionPhase() {
        hydrateAllStats();
        List<GameCup> created = createdBy(GameRegister::registerRegionCups);
        created.removeIf(c -> c.getRegionType() != GameCupRegionType.REGION);

        if (created.isEmpty()) {
            // Fallback simples por macro-região BR
            String[] regs = {"Nordeste","Norte","Centro-Oeste","Sudeste","Sul"};
            for (String reg : regs) {
                GameCup cup = new GameCup(reg, reg, 2_000_000, GameCupType.POINTS,
                        t -> "Brasil".equalsIgnoreCase(t.getCountry()) && reg.equalsIgnoreCase(t.getRegion()),
                        0, GameCupRegionType.REGION, true);
                cup.randomize();
                created.add(cup);
            }
        }
        for (GameCup c : created) enqueueCupMatches(c);
    }

    /* ---------- 2) Brasileirão (todas as séries) ---------- */

    private void buildBrasileiraoPhase() {
        hydrateAllStats();
        List<GameCup> created = createdBy(GameRegister::registerBrasilCups);

        // Mantém só copas cujo nome contenha "Brasileirão"
        List<GameCup> series = new ArrayList<>();
        for (GameCup c : created) if (c.getName().toLowerCase().contains("brasileirão")) series.add(c);

        // Garante que a Copa do Brasil NÃO entre agora
        series.sort(Comparator.comparing(GameCup::getName)); // A, B, C... (opcional)
        for (GameCup c : series) enqueueCupMatches(c);
    }

    /* ---------- 3) Copa do Brasil ---------- */

    private void buildCopaDoBrasilPhase() {
        hydrateAllStats();
        GameCup cdb = GameCup.get("Brasil");
        if (cdb == null) {
            // fallback: cria uma copa de pontos com todos do Brasil (ou ajusta p/ eliminação se tu quiser)
            cdb = new GameCup("Copa do Brasil", "Brasil", 50_000_000, GameCupType.POINTS,
                    t -> "Brasil".equalsIgnoreCase(t.getCountry()), 0, GameCupRegionType.COUNTRY, true);
        }
        enqueueCupMatches(cdb);
    }

    /* ---------- 4) Sul-Americana ---------- */

    private void buildSulamericanaPhase() {
        hydrateAllStats();

        GameCup sula = new GameCup("Conmebol Sul-americana", "Sulamericana", 40_000_000,
                GameCupType.ELIMINATION, t -> false, 0, GameCupRegionType.CONTINENT, false);

        GameCup[] ligas = new GameCup[]{
                GameCup.get("1"),
                GameCup.get("Argentina"), GameCup.get("Bolívia"), GameCup.get("Chile"),
                GameCup.get("Colômbia"), GameCup.get("Equador"), GameCup.get("Paraguai"),
                GameCup.get("Peru"), GameCup.get("Uruguai"), GameCup.get("Venezuela")
        };

        for (GameCup liga : ligas) {
            if (liga == null) continue;
            List<GameTeam> ordered = sortByPointsDesc(liga);
            for (int i = 4; i < Math.min(8, ordered.size()); i++) {
                GameTeam t = ordered.get(i);
                if (!sula.getTeams().contains(t)) {
                    sula.getTeams().add(t);
                    sula.getReason().put(t, (i + 1) + "º lugar na " + liga.getName());
                }
            }
        }
        enqueueCupMatches(sula);
    }

    /* ---------- 5) Libertadores ---------- */

    private void buildLibertadoresPhase() {
        hydrateAllStats();

        GameCup lib = new GameCup("Conmebol Libertadores", "Libertadores", 140_000_000,
                GameCupType.ELIMINATION, t -> false, 0, GameCupRegionType.CONTINENT, false);

        GameCup[] ligas = new GameCup[]{
                GameCup.get("1"),
                GameCup.get("Argentina"), GameCup.get("Bolívia"), GameCup.get("Chile"),
                GameCup.get("Colômbia"), GameCup.get("Equador"), GameCup.get("Paraguai"),
                GameCup.get("Peru"), GameCup.get("Uruguai"), GameCup.get("Venezuela")
        };

        for (GameCup liga : ligas) {
            if (liga == null) continue;
            List<GameTeam> ordered = sortByPointsDesc(liga);
            for (int i = 0; i < Math.min(4, ordered.size()); i++) {
                GameTeam t = ordered.get(i);
                if (!lib.getTeams().contains(t)) {
                    lib.getTeams().add(t);
                    lib.getReason().put(t, (i + 1) + "º lugar na " + liga.getName());
                }
            }
        }
        enqueueCupMatches(lib);
    }

    /* ---------- 6) Mundial ---------- */

    private void buildMundialPhase() {
        hydrateAllStats();

        GameCup mundial = new GameCup("Mundial", "Mundial", 250_000_000,
                GameCupType.ELIMINATION, t -> false, 0, GameCupRegionType.MUNDIAL, false);

        List<GameCup> fontes = new ArrayList<>();
        GameCup lib = GameCup.get("Libertadores");
        GameCup america = GameCup.get("América");
        GameCup europa = GameCup.get("Europa");
        GameCup asia = GameCup.get("Ásia");
        GameCup africa = GameCup.get("África");
        if (lib != null) fontes.add(lib);
        if (america != null) fontes.add(america);
        if (europa != null) fontes.add(europa);
        if (asia != null) fontes.add(asia);
        if (africa != null) fontes.add(africa);
        if (fontes.isEmpty() && lib != null) fontes.add(lib); // fallback

        for (GameCup cup : fontes) {
            List<GameTeam> ord = sortByPointsDesc(cup);
            for (int i = 0; i < Math.min(2, ord.size()); i++) {
                GameTeam t = ord.get(i);
                if (!mundial.getTeams().contains(t)) {
                    mundial.getTeams().add(t);
                    mundial.getReason().put(t, (i == 0 ? "Campeão " : "Vice ") + cup.getName());
                }
            }
        }
        enqueueCupMatches(mundial);
    }
}
