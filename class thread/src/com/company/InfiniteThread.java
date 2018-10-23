package com.company;

import java.io.Console;
import java.util.logging.ConsoleHandler;

public class InfiniteThread implements Runnable{

    boolean isAlive;

    InfiniteThread(){
        isAlive = true;
    }

    void disable(){
        isAlive = false;
    }


    @Override
    public void run() {
        int counter=1; // счетчик циклов
        while(isAlive){
            System.out.println("Loop " + counter++);
            try{
                Thread.sleep(400);
            }
            catch(InterruptedException e){
                System.out.println("Thread has been interrupted");
            }
        }
    }
}
