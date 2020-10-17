package com.web.captcha;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/captcha/sso/logout")
public class SSOLogoutServlet extends BaseServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if(session.getAttribute("username") == null) {
            req.setAttribute("result", "登出失敗: 無登入資訊");
        } else {
            String username = session.getAttribute("username") + "";
            session.removeAttribute("username");
            req.setAttribute("result", username + " 已登出");
        }
        forward(req, resp, "/forms/captcha/sso_login_form.jsp");
    }
    
}
