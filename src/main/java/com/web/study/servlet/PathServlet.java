package com.web.study.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "pathservlet", urlPatterns = {"/servlet/path"})
public class PathServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/plain;charset=utf-8");
        PrintWriter out = resp.getWriter();
        String servletName = getServletName();
        String url = req.getRequestURL().toString();
        String uri = req.getRequestURI().toString();
        String contextPath = req.getContextPath();
        String servletPath = req.getServletPath();
        String pathInfo = req.getPathInfo();
        out.println("Servlet Name: " + servletName);
        out.println("URL: " + url);
        out.println("URI: " + uri);
        out.println("Context Path: " + contextPath);
        out.println("Servlet Path: " + servletPath);
        out.println("Path Info: " + pathInfo);
    }
    
}
