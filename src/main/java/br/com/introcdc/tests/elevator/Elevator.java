package br.com.introcdc.tests.elevator;
/*
 * Written by IntroCDC, Bruno Coêlho at 21/11/2024 - 01:41
 */

import java.util.ArrayList;
import java.util.List;

public class Elevator {

    private final String name;
    private ElevatorFloor currentFloor = ElevatorFloor.SS;
    private boolean up = true;
    private boolean doorOpened = true;
    private int ticks = 0;
    private boolean moving = false;
    private List<ElevatorCall> calls = new ArrayList<>();

    public Elevator(String name) {
        this.name = name;
        for (; ; ) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            updater();
        }
    }

    public String getName() {
        return name;
    }

    public ElevatorFloor getCurrentFloor() {
        return currentFloor;
    }

    public boolean isUp() {
        return up;
    }

    public void setUp(boolean up) {
        this.up = up;
    }

    public boolean isDoorOpened() {
        return doorOpened;
    }

    public void setDoorOpened(boolean doorOpened) {
        this.doorOpened = doorOpened;
    }

    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public List<ElevatorCall> getCalls() {
        return calls;
    }

    public void updater() {
        if (getCalls().isEmpty()) {
            return;
        }
        if (isMoving()) {

        }
    }

}
