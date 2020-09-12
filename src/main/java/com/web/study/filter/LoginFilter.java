package com.web.study.filter;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter(urlPatterns = "/report/*")
public class LoginFilter extends HttpFilter {

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse resp, FilterChain chain) throws IOException, ServletException {
        if(req.getParameter("username") != null && req.getParameter("password") != null) {
            chain.doFilter(req, resp);
        } else {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/forms/login_form.jsp");
            rd.forward(req, resp);
        }
    }
    
}
