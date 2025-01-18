package br.com.introcdc.tests.account;
/*
 * Written by IntroCDC, Bruno Coêlho at 19/10/2021 - 20:34
 */

public class InsuficientBalanceException extends Exception {

    public InsuficientBalanceException(double amount) {
        super("Não foi possível completar a ação de remoção, pois a conta não possui saldo suficiente para remover " + amount + " reais!");
    }

}
