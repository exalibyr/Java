package com.company;

public interface Walkable {

    String NAME = "Walkable";

    static void getName(){
        System.out.println("Walkable");
    }

    default void walk(){
        System.out.println("Walking");
    }
}
