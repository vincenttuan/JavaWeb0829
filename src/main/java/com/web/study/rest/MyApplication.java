package com.web.study.rest;

import com.web.student.service.StudentService;
import com.web.study.rest.lotto.LottoService;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("rest")
public class MyApplication extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> classes = new LinkedHashSet<>();
        classes.add(HelloService.class);
        classes.add(BMIService.class);
        return classes;
    }

    @Override
    public Set<Object> getSingletons() {
        Set<Object> set = new LinkedHashSet<>();
        set.add(new CountSingleTonService());
        set.add(new LottoService());
        set.add(new StudentService());
        return set;
    }

    @Override
    public Map<String, Object> getProperties() {
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("max", 10);
        map.put("min", 0);
        map.put("lotto", new Integer[]{5, 39});
        map.put("passScore", 60);
        return map;
    }
    
    
    
}
