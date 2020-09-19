package com.web.study.servlet.cookies;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet/cookies/read")
public class ReadCookieServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies(); // 取得 client 傳來的 cookie 資料
        PrintWriter out = resp.getWriter();
        if(cookies != null) {
            for(Cookie cookie : cookies) {
                out.println(cookie.getName() + ":" + cookie.getValue());
            }
        } else {
            out.println("None cookie !");
        }
        
    }
    
}
