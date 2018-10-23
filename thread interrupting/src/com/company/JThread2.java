package com.company;

public class JThread2 implements Runnable {
    @Override
    public void run() {
        System.out.printf("%s started... \n", Thread.currentThread().getName());
        int counter=1; // счетчик циклов
        while(!Thread.currentThread().isInterrupted()){
            try{
                Thread.sleep(50);
                System.out.println("Loop " + counter++);
            }
            catch (InterruptedException ex){
                break;
            }
        }


        System.out.printf("%s finished... \n", Thread.currentThread().getName());
    }
}
