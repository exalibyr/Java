package com.company;

import java.util.Date;

public class Period { //период времени задаваемый пользователем

    private Date beginning;
    private Date end;

    public void setBeginning(Date beginning) {
        this.beginning = beginning;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public Date getBeginning() {
        return beginning;
    }

    public Date getEnd() {
        return end;
    }

    public void setDayInterval() { //стандартный интервал в 1 день, присутствует в любом периоде
        beginning.setHours(0);
        beginning.setMinutes(0);
        beginning.setSeconds(0);
        beginning.setTime(beginning.getTime() -
                beginning.getTime()%1000);

        end.setHours(23);
        end.setMinutes(59);
        end.setSeconds(59);
        end.setTime(end.getTime() +
                (999 - end.getTime()%1000));
    }

    Period(){
        beginning = new Date();
        end = new Date();
    }

    @Override
    public String toString() {
        return "Period{" +
                "beginning=" + beginning +
                ", end=" + end +
                '}';
    }
}
