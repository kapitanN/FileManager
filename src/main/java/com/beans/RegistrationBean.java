package com.beans;


import org.apache.log4j.Logger;

public class RegistrationBean {

	private String firstName;
	private String lastName;
	private String login;
	private String password;

	public static final Logger LOG = Logger.getLogger(RegistrationBean.class);
	public RegistrationBean() {}

	public String getFirstName() {
		LOG.info("getFirstName");
		return firstName;
	}

	public void setFirstName(String firstName) {
		LOG.info("setFirstName");
		this.firstName = firstName;
	}

	public String getLastName() {
		LOG.info("getLastName");
		return lastName;
	}

	public void setLastName(String lastName) {
		LOG.info("setLastName");
		this.lastName = lastName;
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

	@Override
	public String toString() {
		return "RegistrationBean [firstName=" + firstName + ", lastName=" + lastName + ", login=" + login
				+ ", password=" + password + "]";
	}
	
	

}
