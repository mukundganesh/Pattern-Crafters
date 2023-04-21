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



}