package com.aegle.java.async.demo.model;

public class GenderData {

    private Long count;
    private String name;
    private String Gender;
    private Float probability;

    public GenderData(Long count, String name, String gender, Float probability) {
        this.count = count;
        this.name = name;
        Gender = gender;
        this.probability = probability;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public Float getProbability() {
        return probability;
    }

    public void setProbability(Float probability) {
        this.probability = probability;
    }
}
