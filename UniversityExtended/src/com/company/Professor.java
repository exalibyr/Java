package com.company;

import java.util.List;

public class Professor extends Person { //профессор имеюищий свой возраст и свойства личности

    private int age;

    public Professor(String name, List<Discipline> disciplines, int age) {
        super(name, disciplines);
        this.age = age;
    }

    public void teach() {
        if ( disciplines == null ) {
            System.out.println( "No Disciplines by professor " + name );
        } else {
            System.out.println( "Disciplines by professor " + name + ":");
            for (Discipline discipline : disciplines ) {
                System.out.println(discipline.getName());
            }
        }
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}
