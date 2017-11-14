package com.company;

import java.util.ArrayList;
import java.util.List;

public class Professor {
    private String name;
    private List<Subject> subjects;

    Professor(String name){
        this.name = name;
        subjects = new ArrayList<>();
    }
    public void teach() {
        System.out.println("Subjects: ");
        for (Subject subject : subjects) {
            System.out.println("\t" + subject.getName());
        }
    }
    public String getName() {
        return name;
    }

    public void setSubject(Subject subject) {
        subjects.add(subject);
    }

}
