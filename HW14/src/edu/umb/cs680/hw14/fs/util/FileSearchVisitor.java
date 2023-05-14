package edu.umb.cs680.hw14.fs.util;

import edu.umb.cs680.hw14.fs.Directory;
import edu.umb.cs680.hw14.fs.FSVisitor;
import edu.umb.cs680.hw14.fs.File;
import edu.umb.cs680.hw14.fs.Link;

import java.util.LinkedList;

public class FileSearchVisitor implements FSVisitor {
    private String fileName;
    private LinkedList<File> foundFiles=new LinkedList<>();

    public FileSearchVisitor(String fileName) {

        this.fileName=fileName;
    }

    @Override
    public void visit(Link link) {
        return;
    }

    @Override
    public void visit(File file) {
        if (file.getname().equals(fileName)) {
            foundFiles.add(file);
        }
    }
    @Override
    public void visit(Directory directory) {
        return;
    }

    public LinkedList<File> getFoundFiles() {
        return foundFiles;
    }

}
