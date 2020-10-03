package com.web.study.rest.lotto;

import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Random;
import java.util.Set;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Context;

@Path("lotto")
public class LottoService {

    private Set<Lotto> lottos = new LinkedHashSet<>();
    private int id;

    // uri: /rest/lotto/
    @Path("/")
    @GET
    @Produces("text/html")
    public String readAll() {
        return lottos.toString();
    }

    // uri: /rest/lotto/1
    @Path("{id}")
    @GET
    @Produces("text/html")
    public String read(@PathParam("id") Integer id) {
        Optional<Lotto> lo = lottos.stream().filter(lotto -> lotto.getId() == id).findAny();
        return lo.isPresent() ? lo.toString() : "Not found!";
    }

    // uri: /rest/lotto/
    @Path("/")
    @POST
    @Produces("text/html")
    public String create(@Context Application app) {
        Lotto lotto = genLotto(app);
        lottos.add(lotto);
        return "Lotto add OK";
    }
    
    // uri: /rest/lotto/1
    @Path("{id}")
    @PUT
    @Produces("text/html")
    public String update(@PathParam("id") Integer id, @Context Application app) {
        Optional<Lotto> lo = lottos.stream().filter(lotto -> lotto.getId() == id).findAny();
        if(lo.isPresent()) {
            Lotto newLotto = genLotto(app);
            lo.get().setNums(newLotto.getNums());
            return "Lotto update OK";
        } else {
            return "id: " + id + " not found";
        }
    }
    
    
    private Lotto genLotto(Application app) {
        Integer[] args = (Integer[])app.getProperties().get("lotto");
        int size = args[0];
        int max = args[1];
        Set<Integer> nums = new LinkedHashSet<>();
        while (nums.size() < size) {
            int num = new Random().nextInt(max) + 1;
            nums.add(num);
        }
        Lotto lotto = new Lotto();
        lotto.setId(++id);
        lotto.setNums(nums);
        return lotto;
    }

}
