package com.storage;

import com.beans.RegistrationBean;
import com.servlets.AuthenticationServlet;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class Storage {
	public static final Logger LOG = Logger.getLogger(Storage.class);

	private static List<RegistrationBean> storage = new ArrayList<>();

	public static void add(RegistrationBean user) {
		storage.add(user);
		LOG.info("User has been added!");
		for (RegistrationBean item : storage) {
			System.out.println(item.toString());
		}
	}
	
	public static List<RegistrationBean> getStorage() {
		return storage;
	}
}
