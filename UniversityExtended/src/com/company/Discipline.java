package com.company;

public class Discipline {

    private String name;
    private int complexity;

    public Discipline(String name, int complexity) {
        this.name = name;
        this.complexity = complexity;
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

}
