package com.web.captcha;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import jdk.nashorn.api.scripting.URLReader;

@WebServlet("/captcha/sso/login")
public class SSOLoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        String grr = req.getParameter("g-recaptcha-response");
        resp.getWriter().print(grr);
        resp.getWriter().print("<hr>");
        // 取得 CAPTCHA 回應碼
        String url = "https://www.google.com/recaptcha/api/siteverify?secret=%s&response=%s&remoteip=%s";
        String secret = "6Lf_JtYZAAAAAKYtDPaFi-d8gWe-M7L3TejxS5Pa";
        String remoteip = "localhost";
        url = String.format(url, secret, grr, remoteip);
        String json = new Scanner(new URL(url).openStream()).useDelimiter("\\A").next();
        resp.getWriter().print(json);
        resp.getWriter().print("<hr>");
        // 驗證 CAPTCHA
    }
    
}
