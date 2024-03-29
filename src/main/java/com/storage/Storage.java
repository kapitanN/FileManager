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

	public Storage(){}
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

	public void createDirectory(String folder){
		File newDirectory = new File(ROOT + path + File.separator + folder);
		if (!newDirectory.exists()){
			newDirectory.mkdirs();
		}
	}
	public void createDirectory(){
		File newDirectory = new File(ROOT + path);
		if (!newDirectory.exists()){
			newDirectory.mkdirs();
		}
	}
	public void setFiles(String sourcePath) {
		Path pathSource = Paths.get(sourcePath);
		String dirPath =  "\\" + String.valueOf(pathSource.getFileName());
		Path pathDestination = Paths.get(ROOT + path + dirPath);
		try {
			Files.walkFileTree(pathSource, new MyFileCopyVisitor(pathSource,    pathDestination));
			System.out.println("Files copied successfully!");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	public String deleteFiles(File file){
		//File file = new File(ROOT + pathToFile);
		if (!file.exists()){
			return "File does not exist.";
		}
		else {
			if (file.isDirectory()){
				for (File fileIterate : file.listFiles()){
					if (fileIterate.isDirectory()){
						deleteFiles(fileIterate);
					}
					else {
						fileIterate.delete();
					}
				}
				file.delete();
			}
			return "File deleted.";
		}
	}
}
