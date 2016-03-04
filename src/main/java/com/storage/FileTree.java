package com.storage;

import java.io.File;
import java.util.List;

/**
 * Created by Nikita on 03.03.2016.
 */
public class FileTree {
    private File directory;
    private List<FileTree> files;

    public FileTree(File directory) {
        this.directory = directory;
    }

    public List<FileTree> getFiles() {

        return files;
    }

    public void setFiles(List<FileTree> files) {
        this.files = files;
    }

    public File getDirectory() {

        return directory;
    }

    public void setDirectory(File directory) {
        this.directory = directory;
    }
}
