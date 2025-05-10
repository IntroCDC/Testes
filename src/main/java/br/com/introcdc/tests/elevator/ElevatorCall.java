package br.com.introcdc.tests.elevator;
/*
 * Written by IntroCDC, Bruno Coelho at 28/11/2024 - 02:24
 */

public class ElevatorCall {

    private final ElevatorFloor floor;
    private final boolean up;

    public ElevatorCall(ElevatorFloor floor, boolean up) {
        this.floor = floor;
        this.up = up;
    }

    public ElevatorFloor getFloor() {
        return floor;
    }

    public boolean isUp() {
        return up;
    }

}
