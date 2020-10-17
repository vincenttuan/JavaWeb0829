package com.web.captcha;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.net.URL;
import java.util.Map;
import java.util.Scanner;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import jdk.nashorn.api.scripting.URLReader;

@WebServlet("/captcha/sso/login")
public class SSOLoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        String grr = req.getParameter("g-recaptcha-response");
        resp.getWriter().print(grr);
        resp.getWriter().print("<hr>");
        // 取得 CAPTCHA 回應碼
        String url      = getServletContext().getAttribute("captcha_verify_url") + "?secret=%s&response=%s&remoteip=%s";
        String secret   = getServletContext().getAttribute("captcha_server_key").toString();
        String remoteip = getServletContext().getAttribute("remoteip").toString();
        url = String.format(url, secret, grr, remoteip);
        String json = new Scanner(new URL(url).openStream()).useDelimiter("\\A").next();
        resp.getWriter().print(json);
        resp.getWriter().print("<hr>");
        // 驗證 CAPTCHA
        Gson gson = new Gson();
        // Map<String, Object>
        Map<String, Object> map = gson.fromJson(json, new TypeToken<Map<String, Object>>(){}.getType());
        boolean success = Boolean.parseBoolean(map.get("success").toString());
        double score = 0;
        if(success) {
            score = Double.parseDouble(map.get("score").toString());
        }
        boolean check = success && score > 0.7 ? true : false;
        resp.getWriter().print("Check CAPTCHA: " + check);
    }
    
}