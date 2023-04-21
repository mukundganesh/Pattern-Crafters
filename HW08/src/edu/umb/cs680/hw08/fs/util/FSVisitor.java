package edu.umb.cs680.hw08.fs.util;

import edu.umb.cs680.hw08.fs.Directory;
import edu.umb.cs680.hw08.fs.Link;

import edu.umb.cs680.hw08.fs.File;

public interface FSVisitor {

    void visit(Link link);
    void visit(File file);
    void visit(Directory directory);


}
