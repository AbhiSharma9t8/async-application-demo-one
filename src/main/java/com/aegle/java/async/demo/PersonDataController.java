package com.aegle.java.async.demo;

import com.aegle.java.async.demo.model.ResponseData;
import com.aegle.java.async.demo.service.DataAggregatorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonDataController {

    private final DataAggregatorService dataAggregatorService;

    public PersonDataController(DataAggregatorService dataAggregatorService) {
        this.dataAggregatorService = dataAggregatorService;
    }

    @GetMapping("/input")
    public ResponseEntity<ResponseData> process(@RequestParam("name") String name){
        ResponseData responseData = dataAggregatorService.getAllValuesOfPersonName(name);
        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }
}
