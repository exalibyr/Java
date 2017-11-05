//Task 1.1
// Прочитать с клавиатуры 5 целочисленных переменных и вывести на экран их сумму.
package com.company;

import java.util.Scanner;

public class Main {
    public static final int N = 5; //кол-во переменных
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in); //объект который принимает данные из потока
        int sum = 0; //сумма
        for (int i = 0; i < N; i++) {
            sum += in.nextInt(); //накапливаем сумму
        }
        System.out.println("Sum of inputted numbers equals " + sum);
    }
}
