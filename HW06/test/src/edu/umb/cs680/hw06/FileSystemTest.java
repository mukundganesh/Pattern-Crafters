package edu.umb.cs680.hw06;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

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
    
    @Test
    void appednroottest(){
        FileSystem fsyst1 = FileSystem.getFileSystem();
        Directory roottest=new Directory(null,"Test",0,LocalDateTime.now());
        fsyst1.appendRootDir(roottest);
        assertEquals("Test",fsyst1.getRootDirs().get(1).getname());
    }
}
