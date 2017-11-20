package com.company;

public class Kiwi extends Fruits {
    private int diameter;

    public Kiwi(){
        setColor("brown");
        setShape("round");
    }

    public int getDiameter() {
        return diameter;
    }

    public void setDiameter(int diameter) {
        this.diameter = diameter;
    }

    public void showDiameter(){
        System.out.println("This kiwi has diameter " + getDiameter() + " inches");
    }
}
