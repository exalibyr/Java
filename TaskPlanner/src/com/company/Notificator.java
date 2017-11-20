package com.company;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Notificator { //устанавливает период в зависимости от ввода пользователя и выводит соответствующие задачи

    private Period period;

    public void showTasks(ListOfTasks list){
        Checker checker = new Checker();
        System.out.println(period.toString() + "\n");
        boolean wasIncluded = false;
        for(Task task:list.getTasks()){
            if(checker.isIncluded(period, task.getDate())){
                System.out.println(task.toString());
                if(!wasIncluded){
                    wasIncluded = true;
                }
            }
        }
        if(!wasIncluded){
            System.out.println("Nothing was found giving inputted period!");
        }
    }

    public void setPeriod(String period) {
        switch (period) {
            case "today": {
                this.period = new Period();
                this.period.setDayInterval();
                break;
            }
            case "tomorrow": {
                this.period = new Period();
                this.period.getBeginning().setDate(this.period.getBeginning().getDate() + 1);
                this.period.getEnd().setDate(this.period.getEnd().getDate() + 1);
                this.period.setDayInterval();
                break;
            }
            case "this week": {
                this.period = new Period();
                this.period.getBeginning().setDate(this.period.getBeginning().getDate() -
                        this.period.getBeginning().getDay());
                this.period.getEnd().setDate(this.period.getEnd().getDate() +
                        (Calendar.SATURDAY - this.period.getEnd().getDay() - 1));
                this.period.setDayInterval();
                break;
            }
            case "next week": {
                this.period = new Period();
                this.period.getBeginning().setDate(this.period.getBeginning().getDate() +
                        (Calendar.SATURDAY - this.period.getBeginning().getDay()));
                this.period.getEnd().setDate(this.period.getEnd().getDate() +
                        (Calendar.SATURDAY - this.period.getEnd().getDay() - 1) +
                        Calendar.SATURDAY);
                this.period.setDayInterval();
                break;
            }
            case "this month": {
                this.period = new Period();
                this.period.getBeginning().setDate(1);
                this.period.getEnd().setMonth(this.period.getEnd().getMonth() + 1);
                this.period.getEnd().setDate(1);
                this.period.getEnd().setDate(this.period.getEnd().getDate() - 1);
                this.period.setDayInterval();
                break;
            }
            case "this year": {
                this.period = new Period();
                this.period.getBeginning().setMonth(Calendar.JANUARY);
                this.period.getBeginning().setDate(1);
                this.period.getEnd().setMonth(Calendar.DECEMBER);
                this.period.getEnd().setDate(31);
                this.period.setDayInterval();
                break;
            }
            default: {
                if (period.contains(".")) {
                    FormatConverter formatConverter = new FormatConverter();
                    formatConverter.setFormat(new SimpleDateFormat("dd.MM.yyyy"));
                    this.period = new Period();

                    if (period.contains("-")) {
                        String[] range = period.split("-");
                        this.period.setBeginning(formatConverter.format(range[0]));
                        this.period.setEnd(formatConverter.format(range[1]));
                        this.period.setDayInterval();
                    }
                    else{
                        this.period.setBeginning(formatConverter.format(period));
                        this.period.setEnd(formatConverter.format(period));
                        this.period.setDayInterval();
                    }

                    break;
                }

                System.out.println("Incorrect range input!");
                break;
            }
        }
    }
}
