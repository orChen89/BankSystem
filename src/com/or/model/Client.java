package com.or.model;

public abstract class Client extends Person implements Comparable {

    protected float interestRate;
    protected Account account;

    public Client(int id, String name, double age, float interestRate, Account account) {
        super(id, name, age);
        this.interestRate = interestRate;
        this.account = account;
    }

    protected Client() {
    }

    public float getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(float interestRate) {
        this.interestRate = interestRate;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "Client{" +
                ", account=" + account +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
