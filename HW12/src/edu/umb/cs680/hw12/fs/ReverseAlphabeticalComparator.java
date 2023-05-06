package edu.umb.cs680.hw12.fs;

import java.util.Comparator;

public class ReverseAlphabeticalComparator implements Comparator<FSElement> {

    @Override
    public int compare(FSElement o1, FSElement o2) {
        return o2.getname().compareTo(o1.getname());
    }
}

