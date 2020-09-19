package com.web.fastfood;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/fastfood/order")
public class OrderServlet extends HttpServlet {
    private FoodDao dao = new FoodDao();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        req.setAttribute("mainFoods", dao.getMainFoods());
        req.setAttribute("secondFoods", dao.getSecondFoods());
        req.setAttribute("drinks", dao.getDrinks());
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/mvc/fastfood/order.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String mainfoodsName = req.getParameter("mainfoods");
        String secondfoodsName = req.getParameter("secondfoods");
        String drinks = req.getParameter("drinks");
        HttpSession session = req.getSession(false);
        List<Food> shoppingCar = null;
        if(session.getAttribute("shoppingCar") == null) {
            shoppingCar = new ArrayList<>();
        } else {
            shoppingCar = (List<Food>)session.getAttribute("shoppingCar");
        }
        if(mainfoodsName != null) {
            Food food = new Food();
            food.setNo(shoppingCar.size() + 1);
            food.setName(mainfoodsName);
            food.setPrice(dao.getMainFoodsPrice(mainfoodsName));
            shoppingCar.add(food);
        }
        if(secondfoodsName != null) {
            Food food = new Food();
            food.setNo(shoppingCar.size() + 1);
            food.setName(secondfoodsName);
            food.setPrice(dao.getSecondFoodsPrice(secondfoodsName));
            shoppingCar.add(food);
        }
        if(drinks != null) {
            Food food = new Food();
            food.setNo(shoppingCar.size() + 1);
            food.setName(drinks);
            food.setPrice(dao.getDrinksPrice(drinks));
            shoppingCar.add(food);
        }
        session.setAttribute("shoppingCar", shoppingCar);
        doGet(req, resp);
    }
    
    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
    }

    
}