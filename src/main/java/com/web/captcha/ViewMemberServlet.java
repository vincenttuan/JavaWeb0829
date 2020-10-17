package com.web.captcha;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/captcha/sso/view/member")
public class ViewMemberServlet extends BaseServlet {
    
    private void doHandler(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        
        if(session.getAttribute("username") == null) {
            req.setAttribute("result", "無登入資料, 請重新登入!");
            forward(req, resp, "/forms/captcha/sso_login_form.jsp");
            return;
        }
        
        String username = session.getAttribute("username") + "";
        List<Map<String, Object>> members = getMember(username);
        req.setAttribute("members", members);
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/mvc/sso/view_member.jsp");
        rd.forward(req, resp);
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doHandler(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doHandler(req, resp);
    }
    
}
