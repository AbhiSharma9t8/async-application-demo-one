package com.aegle.java.async.demo.model;

import java.util.List;

public class NationalityData {

    private Long Count;
    private String Name;
    List<CountryData> country;

    public NationalityData(Long count, String name, List<CountryData> countryList) {
        Count = count;
        Name = name;
        this.country = country;
    }

    public Long getCount() {
        return Count;
    }

    public void setCount(Long count) {
        Count = count;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public List<CountryData> getCountryList() {
        return country;
    }

    public void setCountryList(List<CountryData> countryList) {
        this.country = country;
    }
}
