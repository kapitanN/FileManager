package com.servlets;

import com.beans.RegistrationBean;
import com.DAO.ConnectionHolder;
import com.DAO.DBmanager;
import com.DAO.User;
import com.service.UserService;
import com.service.UserServiceCore;
import com.storage.Storage;
import org.apache.log4j.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	private static final String FIRST_NAME = "firstName";
	private static final String LAST_NAME = "lastName";
	private static final String LOGIN = "login";
	private static final String PASSWORD = "password";
	
	public static final Logger LOG = Logger.getLogger(RegistrationServlet.class);

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LOG.info("doPost registration");
		ConnectionHolder.setConnectionThreadLocal(DBmanager.getConnection());
		RegistrationBean user = fieldsAddition(request);
		Storage.add(user);
		UserService userService = new UserServiceCore();
		userService.addUsers(new User(user));
		List<RegistrationBean> items = Storage.getStorage();
		request.setAttribute("listOfUsers", items);
		request.getRequestDispatcher("ListOfUsers.jsp").forward(request, response);
		//LOG.info("New user has been added");
	
	}
	
	private RegistrationBean fieldsAddition(HttpServletRequest req) {
		RegistrationBean user = new RegistrationBean();
		user.setFirstName(req.getParameter(FIRST_NAME));
		user.setLastName(req.getParameter(LAST_NAME));
		user.setLogin(req.getParameter(LOGIN));
		user.setPassword(req.getParameter(PASSWORD));
		LOG.info("all fields are added");
		return user;
	}
		
}
