package com.company;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FormatConverter { //объект класса формирует из строки дату по установленному формату
    private SimpleDateFormat format;

    public void setFormat(SimpleDateFormat format) {
        this.format = format;
    }

    public Date format(String time) {
        try{
            return format.parse(time);
        }catch (ParseException ex){
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }
}
