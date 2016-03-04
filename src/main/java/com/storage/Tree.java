package com.storage;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nikita on 03.03.2016.
 */
public class Tree {
    private Logger LOG = Logger.getLogger(Tree.class);

    public void iterateTree() {
        Path startingDir = Paths.get("D:\\Filestorage");
        MyFileVisitor pf = new MyFileVisitor();
        List<Path> pathList = new ArrayList<>();
        try {
            pathList.add(Files.walkFileTree(startingDir, pf));
            System.out.format(String.valueOf(pathList));
        } catch (IOException e) {
            LOG.error(e);
        }
    }
}
