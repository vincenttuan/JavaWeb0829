package com.web.study.servlet;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/servlet/image")
public class ImageServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        File file = new File("C:/upload/" + name);
        if(file.exists()) {
            resp.setContentType("image/png");
            resp.setContentLength((int)file.length());
            Files.copy(file.toPath(), resp.getOutputStream());
        } else {
            resp.setContentType("text/html;charset=utf-8");
            resp.getWriter().print("Image not found!");
        }
    }
    
}
