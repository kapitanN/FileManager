package com.servlets;

import com.beans.FileBean;
import com.storage.Storage;
import org.apache.log4j.Logger;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;

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
        Storage storage = new Storage(userPath + File.separator + currentPath);
        storage.createDirectory(folder);
        List<FileBean> lst = storage.getFileBean();
        session.setAttribute("lst",lst);
        System.out.println("start");
        System.out.println("end");
        JSONObject result = new JSONObject();
        result.append("lst", lst);
        response.setContentType("text/html");
        response.getWriter().write(result.toString());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
