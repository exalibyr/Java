package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here

        Person person = new Person(25, "Alex");
        person.showInfo();
        person.run();
        person.walk();
        Runnable.name();
        DisabledPerson disabledPerson = new DisabledPerson(72, "Steve");
        disabledPerson.showInfo();
        disabledPerson.run();
        disabledPerson.walk();
        System.out.println(Walkable.NAME);
    }
}
