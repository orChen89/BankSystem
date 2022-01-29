package com.or.model;


import java.util.concurrent.atomic.AtomicInteger;

public abstract class Person {

    private static final AtomicInteger counter = new AtomicInteger(0);
    protected int id = counter.incrementAndGet();
    protected String name;
    protected double age;

    public Person(int id, String name, double age) {
            this.id = id;
            this.name = name;
            this.age = age;

    }

    protected Person() {

    }


    public int getId() {

       return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        this.name = "Client " + this.id;
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAge() {
        return age;
    }

    public void setAge(double age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                 '\'' +
                ", age=" + age +
                '}';
    }
}
