package com.company;

import java.util.ArrayList;
import java.util.List;

public class Notificator {

    public static void showTasks(List<Task> tasks, Period period){
        System.out.println(period.toString() + '\n');
        List<Task> tasksOut = new ArrayList<>();
        for(Task task : tasks){
            if(DateChecker.isIncluded (period, task.getDate()) ){
                tasksOut.add(task);
            }
        }
        if(tasksOut.isEmpty()){
            System.out.println("Nothing was found giving inputted period!");
        }
        else{
            System.out.println(tasksOut);
        }
    }

}
