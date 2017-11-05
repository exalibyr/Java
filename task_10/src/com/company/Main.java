//Task 1.10
//Прочитать предварительно созданный текстовый файл и создать на его основе другой текстовый файл,
//в котором будут содержаться слова, которые содержат заданную с клавиатуры подстроку.

package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    public static final String DELIM = " "; //разделитель
    public static void copyWithCond(){
        File f = new File("data.txt");
        try{
            Scanner read = new Scanner(f); //объект потока для считывания из исходного файла
            Scanner in = new Scanner(System.in); //объект стандартного потока ввода
            System.out.print("Enter file name: ");
            try{
                String fileName = in.nextLine(); //название нового файла
                if(fileName.isEmpty()||((fileName.compareToIgnoreCase("data.txt")) == 0)){ //если название некорректно
                    throw new IOException(); //или является названием исходного файла, то получаем ошибку ввода
                }
                File file = new File(fileName);
                file.createNewFile();       //создаем файл
                System.out.print("File has been created! Enter the line ");
                String str = in.nextLine();        //вводим подстроку
                PrintWriter write = new PrintWriter(file);      //объект потока для записи в новый файл
                while(read.hasNextLine()){          //считываем весь исходный файл
                    for(String slice : read.nextLine().split(DELIM)){       //делим каждую строку на слова
                        if(slice.contains(str)){        //если подстрока есть в слове
                            write.println(slice);       //то записываем слово в новый файл
                        }
                    }
                }
                write.close();
            }
            catch (IOException ex){
                System.out.println("Error of input! Try another name");
            }
            finally {
                in.close();
                read.close();
            }
        }
        catch (FileNotFoundException ex){ }
    }
    public static void main(String[] args) {
        copyWithCond();
    }

}
