package com.company;

public abstract class Human {

    private float height;
    private float weight;

    Human(float height, float weight){
        this.height = height;
        this.weight = weight;
    }

    abstract void showInfo();

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }
}


