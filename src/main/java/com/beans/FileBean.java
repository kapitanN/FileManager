package com.beans;

/**
 * Created by Nikita on 02.03.2016.
 */
public class FileBean {
    private String name;
    private String path;
    private long size;
    private boolean file;
    private boolean directory;

    public FileBean(String name, String path, long size, boolean file, boolean directory) {
        this.name = name;
        this.path = path;
        this.size = size;
        this.file = file;
        this.directory = directory;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public boolean isFile() {
        return file;
    }

    public void setFile(boolean file) {
        this.file = file;
    }

    public boolean isDirectory() {
        return directory;
    }

    public void setDirectory(boolean directory) {
        this.directory = directory;
    }
}
