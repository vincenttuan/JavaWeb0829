package com.web.captcha;

import java.io.IOException;
import java.util.Set;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/captcha/sso/login")
public class SSOLoginServlet extends BaseServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        boolean checkCaptcher = checkCaptcha(req);
        // 1. 驗證 captcher
        if(!checkCaptcher) {
            req.setAttribute("result", "Captcher: " + checkCaptcher);
            forward(req, resp, "/forms/captcha/sso_login_form.jsp");
            return;
        }
        
        // 2. 驗證 username, password
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        boolean checkLogin = checkLogin(username, password);
        if(!checkLogin) {
            req.setAttribute("result", "Login: " + checkLogin);
            forward(req, resp, "/forms/captcha/sso_login_form.jsp");
            return;
        }
        
        // 3. 此 username 是否已登入?
        Set<String> alreadyLoginMembers = (Set<String>)getServletContext().getAttribute("alreadyLoginMembers");
        if(alreadyLoginMembers.stream().filter(n -> n.equals(username)).findAny().isPresent()) {
            req.setAttribute("result", username + " 已登入");
            forward(req, resp, "/forms/captcha/sso_login_form.jsp");
            return;
        }
        
        // 4. 登入成功
        resp.getWriter().print("Login success !");
        HttpSession session = req.getSession(true);
        
        // 刪除之前未登出的 username
        String preUsername = session.getAttribute("username") + "";
        alreadyLoginMembers.remove(preUsername);
        
        session.setAttribute("username", username);
        alreadyLoginMembers.add(username);
        forward(req, resp, "/captcha/sso/view/member");
        // resp.sendRedirect("/JavaWeb0829/captcha/sso/view/member"); // GET
        System.out.println(alreadyLoginMembers);
    }
    
}
