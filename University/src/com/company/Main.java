//      Task 2.3
//        Создать классы Студент, Преподаватель, Предмет. Самостоятельно определить какие поля будут у этих классов.
//        у студента создать метод learn(…) который будет выводить на экран какие предметы изучает выбранный студент.
//        у преподавателя создать метод teach(…) который будет выводить какие предметы преподает выбранный преподаватель
//
//        В главном классе создать 3 студентов, 2 преподавателей и 5 предметов.
//        Ввести с клавиатуры имя студента и вывести на экран какие предметы он изучает.
//        Ввести с клавиатуры имя преподавателя и вывести список дисциплин, которые он преподает

package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {

        Subject math = new Subject("Math");             //создаем предметы
        Subject chemistry = new Subject("Chemistry");
        Subject physics = new Subject("Physics");
        Subject biology = new Subject("Biology");
        Subject history = new Subject("History");

        Student[] studs = new Student[3];           //массив для 3 студентов
        studs[0] = new Student("Alex");     //инициализируем студентов и задаем каждому свои предметы
        studs[0].setSubject(math);
        studs[0].setSubject(physics);

        studs[1] = new Student("Marry");
        studs[1].setSubject(history);

        studs[2] = new Student("John");
        studs[2].setSubject(chemistry);
        studs[2].setSubject(biology);

        Professor[] profs = new Professor[2];           //массив для 2 преподавателей
        profs[0] = new Professor("Mr. Jackson");        //инициализируем преподавателей
        profs[0].setSubject(math);                          //и задаем каждому свои предметы
        profs[0].setSubject(physics);
        profs[0].setSubject(chemistry);

        profs[1] = new Professor("Mrs. Burns");
        profs[1].setSubject(biology);
        profs[1].setSubject(history);

        try{
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String name;
            System.out.print("Professor's name: ");
            name = reader.readLine();
            for(Professor professor: profs){                    //ищем объект по имени
                if((professor.getName().compareTo(name)) == 0){
                    professor.teach();                          //и при совпадении выводим его список предметов
                    break;
                }
            }
            System.out.print("Student's name: ");
            name = reader.readLine();
            for(Student student: studs){                    //тоже самое для студентов
                if((student.getName().compareTo(name)) == 0){
                    student.learn();
                    break;
                }
            }
        }
        catch (IOException ex){
            ex.printStackTrace();
        }
    }
}
