package ru.job4j.collection;

import java.util.Comparator;

public class DepartmentsDescComparator implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        String leftTop = left.split("/")[0];
        String rightTop = right.split("/")[0];
        int result = rightTop.compareTo(leftTop);
        return result != 0 ? result : left.compareTo(right);
    }
}