package com.servlets;

import com.beans.FileBean;
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
import java.util.List;

/**
 * Created by Nikita on 03.03.2016.
 */
@WebServlet("/storage")
public class StorageServlet extends HttpServlet {
    private static final Logger LOG = Logger.getLogger(StorageServlet.class);

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String userFolder = (String) session.getAttribute("userPath"); // d
        String clientPath = request.getParameter("path"); // 666
        session.setAttribute("currentPath", clientPath + "/");
        Storage s = new Storage(userFolder + File.separator + clientPath);
        Storage forFiles = new Storage(userFolder);
        String source = "D:\\Study\\Test";
        forFiles.setFiles(source);
        List<FileBean> lst = s.getFileBean();
        session.setAttribute("lst", lst);
        request.getRequestDispatcher("SuccessfulAuthentication.jsp").forward(request, response);
    }
}
