package com.or.model;

import java.util.Random;

public class Account {

    Random random = new Random();
    private double balance = random.nextInt(1000000);

    public Account(double balance) {
        this.balance = balance;
    }

    public Account() {
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "balance=" + balance + "$" +
                '}';
    }
}
