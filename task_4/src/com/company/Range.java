package com.company;

import java.util.Scanner;

public class Range{ //класс содержит диапазон
    private int a = 0; //левая часть
    private int b = 0; //правая
    public void scan(){ //считать в формате [a; b]
        final char FIRST_POS = '[';
        final char LAST_POS = ']';
        final char DELIMITER = ';';
        System.out.println("Enter range in the format [a; b]");
        Scanner in = new Scanner(System.in);
        String inputted = in.nextLine(); //считываем строку
        int begin = inputted.indexOf(FIRST_POS) + 1; //устанавливаем индексы
        int pause = inputted.indexOf(DELIMITER);
        int cont = pause + 2;
        int end = inputted.indexOf(LAST_POS);
        a = Integer.parseInt(inputted, begin, pause, 10); //считываем числа из строки
        b = Integer.parseInt(inputted, cont, end, 10);
        in.close();
    }
    public int getA(){
        return a;
    } //метод - получить значение
    public int getB(){
        return b;
    }
}
