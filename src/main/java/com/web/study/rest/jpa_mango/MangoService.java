package com.web.study.rest.jpa_mango;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;

@Path("mango")
public class MangoService {
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
