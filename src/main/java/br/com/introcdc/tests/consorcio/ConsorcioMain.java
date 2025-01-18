package br.com.introcdc.tests.consorcio;
/*
 * Written by IntroCDC, Bruno Coêlho at 19/10/2021 - 20:51
 */

import javax.swing.*;
import java.text.NumberFormat;
import java.util.*;

public class ConsorcioMain {

    public static Locale PT_BR = new Locale("pt", "br");
    public static NumberFormat FORMAT = NumberFormat.getNumberInstance(PT_BR);
    public static Random RANDOM = new Random();
    public static long perMonth = 15;
    public static long totalClients = 1500;
    public static long startingContempleds = 510;
    public static Scanner scanner;
    public static long totalMonths = 0;
    public static long bankAccount = 0;
    public static boolean startRandom = false;
    public static boolean updateAmount = false;
    public static boolean countWithEnds = false;

    public static long salary = 2000;
    public static long workers = 0;
    public static long plus = 1;
    public static boolean log = true;
    public static int positive = 0;
    public static int negative = 0;

    public static void main(String[] args) {
        message("Registrando modelos...");
        ConsorcioModel.registerModels();
        message("Registrando clientes...");
        ConsorcioClient.registerRandomClients();
        scanner = new Scanner(System.in);
        message("Iniciando sistema...");
        nextMonth();
    }

    public static void message(String message) {
        System.out.println(message);
    }

    public static void nextMonth() {
        totalMonths++;

        String message = "Iniciando próximo mês de número #" + totalMonths
                + ", aleatorizando lances e sorteando...\n\n";
        List<ConsorcioClient> contempled = new ArrayList<>();
        List<ConsorcioClient> possible = new ArrayList<>();

        long winned = 0;
        for (ConsorcioClient client : new ArrayList<>(ConsorcioClient.getClientList())) {
            ConsorcioModel model = client.getModel();
            winned += model.getValue(client, 1, true);

            client.setPaidInstallments(client.getPaidInstallments() + 1);
            if (client.getPaidInstallments() >= client.getInstallments()) {
                if (!client.isContemplated()) {
                    client.setContemplated(true);
                    contempled.add(client);
                }
                ConsorcioClient.getClientList().remove(client);

                if (RANDOM.nextBoolean()) {
                    ConsorcioClient.newRandomClient(client.getId(), false, false);
                }
            }

            if (client.isContemplated()) {
                continue;
            }

            if (client.getId() == 195) {
                int pendents = (client.getInstallments() - client.getPaidInstallments()) + 1;
                client.setInstallmentsToPay(Math.min(16, pendents));
            } else {
                if (RANDOM.nextInt(10) <= 0) {
                    client.setInstallmentsToPay(RANDOM.nextInt(client.getInstallments() - client.getPaidInstallments()));
                } else {
                    client.setInstallmentsToPay(0);
                }
            }
            possible.add(client);
        }

        if (possible.isEmpty()) {
            message += "FIM DO CONSÓRCIO!\n\n";
            message += "Conta Bancária do Consórcio no Final: " + money(bankAccount);
            JOptionPane.showMessageDialog(null, message);
            return;
        }
        contempled.add(possible.get(RANDOM.nextInt(possible.size())));

        long pendent = countWithEnds ? (perMonth - contempled.size()) : perMonth;
        for (int i = 1; i <= pendent; i++) {
            long bigger = 0;
            ConsorcioClient biggerClient = null;
            for (ConsorcioClient client : new ArrayList<>(possible)) {
                if (contempled.contains(client)) {
                    continue;
                }

                if (client.getInstallmentsToPay() > bigger) {
                    bigger = client.getInstallmentsToPay();
                    biggerClient = client;
                }
            }

            if (biggerClient == null) {
                continue;
            }
            contempled.add(biggerClient);
        }

        boolean bruno = false;
        long contempleds = 0;
        long toPay = 0;

        for (ConsorcioClient client : contempled) {
            ConsorcioModel model = client.getModel();
            boolean weee = false;
            if (client.getName().equalsIgnoreCase("Bruno Coelho Maia Alves Sabino")) {
                bruno = true;
                weee = true;
            }

            if (log || weee) {
                message += "Contemplado #" + (++contempleds) + ": " + client.getName() + "\n";
                message += "    Modelo: " + model.getName() + " (Plano: " + client.getInstallments() + "x de "
                        + money(model.getValue(client, 1, true)) + " - Total: " + money(model.getValue()) + ")" + "\n";
                message += "    Lance: " + client.getInstallmentsToPay() + " parcelas - Pago: "
                        + money(model.getValue(client, client.getInstallmentsToPay(), false));
                message += " - Estado atual: " + (client.getPaidInstallments() - 1) + " para "
                        + (client.getPaidInstallments() + client.getInstallmentsToPay()) + " de "
                        + client.getInstallments();
                if ((client.getPaidInstallments() + client.getInstallmentsToPay()) >= client.getInstallments()) {
                    message += "(QUITOU)\n";
                } else {
                    message += "\n";
                }
            } else {
                contempleds++;
            }
            winned += model.getValue(client, client.getInstallmentsToPay(), false);
            toPay += model.getValue();

            client.setContemplated(true);
            client.setPaidInstallments(client.getPaidInstallments() + client.getInstallmentsToPay());
            if (log || weee) {
                message += "\n";
            }
        }

        long total = ConsorcioClient.getClientList().size();
        long totalContempleds = 0;
        for (ConsorcioClient client : ConsorcioClient.getClientList()) {
            if (client.isContemplated()) {
                totalContempleds++;
            }
        }

        message += "No mês #" + totalMonths + " do consórcio foram sorteadas " + contempleds
                + " pessoas com o planejamento de " + perMonth + " contemplações!\n";
        message += "A situação do consórcio atual é de " + totalContempleds + " contemplados no total de " + total
                + " consorciados!\n";
        message += "Na parte da equipe, tiveram " + workers + " funcionários que receberam no total "
                + money((salary * workers)) + " de salário e cada um recebendo " + money(salary) + "!\n";
        bankAccount -= (salary * workers);
        toPay += (salary * workers);
        message += "Valor ganho: " + money(winned) + " - Valor gasto: " + money(toPay) + "\n";
        if (winned >= toPay) {
            if (updateAmount) {
                if (bankAccount > 100000) {
                    perMonth = Math.min(bankAccount / 1_000_000, ConsorcioClient.getClientList().size());

                    workers++;
                    salary += 100;
                } else {
                    perMonth = Math.max(perMonth - 1, 0);
                    workers = Math.max(workers - 1, 0);
                    salary -= 100;
                }
            }
            message += ">>>>>>>>>>>>>>>>>>>>>>>>>>\n";
            message += "Neste mês o consórcio saiu no lucro de " + money((winned - toPay)) + " reais!\n";
            bankAccount += (winned - toPay);
        } else {
            if (updateAmount) {
                perMonth = Math.max(perMonth - 1, 0);
                workers = Math.max(workers - 1, 0);
                salary = Math.max(salary - 10000, 2000);
            }

            message += "<<<<<<<<<<<<<<<<<<<<<<<<<<\n";
            message += "Neste mês o consórcio saiu no prejuizo de " + money((toPay - winned)) + " reais!\n";
            bankAccount -= (toPay - winned);
        }
        if (bankAccount >= 0) {
            positive++;
        } else {
            negative++;
        }
        message += "Conta Bancária do Consórcio: " + money(bankAccount) + "!\n";
        message += "Meses positivos: " + positive + " - Meses negativos: " + negative + " - AV: "
                + (positive - negative) + "\n";
        if (bankAccount >= 3) {
            message += "Valor para cada chefão: " + money(bankAccount / 3) + "!\n\n";
        } else {
            message += "Valor para cada chefão: NADA, PREJUÍZO!!!\n\n";
        }
        if (bruno) {
            message += "VOCÊ FOI CONTEMPLADO!!!!!!!!";
        } else {
            message += "Clique ok para passar para o próximo mês...";
        }

        if (Boolean.TRUE) {
            message(message);
            if (bruno) {
                scanner.nextLine();
            } else {
                if (totalMonths >= 1000) {
                    scanner.nextLine();
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, message, "Mês #" + totalMonths + " do Consórcio", JOptionPane.INFORMATION_MESSAGE);
        }
        nextMonth();
    }

    public static String money(long money) {
        return "R$ " + FORMAT.format(money);
    }

}
