package com.or.model;


public class RegularClient extends Client {


    public RegularClient(int id, String name, double age, float interestRate, Account account) {
        super(id, name, age, interestRate, account);
    }

    public RegularClient() {
    }


    @Override
    public String toString() {
        return "RegularClient{" +
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
