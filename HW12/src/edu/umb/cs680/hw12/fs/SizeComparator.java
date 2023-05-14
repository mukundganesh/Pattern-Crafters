package edu.umb.cs680.hw12.fs;

import java.util.Comparator;

public class SizeComparator implements Comparator<FSElement> {
    @Override
    public int compare(FSElement o1, FSElement o2) {
        Integer o1size=o1.getSize();
        Integer o2size=o2.getSize();
        return o1size.compareTo(o2size);
    }
}
