package com.company;

public class Vasya implements Cloneable {
    private String state;

    public Vasya(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    protected Vasya clone() throws CloneNotSupportedException {
        return ((Vasya) super.clone());
    }

}
