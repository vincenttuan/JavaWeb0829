package com.web.fastfood.login;

import java.io.IOException;
import javax.servlet.DispatcherType;
import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(urlPatterns = "/fastfood/*")
public class LoginFilter extends HttpFilter {

    private LoginDao dao = new LoginDao();

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {

        HttpSession session = req.getSession();
        // 判斷是否已經登入過 ?
        if (session.getAttribute("username") != null) {
            chain.doFilter(req, res);
        } else {
            // 從 login_form 進入
            String username = req.getParameter("username");
            String password = req.getParameter("password");
            boolean check = dao.login(username, password);
            if (check) {
                session.setAttribute("username", username);
                chain.doFilter(req, res);
            } else {
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/forms/login_form.jsp");
                rd.forward(req, res);
            }
        }
    }

}
