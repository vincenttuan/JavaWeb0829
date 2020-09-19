package com.web.study.servlet.session;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/servlet/session/read")
public class ReadSessionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        PrintWriter out = resp.getWriter();
        if(session != null) {
            out.println("Read session ok !");
            out.println("Session Id: " + session.getId());
        } else {
            out.print("None session !");
        }
    }
    
}
