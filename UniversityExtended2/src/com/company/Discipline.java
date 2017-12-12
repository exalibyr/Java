package com.company;

import java.util.ArrayList;
import java.util.List;

public class Discipline {

    private String name;
    private int complexity;
    private static List<Discipline> disciplines = new ArrayList<Discipline>();


    public Discipline(String name, int complexity) {
        this.name = name;
        this.complexity = complexity;
        disciplines.add(this);
    }

    public static List<Discipline> getDisciplines() {
        return disciplines;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getComplexity() {
        return complexity;
    }

    public void setComplexity(int complexity) {
        this.complexity = complexity;
    }

    @Override
    public String toString() {
        return "Discipline{" +
                "name='" + name + '\'' +
                ", complexity=" + complexity +
                '}';
    }
}
