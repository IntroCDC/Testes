package br.com.introcdc.tests.kindome;
/*
 * Written by IntroCDC, Bruno Coelho at 08/01/2025 - 20:52
 */

import br.com.introcdc.tests.database.StringComponents;

public class FastTest {

    public static void main(String[] args) {
        String id = "0/0";
        String[] idSplit = id.split("/");
        if (idSplit.length != 2 || !StringComponents.isInt(idSplit[0]) || !StringComponents.isInt(idSplit[1])) {
            System.out.println("N�O");
        } else {
            System.out.println("SIM");
        }
    }

    public static boolean merge(Plot plotOne, Plot plotTwo) {
        int xOne = plotOne.x(), zOne = plotOne.z(), xTwo = plotTwo.x(), zTwo = plotTwo.z();

        // Verifica se s�o o mesmo plot
        if (xOne == xTwo && zOne == zTwo) {
            return false;
        }

        // Verifica se est�o exatamente ao lado no eixo X ou Z, sem ser diagonal
        boolean isAdjacent =
                (xOne == xTwo && Math.abs(zOne - zTwo) == 1) || // Mesma coluna, adjacentes no eixo Z
                        (zOne == zTwo && Math.abs(xOne - xTwo) == 1);   // Mesma linha, adjacentes no eixo X

        if (!isAdjacent) {
            return false; // N�o s�o adjacentes
        }

        // L�gica de mesclagem aqui (se necess�rio)
        return true;
    }


    public static class Plot {
        private int x;
        private int z;

        public Plot(int x, int z) {
            this.x = x;
            this.z = z;
        }

        public int x() {
            return x;
        }

        public int z() {
            return z;
        }
    }

}
