package edu.umb.cs680.hw14.fs;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class DirectoryTest {
    protected static FileSystem f;

    @BeforeAll
    public static void createfsT() {
        f = testfixtures.createfs();
    }


    @Test
    void alphabetcomparatortestgetchildren() {
        LinkedList<FSElement> sortedlist = new LinkedList<FSElement>();
        //Comparator<FSElement> comparator = Comparator.comparing(FSElement::getname);
        sortedlist = f.getRootDirs().getFirst().getChildren();
        assertEquals("lib,src,test,x,y", sortedlist.get(0).getname() + "," + sortedlist.get(1).getname() + "," + sortedlist.get(2).getname() + "," + sortedlist.get(3).getname() + "," + sortedlist.get(4).getname());
    }

    @Test
    void reversealphabetcomparatortestgetchildren() {
        LinkedList<FSElement> sortedlist = new LinkedList<FSElement>();
        Comparator<FSElement> comparator = Comparator.comparing(FSElement::getname).reversed();
        sortedlist = f.getRootDirs().getFirst().getChildren(comparator);
        assertEquals("y,x,test,src,lib", sortedlist.get(0).getname() + "," + sortedlist.get(1).getname() + "," + sortedlist.get(2).getname() + "," + sortedlist.get(3).getname() + "," + sortedlist.get(4).getname());
        //System.out.println(sortedlist.get(0).getname()+","+sortedlist.get(1).getname()+","+sortedlist.get(2).getname()+","+sortedlist.get(3).getname()+","+sortedlist.get(4).getname());
    }

    @Test
    void timestampcomparisiontestgetchildren(){
        LinkedList<FSElement> sortedlist= new LinkedList<>();
        Comparator<FSElement> comparator = Comparator.comparing(FSElement::getCreationtime);
        sortedlist=(f.getRootDirs().getFirst().getChildren(comparator));
        assertEquals("test,src,lib,x,y",sortedlist.get(0).getname()+","+sortedlist.get(1).getname()+","+sortedlist.get(2).getname()+","+sortedlist.get(3).getname()+","+sortedlist.get(4).getname());
    }

    @Test
    void reversetimestampcomparisiontestgetchildren(){
        LinkedList<FSElement> sortedlist= new LinkedList<>();
        Comparator<FSElement> comparator = Comparator.comparing(FSElement::getCreationtime).reversed();
        sortedlist=(f.getRootDirs().getFirst().getChildren(comparator));
        assertEquals("y,x,lib,src,test",sortedlist.get(0).getname()+","+sortedlist.get(1).getname()+","+sortedlist.get(2).getname()+","+sortedlist.get(3).getname()+","+sortedlist.get(4).getname());
    }

    @Test
    void alphabetcomparatortestgetsubdirs() {
        LinkedList<Directory> sortedlist = new LinkedList<Directory>();
        Comparator<FSElement> comparator = Comparator.comparing(FSElement::getname);
        sortedlist = f.getRootDirs().getFirst().getSubDirectories(comparator);
        assertEquals("lib,src,test", sortedlist.get(0).getname() + "," + sortedlist.get(1).getname() + "," + sortedlist.get(2).getname());

    }

    @Test
    void reversealphabetcomparatortestgetsubdirs() {
        LinkedList<Directory> sortedlist = new LinkedList<Directory>();
        Comparator<FSElement> comparator = Comparator.comparing(FSElement::getname).reversed();
        sortedlist = f.getRootDirs().getFirst().getSubDirectories(comparator);
        assertEquals("test,src,lib", sortedlist.get(0).getname() + "," + sortedlist.get(1).getname() + "," + sortedlist.get(2).getname());

    }

    @Test
    void timestampcomparisiontestgetsubdirs(){
        LinkedList<Directory> sortedlist= new LinkedList<Directory>();
        Comparator<FSElement> comparator = Comparator.comparing(FSElement::getCreationtime);
        sortedlist=(f.getRootDirs().getFirst().getSubDirectories(comparator));
        assertEquals("test,src,lib",sortedlist.get(0).getname()+","+sortedlist.get(1).getname()+","+sortedlist.get(2).getname());
    }

    @Test
    void reversetimestampcomparisiontestgetsubdirs(){
        LinkedList<Directory> sortedlist= new LinkedList<Directory>();
        Comparator<FSElement> comparator = Comparator.comparing(FSElement::getCreationtime).reversed();
        sortedlist=(f.getRootDirs().getFirst().getSubDirectories(comparator));
        assertEquals("lib,src,test",sortedlist.get(0).getname()+","+sortedlist.get(1).getname()+","+sortedlist.get(2).getname());
    }

    @Test
    void alphabetcomparatortestgetfiles() {
        LinkedList<File> sortedlist = new LinkedList<File>();
        Comparator<FSElement> comparator = Comparator.comparing(FSElement::getname);
        sortedlist = f.getRootDirs().getFirst().getSubDirectories().get(1).getFiles(comparator);
        assertEquals("a,b", sortedlist.get(0).getname() + "," + sortedlist.get(1).getname());
    }

    @Test
    void reversealphabetcomparatortestgetfiles() {
        LinkedList<File> sortedlist = new LinkedList<File>();
        Comparator<FSElement> comparator = Comparator.comparing(FSElement::getname).reversed();
        sortedlist = f.getRootDirs().getFirst().getSubDirectories().get(1).getFiles(comparator);
        assertEquals("b,a", sortedlist.get(0).getname() + "," + sortedlist.get(1).getname());
    }

    @Test
    void timestampcomparisiontestgetfiles() {
        LinkedList<File> sortedlist = new LinkedList<File>();
        Comparator<FSElement> comparator = Comparator.comparing(FSElement::getCreationtime);
        sortedlist = (f.getRootDirs().getFirst().getSubDirectories().get(1).getFiles(comparator));
        assertEquals("a,b", sortedlist.get(0).getname() + "," + sortedlist.get(1).getname());
    }

    @Test
    void reversetimestampcomparisiontestgetfiles() {
        LinkedList<File> sortedlist = new LinkedList<File>();
        Comparator<FSElement> comparator = Comparator.comparing(FSElement::getCreationtime).reversed();
        sortedlist = (f.getRootDirs().getFirst().getSubDirectories().get(1).getFiles(comparator));
        assertEquals("b,a", sortedlist.get(0).getname() + "," + sortedlist.get(1).getname());


    }
}

