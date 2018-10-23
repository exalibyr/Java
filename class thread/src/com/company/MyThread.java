package com.company;

public class MyThread extends Thread{

    public MyThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        super.run();
        System.out.println("my thread started");
        System.out.println(this.getId());
        System.out.println(getName());
        try {
            sleep(1000);
        }
        catch (InterruptedException ex){
            System.out.println("Interrupted");
        }
        System.out.println("my thread finished");
    }
}
