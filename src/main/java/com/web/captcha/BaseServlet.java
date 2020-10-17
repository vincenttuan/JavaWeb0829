package com.web.captcha;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Base64;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.dbutils.BasicRowProcessor;
import org.apache.commons.dbutils.handlers.MapListHandler;

public class BaseServlet extends HttpServlet {
    private static Connection conn;
    static {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            String dburl = "jdbc:derby://localhost:1527/web";
            String dbuser = "app";
            String dbpwd = "app";
            conn = DriverManager.getConnection(dburl, dbuser, dbpwd);
        } catch (Exception e) {
        }
    }
    
    protected void forward(HttpServletRequest req, HttpServletResponse resp, String path) throws IOException, ServletException {
        RequestDispatcher rd = req.getServletContext().getRequestDispatcher(path);
        rd.forward(req, resp);
    }
    
    protected boolean newMember(String username, String password) {
        // 將 password 進行 base64 編碼
        password = Base64.getEncoder().encodeToString(password.getBytes());
        String sql = "INSERT INTO Member(username, password) VALUES('%s', '%s')";
        sql = String.format(sql, username, password);
        try(Statement stmt = conn.createStatement();) {
            int count = stmt.executeUpdate(sql);
            return count > 0 ? true : false;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    protected List<Map<String, Object>> getMember(String username) {
        String sql = "SELECT username, password FROM Member WHERE username='%s'";
        sql = String.format(sql, username);
        try(Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);) {
            // ResultSet集合 -> List<Map<String, Object>>
            BasicRowProcessor convert = new BasicRowProcessor();
            MapListHandler handler = new MapListHandler(convert);
            return handler.handle(rs);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    protected boolean checkLogin(String username, String password) {
        // 將 password 進行 base64 編碼
        password = Base64.getEncoder().encodeToString(password.getBytes()); 
        String sql = "SELECT username, password FROM Member WHERE username='%s' and password='%s'";
        sql = String.format(sql, username, password);
        try(Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);) {
            if(rs.next()) {
                return true;
            }
        } catch (Exception e) {
        }
        return false;
    }
    
    
    protected boolean checkCaptcha(HttpServletRequest req) throws MalformedURLException, IOException {
        return checkCaptcha(req.getParameter("g-recaptcha-response"));
    }
    protected boolean checkCaptcha(String grr) throws MalformedURLException, IOException {
        
        System.out.println(grr);
        // 取得 CAPTCHA 回應碼
        String url      = getServletContext().getAttribute("captcha_verify_url") + "?secret=%s&response=%s&remoteip=%s";
        String secret   = getServletContext().getAttribute("captcha_server_key").toString();
        String remoteip = getServletContext().getAttribute("captcha_remoteip").toString();
        url = String.format(url, secret, grr, remoteip);
        String json = new Scanner(new URL(url).openStream()).useDelimiter("\\A").next();
        System.out.println(json);
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
        return check;
    }
}
