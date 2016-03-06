package com.servlets;

import com.DAO.ConnectionHolder;
import com.DAO.DBmanager;
import com.DAO.User;
import com.service.UserServiceCore;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;

/**
 * Created by Nikita on 06.03.2016.
 */
@WebServlet("/DeleteUser")
public class DeleteUserServlet extends HttpServlet {
    private static final String ROOT = "D:\\Filestorage\\";
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        ConnectionHolder.setConnectionThreadLocal(DBmanager.getConnection());
        UserServiceCore userService = new UserServiceCore();
        User user = (User) session.getAttribute("user");
        String path = (String) session.getAttribute("userPath");
        File file = new File(ROOT + path);
        userService.deleteUser(user.getLogin(), file);
        request.getRequestDispatcher("AuthenticationForm.jsp").forward(request,response);
        session.invalidate();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
