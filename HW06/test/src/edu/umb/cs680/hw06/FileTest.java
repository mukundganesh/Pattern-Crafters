package edu.umb.cs680.hw06;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class FileTest {

    private File file;
    protected static FileSystem f;


    @BeforeAll
    public static void createfsT(){
        f= testfixtures.createfs();
    }


    @Test
    public void Isdirectorytest(){
        createfsT();
        assertTrue(f.getRootDirs().getFirst().isDirectory());
        assertFalse(f.getRootDirs().get(0).getSubDirectories().get(0).getFiles().get(0).isDirectory());
    }

    @Test
    public void Isfiletest(){
        createfsT();
        assertTrue(f.getRootDirs().get(0).getSubDirectories().get(0).getFiles().get(0).isFile());
        assertFalse(f.getRootDirs().getFirst().isFile());
    }

    private String[] Filetostringarray(File file){

        String[] fileinfo={file.getParent().getname().toString(),file.getname().toString(),String.valueOf(file.getSize()),file.getCreationtime().toString()
        };
        return fileinfo;
    }

    @Test
    void equalitychecktestforfilea(){
        String[] expected=new String[]{"src","a","100", LocalDateTime.of(2023, 4, 24, 04, 20).toString()};
        File actual= f.getRootDirs().getFirst().getSubDirectories().get(0).getFiles().get(0);
        assertArrayEquals(expected,Filetostringarray(actual));
    }



}