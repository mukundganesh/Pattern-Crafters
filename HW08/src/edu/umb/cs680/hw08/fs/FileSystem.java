package edu.umb.cs680.hw08.fs;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.Objects;

public class FileSystem {

    private static FileSystem fileSysteminstance=null;
    private LinkedList<Directory> rootDirs;

    private FileSystem() {
        this.rootDirs = new LinkedList<>();
    }

    public static FileSystem getFileSystem() {

        try {
            return Objects.requireNonNull(fileSysteminstance);
        } catch (NullPointerException ex) {
            fileSysteminstance = new FileSystem();
            return fileSysteminstance;
        }
    }

    public LinkedList<Directory> getRootDirs() {
        return rootDirs;
    }

    public void appendRootDir(Directory root) {
        rootDirs.add(root);
    }


    public static void main(String[] args) {
        FileSystem fileSystem= FileSystem.getFileSystem();
        Directory prjrootRoot= new Directory(null,"prjRoot",0, LocalDateTime.now());
        Directory src= new Directory(prjrootRoot,"src",0, LocalDateTime.now());
        Directory lib= new Directory(prjrootRoot,"lib",0, LocalDateTime.now());
        Directory test= new Directory(prjrootRoot,"test",0, LocalDateTime.now());
        Directory src1= new Directory(test,"src",0, LocalDateTime.now());
        File x=new File(prjrootRoot,"x",10,LocalDateTime.now());
        File a=new File(src,"a",100,LocalDateTime.now());
        File b=new File(src,"b",200,LocalDateTime.now());
        File c=new File(lib,"c",300,LocalDateTime.now());
        File d=new File(lib,"d",400,LocalDateTime.now());
    }
    }
