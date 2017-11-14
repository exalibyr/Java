        //Task 2.5
        //Создать планировщик задач (класс Notificator).
        //В обязанности планировщика входит запрашивать у пользователя период времени
        //и выводить на экран список задач для выбранного периода.
        // Периодом может быть: сегодня, завтра, конкретная дата, текущая неделя, следующая неделя,
        // текущий месяц, текущий год, любой промежуток времени в формате "dd.mm.yyyy-dd.mm.yyyy"
        // Самостоятельно определить какие классы необходимо реализовать для решения поставленной задачи.
        // В главном классе необходимо заполнить все необходимые классы для работы,
        // затем спросить у пользователя за какой период он хочет увидеть список задач и вывести этот список.
        // Если за выбранный период задач нет, то вывести сообщение, что задач за данный период не найдено.

package com.company;

        import java.io.*;
        import java.text.ParseException;
        import java.text.SimpleDateFormat;
        import java.util.*;

public class Main {

    public static void main(String[] args) throws ParseException{
        List<Task> tasks = new ArrayList<>();
        try{
            Scanner read = new Scanner(new FileInputStream("tasks.txt"));
            FormatConverter formatConverter = new FormatConverter();
            formatConverter.setFormat(new SimpleDateFormat("dd.MM.yyyy HH:mm:ss"));
            while(read.hasNextLine()){
                tasks.add(new Task(read.nextLine(), formatConverter));
            }
            read.close();
            ListOfTasks list = new ListOfTasks(tasks);
            Notificator notificator = new Notificator();
            System.out.println("Enter a period(only parameters - today, tomorrow, this week, next week," +
                    " this month, this year, any date of format dd.mm.yyyy " +
                    "or range of format dd.mm.yyyy-dd.mm.yyyy - is admitted) ");
            Scanner in = new Scanner(System.in);
            notificator.setPeriod(in.nextLine());
            notificator.showTasks(list);
            in.close();
        }catch (IOException ex){
            ex.printStackTrace();
        }

    }
}
