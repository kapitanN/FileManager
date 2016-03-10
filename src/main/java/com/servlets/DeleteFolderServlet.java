package com.servlets;

import com.DAO.ConnectionHolder;
import com.DAO.DBmanager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;

/**
 * Created by Nikita on 10.03.2016.
 */
@WebServlet("/DeleteFolderServlet")
public class DeleteFolderServlet extends HttpServlet {
    private static final String ROOT = "D:\\Filestorage\\";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        ConnectionHolder.setConnectionThreadLocal(DBmanager.getConnection());
        String path = (String) session.getAttribute("userPath");
        File file = new File(ROOT + path);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
