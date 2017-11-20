package com.company;

public class Customer {
    private String name;
    private CustomerSchedule schedule;

    public Customer(String customerInfo) {
        String[] line = customerInfo.split("/");
        name = line[0].trim();
        schedule = new CustomerSchedule();
        for (int i = 1; i < line.length; i++) {
            schedule.addVisit(line[i]);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CustomerSchedule getSchedule() {
        return schedule;
    }

    public void setSchedule(CustomerSchedule schedule) {
        this.schedule = schedule;
    }
}
