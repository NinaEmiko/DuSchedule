package com.DuSchedule.demo;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CarService {

    private static final String API_URL = "https://car-models-and-data.p.rapidapi.com/api/v1/brands";
    private static final String API_Key = APIKeyLoader.getAPIKey();
    private static final String API_Host = "car-models-and-data.p.rapidapi.com";

    public Car[] getCars() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-RapidAPI-Key", API_Key);
        headers.set("X-RapidAPI-Host", API_Host);

        RestTemplate restTemplate = new RestTemplate();
        // ResponseEntity<Car[]> response = restTemplate.getForEntity(API_URL,
        // Car[].class);
        ResponseEntity<Car[]> response = restTemplate.exchange(API_URL, HttpMethod.GET, new HttpEntity<>(headers),
                Car[].class);
        return response.getBody();
    }
}