package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
//        testSynchronization();
        testWaitNotify();
    }

    private static void testSynchronization(){
        String[] numbers = {"1", "2", "3", "4", "5", "6"};
        MyThread[] myThreads = new MyThread[numbers.length];
        Resources resources = new Resources();
        for (int i = 0; i < numbers.length; i++) {
            myThreads[i] = new MyThread(resources, numbers[i]);
            myThreads[i].start();
            try{
                myThreads[i].join();
            }
            catch (InterruptedException e){

            }
        }
        System.out.println("sum = " + resources.sum);
    }

    private static void testWaitNotify(){
        Store store = new Store();
        Producer producer = new Producer(store);
        Consumer consumer = new Consumer(store);
        new Thread(producer).start();
        new Thread(consumer).start();
    }
}
