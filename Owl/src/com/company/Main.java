//        Task 2.2
//        Создать класс Сова с полями имя возраст порода и методами охотиться() пожиратьДобычу() спать().
//        Внутри методов просто выводить на экран фразу "Сова охотится", "Сова пожирает добычу" и т.д.
//        Создать в главном классе 4 совы, две из которых будут спать, одна охотиться и еще одна пожирать добычу.

package com.company;

public class Main {

    public static void main(String[] args) {
        Owl firstOwl = new Owl("1st");
        Owl secondOwl = new Owl("2nd");
        Owl thirdOwl = new Owl("3rd");
        Owl fourthOwl = new Owl("4th");

        firstOwl.sleeping();
        secondOwl.sleeping();
        thirdOwl.hunting();
        fourthOwl.eating();
    }
}
