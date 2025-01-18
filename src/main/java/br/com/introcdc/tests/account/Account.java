package br.com.introcdc.tests.account;
/*
 * Written by IntroCDC, Bruno Coêlho at 19/10/2021 - 20:28
 */

public class Account {

    private double balance;

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount < 0)
            throw new IllegalArgumentException("Não é possível depositar um valor negativo em uma conta!");
        this.balance += amount;
    }

    public void withdraw(double amount) throws InsuficientBalanceException {
        if (amount < 0)
            throw new IllegalArgumentException("Não é possível depositar um valor negativo em uma conta!");
        if (getBalance() < amount)
            throw new InsuficientBalanceException(amount);
        this.balance -= amount;
    }

    public static void main(String[] args) {
        Account account = new Account();
        account.deposit(-1);
    }

}
