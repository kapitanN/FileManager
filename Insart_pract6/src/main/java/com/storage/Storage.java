package com.storage;

import com.beans.FileBean;
import com.beans.RegistrationBean;
import com.servlets.AuthenticationServlet;
import org.apache.log4j.Logger;

import java.io.File;
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

	public void setFiles(String path) {


	}

}
