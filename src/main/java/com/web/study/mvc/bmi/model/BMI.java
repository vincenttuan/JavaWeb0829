package com.web.study.mvc.bmi.model;

public class BMI {
    private int _id;
    private double height;
    private double weight;
    private int sex;
    private double bmi;

    public BMI() {
    }

    public BMI(int _id, double height, double weight, int sex) {
        this._id = _id;
        this.height = height;
        this.weight = weight;
        this.sex = sex;
        this.bmi = weight / Math.pow(height/100, 2);
    }

    public int getId() {
        return _id;
    }

    public void setId(int _id) {
        this._id = _id;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public double getBmi() {
        return bmi;
    }

    public void setBmi(double bmi) {
        this.bmi = bmi;
    }

    @Override
    public String toString() {
        return "BMI{" + "_id=" + _id + ", height=" + height + ", weight=" + weight + ", sex=" + sex + ", bmi=" + bmi + '}';
    }
    
    
}
