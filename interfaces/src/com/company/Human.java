package com.company;

public abstract class Human{
    private int age;

    public Human(int age) {
        this.age = age;
    }

    abstract void showInfo();

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
