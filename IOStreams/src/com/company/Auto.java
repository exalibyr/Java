package com.company;

import java.io.Serializable;

public class Auto implements Serializable {

    private String markName;
    private int year;
    private transient double weight;
    private boolean isForeign;

    public Auto(String markName, int year, double weight, boolean isForeign) {
        this.markName = markName;
        this.year = year;
        this.weight = weight;
        this.isForeign = isForeign;
    }

    @Override
    public String toString() {
        return "Auto{" +
                "markName='" + markName + '\'' +
                ", year=" + year +
                ", weight=" + weight +
                ", isForeign=" + isForeign +
                '}';
    }
}
