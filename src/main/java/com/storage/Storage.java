package com.storage;

import com.beans.FileBean;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Storage {
	public static final Logger LOG = Logger.getLogger(Storage.class);

	private static final String ROOT = "D:\\Filestorage\\";
	private String path ;

	public Storage(String path) {
		this.path = path;
	}

	public List<FileBean> getFileBean(){
		List<File> lst = getFiles();
		List<FileBean> result = new ArrayList<>();
		for (File file: lst ) {
			FileBean temp = new FileBean(file.getName(), file.getPath(), file.getTotalSpace(), file.isFile(), file.isDirectory());
			result.add(temp);
		}
		return result;
	}
	public List<File> getFiles(){
		List<File> files = new ArrayList<>();
		File file = new File(ROOT + path);
		if(file.exists()){
			File[] file1 = file.listFiles();
			for (int i = 0; i < file1.length; i++) {
				files.add(file1[i]);
			}
		}
		return files;
	}

	public void createRootDirectory(){
		File newDirectory = new File(ROOT + path);
		if (!newDirectory.exists()){
			newDirectory.mkdirs();
		}
	}
	public void setFiles(String sourcePath) {
		Path pathSource = Paths.get(sourcePath);
		Path pathDestination = Paths.get(ROOT + path);
		try {
			Files.walkFileTree(pathSource, new MyFileCopyVisitor(pathSource,    pathDestination));
			System.out.println("Files copied successfully!");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}



}
