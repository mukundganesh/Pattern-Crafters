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
    public void filecount(){
        FileCrawlingVisitor visitor = new FileCrawlingVisitor();
        f.getRootDirs().get(0).getSubDirectories().get(0).accept(visitor);
        assertEquals(2,visitor.getFiles().size());
    }
}