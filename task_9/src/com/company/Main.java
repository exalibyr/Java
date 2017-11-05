//Task 1.9
//Ввести с клавиатуры 3 строки и вывести в файл слова из из этих строк по одному слову на каждой строке файла.

package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    public static final String DELIM = " ";     //разделитель
    public static void writeToFile(String fileName, int n) throws FileNotFoundException{
        Scanner in = new Scanner(System.in);
        PrintWriter writer = new PrintWriter(fileName);     //объект потока для записи в файл
        System.out.println("Enter the lines ");
        for (int i = 0; i < n; i++) {
            for (String str : in.nextLine().split(DELIM)){          //делим строку на слова
                writer.println(str);        //записываем по слову на строку в файл
            }
        }
        writer.close();
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter file name: ");
        try{
            String fileName = in.nextLine();        //имя создаваемвого файла
            if(fileName.isEmpty()){         //если некорректно то обрабатываем исключение
                throw new IOException();
            }
            File file = new File(fileName);
            if(!file.exists()){
                file.createNewFile();       //создаем новый файл, если не существует
            }
            int n = 0;
            System.out.print("Enter the count of lines you would like to enter: ");
            n = in.nextInt();       //кол во вводимых строк
            if(n < 1){
                throw new IOException();        //если некорректный ввод, то обрабат исключение
            }
            writeToFile(fileName, n);       //вызываем метод записи в файл
        }
        catch (IOException ex){
            System.out.println("Error of input! Try again");
        }
        finally {
            in.close();
        }
    }
}
