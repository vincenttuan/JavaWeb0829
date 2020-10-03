package com.web.study.rest;

// url: /rest/bmi/john/170.0/60.5, /rest/bmi/mary/162.5/55.2

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

// output: John bmi: 20.76...

@Path("bmi")
public class BMIService {
    
    @Path("{name}/{h}/{w}")
    @GET
    @Produces("text/plain")
    public String calcBMI(@PathParam("name") String name, @PathParam("h") Double h, @PathParam("w") Double w) {
        double bmi = w / Math.pow(h/100, 2);
        name = name.substring(0, 1).toUpperCase() + name.substring(1);
        return String.format("%s bmi: %.2f", name, bmi);
    }
    
}
