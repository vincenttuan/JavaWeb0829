package com.web.study.rest.lotto;

import java.util.Set;

public class Lotto {
    private int id;
    private Set<Integer> nums;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Set<Integer> getNums() {
        return nums;
    }

    public void setNums(Set<Integer> nums) {
        this.nums = nums;
    }

    @Override
    public String toString() {
        return "Lotto{" + "id=" + id + ", nums=" + nums + '}';
    }
    
}
