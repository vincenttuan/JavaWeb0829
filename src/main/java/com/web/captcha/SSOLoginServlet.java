package com.web.captcha;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/captcha/sso/login")
public class SSOLoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String grr = req.getParameter("g-recaptcha-response");
        resp.getWriter().print(grr);
        // 驗證 CAPTCHA
        String url = "https://www.google.com/recaptcha/api/siteverify?secret=%s&response=%s&remoteip=%s";
        String secret = "6Lf_JtYZAAAAAKYtDPaFi-d8gWe-M7L3TejxS5Pa";
        String response = grr;
        String remoteip = "localhost";
        
    }
    
}
