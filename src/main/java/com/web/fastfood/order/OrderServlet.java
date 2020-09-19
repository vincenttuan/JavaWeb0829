package com.web.fastfood.order;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
            session.setAttribute("shoppingCar", shoppingCar);
        }
        shoppingCar = (List<Food>)session.getAttribute("shoppingCar");
        if(mainfoodsName != null && mainfoodsName.length() > 0) {
            Food food = new Food();
            food.setNo(nextShoppingCarOrderNo(shoppingCar));
            food.setName(mainfoodsName);
            food.setPrice(dao.getMainFoodsPrice(mainfoodsName));
            shoppingCar.add(food);
        }
        if(secondfoodsName != null && secondfoodsName.length() > 0) {
            Food food = new Food();
            food.setNo(nextShoppingCarOrderNo(shoppingCar));
            food.setName(secondfoodsName);
            food.setPrice(dao.getSecondFoodsPrice(secondfoodsName));
            shoppingCar.add(food);
        }
        if(drinks != null && drinks.length() > 0) {
            Food food = new Food();
            food.setNo(nextShoppingCarOrderNo(shoppingCar));
            food.setName(drinks);
            food.setPrice(dao.getDrinksPrice(drinks));
            shoppingCar.add(food);
        }
        doGet(req, resp);
    }
    
    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream()));
        String data = br.readLine();
        System.out.println(data);
        int no = Integer.parseInt(data.split("=")[1].trim());
        HttpSession session = req.getSession(false);
        if(session != null) {
            List<Food> shoppingCar = (List<Food>)session.getAttribute("shoppingCar");
            shoppingCar.remove(shoppingCar.stream()
                                          .filter(f -> f.getNo() == no)
                                          .findFirst()
                                          .get());
        }
    }

    
    private int nextShoppingCarOrderNo(List<Food> shoppingCar) {
        if(shoppingCar == null || shoppingCar.size() == 0) {
            return 1;
        }
        int maxNo = shoppingCar.stream().mapToInt(f -> f.getNo()).max().getAsInt();
        return maxNo + 1;
    }
    
}
