package com.aegle.java.async.demo.service;

import com.aegle.java.async.demo.model.GenderData;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class GenderPredictor implements Predictor<GenderData>{

    private final String URL ="https://api.genderize.io";

    private final RestTemplate restTemplate;

    public GenderPredictor(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public GenderData predict(String name) {
        String url = UriComponentsBuilder.fromUriString(URL)
                .queryParam("name",name)
                .toUriString();

        ResponseEntity<GenderData> response = restTemplate.getForEntity(url,GenderData.class);
        if(response.getStatusCode()== HttpStatus.OK){
            return response.getBody();
        }
        else{
            throw new RuntimeException("Could Not Fetch Data For Gender: "+response.getStatusCode());
        }
    }
}
