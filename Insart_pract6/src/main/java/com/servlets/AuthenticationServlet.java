package com.servlets;

import com.beans.AuthenticationBean;
import com.beans.RegistrationBean;
import com.storage.Storage;
import org.apache.log4j.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import javax.servlet.annotation.WebServlet;

@WebServlet("/authentication")
public class AuthenticationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String LOGIN = "login";
	private static final String PASSWORD = "password";
	
	public static final Logger LOG = Logger.getLogger(AuthenticationServlet.class);

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LOG.info("doPost authentication");
		AuthenticationBean user = fieldsAddition(request);
		boolean result = checkAuthentication(user);
		LOG.info(Boolean.toString(result));
		if(result){
			request.getRequestDispatcher("SuccessfulAuthentication.jsp").forward(request, response);
		}
		else{
			request.getRequestDispatcher("FailAuthentication.jsp").forward(request, response);
			}
	}
	
	private AuthenticationBean fieldsAddition(HttpServletRequest request){
		AuthenticationBean user = new AuthenticationBean();
		user.setLogin(request.getParameter(LOGIN));
		user.setPassword(request.getParameter(PASSWORD));
		LOG.info("all fields in fieldsAddition are added");
		return user;
	}
	
	private static boolean checkAuthentication(AuthenticationBean user){
		List<RegistrationBean> listOfUsers = Storage.getStorage();
		for(RegistrationBean item : listOfUsers){
			if(user.getLogin().equals(item.getLogin()) && user.getPassword().equals(item.getPassword())){
				return true;
			}
		}
		return false;
	}
}
