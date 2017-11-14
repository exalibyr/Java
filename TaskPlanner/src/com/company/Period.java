package com.company;

import java.util.Date;

public class Period {
    private Date beginning;
    private Date end;

    Period(Date beginning, Date end){
        this.beginning = beginning;
        this.end = end;
    }

    public boolean isIncluded(Date date){
        if((date.after(beginning)&&date.before(end))||(date.equals(beginning))||(date.equals(end))){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public String toString() {
        return "Period{" +
                "beginning=" + beginning +
                ", end=" + end +
                '}';
    }
}
