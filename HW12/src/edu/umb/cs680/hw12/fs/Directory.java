package edu.umb.cs680.hw12.fs;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.stream.Collectors;

public class Directory extends FSElement{

    public Directory(Directory parent, String name, Integer size, LocalDateTime creationTime) {
        super(parent, name, 0, creationTime);
    }

    private LinkedList<FSElement> children = new LinkedList<>();

    public LinkedList<FSElement> getChildren() {
        Collections.sort(this.children,new AlphabeticalComparator());
        return this.children;
    }

    //Comparator
    public LinkedList<FSElement> getChildren(Comparator <FSElement> fsElementComparator) {
        LinkedList<FSElement> children=getChildren();
        Collections.sort(children,fsElementComparator);
        return this.children;
    }

    public void appendChild(FSElement appendChild){
        this.children.add(appendChild);
    }

    public int countChild(){
        return this.children.size();
    }

    public LinkedList<Directory> getSubDirectories(){
        LinkedList<Directory> subDirectories = getChildren().stream().filter(FSElement::isDirectory)
                .map(d -> (Directory) d).collect(Collectors.toCollection(LinkedList::new));
        Collections.sort(subDirectories,new AlphabeticalComparator());
        return subDirectories;
    }
//Comparator
    public LinkedList<Directory> getSubDirectories(Comparator<FSElement> fsElementComparator){
        LinkedList<Directory> tobesortedsubdirs=getSubDirectories();
        Collections.sort(tobesortedsubdirs,fsElementComparator);
        return tobesortedsubdirs;
    }

    public LinkedList<File> getFiles(){

        LinkedList<File> files= getChildren().stream().filter(FSElement::isFile)
                .map(f -> (File) f).
                collect(Collectors.toCollection(LinkedList::new));
        Collections.sort(files,new AlphabeticalComparator());
        return  files;
    }

//Comparator
    public LinkedList<File> getFiles(Comparator<FSElement> fsElementComparator){

        LinkedList<File> tobesortedfiles=getFiles();
        Collections.sort(tobesortedfiles,fsElementComparator);
        return tobesortedfiles;
    }

    public int getTotalSize() {
        int totalSize = 0;
        for (FSElement element : children) {
            if (element instanceof File) {
                totalSize += ((File) element).getSize();
            } else if (element instanceof Directory) {
                totalSize += ((Directory) element).getTotalSize();
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

    @Override
    public void accept(FSVisitor v) {
        v.visit(this);
        for(FSElement e: children){
            e.accept(v);
        }
    }
}
