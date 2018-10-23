package com.company;

public class PriorityAccount extends Account {

    private String name;
    private double cashbackValue;


    public PriorityAccount(int id, double balance, String name, double cashbackValue) {
        super(id, balance);
        this.name = name;
        this.cashbackValue = cashbackValue;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCashbackValue() {
        return cashbackValue;
    }

    public void setCashbackValue(double cashbackValue) {
        this.cashbackValue = cashbackValue;
    }

    @Override
    public void showInfo() {
        System.out.println(this.getName() + '\t' + this.getBalance() + '\t' + this.getCashbackValue());
    }
}
