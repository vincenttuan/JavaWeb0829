package com.web.fastfood;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/fastfood/order")
public class OrderServlet extends HttpServlet {
    private FoodDao dao = new FoodDao();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("mainFoods", dao.getMainFoods());
        req.setAttribute("secondFoods", dao.getSecondFoods());
        req.setAttribute("drinks", dao.getDrinks());
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/mvc/fastfood/order.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
    }
    
    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
    }

    
}
