package com.aegle.java.async.demo.service;

import com.aegle.java.async.demo.model.*;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Service
public class DataAggregatorService {

    private final AgePredictor agePredictor;
    private final GenderPredictor genderPredictor;
    private final CountryPredictor countryPredictor;

    public DataAggregatorService(AgePredictor agePredictor, GenderPredictor genderPredictor, CountryPredictor countryPredictor) {
        this.agePredictor = agePredictor;
        this.genderPredictor = genderPredictor;
        this.countryPredictor = countryPredictor;
    }

    public ResponseData getAllValuesOfPersonName(String name){

        ResponseData responseData = new ResponseData();
        responseData.setName(name);


        CompletableFuture<AgeData> ageDataCompletableFuture = CompletableFuture
                .supplyAsync(()->agePredictor.predict(name));
        CompletableFuture<GenderData> genderDataCompletableFuture = CompletableFuture
                .supplyAsync(()->genderPredictor.predict(name));
        CompletableFuture<NationalityData> nationalityDataCompletableFuture = CompletableFuture
                .supplyAsync(()->countryPredictor.predict(name));

        try {
            AgeData ageData = ageDataCompletableFuture.get();
            GenderData genderData = genderDataCompletableFuture.get();
            NationalityData nationalityData = nationalityDataCompletableFuture.get();
            responseData.setAge(ageData.getAge());
            responseData.setGender(genderData.getGender());
            responseData.setCountryDataList(nationalityData.getCountryList());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        return responseData;


    }




}
