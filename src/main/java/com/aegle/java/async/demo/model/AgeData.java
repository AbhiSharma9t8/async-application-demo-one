package com.aegle.java.async.demo.model;

public class AgeData {

    private Long count;
    private String name;
    private Integer age;

    public AgeData(Long count, String name, Integer age) {
        this.count = count;
        this.name = name;
        this.age = age;
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "AgeData{" +
                "count=" + count +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
