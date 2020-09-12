package com.web.study.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LottoServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doHandler(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doHandler(req, resp);
    }
    
    protected void doHandler(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // utf-8 編碼
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        
        // 產出 1 ~ 50 不重複的數字 10 個
        Random r = new Random();
        Set<Integer> nums = new LinkedHashSet<>();
        while(nums.size() < 10) {
            nums.add(r.nextInt(50) + 1);
        }
        
        // 回應資訊
        PrintWriter out = resp.getWriter();
        out.print(nums);
    }
    
}
