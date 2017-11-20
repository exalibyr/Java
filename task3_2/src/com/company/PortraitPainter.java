package com.company;

public class PortraitPainter extends Artist {

    @Override
    public void draw(){
        System.out.println("The artist " + getName() + " is a portrait painter");
    }
}
