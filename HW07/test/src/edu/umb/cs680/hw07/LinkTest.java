package edu.umb.cs680.hw07;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkTest {

    protected static FileSystem f;

    @BeforeAll
    public static void createfsT(){
        f= testfixtures.createfs();
    }


    @Test
    void Linksrc1test(){
        Link onlylink= (Link)f.getRootDirs().get(0).getChildren().get(4);
        assertEquals("src",onlylink.getTarget().getname());
    }


    @Test
    void isFiletest(){
        Link onlylink= (Link) f.getRootDirs().get(0).getChildren().get(4);
        assertFalse(onlylink.getTarget().isFile());
        assertFalse(onlylink.isFile());

    }

    @Test
    void isLinkTest(){
        assertTrue(f.getRootDirs().get(0).getChildren().get(4).isLink());
    }

    @Test
    void isDirectorytest(){
        Link onlylink= (Link)f.getRootDirs().get(0).getChildren().get(4);
        assertTrue(onlylink.getTarget().isDirectory());
        assertFalse(onlylink.isDirectory());
    }






}