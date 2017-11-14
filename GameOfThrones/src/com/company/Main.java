//      Task 2.4
//        реализовать проект с классом GameOfThrones ( поля список Персонажей )
//        Класс Персонаж (поля имя, возраст, место проживания (класс Земля))
//        Класс Земля ( поля название земли, правитель земли)
//
//        В классе Main создать по 5 экземпляров классов Земля, Персонаж.
// Вывести на экран список персонажей через переопределенный метод toString()

package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Land dark = new Land("dark", "darkLord");
        Land bright = new Land("bright", "brightLord");
        Land grey = new Land("grey", "greyLord");
        Land peace = new Land("peace", "peaceLord");
        Land evil = new Land("evil", "evilLord");

        List<Character> characters = new ArrayList<>();
        characters.add(new Character("Eddard Ned Stark", 20, dark));
        characters.add(new Character("Cersei Lannister", 25, bright));
        characters.add(new Character("Jorah Mormont", 35, grey));
        characters.add(new Character("Robb Stark", 50, evil));
        characters.add(new Character("Khai Drogo", 30, peace));

        GameOfThrones gameOfThrones = new GameOfThrones();
        gameOfThrones.setCharacters(characters);
        System.out.println(gameOfThrones.toString());
    }
}
