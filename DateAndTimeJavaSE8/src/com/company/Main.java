package com.company;

import java.time.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Clock clock = Clock.systemUTC();
        System.out.println("Local date: " + LocalDate.now());
        System.out.println("Local date form clock: " + LocalDate.now(clock));
        System.out.println();
        System.out.println("Local time: " + LocalTime.now());
        System.out.println("Local time from clock: " + LocalTime.now(clock));
        System.out.println();
        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDateTime localDateTime1Clock = LocalDateTime.now(clock);
        System.out.println("Local date time: " + localDateTime);
        System.out.println("Local date time from clock: " + localDateTime1Clock);
        System.out.println();
        System.out.println("Zoned date time: " + ZonedDateTime.now());
        System.out.println("Zoned date time from clock: " + ZonedDateTime.now(clock));
        System.out.println("Zoned date time from config: " + ZonedDateTime.now(ZoneId.systemDefault()));
        System.out.println();
        Duration duration = Duration.between(localDateTime, localDateTime1Clock);
        System.out.println("Difference between MSK and +0UTC: " + duration.toDays() + " or " + duration.toHours());
    }
}
