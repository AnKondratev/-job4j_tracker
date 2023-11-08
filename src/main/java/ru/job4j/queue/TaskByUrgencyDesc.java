package ru.job4j.queue;

import java.util.Comparator;

public class TaskByUrgencyDesc implements Comparator<Task> {
    @Override
    public int compare(Task o1, Task o2) {
        Integer u2 = o2.urgency();
        return u2.compareTo(o1.urgency());
    }
}