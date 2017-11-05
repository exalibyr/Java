//Task 1.2
//Написать программу, которая выводит на экран в строку 20 целых случайных чисел от 1 до 100,
//потом в столбец 10 дробных от 25 до 75 и затем выводит в строку через пробел символы строки
//"Съешь ещё этих мягких французских булок, да выпей же чаю".

package com.company;

import java.util.Random;

public class Main {
    public static void outInt(Random rand){ //вывести целые
        int n = 20;
        int max = 100;
        int min = 1;
        for (int i = 0; i < n; i++) {
            System.out.print(rand.nextInt(max) + min + "\t"); //генерация и вывод
        }
        System.out.println();
    }
    public static void outFl(Random rand ){ //вывести дробные
        int n = 10;
        float max = 75;
        float min  = 25;
        for (int i = 0; i < n; i++) {
            System.out.println(rand.nextFloat()*(max - min) + min); //генерация и вывод
        }
    }
    public static void outStr(){ //вывести строку
        String str = "Съешь ещё этих мягких французских булок, да выпей же чаю";
        char ch;
        for (int i = 0; i < str.length(); i++) {
            ch = str.charAt(i);
            if((Character.compare(ch, ' ')) == 0){ //если символ пробел то просто выводим
                System.out.print(Character.toString(ch));
            }
            else{ //если нет, то выводим и добавляем пробел
                System.out.print(Character.toString(ch) + ' ');
            }
        }
    }
    public static void main(String[] args) {
        Random rand = new Random();
        outInt(rand);
        outFl(rand);
        outStr();
    }
}
