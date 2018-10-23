package com.company;

import java.util.concurrent.Semaphore;

public class SumThread extends Thread{

    Resource resource;
    Semaphore semaphore;
    int number;

    public SumThread(String name, Resource resource, Semaphore semaphore, int number) {
        super(name);
        this.resource = resource;
        this.semaphore = semaphore;
        this.number = number;
    }

    @Override
    public void run() {
        System.out.println(getName() + " is waiting");
        try {
            semaphore.acquire();
            resource.sum += number;
            semaphore.release();
        }
        catch (InterruptedException e){

        }
        System.out.println(getName() + " released");
    }
}
