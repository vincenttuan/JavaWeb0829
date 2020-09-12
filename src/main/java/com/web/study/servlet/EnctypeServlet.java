package com.web.study.servlet;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
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
        out.print("OK 中文");
        
        InputStreamReader isr = new InputStreamReader(req.getInputStream(), "UTF-8");
        char[] buffer = new char[1];
        while (isr.read(buffer) != -1) {
            out.print(buffer);
        }
    }
    
}
