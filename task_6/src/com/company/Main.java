//Task 1.6
//Ввести с клавиатуры 5 строк, записать их в массив строк.
//Отсортировать массив по возрастанию длины строк и вывести на экран.

package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void scan(ArrayList<String> str){ //считать строки
        Scanner in = new Scanner(System.in);
        System.out.print("Enter amount of lines ");
        int n = Integer.parseInt(in.nextLine()); //количество строк, которые нужно ввести
        int i = 0; //счетчик
        String input; //куда будем считывать строку
        while(i < n){ //пока число записанных строк меньше необходимого
            input = in.nextLine(); //считываем
            if(input.isEmpty()){ //если строка пустая, повторяем ввод
                System.out.println("Line is empty! Try again");
            }
            else{ //если не пустая, то считываем и инкрементируем счетчик
                str.add(input);
                i++;
            }
        }
        in.close();
    }
    public static void main(String[] args) {
        ArrayList<String> str = new ArrayList<String>(); //объект коллекции имеющий свой метод сортировки
        scan(str); //считываем в него
        Collections.sort(str); //сортируем встроенным методом
        str.forEach(System.out::println); //выводим
    }
}
