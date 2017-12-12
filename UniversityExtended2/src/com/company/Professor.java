package com.company;

import java.util.ArrayList;
import java.util.List;

public class Professor extends Person { //профессор имеюищий свой возраст и свойства личности

    private int age;
    private static List<Professor> professors = new ArrayList<Professor>();

    public Professor(String name, List<Discipline> disciplines, int age) {
        super(name, disciplines);
        this.age = age;
        professors.add(this);
    }

    public static List<Professor> getProfessors() {
        return professors;
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

    @Override
    public String toString() {
        return "Professor{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", disciplines=" + disciplines +
                '}';
    }
}
