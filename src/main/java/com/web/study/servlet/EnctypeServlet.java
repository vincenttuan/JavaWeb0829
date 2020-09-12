package com.web.study.servlet;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/servlet/enctype")
public class EnctypeServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");

        PrintWriter out = resp.getWriter();

        // 顯示Header：HTTP 文件 (Part 2)
        out.println("顯示Header：HTTP 文件 (Part 2)<p>");
        Enumeration<String> headerNames = req.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String name = headerNames.nextElement();
            out.print(name + "=" + req.getHeader(name) + "<br>");
        }
        out.println("<p>");
        out.println("顯示Header：HTTP 文件 (Part 4)<p>");
        InputStreamReader isr = new InputStreamReader(req.getInputStream(), "UTF-8");
        char[] buffer = new char[1];
        while (isr.read(buffer) != -1) {
            out.print(buffer);
        }
//        out.print("<p><hr>");
//        out.print("name = " + req.getParameter("name") + "<p>");
//        out.print("age = " + req.getParameter("age") + "<p>");
    }

}
