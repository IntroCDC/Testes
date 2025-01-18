package br.com.introcdc.tests.elevator;
/*
 * Written by IntroCDC, Bruno Coêlho at 21/11/2024 - 01:48
 */

public enum ElevatorFloor {
    A21(21, "21"),
    A20(20, "20"),
    A19(19, "19"),
    A18(18, "18"),
    A17(17, "17"),
    A16(16, "16"),
    A15(15, "15"),
    A14(14, "14"),
    A13(13, "13"),
    A12(12, "12"),
    A11(11, "11"),
    A10(10, "10"),
    A9(9, "9"),
    A8(8, "8"),
    A7(7, "7"),
    A6(6, "6"),
    A5(5, "5"),
    A4(4, "4"),
    M(3, "M"),
    P(2, "P"),
    SS(1, "SS");

    private final int id;
    private final String display;

    ElevatorFloor(int id, String display) {
        this.id = id;
        this.display = display;
    }

    public int getId() {
        return id;
    }

    public String getDisplay() {
        return display;
    }

    public ElevatorFloor up() {
        return byId(getId() + 1);
    }

    public ElevatorFloor down() {
        return byId(getId() - 1);
    }

    public static ElevatorFloor byId(int id) {
        for (ElevatorFloor floor : values()) {
            if (id == floor.getId()) {
                return floor;
            }
        }
        return null;
    }

}
