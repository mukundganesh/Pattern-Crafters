package edu.umb.cs680.hw08.fs.util;

import edu.umb.cs680.hw08.fs.FileSystem;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CountingVisitorTest {

    protected static FileSystem f;

    @BeforeAll
    public static void createfsT(){
        f= testfixtures.createfs();
    }

    @Test
    void getcountlinkinfs(){

        CountingVisitor visitor=new CountingVisitor();
        f.getRootDirs().getFirst().accept(visitor);
        assertEquals(1,visitor.getLinkNum());
    }

    @Test
    void getcountdirnum(){
        CountingVisitor visitor=new CountingVisitor();
        f.getRootDirs().getFirst().accept(visitor);
        assertEquals(10,visitor.getDirNum());
    }

    @Test
    void getcountfilenum(){
        CountingVisitor visitor=new CountingVisitor();
        f.getRootDirs().getFirst().accept(visitor);
        assertEquals(5,visitor.getFileNum());
    }





}