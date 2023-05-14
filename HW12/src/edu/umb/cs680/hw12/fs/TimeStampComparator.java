package edu.umb.cs680.hw12.fs;

import java.util.Comparator;

public class TimeStampComparator implements Comparator<FSElement> {

    @Override
    public int compare(FSElement o1, FSElement o2) {
        return o1.getCreationtime().compareTo(o2.getCreationtime());
    }
}
