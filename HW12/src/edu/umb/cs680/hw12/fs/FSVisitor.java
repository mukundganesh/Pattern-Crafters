package edu.umb.cs680.hw12.fs;

import edu.umb.cs680.hw12.fs.Directory;
import edu.umb.cs680.hw12.fs.Link;

import edu.umb.cs680.hw12.fs.File;

public interface FSVisitor {

    void visit(Link link);
    void visit(File file);
    void visit(Directory directory);


}
