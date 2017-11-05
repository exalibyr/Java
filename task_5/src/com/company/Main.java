//Task 1.5
//Ввести с клавиатуры 2 строки login и password.
//При выводе на экран обоих строк заменить символы строки password символами *.
package com.company;

public class Main {

    public static void main(String[] args) {
        User user = new User(); //объект польз класса
        user.scan(); //методы класса
        user.encodeAndShow();
    }
}
