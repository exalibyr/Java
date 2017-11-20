package com.company;

import java.time.DayOfWeek;
import java.util.Map;

public class EmployeeSchedule {
    private Map<DayOfWeek, WorkingTime> schedule;

    public EmployeeSchedule(Map<DayOfWeek, WorkingTime> schedule) {
        this.schedule = schedule;
    }

    public Map<DayOfWeek, WorkingTime> getSchedule() {
        return schedule;
    }

    public void setSchedule(Map<DayOfWeek, WorkingTime> schedule) {
        this.schedule = schedule;
    }
}
