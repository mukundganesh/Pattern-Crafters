package edu.umb.cs680.hw06;

import java.time.LocalDateTime;

public abstract class FSElement {
    protected String name;
    protected Directory parent;
    protected Integer size;
    protected LocalDateTime creationTime;

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

    public abstract boolean isDirectory();
    public abstract boolean isFile();

}
