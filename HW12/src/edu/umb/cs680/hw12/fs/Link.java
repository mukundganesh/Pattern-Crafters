package edu.umb.cs680.hw12.fs;

import java.time.LocalDateTime;

public class Link extends FSElement{
    private  FSElement target;

    public Link(Directory parent, String name, Integer size, LocalDateTime creationTime,FSElement target) {
        super(parent, name, 0, creationTime);
        this.target=target;
    }

    public FSElement getTarget(){
        return this.target;
    }


    @Override
    public boolean isDirectory() {
        return false;
    }

    @Override
    public boolean isFile() {
        return false;
    }

    @Override
    public void accept(FSVisitor visitor) {
        visitor.visit(this);
    }
}

