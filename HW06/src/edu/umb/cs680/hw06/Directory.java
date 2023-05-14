package edu.umb.cs680.hw06;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.stream.Collectors;

public class Directory extends FSElement{

    public Directory(Directory parent, String name, Integer size, LocalDateTime creationTime) {
        super(parent, name, 0, creationTime);
    }

    private LinkedList<FSElement> children = new LinkedList<>();

    public LinkedList<FSElement> getChildren() {
        return this.children;
    }

    public LocalDateTime getCreationtime(){
        return this.creationTime;
    }

    public void appendChild(FSElement appendChild){
        this.children.add(appendChild);
    }

    public int countChild(){
        return this.children.size();
    }


    public LinkedList<File> getFiles() {
        LinkedList<File> files = new LinkedList<File>();
        for (FSElement fs : children) {
            if (fs instanceof File) {
                files.add((File) fs);
            }
        }
        return files;
    }

    public LinkedList<Directory> getSubDirectories(){

        LinkedList<Directory> subDirectories= new LinkedList<Directory>();

        for(FSElement fs:children){
            if(fs instanceof Directory){
                subDirectories.add((Directory) fs);
            }
        }

        return subDirectories;
    }

    public int getTotalSize() {
        int totalSize = 0;
        for (FSElement fs : children) {
            if (fs instanceof File) {
                totalSize += ((File) fs).getSize();
            } else if (fs instanceof Directory) {
                totalSize += ((Directory) fs).getTotalSize();
            }
        }
        return totalSize;
    }

    @Override
    public boolean isDirectory() {
        return true;
    }

    @Override
    public boolean isFile(){
        return false;
    }



}
