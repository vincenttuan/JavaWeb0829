package com.web.study.mvc.bmi.model;

import java.util.ArrayList;
import java.util.List;

public class BMIDAO {
    private static List<BMI> bmis = new ArrayList<>();
    
    public void add(BMI bmi) {
        bmis.add(bmi);
    }
    
    public List<BMI> queryAll() {
        return bmis;
    }
    
}
