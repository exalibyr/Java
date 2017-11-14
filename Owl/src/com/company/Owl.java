package com.company;

public class Owl {
    private String name;
    private int age;
    private String breed;
    Owl(String name){
        this.name = name;
    }
    public void hunting(){
        System.out.println(getName() + " owl is hunting now");
    }
    public void eating(){
        System.out.println(getName() + " owl is eating now");
    }
    public void sleeping(){
        System.out.println(getName() + " owl is sleeping now");
    }
    private String getName() {
        return name;
    }

//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public int getAge() {
//        return age;
//    }
//
//    public void setAge(int age) {
//        this.age = age;
//    }
//
//    public String getBreed() {
//        return breed;
//    }
//
//    public void setBreed(String breed) {
//        this.breed = breed;
//    }
}
