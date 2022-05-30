package com.globant.got.client.cucumber.common;

import com.globant.got.client.model.Book;
import com.globant.got.client.model.House;
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
    private final String HOUSES_ENDPOINT = "/houses";
    private final String CHARACTERS_ENDPOINT = "/characters";

    @LocalServerPort
    private int port;
    private final RestTemplate restTemplate = new RestTemplate();

    private String endpoint(String endpoint) {
        return SERVER_URL + ":" + port + endpoint;
    }

    public Book getOneBook(int id) {
        return restTemplate.getForObject("http://localhost:8080/books/{id}", Book.class, id);
    }

    public Book[] getAllBooks() {
        return restTemplate.getForObject(endpoint(BOOKS_ENDPOINT), Book[].class);
    }

    public House getOneHouse(int id) {
        return restTemplate.getForObject("http://localhost:8080/" + HOUSES_ENDPOINT + "/{id}", House.class, id);
    }

    public House[] getAllHouses() {
        return restTemplate.getForObject(endpoint(HOUSES_ENDPOINT), House[].class);
    }


}