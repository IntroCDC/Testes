package br.com.introcdc.tests.consorcio;
/*
 * Written by IntroCDC, Bruno Coêlho at 19/10/2021 - 20:52
 */

import java.util.ArrayList;
import java.util.List;

public class ConsorcioClient {

    public static ConsorcioClient BRUNO;

    private static final List<ConsorcioClient> clientList = new ArrayList<>();

    public static List<ConsorcioClient> getClientList() {
        return clientList;
    }

    private final String name;
    private final ConsorcioModel model;

    private int paidInstallments;
    private final int installments;
    private final int id;

    private boolean contemplated = false;
    private int installmentsToPay = 0;

    public ConsorcioClient(String name, ConsorcioModel model, int paidInstallments, int installments, int id) {
        this.name = name;
        this.model = model;
        this.paidInstallments = paidInstallments;
        this.installments = installments;
        this.id = id;
        clientList.add(this);
    }

    public String getName() {
        return name;
    }

    public ConsorcioModel getModel() {
        return model;
    }

    public int getId() {
        return id;
    }

    public int getPaidInstallments() {
        return paidInstallments;
    }

    public void setPaidInstallments(int paidInstallments) {
        this.paidInstallments = paidInstallments;
    }

    public int getInstallments() {
        return installments;
    }

    public boolean isContemplated() {
        return contemplated;
    }

    public void setContemplated(boolean contemplated) {
        this.contemplated = contemplated;
    }

    public int getInstallmentsToPay() {
        return installmentsToPay;
    }

    public void setInstallmentsToPay(int percentage) {
        this.installmentsToPay = percentage;
    }

    public static void registerRandomClients() {
        for (int i = 1; i <= ConsorcioMain.totalClients; i++) {
            if (i == 195) {
                continue;
            }

            newRandomClient(i, ConsorcioMain.startRandom, i >= (ConsorcioMain.totalClients - ConsorcioMain.startingContempleds));
        }
        BRUNO = new ConsorcioClient("Bruno Coelho Maia Alves Sabino", new ConsorcioModel("Kawasaki z1000 R Edition", 70000), 7, 36, 195);
    }

    public static void newRandomClient(int id, boolean random, boolean contemplated) {
        List<String> names = new ArrayList<>();
        names.add("Maria");
        names.add("José");
        names.add("Antônio");
        names.add("João");
        names.add("Francisco");
        names.add("Ana");
        names.add("Luiz");
        names.add("Paulo");
        names.add("Carlos");
        names.add("Manoel");
        names.add("Pedro");
        names.add("Francisca");
        names.add("Marcos");
        names.add("Raimundo");
        names.add("Sebastião");
        names.add("Antônia");
        names.add("Marcelo");
        names.add("Jorge");
        names.add("Márcia");
        names.add("Geraldo");
        names.add("Adriana");
        names.add("Sandra");
        names.add("Luis");
        names.add("Fernando");
        names.add("Fabio");
        names.add("Roberto");
        names.add("Márcio");
        names.add("Edson");
        names.add("André");
        names.add("Sérgio");
        names.add("Josefa");
        names.add("Patrícia");
        names.add("Daniel");
        names.add("Rodrigo");
        names.add("Rafael");
        names.add("Joaquim");
        names.add("Vera");
        names.add("Ricardo");
        names.add("Eduardo");
        names.add("Terezinha");
        names.add("Sônia");
        names.add("Alexandre");
        names.add("Rita");
        names.add("Luciana");
        names.add("Cláudio");
        names.add("Rosa");
        names.add("Benedito");
        names.add("Leandro");
        names.add("Raimunda");
        names.add("Mário");

        List<Integer> installments = new ArrayList<>();
        installments.add(10);
        installments.add(20);
        installments.add(30);
        installments.add(40);
        installments.add(50);
        installments.add(60);
        installments.add(70);
        installments.add(80);
        installments.add(90);
        installments.add(100);

        StringBuilder name = new StringBuilder(names.get(ConsorcioMain.RANDOM.nextInt(names.size())));
        for (int r = 1; r <= (ConsorcioMain.RANDOM.nextInt(4) + 1); r++) {
            name.append(" ").append(names.get(ConsorcioMain.RANDOM.nextInt(names.size())));
        }

        int total = installments.get(ConsorcioMain.RANDOM.nextInt(installments.size()));
        new ConsorcioClient(name.toString(), ConsorcioModel.randomModel(),
                random ? ConsorcioMain.RANDOM.nextInt(total / (ConsorcioMain.RANDOM.nextInt(5) + 1)) : 0, total, id)
                .setContemplated(contemplated);
    }

}
