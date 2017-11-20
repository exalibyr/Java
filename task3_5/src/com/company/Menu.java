package com.company;

import java.util.List;

public class Menu {

    private List<Salad> salads;
    private List<Garnish> garnishes;
    private List<Snack> snacks;
    private List<Starter> starters;
    private List<Dessert> desserts;

    public List<Salad> getSalads() {
        return salads;
    }

    public void setSalads(List<Salad> salads) {
        this.salads = salads;
    }

    public List<Garnish> getGarnishes() {
        return garnishes;
    }

    public void setGarnishes(List<Garnish> garnishes) {
        this.garnishes = garnishes;
    }

    public List<Snack> getSnacks() {
        return snacks;
    }

    public void setSnacks(List<Snack> snacks) {
        this.snacks = snacks;
    }

    public List<Starter> getStarters() {
        return starters;
    }

    public void setStarters(List<Starter> starters) {
        this.starters = starters;
    }

    public List<Dessert> getDesserts() {
        return desserts;
    }

    public void setDesserts(List<Dessert> desserts) {
        this.desserts = desserts;
    }

}
