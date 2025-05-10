package br.com.introcdc.tests.social;
/*
 * Written by IntroCDC, Bruno Coelho at 08/07/2024 - 19:54
 */

public class SocialDay {

    private final String day;
    private final String[] places;

    public SocialDay(String day, String... places) {
        this.day = day;
        this.places = places;
    }

    public String getDay() {
        return day;
    }

    public String[] getPlaces() {
        return places;
    }

    public void print(SocialRegister register) {
        SocialCalculator.DAYS_TOGETHER++;
        int distance = 0;
        for (int i = 0; i < (getPlaces().length - 1); i++) {
            distance += SocialDistance.distance(getPlaces()[i], getPlaces()[i + 1]);
        }
        register.addTotalDistance(distance);
        SocialCalculator.TOTAL_DISTANCE += distance;
        SocialCalculator.print("#" + SocialCalculator.DAYS_TOGETHER + " - " + getDay() + ": " + arrayWithSeparator(getPlaces()) + " (" + (distance / 1000) + " KM)");
    }

    public String arrayWithSeparator(String[] array) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            String key = array[i].startsWith("-") ? array[i].substring(1) : array[i];
            result.append(key);
            if (i < array.length - 1) {
                result.append(" -> ");
            }
        }
        return result.toString();
    }

}
