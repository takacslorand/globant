package com.globant.got.client.cucumber.common;

import com.globant.got.client.model.Book;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import static io.cucumber.spring.CucumberTestContext.SCOPE_CUCUMBER_GLUE;

@Component
@Scope(SCOPE_CUCUMBER_GLUE)
public class GoTHttpClient {

    private final String SERVER_URL = "http://localhost";
    private final String BOOKS_ENDPOINT = "/books";
    @LocalServerPort
    private int port;
    private final RestTemplate restTemplate = new RestTemplate();

    private String booksEndpoint() {
        return SERVER_URL + ":" + port + BOOKS_ENDPOINT;
    }

    public Book getOne(int id) {
        return restTemplate.getForObject("http://localhost:8080/books/{id}", Book.class, id);
    }

    public Book[] getAll() {
        return restTemplate.getForObject(booksEndpoint(), Book[].class);
    }

}