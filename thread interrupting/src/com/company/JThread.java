package com.company;

public class JThread extends Thread{
    JThread(String name){
        super(name);
    }
    public void run(){

        System.out.printf("%s started... \n", Thread.currentThread().getName());
        int counter=1; // счетчик циклов
        try{
            while(!isInterrupted()){
                sleep(50);
                System.out.println("Loop " + counter++);
            }
        }
        catch (InterruptedException ex){

        }

        System.out.printf("%s finished... \n", Thread.currentThread().getName());
    }
}
