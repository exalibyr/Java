package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Store store=new Store();
        Producer producer = new Producer(store);
        Consumer consumer = new Consumer(store);
        new Thread(producer).start();
        new Thread(consumer).start();
    }
}
