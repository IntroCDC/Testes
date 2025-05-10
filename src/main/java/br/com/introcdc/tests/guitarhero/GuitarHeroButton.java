package br.com.introcdc.tests.guitarhero;
/*
 * Written by IntroCDC, Bruno Coelho at 14/05/2021 - 16:04
 */

import java.util.Arrays;
import java.util.List;

public enum GuitarHeroButton {
    GREEN(0x41, -12565695, 693, 926,
            -12368315, -2958896, -6423394, -723471, -8750221, -12565694),


    RED(0x53, -13487052, 827, 926,
            -13355209, -2568496, -222582, -460813, -13486795, -2502447, -592142, -8881294),


    YELLOW(0x4A, -13684433, 958, 926,
            -13618640, -2500657, -2632244, -13552847, -2566450, -132462, -9013137, -2829363, -330390, -263178, -13552590, -4209989),


    BLUE(0x4B, -13486281, 1091, 926,
            -13420745, -4538431, -1050372, -2237738, -13354952, -9648132, -263173, -11709871, -9263941, -3347459, -11315630, -11690041, -2691075, -856082),


    ORANGE(0x4C, -12697537, 1224, 926,
            -12236986, -4548239, -202569, -920592, -10723751, -11316141, -201792, -11381680, -3829684, -1051921);

    int keyPress;
    int ignoreColor;
    int x;
    int y;
    boolean pressing = false;
    List<Integer> toPress;

    GuitarHeroButton(int keyPress, int ignoreColor, int x, int y, Integer... toPress) {
        this.keyPress = keyPress;
        this.ignoreColor = ignoreColor;
        this.x = x;
        this.y = y;
        this.toPress = Arrays.asList(toPress);
    }

    public int getKeyPress() {
        return keyPress;
    }

    public int getIgnoreColor() {
        return ignoreColor;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public List<Integer> getToPress() {
        return toPress;
    }

    public boolean isPressing() {
        return pressing;
    }

    public void setPressing(boolean pressing) {
        this.pressing = pressing;
    }

    public void pressButton(boolean press) {
        if (press) {
            if (isPressing()) {
                return;
            }
            setPressing(true);
            press();
        } else {
            if (!isPressing()) {
                return;
            }
            setPressing(false);
            release();
        }
    }

    public void press() {
        GuitarHeroBot.robot.keyPress(getKeyPress());
    }

    public void release() {
        GuitarHeroBot.robot.keyRelease(getKeyPress());
    }

    public void checkPress(int rgb) {
        pressButton(getToPress().contains(rgb));
    }

}
