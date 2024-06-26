package edu.umb.cs680.hw12.fs;

import java.time.LocalDateTime;

public abstract class FSElement {
    private String name;
    private Directory parent;
    private Integer size;
    private LocalDateTime creationTime;

    public FSElement(Directory parent,String name,Integer size,LocalDateTime creationTime){
        this.name=name;
        this.size=size;
        this.parent=parent;
        this.creationTime=creationTime;
    }

    public Directory getParent() {
        return this.parent;
    }

    public int getSize(){
        return this.size;
    }

    public String getname(){
        return this.name;
    }

    public LocalDateTime getCreationtime(){
        return this.creationTime;
    }

    public abstract boolean isDirectory();
    public abstract boolean isFile();

    public void accept(FSVisitor visitor){
        return;
    };

}
