package com.DuSchedule.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CarService {

    private static final String API_URL = "https://simple-books-api.glitch.me/books";

    public Car[] getCars() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Car[]> response = restTemplate.getForEntity(API_URL, Car[].class);
        return response.getBody();
    }
}