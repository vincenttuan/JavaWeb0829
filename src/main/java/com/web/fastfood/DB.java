package com.web.fastfood;

import java.util.LinkedHashMap;
import java.util.Map;

public class DB {
    public static final Map<String, String> users = new LinkedHashMap<>();
    
    public static final Map<String, Integer> mainFoods = new LinkedHashMap<>();
    public static final Map<String, Integer> secondFoods = new LinkedHashMap<>();
    public static final Map<String, Integer> drinks = new LinkedHashMap<>();
    
    static {
        users.put("John", "1234");
        users.put("Mary", "5678");
        
        mainFoods.put("big_mac", 70);
        mainFoods.put("double_beef", 80);
        mainFoods.put("fish", 50);
        mainFoods.put("pounder_cheese", 90);
        
        secondFoods.put("apple_pie", 30);
        secondFoods.put("chicken", 40);
        secondFoods.put("french_fries", 20);
        secondFoods.put("french_fries_big", 40);
        secondFoods.put("hash_browns", 15);
        secondFoods.put("salad", 35);
        
        drinks.put("coca_cola", 20);
        drinks.put("corn_soup", 35);
        drinks.put("ice_cream", 25);
        drinks.put("iced_coffee", 45);
        drinks.put("milkshake", 40);
    }
}
