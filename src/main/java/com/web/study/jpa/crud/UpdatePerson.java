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

@WebServlet("/jpa/person/update")
public class UpdatePerson extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        int id = Integer.parseInt(req.getParameter("id"));
        int age = Integer.parseInt(req.getParameter("age"));
        // 取得 EntityManagerFactory
        EntityManagerFactory emf = (EntityManagerFactory)getServletContext().getAttribute("emf");
        // 取得 EntityManager
        EntityManager em = emf.createEntityManager();
        // 尋找 Person
        Person person = em.find(Person.class, id);
        if(person == null) {
            out.print("查無此人 !");
            em.close();
            return;
        }
        out.print(person + " 要進行修改");
        person.setAge(age);
        // 修改一筆 Person 紀錄
        // 建立交易模式
        EntityTransaction et = em.getTransaction();
        et.begin(); // 交易開始
        em.merge(person); // 將 person 資料修改
        et.commit(); // 交易提交
        em.close();
        out.print(person + " 修改成功");
    }
    
}
