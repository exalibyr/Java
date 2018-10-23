package com.company;

public class Auto {

    private String name;
    private int year;
    private boolean isForeign;

    public Auto(String name, int year, boolean isForeign) {
        this.name = name;
        this.year = year;
        this.isForeign = isForeign;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Auto{" +
                "name='" + name + '\'' +
                ", year=" + year +
                ", isForeign=" + isForeign +
                '}';
    }

    public int getYear() {
        return year;
    }

    public boolean isForeign() {
        return isForeign;
    }
}
