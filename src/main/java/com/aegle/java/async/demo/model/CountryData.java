package com.aegle.java.async.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CountryData {

    @JsonProperty("country_id")
    private String countryId;
    private Float probability;

    public CountryData(String countryId, Float probability) {
        this.countryId = countryId;
        this.probability = probability;
    }

    public String getCountryId() {
        return countryId;
    }

    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }

    public Float getProbability() {
        return probability;
    }

    public void setProbability(Float probability) {
        this.probability = probability;
    }
}
