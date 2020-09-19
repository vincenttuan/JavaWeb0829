package com.web.fastfood;

import java.util.Map;

public class FoodDao {
    public Map<String, Integer> getMainFoods() {
        return DB.mainFoods;
    }
    public Map<String, Integer> getSecondFoods() {
        return DB.secondFoods;
    }
    public Map<String, Integer> getDrinks() {
        return DB.drinks;
    }
}
