package com.company;

import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskReader {

    public static List<Task> readFromFile(String fileName){
        List<Task> tasks = new ArrayList<>();
        try {
            Scanner read = new Scanner(new FileInputStream(fileName));
            FormatConverter formatConverter = new FormatConverter();
            formatConverter.setFormat(new SimpleDateFormat("dd.MM.yyyy HH:mm:ss"));
            int i = 1;
            while (read.hasNextLine()) {
                tasks.add(new Task(i, read.nextLine(), formatConverter));
                i++;
            }
            read.close();
            return tasks;
        }catch (Exception ex){
            ex.printStackTrace();
            throw new RuntimeException();
        }
    }

}
