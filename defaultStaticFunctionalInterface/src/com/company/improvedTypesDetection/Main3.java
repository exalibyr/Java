package com.company.improvedTypesDetection;

import java.util.Scanner;

public class Main3 {

    public static void main(String[] args) {
        final Value< String > value = new Value<>();
        String s = value.getOrDefault( "sfdfdsf", Value.defaultValue() );   //not necessary to input type <String>
        System.out.println(s);
    }



}
class Value< T > {
   static<T> T defaultValue() {
        return null;
    }

    T getOrDefault( T value, T defaultValue ) {
        return ( value != null ) ? value : defaultValue;
    }
}