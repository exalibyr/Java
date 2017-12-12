package com.company;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProfessorCreator extends DisciplineCreator{ //класс отвечает за создание из файла списка профессоров
                                                        // с собственными предметами

    public static void createFromFile(String fileName){

        List<Professor> professors = new ArrayList<>();
        String[] line;
        try(Scanner read = new Scanner(new FileReader(fileName))){
            while (read.hasNextLine()){
                line = read.nextLine().split("/");
                List<String> disciplineNames = new ArrayList<>();
                for(String disciplineName:line[1].split(",")){
                    disciplineName = disciplineName.trim();
                    disciplineNames.add(disciplineName);
                }
                professors.add(new Professor(line[0].trim(),
                        getDisciplinesByNames(Discipline.getDisciplines(), disciplineNames),
                        Integer.parseInt(line[2].trim()))
                );
            }
            read.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }

    }
}
