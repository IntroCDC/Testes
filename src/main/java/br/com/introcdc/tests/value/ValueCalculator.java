package br.com.introcdc.tests.value;
/*
 * Written by IntroCDC, Bruno Coêlho at 02/09/2024 - 21:55
 */

import br.com.introcdc.tests.Main;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.FileReader;
import java.text.DecimalFormat;

public class ValueCalculator {

    public static void main(String[] args) throws Exception {
        if (Boolean.TRUE) {
            Main.main(args);
            return;
        }
        JsonParser parser = new JsonParser();
        JsonArray jsonArray = parser.parse(new FileReader("C:/Users/Bruno/Downloads/bv.json")).getAsJsonArray();
        double others = 0;
        int amountOthers = 0;
        for (JsonElement element : jsonArray) {
            JsonObject object = element.getAsJsonObject();
            String description = object.get("d").getAsString();
            double value = object.get("v").getAsDouble();
            boolean found = false;
            for (ValueType type : ValueType.values()) {
                for (String desc : type.getType()) {
                    if (description.toLowerCase().contains(desc.toLowerCase())) {
                        if (type == ValueType.PARCELADA) {
                            System.out.println(description + ": R$ " + formatDouble(value));
                        }
                        type.setValue(type.getValue() + value);
                        type.setAmount(type.getAmount() + 1);
                        found = true;
                        break;
                    }
                    if (found) {
                        break;
                    }
                }
            }
            if (found) {
                continue;
            }
            others += value;
            amountOthers++;
        }

        double total = 0;
        int totalAmount = 0;
        for (ValueType type : ValueType.values()) {
            System.out.println(type.getTitle() + ": R$ " + formatDouble(type.getValue()) + " (" + type.getAmount() + "x)");
            total += type.getValue();
            totalAmount++;
        }
        System.out.println("Outros: R$ " + formatDouble(others) + " (" + amountOthers + "x)");
        total += others;
        totalAmount += amountOthers;
        System.out.println("TOTAL: R$ " + formatDouble(total) + " (" + totalAmount + "x)");
    }

    public static String formatDouble(double value) {
        DecimalFormat df = new DecimalFormat("#.00");
        return df.format(value);
    }

}
