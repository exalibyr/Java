package com.company;

import static java.lang.Thread.sleep;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println("main thread started");
        Thread thread = new MyThread("my thread");
        thread.setPriority(3);
        thread.start();
        Thread thread1 = new Thread(() -> {
            try{
                System.out.println("thread started");
                sleep(5000);
                System.out.println("thread finished");
            }
            catch (InterruptedException ex){

            }
        }, "thread");
        thread1.start();
        try {
            thread.join();
            thread1.join();
        }
        catch (InterruptedException ex){

        }
        InfiniteThread infiniteThread = new InfiniteThread();
        new Thread(infiniteThread,"MyThread").start();

        try{
            Thread.sleep(1100);

            infiniteThread.disable();

            Thread.sleep(1000);
        }
        catch(InterruptedException e){
            System.out.println("Thread has been interrupted");
        }
        System.out.println("main thread finished");
    }
}
