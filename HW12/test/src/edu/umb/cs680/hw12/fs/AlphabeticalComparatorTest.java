package edu.umb.cs680.hw12.fs;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class AlphabeticalComparatorTest {

    protected static FileSystem f;

    @BeforeAll
    public static void createfsT(){
        f= testfixtures.createfs();
    }

    @Test
    void alphabetcomparatortest(){
        LinkedList<FSElement> sortedlist=new LinkedList<FSElement>();
        sortedlist=f.getRootDirs().getFirst().getChildren(new AlphabeticalComparator());
        assertEquals("lib,src,test,x,y",sortedlist.get(0).getname()+","+sortedlist.get(1).getname()+","+sortedlist.get(2).getname()+","+sortedlist.get(3).getname()+","+sortedlist.get(4).getname());
        //System.out.println(sortedlist.get(0).getname()+","+sortedlist.get(1).getname()+","+sortedlist.get(2).getname()+","+sortedlist.get(3).getname()+","+sortedlist.get(4).getname());
    }
}