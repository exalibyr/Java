package com.company;

import java.util.Date;

public class DateChecker { //checker to check if date is inside the period

    public static boolean isIncluded(Period period, Date date){
        if((date.after(period.getBeginning())
                &&date.before(period.getEnd()))
                ||(date.equals(period.getBeginning()))
                ||(date.equals(period.getEnd()))){
            return true;
        }
        else{
            return false;
        }
    }
}
