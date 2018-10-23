package com.company;

public class DisabledPerson extends Human implements Runnable, Walkable {
    private String name;

    public DisabledPerson(int age, String name) {
        super(age);
        this.name = name;
    }

    @Override
    void showInfo() {
        System.out.println(getAge());
        System.out.println(this.name);
    }

    @Override
    public void run() {
        System.out.println("He is disabled person! He cannot run!");
    }

    @Override
    public void walk() {
        System.out.println("But he can walk!");
    }
}
