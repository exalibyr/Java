package com.company;

import java.time.DayOfWeek;
import java.util.Map;

public class CustomerSchedule {
    private Map<DayOfWeek, Integer> schedule;

    public Map<DayOfWeek, Integer> getSchedule() {
        return schedule;
    }

    public void addVisit(String time){
        String[] visit = time.split(",");
        visit[0] = visit[0].trim();
        switch (visit[0]){
            case "Monday":{
                schedule.put(DayOfWeek.MONDAY, Integer.parseInt(visit[1].trim().substring(0, 2)));
                break;
            }
            case "Tuesday":{
                schedule.put(DayOfWeek.TUESDAY, Integer.parseInt(visit[1].trim().substring(0, 2)));
                break;
            }
            case "Wednesday":{
                schedule.put(DayOfWeek.WEDNESDAY, Integer.parseInt(visit[1].trim().substring(0, 2)));
                break;
            }
            case "Thursday":{
                schedule.put(DayOfWeek.THURSDAY, Integer.parseInt(visit[1].trim().substring(0, 2)));
                break;
            }
            case "Friday":{
                schedule.put(DayOfWeek.FRIDAY, Integer.parseInt(visit[1].trim().substring(0, 2)));
                break;
            }
            case "Saturday":{
                schedule.put(DayOfWeek.SATURDAY, Integer.parseInt(visit[1].trim().substring(0, 2)));
                break;
            }
            case "Sunday":{
                schedule.put(DayOfWeek.SUNDAY, Integer.parseInt(visit[1].trim().substring(0, 2)));
                break;
            }
            default:{
                System.out.println("Incorrect day of week! Nothing was added!");
                break;
            }
        }
    }
}
