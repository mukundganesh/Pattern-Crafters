package edu.umb.cs680.hw07;

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
    }
    }
