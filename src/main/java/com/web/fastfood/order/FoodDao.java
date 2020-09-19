package com.web.fastfood.order;

import com.web.fastfood.DB;
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
    public int getMainFoodsPrice(String name) {
        return DB.mainFoods.entrySet()
                .stream()
                .filter(e -> e.getKey().equals(name))
                .findFirst()
                .get()
                .getValue();
    }
    public int getSecondFoodsPrice(String name) {
        return DB.secondFoods.entrySet()
                .stream()
                .filter(e -> e.getKey().equals(name))
                .findFirst()
                .get()
                .getValue();
    }
    public int getDrinksPrice(String name) {
        return DB.drinks.entrySet()
                .stream()
                .filter(e -> e.getKey().equals(name))
                .findFirst()
                .get()
                .getValue();
    }
}
