package com.company;

import java.util.Date;

public class Task {
    private String name;
    private Date date;

    Task(String task, FormatConverter formatConverter){
        boolean isTime = true;
        for(String line: task.split("/")){
            if(isTime){
                //FormatConverter formatConverter = new FormatConverter();
                date = formatConverter.format(line);
                isTime = false;
            }
            else{
                name = line;
            }
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Task{" +
                "name='" + name + '\'' +
                ", date=" + date.toString() +
                '}';
    }
}
