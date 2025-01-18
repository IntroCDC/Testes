package br.com.introcdc.tests.game;
/*
 * Written by IntroCDC, Bruno Coêlho at 10/04/2024 - 22:13
 */

public enum GameCupType {
    POINTS,
    ELIMINATION;

    public boolean isElimination() {
        return false;
    }

}
