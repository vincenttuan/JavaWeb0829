package com.web.study.mvc.bmi.controller;

import com.web.study.mvc.bmi.model.BMI;
import com.web.study.mvc.bmi.model.BMIDAO;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "bmicontroller", urlPatterns = {"/mvc/bmi"})
public class BMIController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/mvc/bmi/view/bmi_form.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String _id = req.getParameter("_id");
        String height = req.getParameter("height");
        String weight = req.getParameter("weight");
        String sex = req.getParameter("sex");
        // 建立 BMI 物件
        BMI bmi = new BMI(Integer.parseInt(_id), 
                          Double.parseDouble(height), 
                          Double.parseDouble(weight), 
                          Integer.parseInt(sex));
        
        // 建立 Dao 物件
        BMIDAO dao = new BMIDAO();
        dao.add(bmi); // 將資料加入
        
        // 重導到 bmi_form.jsp
        List<BMI> bmis = dao.queryAll();
        req.setAttribute("bmis", bmis);
        req.setAttribute("avgHeight", bmis.stream().mapToDouble(b->b.getHeight()).average().getAsDouble());
        req.setAttribute("avgWeight", bmis.stream().mapToDouble(b->b.getWeight()).average().getAsDouble());
        doGet(req, resp);
    }

    
}
