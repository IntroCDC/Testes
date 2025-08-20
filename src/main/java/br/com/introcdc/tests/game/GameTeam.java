package br.com.introcdc.tests.game;
/*
 * Written by IntroCDC, Bruno Coelho at 10/04/2024 - 15:46
 */

import java.util.ArrayList;
import java.util.List;

public class GameTeam {

    private final static List<GameTeam> teamList = new ArrayList<>();

    public static List<GameTeam> getTeamList() {
        return teamList;
    }

    private final String name;
    private final String abbreviation;
    private final String shortName;
    private final String longName;
    private final String fandom;
    private final String stadium;
    private final int stadiumAmount;
    private final String state;
    private final String region;
    private final String country;
    private final String continent;

    private int division;
    private long money = 0;

    private int matchs = 0;
    private int victories = 0;
    private int loses = 0;
    private int draws = 0;
    private int goals = 0;
    private int goalst = 0;
    private int sg = 0;

    private int titles = 0;
    private final boolean follow;

    public GameTeam(String name, String abbreviation, String shortName, String longName, String fandom, String stadium, int stadiumAmount, String state, String region, String country, String continent, int division) {
        this(name, abbreviation, shortName, longName, fandom, stadium, stadiumAmount, state, region, country, continent, division, false);
    }

    public GameTeam(String name, String abbreviation, String shortName, String longName, String fandom, String stadium, int stadiumAmount, String state, String region, String country, String continent, int division, boolean follow) {
        this.name = name;
        this.abbreviation = abbreviation;
        this.shortName = shortName;
        this.longName = longName;
        this.fandom = fandom;
        this.stadium = stadium;
        this.stadiumAmount = stadiumAmount;
        this.state = state;
        this.region = region;
        this.country = country;
        this.continent = continent;
        this.division = division;
        this.follow = follow;

        System.out.println("[\"id\"=>\"");

        getTeamList().add(this);
    }

    public String getName() {
        return name;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public String getShortName() {
        return shortName;
    }

    public String getLongName() {
        return longName;
    }

    public String getFandom() {
        return fandom;
    }

    public String getStadium() {
        return stadium;
    }

    public int getStadiumAmount() {
        return stadiumAmount;
    }

    public String getState() {
        return state;
    }

    public String getRegion() {
        return region;
    }

    public String getCountry() {
        return country;
    }

    public String getContinent() {
        return continent;
    }

    public int getDivision() {
        return division;
    }

    public void setDivision(int division) {
        this.division = division;
    }

    public long getMoney() {
        return money;
    }

    public void setMoney(long money) {
        this.money = money;
    }

    public int getMatchs() {
        return matchs;
    }

    public void addMatch() {
        matchs++;
    }

    public int getVictories() {
        return victories;
    }

    public void addVictory() {
        victories++;
    }

    public int getLoses() {
        return loses;
    }

    public void addLose() {
        loses++;
    }

    public int getDraws() {
        return draws;
    }

    public int getGoals() {
        return goals;
    }

    public void addGoal() {
        goals++;
    }

    public int getGoalst() {
        return goalst;
    }

    public void addGoalt() {
        goalst++;
    }

    public void addDraw() {
        draws++;
    }

    public int getTitles() {
        return titles;
    }

    public void addTitle() {
        titles++;
    }

    public int getSg() {
        return sg;
    }

    public void addSg() {
        sg++;
    }

    public void removeSg() {
        sg--;
    }

    public boolean isFollow() {
        return follow;
    }

    public GameCup getStateCup() {
        return GameCup.get(getState());
    }

    public GameCup getRegionCup() {
        return GameCup.get(getRegion());
    }

    public GameCup getBrasilCup() {
        return GameCup.get(String.valueOf(getDivision()));
    }

    public String division() {
        return switch (getDivision()) {
            case 0 -> "X";
            case 1 -> "A/" + getDivision();
            case 2 -> "B/" + getDivision();
            case 3 -> "C/" + getDivision();
            case 4 -> "D/" + getDivision();
            case 5 -> "E/" + getDivision();
            case 6 -> "F/" + getDivision();
            case 7 -> "G/" + getDivision();
            case 8 -> "H/" + getDivision();
            case 9 -> "I/" + getDivision();
            case 10 -> "J/" + getDivision();
            case 11 -> "K/" + getDivision();
            default -> "X";
        };
    }

}
