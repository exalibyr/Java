package com.company;

public class Fruits {
    private String color;
    private String shape;

    protected String getColor() {
        return color;
    }

    protected void setColor(String color) {
        this.color = color;
    }

    protected String getShape() {
        return shape;
    }

    protected void setShape(String shape) {
        this.shape = shape;
    }

    protected void grow(){
        System.out.println("The fruit is growing");
    }
    protected void bloom(){
        System.out.println("The fruit is blooming");
    }
    protected void growUp(){
        System.out.println("The fruit has grown up");
    }
}
