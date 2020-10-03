package com.web.study.rest.lotto;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Random;
import java.util.Set;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

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
    
    // uri: /rest/lotto/
    @Path("/")
    @POST
    @Produces("text/html")
    public String create() {
        Set<Integer> nums = new LinkedHashSet<>();
        while (nums.size() < 5) {
            int num = new Random().nextInt(39) + 1;
            nums.add(num);
        }
        Lotto lotto = new Lotto();
        lotto.setId(++id);
        lotto.setNums(nums);
        
        lottos.add(lotto);
        return "Lotto add OK";
    }
    
}
