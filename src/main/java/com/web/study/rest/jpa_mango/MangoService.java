package com.web.study.rest.jpa_mango;

import com.web.student.entity.Message;
import com.web.student.entity.Student;
import com.web.study.rest.jpa_mango.entity.Customer;
import com.web.study.rest.jpa_mango.entity.Mango;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

@Path("mango")
public class MangoService {
    // http://localhost:8080/JavaWeb0829/rest/mango/customers
    @Path("customer")
    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public String create(Customer customer, @Context HttpServletRequest req) {
        System.out.println(customer);
        EntityManager em = getEntityManager(req);
        // 確認數量
        Mango mango = (Mango)em.createNamedQuery("Mango.Remain.Amount").getSingleResult();
        System.out.println(mango);
        if(mango.getAmount() >= customer.getAmount()) {
            EntityTransaction et = em.getTransaction();
            et.begin(); // 交易開始
            em.persist(customer); // 將 customer 加入
            et.commit(); // 交易提交
            em.close();
            return "OK";
        } else {
            return "餘量不足, 尚有庫存:" + mango.getAmount();
        }
    }
    
    // http://localhost:8080/JavaWeb0829/rest/mango/customers
    @Path("customers")
    @GET
    @Produces("application/json")
    public List readAllCustomer(@Context HttpServletRequest req) {
        EntityManager em = getEntityManager(req);
        return em.createNamedQuery("Customer.findAll").getResultList();
    }
    
    private EntityManager getEntityManager(HttpServletRequest req) {
        EntityManagerFactory emf = (EntityManagerFactory)req.getServletContext().getAttribute("emf");
        return emf.createEntityManager();
    }
    
}
