package com.web.study.rest.jpa_mango.service;

import com.web.study.rest.jpa_mango.entity.Customer;
import com.web.study.rest.lotto.Lotto;
import java.util.List;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;

@Path("mango")
public class MangoService {
    // uri: /rest/mango/customers
    @Path("/customers")
    @GET
    @Produces("application/json")
    public List readAllCustomer(@Context HttpServletRequest req) {
        EntityManagerFactory emf = (EntityManagerFactory)req.getServletContext().getAttribute("emf");
        EntityManager em = emf.createEntityManager();
        return em.createNamedQuery("Customer.findAll").getResultList();
    }
}
