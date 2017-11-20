package com.company;

public class LandscapePainter extends Artist {

    @Override
    public void draw(){
        System.out.println("The artist " + getName() + " is a landscape painter");
    }
}
