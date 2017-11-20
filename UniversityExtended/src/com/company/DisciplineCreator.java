package com.company;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DisciplineCreator { //класс отвечает за создание списка предметов считанных с файла

    public List<Discipline> createFromFile(String fileName){

        List<Discipline> disciplines = new ArrayList<>();
        String[] line;
        try(Scanner read = new Scanner(new FileReader(fileName))){
            while (read.hasNextLine()){
                line = read.nextLine().split("/");
                disciplines.add(new Discipline(line[0].trim(),
                        Integer.parseInt(line[1].trim())
                ));
            }
            read.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }

        return disciplines;
    }

    public List<Discipline> getDisciplinesByNames(
            List<Discipline> disciplines,
            List<String> disciplineNames
    ) {
        List<Discipline> resultList = new ArrayList<>();

        for ( Discipline discipline : disciplines ) {
            if ( disciplineNames.contains(discipline.getName() ) ) {
                resultList.add(discipline);
            }
        }
        return resultList;
    }
}
