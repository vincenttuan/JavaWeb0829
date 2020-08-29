package com.web.study.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet/time")
public class TimeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 中文編碼
        req.setCharacterEncoding("utf-8"); // 將 client 的請求編碼成 UTF-8(如此便可以支援中文)
        resp.setCharacterEncoding("utf-8");// 將 server 的回應編碼成 UTF-8
        resp.setContentType("text/html;charset=utf-8"); // 告知瀏覽器回應的文件格式是 text/html, 編碼是 utf-8
        
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss E");
        PrintWriter out = resp.getWriter();
        out.print("現在時間:");
        out.print("<p>");
        out.print(sdf.format(new Date()));
    }
    
}
