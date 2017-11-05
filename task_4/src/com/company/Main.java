//Task 1.4
//Ввести с клавиатуры диапазон значений целых чисел в формате "[a; b]".
//Используя этот диапазон, вывести на экран 10 случайных чисел.
//Выполнить программу без использования массивов.

package com.company;

import java.util.Random;

public class Main {
    public static final int N = 10; //кол-во чисел
    public static void main(String[] args) {
        Range range = new Range(); //создаем объект пользовательского класса
        range.scan(); //вызываем метод для считывания данных в объект
        Random rand = new Random();
        int max = range.getB(); //получаем значения диапазона
        int min = range.getA();
        int x;
        for (int i = 0; i < N; i++) {
            x = rand.nextInt(max - min) + min; //генерация и вывод
            System.out.print(x + "\t");
        }
    }
}
