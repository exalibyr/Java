package com.company;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Task {

    private String name;
    private Date date;
    private int number;
    private static List<Task> tasks = new ArrayList<>();

    Task(int number, String task, FormatConverter formatConverter){
        boolean isTime = true;
        for(String line: task.split("/")){
            if(isTime){
                date = formatConverter.format(line);
                isTime = false;
            }
            else{
                name = line;
            }
        }
        this.number = number;
        tasks.add(this);
    }


    public Date getDate() {
        return date;
    }

    public static List<Task> getTasks() {
        return tasks;
    }

    @Override
    public String toString() {
        return "\nTask#" + number + " {" +
                "name='" + name + '\'' +
                ", date=" + date.toString() +
                '}';
    }
}
