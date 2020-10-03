package com.web.study.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("hello")
public class HelloService {
    
    @Path("john")
    @GET
    @Produces("text/plain")
    public String helloJohn() {
        return "Hello John";
    }
}
