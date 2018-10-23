package com.company;

public class Auto {

    private String mark;
    private int year;

    public Auto(String mark, int year) {
        this.mark = mark;
        this.year = year;
    }

    public String getMark() {
        return mark;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return "Auto{" +
                "mark='" + mark + '\'' +
                ", year=" + year +
                '}';
    }
}
