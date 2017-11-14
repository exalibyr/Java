package com.company;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Notificator {
    private Period period;

    public void showTasks(ListOfTasks list){
        System.out.println(period.toString());
        boolean wasIncluded = false;
        for(Task task:list.getTasks()){
            if(period.isIncluded(task.getDate())){
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
                Date beginning = new Date();
                beginning.setHours(0);
                beginning.setMinutes(0);
                beginning.setSeconds(0);
                Date end = new Date();
                end.setHours(23);
                end.setMinutes(59);
                end.setSeconds(59);
                this.period = new Period(beginning, end);
                break;
            }
            case "tomorrow": {
                Date beginning = new Date();
                beginning.setDate(beginning.getDate() + 1);
                beginning.setHours(0);
                beginning.setMinutes(0);
                beginning.setSeconds(0);
                Date end = new Date();
                end.setDate(end.getDate() + 1);
                end.setHours(23);
                end.setMinutes(59);
                end.setSeconds(59);
                this.period = new Period(beginning, end);
                break;
            }
            case "this week": {
                Date beginning = new Date();
                beginning.setDate(beginning.getDate() - beginning.getDay());
                beginning.setHours(0);
                beginning.setMinutes(0);
                beginning.setSeconds(0);
                Date end = new Date();
                end.setDate(end.getDate() +
                        (Calendar.SATURDAY - end.getDay() - 1));
                end.setHours(23);
                end.setMinutes(59);
                end.setSeconds(59);
                this.period = new Period(beginning, end);
                break;
            }
            case "next week": {
                Date beginning = new Date();
                beginning.setDate(beginning.getDate() +
                        (Calendar.SATURDAY - beginning.getDay()));
                beginning.setHours(0);
                beginning.setMinutes(0);
                beginning.setSeconds(0);
                Date end = new Date();
                end.setDate(end.getDate() +
                        (Calendar.SATURDAY - end.getDay() - 1) +
                        Calendar.SATURDAY);
                end.setHours(23);
                end.setMinutes(59);
                end.setSeconds(59);
                this.period = new Period(beginning, end);
                break;
            }
            case "this month": {
                Date beginning = new Date();
                beginning.setDate(1);
                beginning.setHours(0);
                beginning.setMinutes(0);
                beginning.setSeconds(0);
                Date end = new Date();
                end.setMonth(end.getMonth() + 1);
                end.setDate(1);
                end.setDate(end.getDate() - 1);
                end.setHours(23);
                end.setMinutes(59);
                end.setSeconds(59);
                this.period = new Period(beginning, end);
                break;
            }
            case "this year": {
                Date beginning = new Date();
                beginning.setMonth(Calendar.JANUARY);
                beginning.setDate(1);
                beginning.setHours(0);
                beginning.setMinutes(0);
                beginning.setSeconds(0);
                Date end = new Date();
                end.setMonth(Calendar.DECEMBER);
                end.setDate(31);
                end.setHours(23);
                end.setMinutes(59);
                end.setSeconds(59);
                this.period = new Period(beginning, end);
                break;
            }
            default: {
                if (period.contains(".")) {
                    FormatConverter formatConverter = new FormatConverter();
                    formatConverter.setFormat(new SimpleDateFormat("dd.MM.yyyy"));

                    if (period.contains("-")) {
                        Date[] dateRange = new Date[2];
                        int i = 0;
                        for(String date:period.split("-")){
                            dateRange[i] = formatConverter.format(date);
                            i++;
                        }
                        this.period = new Period(dateRange[0], dateRange[1]);
                        break;
                    }

                    Date beginning = formatConverter.format(period);
                    Date end = beginning;
                    beginning.setHours(0);
                    beginning.setMinutes(0);
                    end.setHours(23);
                    end.setMinutes(59);
                    this.period = new Period(beginning, end);
                    break;
                }

                System.out.println("Incorrect range input!");
                break;
            }
        }
    }
}
