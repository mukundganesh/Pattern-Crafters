package edu.umb.cs680.hw08.fs.util;

import edu.umb.cs680.hw08.fs.FileSystem;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FileSearchVisitorTest {
    protected static FileSystem f;
    private String fileName;
    private String actual;

    @BeforeAll
    public static void createfsT(){
        f= testfixtures.createfs();
    }

    @Test
    public void getnooffilescount(){
        FileSearchVisitor visitor = new FileSearchVisitor("x");
        f.getRootDirs().getFirst().accept(visitor);
        assertEquals(visitor.getFoundFiles().size(), 1);
    }









}