package edu.umb.cs680.hw12.fs;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class TimeStampComparatorTest {
    protected static FileSystem f;

    @BeforeAll
    public static void createfsT(){
        f= testfixtures.createfs();
    }

    @Test
    void timestampcomparisiontestgetchildren(){
        LinkedList<FSElement> sortedlist= new LinkedList<>();
        sortedlist=(f.getRootDirs().getFirst().getChildren(new TimeStampComparator()));
        assertEquals("test,src,lib,x,y",sortedlist.get(0).getname()+","+sortedlist.get(1).getname()+","+sortedlist.get(2).getname()+","+sortedlist.get(3).getname()+","+sortedlist.get(4).getname());
    }
    @Test
    void timestampcomparisiontestgetsubdirs(){
        LinkedList<Directory> sortedlist= new LinkedList<Directory>();
        sortedlist=(f.getRootDirs().getFirst().getSubDirectories(new TimeStampComparator()));
        assertEquals("test,src,lib",sortedlist.get(0).getname()+","+sortedlist.get(1).getname()+","+sortedlist.get(2).getname());
    }

    @Test
    void timestampcomparisiontestgetfiles(){
        LinkedList<File> sortedlist= new LinkedList<File>();
        sortedlist=(f.getRootDirs().getFirst().getSubDirectories().get(1).getFiles(new TimeStampComparator()));
        assertEquals("a,b",sortedlist.get(0).getname()+","+sortedlist.get(1).getname());
    }





}