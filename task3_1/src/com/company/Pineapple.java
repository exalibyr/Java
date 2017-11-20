package com.company;

public class Pineapple extends Fruits {
    private int weight;

    public Pineapple(){
        setColor("bright-brown");
        setShape("oval");
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void showWeight(){
        System.out.println("this Pineapple weigh " + getWeight() + " lbs");
    }
}
