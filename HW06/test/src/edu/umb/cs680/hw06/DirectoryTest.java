package edu.umb.cs680.hw06;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.management.StringValueExp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class DirectoryTest {

    protected static FileSystem f;

    private Directory d;
    @BeforeAll
    public static void createfsT(){
        f= testfixtures.createfs();
    }



    @Test
    void isChildrenTest(){
        createfsT();
        assertEquals(4,f.getRootDirs().getFirst().getChildren().size());
    }

    @Test
    void Subdirectorytest(){
        createfsT();
        String actual=f.getRootDirs().getFirst().getSubDirectories().get(0).getname()+","+f.getRootDirs().getFirst().getSubDirectories().get(1).getname()+","+f.getRootDirs().getFirst().getSubDirectories().get(2).getname();
        assertEquals("src,lib,test",actual);
    }

    @Test
    void countchildtest(){
        createfsT();
        assertEquals(4,f.getRootDirs().getFirst().countChild());
    }
    @Test
    void getfilestest(){
        createfsT();
        String actual=f.getRootDirs().get(0).getSubDirectories().get(0).getFiles().get(0).getname()+","+f.getRootDirs().get(0).getSubDirectories().get(0).getFiles().get(1).getname();
        assertEquals("a,b",actual);
    }

    @Test
    void totalsizetest(){
        createfsT();
        assertEquals(1010,f.getRootDirs().get(0).getTotalSize());
    }

    @Test
    void isDirectorytest(){
        createfsT();
        assertTrue(f.getRootDirs().getFirst().isDirectory());
        assertFalse(f.getRootDirs().get(0).getSubDirectories().get(0).getFiles().get(0).isDirectory());
    }

    @Test
    void isFiletest(){
        createfsT();
        assertTrue(f.getRootDirs().get(0).getSubDirectories().get(0).getFiles().get(0).isFile());
        assertFalse(f.getRootDirs().getFirst().isFile());
    }

    private String[] directorytostringarray(Directory d){

        String[] dirinfo={d.getParent().getname().toString(),d.getname().toString(),String.valueOf(d.getSize()),d.getCreationtime().toString()
        };
        return dirinfo;
    }

    @Test
    void equalitychecktestforsrcdir(){
            String[] expected=new String[]{"prjRoot","src","0",LocalDateTime.of(2023, 4, 24, 02, 20).toString()};
            Directory actual= f.getRootDirs().getFirst().getSubDirectories().get(0);
            assertArrayEquals(expected,directorytostringarray(actual));
        }

    @Test
    void equalitychecktestforlib(){
        String[] expected=new String[]{"prjRoot","lib","0",LocalDateTime.of(2023, 4, 24, 03, 20).toString()};
        Directory actual= f.getRootDirs().getFirst().getSubDirectories().get(1);
        assertArrayEquals(expected,directorytostringarray(actual));
    }
}

