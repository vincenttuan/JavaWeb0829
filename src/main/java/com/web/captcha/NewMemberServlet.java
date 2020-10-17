package com.web.captcha;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/captcha/sso/new/member")
public class NewMemberServlet extends BaseServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        boolean checkCaptcher = checkCaptcha(req);
        // 1. 驗證 captcher
        if(!checkCaptcher) {
            resp.getWriter().print("Captcher: " + checkCaptcher);
            return;
        }
        
        // 2. 檢查 username 是否已經被註冊 ?
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        if(getMember(username).size() > 0) {
            resp.getWriter().print(username + "已被註冊");
            return;
        }
        
        // 3. 加入到 Member 資料表中
        boolean check = newMember(username, password);
        if(check) {
            resp.getWriter().print("新增成功");
        } else {
            resp.getWriter().print("新增失敗");
        }
    }
    
}
