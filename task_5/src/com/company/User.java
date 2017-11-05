package com.company;

import java.util.Scanner;

public class User { //класс с данными пользователя
    private String login;
    private String password;
    public void scan(){ //метод считывает данные  со  стандартного потока
        Scanner in = new Scanner(System.in);
        System.out.print("Enter login: ");
        login  = in.nextLine();
        System.out.print("Enter pass: ");
        password = in.nextLine();
        in.close();
    }
    public void encodeAndShow(){ //метод отображает данные, скрывая пароль
        System.out.print("Your login: ");
        System.out.println(login);
        String replacement = new String(); //строка со скрытым паролем
        for (int i = 0; i < password.length(); i++) {
            replacement += "*"; //инициируем ее длиной соответствующей длине пароля
        }
        System.out.print("Your pass: ");
        System.out.println(password.replaceAll(password, replacement));  //заменяем и выводим
    }
}
