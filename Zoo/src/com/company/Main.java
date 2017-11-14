//        Task 2.3
//        Создать класс Зоопарк (поля Тигр, Лев, Жираф) Создать классы Тигр, Лев, Жираф с полями кличка, возраст и методами Есть() Пить() Спать() Скучать()
//        В главном классе создать по одному Тигру, Льву и Жирафу и поместить их в Зоопарк используя сеттеры класса Зоопарк.
//        Вывести на экран содержимое зоопарка, переопределив метод toString() для класса Зоопарк

package com.company;

public class Main {

    public static void main(String[] args) {
        Zoo zoo = new Zoo();
        zoo.setGiraffe(new Giraffe("dufy", 7));
        zoo.setLion(new Lion("roar", 12));
        zoo.setTiger(new Tiger("gufy", 5));
        System.out.println(zoo.toString());
    }
}
