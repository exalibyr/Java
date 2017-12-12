package com.company;

import java.util.List;

public class Person { //личность обладающая именем и списком предметов

    protected String name;
    protected List<Discipline> disciplines;

    public Person(String name, List<Discipline> disciplines) {
        this.name = name;
        this.disciplines = disciplines;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Discipline> getDisciplines() {
        return disciplines;
    }

    public void setDisciplines(List<Discipline> disciplines) {
        this.disciplines = disciplines;
    }
}
