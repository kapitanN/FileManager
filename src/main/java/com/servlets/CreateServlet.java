package com.servlets;

import com.storage.Storage;
import org.apache.log4j.Logger;

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
@WebServlet("/CreateServlet")
public class CreateServlet extends HttpServlet {
    private static Logger LOG = Logger.getLogger(CreateServlet.class);
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String userPath = (String)session.getAttribute("userPath");
        String currentPath = (String)session.getAttribute("currentPath");
        String folder = request.getParameter("folderName");
        String pathCreateFolder = null;
        if (currentPath == null){
            pathCreateFolder = userPath + File.separator + folder;
        }
        else {
            pathCreateFolder = userPath + File.separator + currentPath + File.separator + folder;
        }
        Storage storage = new Storage(pathCreateFolder);
        storage.createDirectory();
        request.getRequestDispatcher("SuccessfulAuthentication.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
