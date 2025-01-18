package br.com.introcdc.tests.account;
/*
 * Written by IntroCDC, Bruno Co�lho at 19/10/2021 - 20:34
 */

public class InsuficientBalanceException extends Exception {

    public InsuficientBalanceException(double amount) {
        super("N�o foi poss�vel completar a a��o de remo��o, pois a conta n�o possui saldo suficiente para remover " + amount + " reais!");
    }

}
