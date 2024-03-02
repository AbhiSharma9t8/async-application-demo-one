package com.aegle.java.async.demo.service;

import com.aegle.java.async.demo.model.AgeData;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class AgePredictor implements Predictor<AgeData>{

    private final String URL ="https://api.agify.io";

    private final RestTemplate restTemplate;

    public AgePredictor(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public AgeData predict(String name) {
        String url = UriComponentsBuilder.fromUriString(URL)
                .queryParam("name",name)
                .toUriString();
        ResponseEntity<AgeData> response = restTemplate.getForEntity(url,AgeData.class);
        if(response.getStatusCode()== HttpStatus.OK){
            return response.getBody();
        }
        else{
            throw new RuntimeException("Could Not Fetch Data For Age: "+response.getStatusCode());
        }
    }
}
