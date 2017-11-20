package com.company;

public class Artist {
    private String name;

    protected String getName() {
        return name;
    }

    protected void setName(String name) {
        this.name = name;
    }

    protected void draw(){
        System.out.println("I'm not a painter, i'm just studying");
    }
}
