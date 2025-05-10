package br.com.introcdc.tests.consorcio;
/*
 * Written by IntroCDC, Bruno Coelho at 19/10/2021 - 20:52
 */

import java.util.ArrayList;
import java.util.List;

public class ConsorcioModel {

    private static final List<ConsorcioModel> modelList = new ArrayList<>();

    public static List<ConsorcioModel> getModelList() {
        return modelList;
    }

    private final String name;
    private final long value;

    public ConsorcioModel(String name, long value) {
        this.name = name;
        this.value = value;
        modelList.add(this);
    }

    public String getName() {
        return name;
    }

    public long getValue() {
        return value;
    }

    public long getValue(ConsorcioClient client, long installments, boolean plus) {
        return ((getValue() / client.getInstallments()) * installments) + (plus ? ((getValue() / 100) * ConsorcioMain.plus) : 0);
    }

    public static void registerModels() {
        new ConsorcioModel("Kawasaki ER-6N ABS", 25000);
        new ConsorcioModel("Kawasaki KZ-1000", 35000);
        new ConsorcioModel("Kawasaki Ninja 1000 ABS", 53000);
        new ConsorcioModel("Kawasaki Ninja 300", 16000);
        new ConsorcioModel("Kawasaki Ninja 650", 43000);
        new ConsorcioModel("Kawasaki Ninja H2", 150000);
        new ConsorcioModel("Kawasaki Ninja ZX-10R", 110000);
        new ConsorcioModel("Kawasaki Ninja ZX-14R", 40000);
        new ConsorcioModel("Kawasaki Versys 1000", 68000);
        new ConsorcioModel("Kawasaki Vulcan 900", 30000);
        new ConsorcioModel("Kawasaki z1000 R Edition", 70000);
        new ConsorcioModel("Kawasaki z400", 30000);
        new ConsorcioModel("Kawasaki z650", 40000);
        new ConsorcioModel("Kawasaki z800", 40000);
        new ConsorcioModel("Kawasaki z900", 55000);
        new ConsorcioModel("Honda Hornet 2011", 30000);
        new ConsorcioModel("Honda Hornet 2013", 40000);
        new ConsorcioModel("Suzuki Hayabusa", 50000);
        new ConsorcioModel("Honda XRE 300 Adventure", 25000);
        new ConsorcioModel("Honda Titan 160 EX", 13000);
    }

    public static ConsorcioModel randomModel() {
        return getModelList().get(ConsorcioMain.RANDOM.nextInt(getModelList().size()));
    }

}
