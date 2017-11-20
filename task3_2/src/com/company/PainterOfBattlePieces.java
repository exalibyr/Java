package com.company;

public class PainterOfBattlePieces extends Artist {

    @Override
    public void draw(){
        System.out.println("The artist " + getName() + " is a painter of battle-pieces");
    }

}
