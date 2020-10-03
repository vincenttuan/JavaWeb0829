package com.web.student.service;

import com.web.student.entity.Message;
import com.web.student.entity.Student;
import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("student")
public class StudentService {
    private Set<Student> students = new LinkedHashSet<>();
    
    // uri: /rest/student/
    @Path("/")
    @GET
    @Produces("application/json")
    public Response getAll() {
        if(students.size() > 0) {
            return Response.ok().entity(students).encoding("utf-8").build();
        } else {
            Message message = new Message(400, "No data !");
            return Response.status(message.getCode()).entity(message).encoding("utf-8").build();
        }
    }
    
    // uri: /rest/student/1
    @Path("{id}")
    @GET
    @Produces("application/json")
    public Response get(@PathParam("id") Integer id) {
        Optional<Student> st = students.stream().filter(s -> s.getId() == id).findFirst();
        if(st.isPresent()) {
            return Response.ok().entity(st.get()).encoding("utf-8").build();
        } else {
            Message message = new Message(400, String.format("id: %d not fount", id));
            return Response.status(message.getCode()).entity(message).encoding("utf-8").build();
        }
    }
    
    /*
    uri: /rest/student/
    Json 格式
    {
        "id": 1,
        "name": "John",
        "score": 90
    }
    */
    @Path("/")
    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Response create(Student student) {
        if(student != null) {
            students.add(student);
            Message message = new Message(200, "create success !");
            return Response.ok().entity(message).encoding("utf-8").build();
        } else {
            Message message = new Message(400, "No data (create error) !");
            return Response.status(message.getCode()).entity(message).encoding("utf-8").build();
        }
    }
}
