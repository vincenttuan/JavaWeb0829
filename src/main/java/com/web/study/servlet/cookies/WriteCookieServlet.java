package com.web.study.servlet.cookies;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet/cookies/write")
public class WriteCookieServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int salary = new Random().nextInt(100000);
        Cookie cookie = new Cookie("salary", salary + ""); // 建立 cookie 物件
        cookie.setMaxAge(60); // 存續時間(秒)
        resp.addCookie(cookie); // 將 cookie 寫入 client 端
        PrintWriter out = resp.getWriter();
        out.println("Write cookie ok !");
        
    }
    
}
