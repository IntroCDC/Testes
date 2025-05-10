package br.com.introcdc.tests.elevator;
/*
 * Written by IntroCDC, Bruno Coelho at 28/11/2024 - 02:23
 */

import java.util.ArrayList;
import java.util.List;

public class ElevatorMain {

    private static List<Elevator> elevatorList = new ArrayList<>();

    public static void main(String[] args) {
        elevatorList.add(new Elevator("Social"));
    }

}
