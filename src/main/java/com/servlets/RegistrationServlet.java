package com.servlets;

import com.DAO.ConnectionHolder;
import com.DAO.DBmanager;
import com.DAO.User;
import com.beans.RegistrationBean;
import com.service.Service;
import com.service.Service;
import com.storage.Storage;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private static final String FIRST_NAME = "firstName";
	private static final String LAST_NAME = "lastName";
	private static final String LOGIN = "login";
	private static final String PASSWORD = "password";

	private static final Logger LOG = Logger.getLogger(RegistrationServlet.class);

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LOG.info("doPost registration");
		HttpSession session = request.getSession();
		ConnectionHolder.setConnectionThreadLocal(DBmanager.getConnection());
		RegistrationBean registrationUser = fieldsAddition(request);
		boolean check = checkRegistrationLogin(registrationUser);
		if (check){
			Service userService = new Service();
			String folderName = generateFolderName();
			User user = new User(registrationUser);
			userService.addUsers(user);
			userService.setPath(user.getLogin(), folderName);
			Storage file = new Storage(folderName);
			file.createDirectory();
			session.setAttribute("user", user);
			session.setAttribute("userPath", folderName);
			request.getRequestDispatcher("SuccessfulAuthentication.jsp").forward(request, response);
		}
		else {
			request.getRequestDispatcher("FailRegistration.jsp").forward(request, response);
		}
	}

	private RegistrationBean fieldsAddition(HttpServletRequest req) {
		RegistrationBean user = new RegistrationBean();
		user.setFirstName(req.getParameter(FIRST_NAME));
		user.setLastName(req.getParameter(LAST_NAME));
		user.setLogin(req.getParameter(LOGIN));
		user.setPassword(req.getParameter(PASSWORD));
		LOG.info("all fields have been added");
		return user;
	}

	private String generateFolderName(){
		String result = RandomStringUtils.random(16, 0, 20, true, true, "qw32rfHIJk9iQ8Ud7h0X".toCharArray());
		return result;
	}

	private static boolean checkRegistrationLogin(RegistrationBean login){
		Service service = new Service();
		if (service.getUserByLogin(login.getLogin()) != null){
			User user = service.getUserByLogin(login.getLogin());
			if (user.getLogin().equals(login.getLogin())){
				return false;
			}
		}
		return true;
	}

}
