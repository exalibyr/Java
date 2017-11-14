package com.company;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FormatConverter {
    private SimpleDateFormat format;
//    FormatConverter(){
//        format = new SimpleDateFormat("dd.MM.yyyy HH:mm");
//    }

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
