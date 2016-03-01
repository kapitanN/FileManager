package com.beans;

import com.sun.istack.logging.Logger;

public class AuthenticationBean {

	private String login;
	private String password;
	public static final Logger LOG = Logger.getLogger(AuthenticationBean.class);
	
	public AuthenticationBean(){}
	public String getLogin() {
		LOG.info("getLogin");
		return login;
	}
	public void setLogin(String login) {
		LOG.info("setLogin");
		this.login = login;
	}
	public String getPassword() {
		LOG.info("getPassword");
		return password;
	}
	public void setPassword(String password) {
		LOG.info("setPassword");
		this.password = password;
	}
	
	
}
