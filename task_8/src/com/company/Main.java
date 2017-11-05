//Task 1.8
//Создать в проекте (руками) текстовый файл. Прочитать его и вывести строки из него на экран.
//Вывести так же информацию о количестве строк, сдине каждой строки и общей длине строк в файле.

package com.company;

import java.io.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException{
        String fileName = "data.txt";
        FileInfo fileInfo = new FileInfo();
        fileInfo.showTextWithLenOfLines(fileName);
        System.out.println("Amount of lines of file equals " + fileInfo.getAmountOfLines(fileName));
        System.out.println("Length of file equals " + fileInfo.getLenOfFile(fileName) + " symbols");
    }
}
