package com.storage;

import java.io.File;
import java.util.List;

/**
 * Created by Nikita on 03.03.2016.
 */
public class FileTree {
    private File directory;
    private List<FileTree> subdirectory;

    public FileTree(File directory)
    {
        this.directory = directory;
    }

    public List<FileTree> getSubdirectory() {

        return subdirectory;
    }

    public void setFiles(List<FileTree> files) {
        this.subdirectory = files;
    }

    public File getDirectory() {

        return directory;
    }

    public void setSubdirectory(File directory) {
        this.directory = directory;
    }
}
