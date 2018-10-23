package com.company;

import java.util.Comparator;

public class AutoYearComparator implements Comparator<Auto> {
    @Override
    public int compare(Auto o1, Auto o2) {
        return o1.getYear() - o2.getYear();
    }
}
