package com.web.study.jpa.crud;

import com.github.javafaker.Faker;
import com.web.study.jpa.entity.Person;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/jpa/person/create")
public class CreatePerson extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        // 建立 Person
        Person person = new Person();
        person.setName(new Faker().pokemon().name());
        person.setAge(new Random().nextInt(10) + 10);
        // 取得 EntityManagerFactory
        EntityManagerFactory emf = (EntityManagerFactory)getServletContext().getAttribute("emf");
        // 取得 EntityManager
        EntityManager em = emf.createEntityManager();
        // 新增一筆 Person 紀錄
        // 建立交易模式
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(person); // 將 person 加入
        et.commit(); // 提交
        em.close();
        out.print(person + " 建立成功");
    }
    
}
