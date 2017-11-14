package com.company;

public class Character {
    private String name;
    private int age;
    private Land land;

    Character(String name, int age, Land land){
        this.name = name;
        this.age = age;
        this.land = land;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Land getLand() {
        return land;
    }

    public void setLand(Land land) {
        this.land = land;
    }

    @Override
    public String toString() {
        return "Character{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", land=" + land.toString() +
                '}';
    }
}
