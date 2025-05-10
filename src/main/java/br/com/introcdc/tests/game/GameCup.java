package br.com.introcdc.tests.game;
/*
 * Written by IntroCDC, Bruno Coelho at 10/04/2024 - 22:12
 */

import java.util.*;
import java.util.function.Function;

public class GameCup {

    public static boolean END_CODE = false;

    private static final List<GameCup> cupList = new ArrayList<>();

    public static List<GameCup> getCupList() {
        return cupList;
    }

    public static GameCup get(String key) {
        for (GameCup gameCup : getCupList()) {
            if (gameCup.getKey().equalsIgnoreCase(key)) {
                return gameCup;
            }
        }
        return null;
    }

    private final String name;
    private final String key;
    private final long prize;
    private final GameCupType cupType;
    private final Map<GameTeam, Integer> points = new HashMap<>();
    private final Map<GameTeam, Integer> matchs = new HashMap<>();
    private final Map<GameTeam, Integer> goals = new HashMap<>();
    private final Map<GameTeam, Integer> goalst = new HashMap<>();
    private final Map<GameTeam, Integer> victories = new HashMap<>();
    private final Map<GameTeam, Integer> loses = new HashMap<>();
    private final Map<GameTeam, Integer> draw = new HashMap<>();
    private final Map<GameTeam, Integer> sg = new HashMap<>();
    private final Map<GameTeam, String> reason = new HashMap<>();
    private final List<GameTeam> teams = new ArrayList<>();
    private final List<GameMatch> matchList = new ArrayList<>();
    private boolean firstStep = true;
    private final Function<GameTeam, Boolean> joinTest;
    private final int maxTeams;
    private int matches = 0;
    private boolean executed = false;
    private GameCupRegionType regionType;
    private GameTeam winner = null;

    public GameCup(String name, String key, int prize, GameCupType cupType, Function<GameTeam, Boolean> joinTest, int maxTeams, GameCupRegionType regionType, boolean addAll) {
        this.name = name;
        this.key = key;
        this.prize = prize;
        this.cupType = cupType;
        this.joinTest = joinTest;
        this.maxTeams = maxTeams;
        this.regionType = regionType;

        getCupList().add(this);
        if (addAll) {
            addAllTeams();
        }
    }

    public String getName() {
        return name;
    }

    public String getKey() {
        return key;
    }

    public long getPrize() {
        return prize;
    }

    public GameCupType getCupType() {
        return cupType;
    }

    public Map<GameTeam, Integer> getPoints() {
        return points;
    }

    public Map<GameTeam, Integer> getMatchs() {
        return matchs;
    }

    public Map<GameTeam, Integer> getGoals() {
        return goals;
    }

    public Map<GameTeam, Integer> getGoalst() {
        return goalst;
    }

    public Map<GameTeam, Integer> getVictories() {
        return victories;
    }

    public Map<GameTeam, Integer> getLoses() {
        return loses;
    }

    public Map<GameTeam, Integer> getDraw() {
        return draw;
    }

    public Map<GameTeam, Integer> getSg() {
        return sg;
    }

    public Map<GameTeam, String> getReason() {
        return reason;
    }

    public List<GameTeam> getTeams() {
        return teams;
    }

    public List<GameMatch> getMatchList() {
        return matchList;
    }

    public boolean isFirstStep() {
        return firstStep;
    }

    public void setFirstStep(boolean firstStep) {
        this.firstStep = firstStep;
    }

    public Function<GameTeam, Boolean> getJoinTest() {
        return joinTest;
    }

    public int getMaxTeams() {
        return maxTeams;
    }

    public int getMatches() {
        return matches;
    }

    public void setMatches(int matches) {
        this.matches = matches;
    }

    public boolean isExecuted() {
        return executed;
    }

    public GameCupRegionType getRegionType() {
        return regionType;
    }

    public void setExecuted(boolean executed) {
        this.executed = executed;
    }

    public boolean isStateCup() {
        return getRegionType() == GameCupRegionType.STATE;
    }

    public boolean isRegionCup() {
        return getRegionType() == GameCupRegionType.REGION;
    }

    public GameTeam getWinner() {
        return winner;
    }

    public void addAllTeams() {
        List<String> items = new ArrayList<>();
        int number = 1;
        for (GameTeam gameTeam : GameTeam.getTeamList()) {
            if (getJoinTest().apply(gameTeam)) {
                getTeams().add(gameTeam);
                getReason().put(gameTeam, number++ + "º no registro");
                if (isRegionCup()) {
                    if (!items.contains(gameTeam.getState())) {
                        items.add(gameTeam.getState());
                    }
                }
            }
        }
        Collections.shuffle(items);

        if (getMaxTeams() > 0 && getTeams().size() >= getMaxTeams() && isRegionCup()) {
            List<GameTeam> ignore = new ArrayList<>();
            while (getTeams().size() > getMaxTeams()) {
                for (String state : new ArrayList<>(items)) {
                    GameCup gameCup = get(state);

                    int less = 1_000_000_000;
                    GameTeam lessTeam = null;
                    for (GameTeam gameTeam : gameCup.getTeams()) {
                        if (ignore.contains(gameTeam)) {
                            continue;
                        }
                        if (gameCup.getPoints().get(gameTeam) < less) {
                            less = gameCup.getPoints().get(gameTeam);
                            lessTeam = gameTeam;
                        }
                    }

                    ignore.add(lessTeam);
                    getTeams().remove(lessTeam);
                }
            }
        }

        if (isRegionCup()) {
            for (String state : new ArrayList<>(items)) {
                GameCup gameCup = get(state);
                List<GameTeam> teamList = new ArrayList<>(gameCup.getTeams());
                int pos = 1;
                while (!teamList.isEmpty()) {
                    int more = -1;
                    GameTeam moreTeam = null;
                    for (GameTeam gameTeam : teamList) {
                        if (gameCup.getPoints().get(gameTeam) > more) {
                            more = gameCup.getPoints().get(gameTeam);
                            moreTeam = gameTeam;
                        }
                    }

                    teamList.remove(moreTeam);
                    getReason().put(moreTeam, pos++ + "º lugar em " + gameCup.getName());
                }
            }
        }
    }

    public boolean follow() {
        if (GameMain.FOLLOW_CUP.contains(getName())) {
            return true;
        }
        for (GameTeam gameTeam : getTeams()) {
            if (gameTeam.isFollow()) {
                return true;
            }
        }
        return false;
    }

    public void startCup() {
        boolean follow = follow();
        if (follow) {
            System.out.println();
            System.out.println("========================================");
            System.out.println("INICIANDO " + getName().toUpperCase() + " " + GameMain.YEAR);
            System.out.println("========================================");
            System.out.println();

            try {
                Thread.sleep(GameMain.TIME);
            } catch (InterruptedException ignored) {
            }
        }

        randomize();

        while (getMatches() < getMatchList().size()) {
            nextMatch();
        }

        setExecuted(true);
        boolean print = GameMain.PRINTS_ONLY.isEmpty() || GameMain.PRINTS_ONLY.contains(getKey().toUpperCase());
        if (!print) {
            for (GameTeam gameTeam : getTeams()) {
                if (gameTeam.isFollow()) {
                    print = true;
                    break;
                }
            }
        }

        if (print) {
            System.out.println();
            System.out.println("========================================");
            System.out.println("RESULTADOS - " + getName().toUpperCase() + " " + GameMain.YEAR + " - " + getMatchList().size() + " PARTIDAS");
            System.out.println("========================================");
        }
        showPoints(true, print);
        if (print) {
            System.out.println("========================================");
            System.out.println();

            try {
                Thread.sleep((long) GameMain.TIME * (follow ? 1 : 2));
            } catch (InterruptedException ignored) {
            }
        }
    }

    public void showPoints(boolean win, boolean print) {
        List<GameTeam> teamList = new ArrayList<>(getTeams());

        int number = 1;
        while (!teamList.isEmpty()) {
            int more = -1;
            GameTeam moreTeam = null;
            for (GameTeam gameTeam : new ArrayList<>(teamList)) {
                if (getPoints().get(gameTeam) > more) {
                    more = getPoints().get(gameTeam);
                    moreTeam = gameTeam;
                }
            }

            if (win) {
                moreTeam.setMoney(moreTeam.getMoney() + (getPrize() / number));

                if (number == 1) {
                    moreTeam.addTitle();
                    winner = moreTeam;
                }

                if (number == 1 && moreTeam.getName().equalsIgnoreCase("Fortaleza") && getName().toUpperCase().contains("MUNDIAL")) {
                    END_CODE = true;
                }

                if (number <= 4 && getName().contains("Brasileirão") && !getName().contains("Série A")) {
                    moreTeam.setDivision(moreTeam.getDivision() - 1);
                }
                if (number >= (getTeams().size() - 3) && getName().contains("Brasileirão") && !getName().contains("Série K")) {
                    moreTeam.setDivision(moreTeam.getDivision() + 1);
                }
            }

            if (print) {
                System.out.println(" " + number + "º: " + moreTeam.getName() + (win ? " - " + getReason().get(moreTeam) : "") + " (" + moreTeam.getState() + ";" + moreTeam.division() + ";" + moreTeam.getCountry() + ")" + " - P: " + (getPoints().get(moreTeam) / 1000) + " - V: " +
                        getVictories().get(moreTeam) + " - D: " + getLoses().get(moreTeam) + " - E: " + getDraw().get(moreTeam) + " - G: " + getGoals().get(moreTeam) +
                        " - GL: " + getGoalst().get(moreTeam) + " - SG: " + getSg().get(moreTeam) + " - J: " + getMatchs().get(moreTeam) + " /// J: " + moreTeam.getMatchs() + " - V: " +
                        moreTeam.getVictories() + " - D: " + moreTeam.getLoses() + " - E: " + moreTeam.getDraws() + " - G: " + moreTeam.getGoals() +
                        " - GL: " + moreTeam.getGoalst() + " - SG: " + moreTeam.getSg() + " - R$: " + formatNumber(moreTeam.getMoney()) + " - T: " + moreTeam.getTitles());
            }

            number++;
            teamList.remove(moreTeam);
        }
    }

    public static String formatNumber(long number) {
        String numberString = String.valueOf(number);
        StringBuilder result = new StringBuilder();

        int counter = 0;
        for (int i = numberString.length() - 1; i >= 0; i--) {
            result.insert(0, numberString.charAt(i));
            counter++;
            if (counter == 3 && i != 0) {
                result.insert(0, ".");
                counter = 0;
            }
        }

        return result.toString();
    }

    public void randomize() {
        if (getCupType().isElimination()) {
            if (isFirstStep()) {
                return;
            }

            return;
        }

        for (GameTeam gameTeam : getTeams()) {
            getPoints().put(gameTeam, 0);
            getMatchs().put(gameTeam, 0);
            getGoals().put(gameTeam, 0);
            getGoalst().put(gameTeam, 0);
            getVictories().put(gameTeam, 0);
            getLoses().put(gameTeam, 0);
            getDraw().put(gameTeam, 0);
            getSg().put(gameTeam, 0);
            for (GameTeam otherTeam : getTeams()) {
                if (gameTeam == otherTeam) {
                    continue;
                }
                getMatchList().add(new GameMatch(this, gameTeam, otherTeam));
            }
        }

        Collections.shuffle(getMatchList());
    }

    public boolean nextMatch() {
        if (getMatches() >= getMatchList().size() && getCupType().isElimination() && isFirstStep()) {
            setFirstStep(false);
            randomize();
            return nextMatch();
        }

        for (GameMatch match : getMatchList()) {
            if (match.isMatchExecuted()) {
                continue;
            }
            match.startMatch();
            return true;
        }
        return false;
    }

}
