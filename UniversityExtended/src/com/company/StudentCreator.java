package com.company;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentCreator extends DisciplineCreator{ //класс отвечает за создание из файла списка студентов
                                                        // с собственными предметами

    public List<Student> createFromFile(List<Discipline> disciplines, String fileName){

        List<Student> students = new ArrayList<>();
        String[] line;
        try(Scanner read = new Scanner(new FileReader(fileName))){
            while (read.hasNextLine()){
                line = read.nextLine().split("/");
                List<String> disciplineNames = new ArrayList<>();
                for(String disciplineName:line[1].split(",")){
                    disciplineName = disciplineName.trim();
                    disciplineNames.add(disciplineName);
                }
                students.add(new Student(line[0].trim(),
                        getDisciplinesByNames(disciplines, disciplineNames),
                        Integer.parseInt(line[2].trim())
                        ));
            }
            read.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }

        return students;
    }
}
