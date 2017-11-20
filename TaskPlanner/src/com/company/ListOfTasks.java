package com.company;

import java.util.ArrayList;
import java.util.List;

public class ListOfTasks {

    private List<Task> tasks;

    ListOfTasks(List<Task> tasks){
        this.tasks = new ArrayList<>(tasks);
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
}
