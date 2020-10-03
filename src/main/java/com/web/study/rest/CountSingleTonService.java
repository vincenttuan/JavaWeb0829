package com.web.study.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("count")
public class CountSingleTonService {
    private int count;
    
    // uri: /rest/count/add
    @Path("add")
    @GET
    @Produces("text/plain")
    public String add() {
        count++;
        return "Count: " + count;
    }
    
    
}
