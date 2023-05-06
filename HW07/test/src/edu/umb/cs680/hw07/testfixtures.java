package edu.umb.cs680.hw07;

import java.time.LocalDateTime;

public class testfixtures {

    public static FileSystem createfs() {

        FileSystem fileSystem = FileSystem.getFileSystem();

        Directory prjrootRoot = new Directory(null, "prjRoot", 0, LocalDateTime.now());
        Directory src = new Directory(prjrootRoot, "src", 0, LocalDateTime.of(2023, 4, 24, 02, 20));
        Directory lib = new Directory(prjrootRoot, "lib", 0, LocalDateTime.of(2023, 4, 24, 03, 20));
        Directory test = new Directory(prjrootRoot, "test", 0, LocalDateTime.now());
        Directory src1 = new Directory(test, "src", 0, LocalDateTime.now());
        File x = new File(prjrootRoot, "x", 400, LocalDateTime.now());
        File a = new File(src, "a", 100, LocalDateTime.of(2023, 4, 24, 04, 20));
        File b = new File(src, "b", 200, LocalDateTime.of(2023, 4, 24, 05, 20));
        File c = new File(lib, "c", 300, LocalDateTime.now());
        File d = new File(src1, "d", 10, LocalDateTime.now());
        Link link1=new Link(prjrootRoot,"y",10,LocalDateTime.now(),src1);




        prjrootRoot.appendChild(src);
        prjrootRoot.appendChild(lib);
        prjrootRoot.appendChild(test);
        prjrootRoot.appendChild(x);
        prjrootRoot.appendChild(link1);


        src.appendChild(a);
        src.appendChild(b);

        lib.appendChild(c);

        test.appendChild(src1);

        src1.appendChild(d);


        fileSystem.appendRootDir(prjrootRoot);


        return fileSystem;
    }

}
