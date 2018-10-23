package com.company;

public class MyThread extends Thread {

    private String number;
    private Resources resources;

    public MyThread(Resources resources, String number) {
        this.resources = resources;
        this.number = number;
    }

    @Override
    public void run() {
        synchronized (resources){
            System.out.println(getId());
            resources.sum += Integer.valueOf(number);
            try{
                sleep(100);
            }
            catch (InterruptedException e){

            }
        }
    }
}
