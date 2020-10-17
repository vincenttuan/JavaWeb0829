package com.web.captcha;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/captcha/sso/login")
public class SSOLoginServlet extends BaseServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        boolean checkCaptcher = checkCaptcha(req);
        // 1. 驗證 captcher
        if(!checkCaptcher) {
            resp.getWriter().print("Captcher: " + checkCaptcher);
            return;
        }
        
        // 2. 驗證 username, password
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        boolean checkLogin = checkLogin(username, password);
        if(!checkLogin) {
            resp.getWriter().print("Login: " + checkLogin);
            return;
        }
        
        // 3. 登入成功
        resp.getWriter().print("Login success !");
        
        
    }
    
}
