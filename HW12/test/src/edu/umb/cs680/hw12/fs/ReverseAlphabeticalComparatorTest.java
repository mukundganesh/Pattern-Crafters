package edu.umb.cs680.hw12.fs;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class ReverseAlphabeticalComparatorTest {

    protected static FileSystem f;

    @BeforeAll
    public static void createfsT(){
        f= testfixtures.createfs();
    }

    @Test
    void reversealphabetcomparatortest(){
        LinkedList<FSElement> sortedlist=new LinkedList<FSElement>();
        sortedlist=f.getRootDirs().getFirst().getChildren(new ReverseAlphabeticalComparator());
        assertEquals("y,x,test,src,lib",sortedlist.get(0).getname()+","+sortedlist.get(1).getname()+","+sortedlist.get(2).getname()+","+sortedlist.get(3).getname()+","+sortedlist.get(4).getname());
    }

}