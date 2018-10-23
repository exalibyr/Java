package com.company;

public class FreeAccount extends Account {

    private String name;
    private double cashbackValue;


    public FreeAccount(int id, double balance, String name) {
        super(id, balance);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public void showInfo() {
        System.out.println(this.getName() + '\t' + this.getBalance());
    }
}
