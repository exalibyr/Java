package com.company;

import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) {
        testSemaphore(5);
        testPhilosophers();
    }

    private static void testSemaphore(int threadsNumber){
        int number = 1;
        Semaphore semaphore = new Semaphore(1);
        Resource resource = new Resource();
        SumThread[] sumThreads = new SumThread[threadsNumber];
        for (int i = 0; i < threadsNumber; i++) {
            sumThreads[i] = new SumThread("Thread " + i, resource, semaphore, number++);
            sumThreads[i].start();
            try {
                sumThreads[i].join();
            }
            catch (InterruptedException e){

            }
        }
        System.out.println("Sum = " + resource.sum);
    }

    private static void testPhilosophers(){
        Semaphore sem = new Semaphore(2);
        for(int i=1;i<6;i++)
            new Philosopher(sem,i).start();
    }
}
