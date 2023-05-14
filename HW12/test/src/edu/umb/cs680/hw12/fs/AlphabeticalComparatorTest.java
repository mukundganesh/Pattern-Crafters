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
    void alphabetcomparatortestgetchidren(){
        LinkedList<FSElement> sortedlist=new LinkedList<FSElement>();
        sortedlist=f.getRootDirs().getFirst().getChildren();
        assertEquals("lib,src,test,x,y",sortedlist.get(0).getname()+","+sortedlist.get(1).getname()+","+sortedlist.get(2).getname()+","+sortedlist.get(3).getname()+","+sortedlist.get(4).getname());
        //System.out.println(sortedlist.get(0).getname()+","+sortedlist.get(1).getname()+","+sortedlist.get(2).getname()+","+sortedlist.get(3).getname()+","+sortedlist.get(4).getname());
    }

    @Test
    void alphabetcomparatortestgetsubdirs(){
        LinkedList<Directory> sortedlist=new LinkedList<Directory>();
        sortedlist=f.getRootDirs().getFirst().getSubDirectories();
        //System.out.println(sortedlist);
        assertEquals("lib,src,test",sortedlist.get(0).getname()+","+sortedlist.get(1).getname()+","+sortedlist.get(2).getname());
        //System.out.println(sortedlist.get(0).getname()+","+sortedlist.get(1).getname()+","+sortedlist.get(2).getname()+","+sortedlist.get(3).getname()+","+sortedlist.get(4).getname());
    }

    @Test
    void alphabetcomparatortestgetfiles(){
        LinkedList<File> sortedlist=new LinkedList<File>();
        sortedlist=f.getRootDirs().getFirst().getSubDirectories().get(1).getFiles();
        assertEquals("a,b",sortedlist.get(0).getname()+","+sortedlist.get(1).getname());
        //System.out.println(sortedlist.get(0).getname()+","+sortedlist.get(1).getname()+","+sortedlist.get(2).getname()+","+sortedlist.get(3).getname()+","+sortedlist.get(4).getname());
    }


}