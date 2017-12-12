package com.company;

import java.util.ArrayList;
import java.util.List;

public class Student extends Person { //студент имеющий свой курс и свойства личности

    private int course;
    private static List<Student> students = new ArrayList<Student>();

    public Student(String name, List<Discipline> disciplines, int course) {
        super(name, disciplines);
        this.course = course;
        students.add(this);
    }

    public static List<Student> getStudents() {
        return students;
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

    @Override
    public String toString() {
        return "Student{" +
                "course=" + course +
                ", name='" + name + '\'' +
                ", disciplines=" + disciplines +
                '}';
    }
}
