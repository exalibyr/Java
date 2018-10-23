package com.company;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
	// write your code here
        regex1();
        regex2();
        patterClass();
        matcherClass();
        regex3();
        ownExpl();
    }

    static void regex1(){
        String text = "FIFA will never regret it";
        String[] words = text.split("\\s*(\\s|,|!|\\.)\\s*");
        for(String word : words){
            System.out.println(word);
        }
    }
    static void regex2() {
        String input = "+12343454556";
        if (input.matches("(\\+*)\\d{11}")) {
            System.out.println("It is a phone number");
        } else {
            System.out.println("It is not a phone number!");
        }
    }
    static void patterClass(){
        String input = "Hello";
        boolean found = Pattern.matches("Hello", input);
        //second option
        //input.matches("Hello");
        if(found)
            System.out.println("Найдено");
        else
            System.out.println("Не найдено");
    }
    static void matcherClass(){
        String input = "Hello Java! Hello JavaScript! JavaSE 8.";
        Pattern pattern = Pattern.compile("Java(\\w*)");
        Matcher matcher = pattern.matcher(input);
        while(matcher.find())
            System.out.println(matcher.group());
        System.out.println(matcher.replaceAll("java"));

        //second option
        System.out.println(input.replaceAll("Java(\\w*)", "java"));
    }
    static void regex3(){
        String input = "Hello Java! Hello JavaScript! JavaSE 8.";
        Pattern pattern = Pattern.compile("[ ,.!?]");
        String[] words = pattern.split(input);
        for(String word:words)
            System.out.print(word + "\t");
        System.out.print("\n");
        //more precisely via regex
        pattern = Pattern.compile("\\s*(\\s|!|,|\\.)\\s*");
        for(String word : pattern.split(input)){
            System.out.print(word + "\t");
        }
    }

    static void ownExpl(){
        String input = "What are u doing m8?";
        Pattern pattern = Pattern.compile("\\d");
        Matcher matcher = pattern.matcher(input);
        if(matcher.find()){
            int x = Integer.valueOf(matcher.group());
            System.out.println(x++);
            System.out.println(x);
        }
    }
}
