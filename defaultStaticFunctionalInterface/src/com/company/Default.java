package com.company;

public interface Default {

    default String defaultMethod(){
        return "default";
    }
}
