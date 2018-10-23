package com.company;

import java.util.concurrent.Exchanger;

public class BisSpatterThread extends Thread{

    private String mes;
    private Exchanger<String> exchanger;

    public BisSpatterThread(String mes, Exchanger<String> exchanger) {
        this.mes = mes;
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        try {
            mes = exchanger.exchange(mes);
            System.out.println("BisSpatterThread - " + mes);
        }
        catch (InterruptedException e){

        }
    }
}
