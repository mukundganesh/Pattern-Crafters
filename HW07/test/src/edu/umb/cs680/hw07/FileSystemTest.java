package edu.umb.cs680.hw07;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

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
        assertSame(fsyst1,fsyst2);
    }

    @Test
    void FileSysrootdirtest(){
        FileSystem fsyst1 = FileSystem.getFileSystem();
        assertEquals("prjRoot",fsyst1.getRootDirs().getFirst().getname());
    }

    @Test
    void append_root_dir_test(){
        FileSystem fsyst1 = FileSystem.getFileSystem();
        Directory test=new Directory(null,"test",0, LocalDateTime.now());
        fsyst1.appendRootDir(test);
        assertEquals(test.getname(),fsyst1.getRootDirs().getLast().getname());
    }


}