package com.aegle.java.async.demo.model;

import java.util.List;

public class ResponseData {

    private String name;
    private Integer age;
    private String gender;
    private List<CountryData> countryDataList;

    public ResponseData() {
    }

    public ResponseData(String name, Integer age, String gender, List<CountryData> countryDataList) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.countryDataList = countryDataList;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public List<CountryData> getCountryDataList() {
        return countryDataList;
    }

    public void setCountryDataList(List<CountryData> countryDataList) {
        this.countryDataList = countryDataList;
    }
}
