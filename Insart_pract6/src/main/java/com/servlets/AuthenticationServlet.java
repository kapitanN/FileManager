package com.servlets;

import com.DAO.ConnectionHolder;
import com.DAO.DBmanager;
import com.DAO.User;
import com.beans.AuthenticationBean;
import com.beans.FileBean;
import com.service.UserService;
import com.service.UserServiceCore;
import com.storage.Storage;
import org.apache.log4j.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpSession;

@WebServlet("/authentication")
public class AuthenticationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String LOGIN = "login";
	private static final String PASSWORD = "password";

	public static final Logger LOG = Logger.getLogger(AuthenticationServlet.class);

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LOG.info("doPost authentication");
		HttpSession session = request.getSession();
		ConnectionHolder.setConnectionThreadLocal(DBmanager.getConnection());
		AuthenticationBean login = fieldsAddition(request);
		UserServiceCore userService = new UserServiceCore();
		User user = userService.getUserByLogin(login.getLogin());
		LOG.info("Current user ==> " + user);
		boolean result = checkAuthentication(login);
		LOG.info(Boolean.toString(result));
		if(result){
			session.setAttribute("user", user);
			String path = userService.getPath(user.getIdUser());
			Storage s = new Storage(path) ;
			List<FileBean> lst = s.getFileBean();
			session.setAttribute("lst",lst);
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
	
	private static boolean checkAuthentication(AuthenticationBean loginUser){
		UserService userService = new UserServiceCore();
		User user = userService.getUserByLogin(loginUser.getLogin());
		if (loginUser.getLogin().equals(user.getLogin()) && loginUser.getPassword().equals(user.getPassword())){
				return true;
			}
		return false;
	}
}
