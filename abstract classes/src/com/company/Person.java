package com.company;

class Person extends Human{

    private String name;

    Person(float height, float weight, String name){
        super(height, weight);
        this.name = name;
    }

    @Override
    void showInfo() {
        System.out.println(this.name);
        System.out.println(getHeight());
        System.out.println(getWeight());
    }
}
