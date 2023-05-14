package edu.umb.cs680.hw12.fs.util;

import edu.umb.cs680.hw12.fs.Directory;
import edu.umb.cs680.hw12.fs.FSVisitor;
import edu.umb.cs680.hw12.fs.File;
import edu.umb.cs680.hw12.fs.Link;

public class CountingVisitor implements FSVisitor {
    private int dirNum=0;
    private int fileNum=0;
    private int linkNum=0;


    @Override
    public void visit(Link link) {
        linkNum++;
    }

    @Override
    public void visit(File file) {
        fileNum++;

    }

    @Override
    public void visit(Directory directory) {
        dirNum++;

    }

    public int getDirNum(){
        return  dirNum;
    }

    public int getFileNum() {
        return fileNum;
    }

    public int getLinkNum() {
        return linkNum;
    }
}
