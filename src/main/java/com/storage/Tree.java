package com.storage;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.EnumSet;

/**
 * Created by Nikita on 03.03.2016.
 */
public class Tree {
    private Logger LOG = Logger.getLogger(Tree.class);

    public void iterateTree() {
        Path startingDir = Paths.get("D:\\Filestorage");
        MyFileVisitor pf = new MyFileVisitor();
        EnumSet<FileVisitOption> options = EnumSet.of(FileVisitOption.FOLLOW_LINKS);
        int maxDepth = 2;

        try {
            Files.walkFileTree(startingDir, options, maxDepth, pf);
        } catch (IOException e) {
            LOG.error(e);
        }
    }
}
