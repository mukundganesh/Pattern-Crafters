package edu.umb.cs680.hw07;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FileSystemTest {
    protected static FileSystem f;

    @BeforeAll
    public static void createfsT(){
        f= testfixtures.createfs();
    }

    @Test
    void FilesystemSingletontest() {
        FileSystem fsyst1 = FileSystem.getFileSystem();
        FileSystem fsyst2 = FileSystem.getFileSystem();
        assertEquals(fsyst1.hashCode(), fsyst2.hashCode());
    }

    @Test
    void FileSysrootdirtest(){
        FileSystem fsyst1 = FileSystem.getFileSystem();
        assertEquals("prjRoot",fsyst1.getRootDirs().getFirst().getname());
    }
}