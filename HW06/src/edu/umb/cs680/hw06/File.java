package edu.umb.cs680.hw06;

import java.time.LocalDateTime;

public class File extends FSElement{


    public File(Directory parent, String name, Integer size, LocalDateTime creationTime) {
        super(parent, name, size, creationTime);

    }
    public LocalDateTime getCreationtime(){
        return this.creationTime;
    }


    @Override
    public boolean isDirectory() {
        return false;
    }



    @Override
    public boolean isFile() {
        return true;
    }
}
