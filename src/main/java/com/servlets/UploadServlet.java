package com.servlets;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by Nikita on 06.03.2016.
 */
@WebServlet("/UploadServlet")
@MultipartConfig(fileSizeThreshold=1024*1024*2, // 2MB
        maxFileSize=1024*1024*10,      // 10MB
        maxRequestSize=1024*1024*50)   // 50MB
public class UploadServlet extends HttpServlet {
    private static Logger LOG = Logger.getLogger(UploadServlet.class);
    private static final String ROOT = "D:\\Filestorage\\";

    private String generateFileElement(String file, String currentPath) {
        String two = "<input id=\"" + file + "\" type=\"hidden\" name=\"path\" />\n";
        String three = "<div class=\"col-md-3 col-xs-10 file-block\" >\n";
        String four = "<span class=\"glyphicon glyphicon-file\" aria-hidden=\"true\"></span>\n";
        String five = "<h3 class=\"folder-name\">" + file + "</h3>";
        String six = "</div>";
        return two + three + four + five + six;
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        String userPath = (String)session.getAttribute("userPath");
        String path = (String)session.getAttribute("currentPath");
        Object object = request.getParameter("data");
        System.out.println(object);
        String savePath = null;
        if (path == null){
            savePath = ROOT + userPath;
        }else {
            savePath = ROOT + userPath + File.separator +  path;
        }
        File fileSaveDir = new File(savePath);
        if (!fileSaveDir.exists()) {
            fileSaveDir.mkdir();
        }
        String fileName = null;
        for (Part part : request.getParts()) {
            fileName = extractFileName(part);
            part.write(savePath + File.separator + fileName);
            }
        response.setContentType("text/html");
        response.getWriter().write(generateFileElement(fileName, savePath));

        request.getRequestDispatcher("SuccessfulAuthentication.jsp").forward(request, response);

    }

    private String extractFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 2, s.length()-1);
            }
        }
        return "";
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
