package edu.umb.cs680.hw12.fs.util;

import edu.umb.cs680.hw12.fs.Directory;
import edu.umb.cs680.hw12.fs.FSVisitor;
import edu.umb.cs680.hw12.fs.Link;
import edu.umb.cs680.hw12.fs.File;


import java.util.LinkedList;

public class FileCrawlingVisitor implements FSVisitor {
    private LinkedList<File> files=new LinkedList<>();


    @Override
    public void visit(Link link) {
        return;
    }

    @Override
    public void visit(File file) {
        files.add(file);
    }

    @Override
    public void visit(Directory directory) {
        return;
    }

    public LinkedList<File> getFiles() {
        return files;
    }
}
