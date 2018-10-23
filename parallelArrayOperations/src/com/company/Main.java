package com.company;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.IntBinaryOperator;

public class Main {

    public static void main(String[] args) {
	// write your code here
        testSetAll();
        testSort();
        testPrefix();
    }

    static void testSetAll(){
        int[] array = new int[10];
        Arrays.parallelSetAll(array, i -> ++i);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
        }
    }

    static void testSort(){
        Human[] humans = {new Human("Perfect human", 2000),
                new Human("Jack", 20),
                new Human("John", 30)};
        Arrays.parallelSort(humans, (o1, o2) -> o1.getAge() - o2.getAge());
        for(Human human : humans){
            System.out.println(human);
        }
    }

    static void testPrefix(){
        int[] array = new int[10];
        Arrays.parallelSetAll(array, i -> ++i);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "\t");
        }
        System.out.println();
        IntBinaryOperator ibo = (x, y) -> x * y;
        OptionalInt optionalInt = Arrays.stream(array).parallel().reduce(ibo);
        if (optionalInt.isPresent()){
            System.out.println(optionalInt.getAsInt());
        }
        else {
            System.out.println("OOOPSS!");
        }
        System.out.println();
        Arrays.parallelPrefix(array, ibo);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
