package com.company;

import java.util.concurrent.Exchanger;

public class Main {

    public static void main(String[] args) {
	// write your code here
        testExchanger();
    }

    private static void testExchanger(){
        Exchanger<String> exchanger = new Exchanger<>();
        new HalloThread("Hallo", exchanger).start();
        new BisSpatterThread("Bis spatter", exchanger).start();
    }
}
