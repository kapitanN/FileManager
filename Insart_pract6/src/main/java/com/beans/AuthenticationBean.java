package com.beans;

import com.sun.istack.logging.Logger;

public class AuthenticationBean {

	private String login;
	private String password;
	public static final Logger LOG = Logger.getLogger(AuthenticationBean.class);
	
	public AuthenticationBean(){}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		AuthenticationBean that = (AuthenticationBean) o;

		if (login != null ? !login.equals(that.login) : that.login != null) return false;
		return password != null ? password.equals(that.password) : that.password == null;

	}

	@Override
	public int hashCode() {
		int result = login != null ? login.hashCode() : 0;
		result = 31 * result + (password != null ? password.hashCode() : 0);
		return result;
	}

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
