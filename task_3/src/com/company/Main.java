//Task 1.3
//Ввести с клавиатуры строку, вывести ее на экран.
//Далее ввести еще одну строку и вывести на экран содержит ли первая строка в себе вторую, если не содержит,
//то вывести на экран какие символы из второй строки содержатся в первой.

package com.company;

import java.util.Scanner;

public class Main {
    public static String inStr(Scanner in){ //ввод строки
        String str;
        while(true) {
            str = in.nextLine(); //считываем, что ввели
            if (str.isEmpty()) { //пока ничего не введено
                System.out.println("String is empty! Try again"); //повторяем ввод
            }
            else {
                return str; //если что-то ввели, то возвращаем введенную строку
            }
        }
    }
    public static void analyseString(String str1, String str2){ //вывод символов второй строки,
        char symb;                                              //которые содержатся в первой
        boolean exit;    //условие выхода из цикла по первой строке
        String symbols = " ";       //строка уникальных символов, которые есть в обеих строках
                                    //инициализируем пробелом, чтобы он не выводился как совпавший символ
        System.out.print("First string contains symbols ");
        for (int i = 0; i < str2.length(); i++) {   //сравниваем каждый символ второй строки
            symb = str2.charAt(i);
            exit = false;
            for (int j = 0; j < str1.length(); j++) {   //с каждым символом первой строки
                if(Character.compare(symb, str1.charAt(j)) == 0){         //если есть совпадение
                    for (int k = 0; k < symbols.length(); k++) {    //смотрим было ли такое совпадение ранее
                        if(Character.compare(symb, symbols.charAt(k)) == 0){      //если было, то выходим из вложенных циклов
                            exit = true;                //и берем следующий символ второй строки
                            break;
                        }
                    }
                    if(exit){
                        break;
                    }
                    symbols = symbols.concat(Character.toString(symb));       //если не было, то записываем символ в строку
                    System.out.print(Character.toString(symb) + ", ");  //уникальных символов и выводим символ
                    break;                          //и берем следующий символ второй строки
                }
            }
        }
        System.out.println("of the second one");
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str1 = inStr(in);
        System.out.println("First string: " + str1);
        String str2 = inStr(in);
        in.close();
        System.out.println("Second string: " + str2);
        if(str1.contains(str2)){        //если первая строка содержит в себе вторую
            System.out.println("Second string has been found in the first one");    //то уведомляем
        }
        else{   //если нет, то ищем общие символы у обеих строк
            analyseString(str1, str2);
        }
    }
}
