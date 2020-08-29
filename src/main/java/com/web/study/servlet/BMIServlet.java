package com.web.study.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "bmiservlet", urlPatterns = {"/servlet/bmi"})
public class BMIServlet extends HttpServlet {
    
    private void doHandler(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        // 參數檢查
        if(req.getParameter("name") == null || 
                req.getParameter("h") == null || req.getParameter("w") == null) {
            out.println("請輸入參數(例如:?name=john&h=170&w=60)");
            return;
        }
            
        // 取得參數 "?name=john&h=170&w=60"
        String name = req.getParameter("name");
        double h = Double.parseDouble(req.getParameter("h"));
        double w = Double.parseDouble(req.getParameter("w"));
        double bmi = w / Math.pow(h/100, 2);
        // 回應資料
        out.print(String.format("%s <p>身高: %.1f <p>體重: %.1f <p>BMI = %.2f<p>", name, h, w, bmi));
        if(bmi > 23) {
            out.print("過重");
        } else if (bmi <= 18) {
            out.print("過輕");
        } else {
            out.print("正常");
        }
        
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
