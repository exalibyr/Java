//Task3_3
//Для проекта создать три класса StudentCreator, ProfessorCreator, DisciplineCreator, которые будут иметь каждый свой метод create().
//Перенести создание дисциплин, профессоров и студентов в соответствующие классы.
//В классе Main заменить код заполнения дисциплин List<Discipline> disciplines = createAllDisciplines();
//на код:
//DisciplineCreator disciplineCreator = new DisciplineCreator();
//List<Discipline> disciplines = disciplineCreator.create();
//Сделать соответствующие замены кода для создания профессоров и студентов.
//Task3_4 (продолжение 3_3)
//Составить файлы discipline.txt, students.txt, professors.txt
//и заполнить их информацией о дисциплинах, профессорах и студентах (по 10 и более записей в файле).
//Изменить методы create() в классах-криэйторах на createFromFile(FILE_NAME)

package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        //-------------------считываем списки профессоров, студентов и предметов из файлов

        DisciplineCreator disciplineCreator = new DisciplineCreator();
        ProfessorCreator professorCreator = new ProfessorCreator();
        StudentCreator studentCreator = new StudentCreator();

        List<Discipline> disciplines = disciplineCreator.createFromFile("disciplines.txt");
        List<Professor> professors = professorCreator.createFromFile(disciplines, "professors.txt");
        List<Student> students = studentCreator.createFromFile(disciplines, "students.txt");

        //--------------------получаем информацию о студенте и преподавателе по его имени

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            System.out.println("Enter studentName");
            String studentName = br.readLine();
            Student studentFromConsole = getStudentByName(studentName, students);
            studentFromConsole.learn();

            System.out.println("Enter professorName");
            String professorName = br.readLine();
            Professor professorFromConsole = getProfessorByName(professorName, professors);
            professorFromConsole.teach();

        } catch ( IOException e){
            e.printStackTrace();
        }
    }

    private static Professor getProfessorByName(String professorName, List<Professor> professors) {

        for ( Professor student : professors ) {
            if ( professorName.equals(student.getName())) {
                return student;
            }
        }
        return null;
    }

    private static Student getStudentByName(String studentName, List<Student> students) {

        for ( Student student : students ) {
            if ( studentName.equals(student.getName())) {
                return student;
            }
        }
        return null;
    }

}
