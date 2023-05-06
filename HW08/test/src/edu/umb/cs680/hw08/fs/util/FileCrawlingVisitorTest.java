package edu.umb.cs680.hw08.fs.util;

import edu.umb.cs680.hw08.fs.FileSystem;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FileCrawlingVisitorTest {

    protected static FileSystem f;

    @BeforeAll
    public static void createfsT(){
        f= testfixtures.createfs();
    }

    @Test
    public void filecrawlingtest(){
        FileCrawlingVisitor visitor = new FileCrawlingVisitor();
        f.getRootDirs().get(0).getSubDirectories().get(0).accept(visitor);
        assertEquals("a,b",visitor.getFiles().get(0).getname()+","+visitor.getFiles().get(1).getname());
        assertEquals(2,visitor.getFiles().size());
    }
}