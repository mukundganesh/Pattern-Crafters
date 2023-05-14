package edu.umb.cs680.hw12.fs;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class FileSystem {

    private static FileSystem fileSysteminstance=null;
    private LinkedList<Directory> rootDirs= new LinkedList<>();;

    private FileSystem() {
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

    }
    }
