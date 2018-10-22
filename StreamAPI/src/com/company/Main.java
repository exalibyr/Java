package com.company;

import java.util.Arrays;
import java.util.Collection;

public class Main {

    public static void main(String[] args) {
	// write your code here

        Collection<Task> tasks = Arrays.asList(
                new Task(Status.OPEN, 5),
                new Task(Status.OPEN, 10),
                new Task(Status.CLOSED, 9),
                new Task(Status.OPEN, 3)
        );
        double pointsSum = tasks
                .stream()
                .filter(task -> task.status == Status.OPEN)
                .parallel()
                .map(Task::getDifficulty)
                .reduce(0, Integer::sum);
        tasks
                .stream()
                .filter(task -> task.status == Status.OPEN)
                .parallel()
                .map(task -> task.difficulty / pointsSum)
                .map(difficulty -> Math.round(difficulty * 100) + "%")
                .forEach(System.out::println);
    }
    private enum Status{
        OPEN, CLOSED
    }

    private static final class Task{
        private final Status status;
        private final Integer difficulty;

        public Task(Status status, Integer difficulty) {
            this.status = status;
            this.difficulty = difficulty;
        }

        public Status getStatus() {
            return status;
        }

        public Integer getDifficulty() {
            return difficulty;
        }

        @Override
        public String toString() {
            return "Task{" +
                    "status=" + status +
                    ", difficulty=" + difficulty +
                    '}';
        }
    }
}
