package edu.umb.cs680.hw07;

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
        assertFalse(f.getRootDirs().get(0).getSubDirectories().get(0).getFiles().get(0).isDirectory());
    }

    @Test
    public void Isfiletest(){
        assertTrue(f.getRootDirs().get(0).getSubDirectories().get(0).getFiles().get(0).isFile());
        assertFalse(f.getRootDirs().getFirst().isFile());
    }

    @Test
    void isLinktest(){
        assertFalse(f.getRootDirs().getFirst().isLink());
        assertFalse(f.getRootDirs().get(0).getSubDirectories().get(0).getFiles().get(0).isLink());
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

    @Test
    void creationtimetest(){  String expected=new String(LocalDateTime.of(2023, 4, 24, 04, 20).toString());
        String actual= f.getRootDirs().getFirst().getSubDirectories().get(0).getFiles().get(0).getCreationtime().toString();
        assertEquals(expected,actual);
    }

}