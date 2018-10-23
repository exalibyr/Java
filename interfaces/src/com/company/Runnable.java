package com.company;

public interface Runnable {

    String NAME = "Runnable";

    default void run(){
        System.out.println("running");
    }

    static void name(){
        System.out.println("Runnable");
    }

}
