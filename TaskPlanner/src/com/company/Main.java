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

        import java.util.*;

public class Main {

    public static void main(String[] args){
        TaskReader.readFromFile("Tasks.txt");
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a period(only parameters - today, tomorrow, this week, next week," +
                " this month, this year, any date of format dd.mm.yyyy " +
                "or range of format dd.mm.yyyy-dd.mm.yyyy - is admitted) ");
        Notificator.showTasks(Task.getTasks(),
                PeriodConverter.getPeriodFromString(in.nextLine()));
        in.close();
    }
}
