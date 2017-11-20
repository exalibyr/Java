package com.company;

import java.util.List;

public class Student extends Person { //студент имеющий свой курс и свойства личности

    private int course;

    public Student(String name, List<Discipline> disciplines, int course) {
        super(name, disciplines);
        this.course = course;
    }

    public void learn() {
        if ( disciplines == null ) {
            System.out.println( "No Disciplines for student " + name );
        } else {
            System.out.println( "Disciplines for student " + name + ":");
            for (Discipline discipline : disciplines ) {
                System.out.println(discipline.getName());
            }
        }
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

}
