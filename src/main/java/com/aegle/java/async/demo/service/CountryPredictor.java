package com.aegle.java.async.demo.service;

import com.aegle.java.async.demo.model.CountryData;
import com.aegle.java.async.demo.model.NationalityData;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class CountryPredictor implements Predictor<NationalityData> {

    private final String URL ="https://api.nationalize.io";

    private final RestTemplate restTemplate;

    public CountryPredictor(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public NationalityData predict(String name) {
        String url = UriComponentsBuilder.fromUriString(URL)
                .queryParam("name",name)
                .toUriString();

        ResponseEntity<NationalityData> response = restTemplate.getForEntity(url, NationalityData.class);
       // System.out.println(response.getBody().getCountryList().toString());
        if(response.getStatusCode()== HttpStatus.OK){
            return response.getBody();
        }
        else{
            throw new RuntimeException("Could Not Fetch Data For Nationality: "+response.getStatusCode());
        }
    }
}
