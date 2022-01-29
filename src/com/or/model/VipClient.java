package com.or.model;

public class VipClient extends Client{

    public VipClient(int id, String name, double age, float interestRate, Account account) {
        super(id, name, age, interestRate, account);
    }

    public VipClient() {
    }

    @Override
    public String toString() {
        return "VipClient{" +
                "interestRate=" + interestRate +
                ", account=" + account +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
