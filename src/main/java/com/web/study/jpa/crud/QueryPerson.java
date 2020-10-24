package com.web.study.jpa.crud;

import com.web.study.jpa.entity.Person;
import java.io.IOException;
import java.io.PrintWriter;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/jpa/person/query")
public class QueryPerson extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        // 取得 EntityManagerFactory
        EntityManagerFactory emf = (EntityManagerFactory)getServletContext().getAttribute("emf");
        // 取得 EntityManager
        EntityManager em = emf.createEntityManager();
        // 全部查詢
        Query query = em.createQuery("SELECT p FROM Person p");
        out.print(query.getResultList());
        out.print("<hr>");
        // 帶入條件查詢
        String sql = "SELECT p FROM Person p WHERE p.age >= :age";
        query = em.createQuery(sql);
        query.setParameter("age", 15);        
        out.print(query.getResultList());
        out.print("<hr>");
        
        em.close();
    }
    
}
