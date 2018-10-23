package com.company;

public class Person extends Human implements Runnable, Walkable{
    private String name;

    public Person(int age, String name) {
        super(age);
        this.name = name;
    }

    @Override
    void showInfo() {
        System.out.println(getAge());
        System.out.println(this.name);
    }

}
