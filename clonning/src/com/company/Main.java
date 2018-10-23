package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Vasya vasya = new Vasya("Pupkin");
        try{
            Vasya vasya1 = vasya.clone();
            vasya1.setState("Pumpkin");
            System.out.println(vasya.getState());
            System.out.println(vasya1.getState());
        }
        catch (CloneNotSupportedException ex){
            ex.printStackTrace();
        }

    }
}
