package com.company;

import java.util.Date;

public class Task { //класс задача, содержащий информацию о запланированной задаче

    private String name;
    private Date date;
    private int number;

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

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Task#" + number + " {" +
                "name='" + name + '\'' +
                ", date=" + date.toString() +
                '}';
    }
}
