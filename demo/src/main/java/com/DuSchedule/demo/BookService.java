package com.DuSchedule.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class BookService {

    private static final String API_URL = "https://simple-books-api.glitch.me/books";

    public Book[] getBooks() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Book[]> response = restTemplate.getForEntity(API_URL, Book[].class);
        return response.getBody();
    }
}
