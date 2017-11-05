//Task 1.7
//Ввести с клавиатуры строку. Затем ввести строку-разделитель и образовать массив строк,
//разделив исходную строку на подстроки с помощью разделителя.
//в случае отсутствия разделителя внутри исходной строки вывести сообщение о невозможности разделения строки на подстроки.
//Вывести на экран получившиеся подстроки.

package com.company;

import java.util.Scanner;

public class Main {
    public static String scan(String s, Scanner in){
        while(true){ //пока хоть что-то не введено, будет повторяться ввод
            s = in.nextLine();//куда считаем
            if(s.isEmpty()){
                System.out.println("Empty!. Try again!");
            }
            else{
                return s; //считали успешно и вернули
            }
        }

    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = new String();
        String delim = new String();
        System.out.print("Enter the string ");
        str = scan(str, in);
        System.out.print("Enter delimiter ");
        delim = scan(delim, in);
        if(!str.contains(delim)){ //если разделителя в строке нет, то уведомляем
            System.out.println("Splitting is impossible!");
        }
        else{ //иначе делим и выводим
            for(String s : str.split(delim)) {      //тут образуется массив строк
                System.out.println(s);
            }
        }
    }
}
