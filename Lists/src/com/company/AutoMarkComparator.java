package com.company;

import java.util.Comparator;

public class AutoMarkComparator implements Comparator<Auto> {
    @Override
    public int compare(Auto o1, Auto o2) {
        return o1.getMark().compareTo(o2.getMark());
    }
}
