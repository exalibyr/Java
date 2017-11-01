package com.company;

import java.util.Arrays;
import java.util.Random;
import java.util.Vector;

public class Main {
    public static void main(String[] args) {
        int[] array = new int[50];
        String str = "Hello, my name is alexey";
        //Vector<int> array2;
        Random rand = new Random();
        int min = -500;
        int max = 500;
//        for (int i = 0; i < array.length; i++) {
//            array[i] = rand.nextInt(max) + min;
//            if(i%10 == 0){
//                System.out.println();
//            }
//            System.out.print(array[i] + "\t");
//        }
        System.out.println(Arrays.toString(array));
    }
}
