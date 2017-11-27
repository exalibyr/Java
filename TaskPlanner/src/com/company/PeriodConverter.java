package com.company;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class PeriodConverter {

    public static Period getPeriodFromString(String textPeriod) {
        switch (textPeriod) {
            case "today": {
                Period period = new Period();
                period.setDayInterval();
                return period;
            }
            case "tomorrow": {
                Period period = new Period();
                period.getBeginning().setDate(period.getBeginning().getDate() + 1);
                period.getEnd().setDate(period.getEnd().getDate() + 1);
                period.setDayInterval();
                return period;
            }
            case "this week": {
                Period period = new Period();
                period.getBeginning().setDate(period.getBeginning().getDate() -
                        period.getBeginning().getDay());
                period.getEnd().setDate(period.getEnd().getDate() +
                        (Calendar.SATURDAY - period.getEnd().getDay() - 1));
                period.setDayInterval();
                return period;
            }
            case "next week": {
                Period period = new Period();
                period.getBeginning().setDate(period.getBeginning().getDate() +
                        (Calendar.SATURDAY - period.getBeginning().getDay()));
                period.getEnd().setDate(period.getEnd().getDate() +
                        (Calendar.SATURDAY - period.getEnd().getDay() - 1) +
                        Calendar.SATURDAY);
                period.setDayInterval();
                return period;
            }
            case "this month": {
                Period period = new Period();
                period.getBeginning().setDate(1);
                period.getEnd().setMonth(period.getEnd().getMonth() + 1);
                period.getEnd().setDate(1);
                period.getEnd().setDate(period.getEnd().getDate() - 1);
                period.setDayInterval();
                return period;
            }
            case "this year": {
                Period period = new Period();
                period.getBeginning().setMonth(Calendar.JANUARY);
                period.getBeginning().setDate(1);
                period.getEnd().setMonth(Calendar.DECEMBER);
                period.getEnd().setDate(31);
                period.setDayInterval();
                return period;
            }
            default: {
                if (textPeriod.contains(".")) {
                    FormatConverter formatConverter = new FormatConverter();
                    formatConverter.setFormat(new SimpleDateFormat("dd.MM.yyyy"));
                    Period period = new Period();

                    if (textPeriod.contains("-")) {
                        String[] range = textPeriod.split("-");
                        period.setBeginning(formatConverter.format(range[0]));
                        period.setEnd(formatConverter.format(range[1]));
                        period.setDayInterval();
                    }
                    else{
                        period.setBeginning(formatConverter.format(textPeriod));
                        period.setEnd(formatConverter.format(textPeriod));
                        period.setDayInterval();
                    }
                    return period;
                }

                System.out.println("Incorrect range input!");
                throw new RuntimeException();
            }
        }
    }
}
