package br.com.introcdc.tests.kindome;
/*
 * Written by IntroCDC, Bruno Coelho at 20/04/2020 - 04:29
 */

import java.util.ArrayList;
import java.util.List;

public class TeamSelector {

    public static List<Team> teams = new ArrayList<>();

    public static void main(String[] args) {
        teams.add(new Team("Azul", 1, 8));
        teams.add(new Team("Vermelho", 1, 8));
        teams.add(new Team("Verde", 1, 8));
        teams.add(new Team("Amarelo", 1, 8));
        System.out.println("Aleatório: " + randomTeam());
    }

    public static String randomTeam() {
        Team lessPlayersTeam = null;
        int lessPlayersAmount = 10000;

        for (Team team : teams) {
            if (team.players < team.maxPlayers) {
                if (team.players < lessPlayersAmount) {
                    lessPlayersAmount = team.players;
                    lessPlayersTeam = team;
                }
            }
        }

        return lessPlayersTeam.getName();
    }

    public static class Team {

        String name;
        int players;
        int maxPlayers;

        public Team(String name, int players, int maxPlayers) {
            this.name = name;
            this.players = players;
            this.maxPlayers = maxPlayers;
        }

        public String getName() {
            return name;
        }

        public int getPlayers() {
            return players;
        }

        public int getMaxPlayers() {
            return maxPlayers;
        }
    }

}
