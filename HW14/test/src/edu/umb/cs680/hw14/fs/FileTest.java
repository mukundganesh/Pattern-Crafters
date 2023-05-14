package edu.umb.cs680.hw14.fs;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class FileTest {
    protected static FileSystem f;

    @BeforeAll
    public static void createfsT() {
        f = testfixtures.createfs();
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