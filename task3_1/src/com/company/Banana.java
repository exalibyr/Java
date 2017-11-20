package com.company;

public class Banana extends Fruits {
    private int length;

    public Banana() {
        setColor("yellow");
        setShape("sickle");
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void showLength(){
        System.out.println("This banana has length " + getLength() + " inches");
    }
}
