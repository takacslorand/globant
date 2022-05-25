package com.globant.got.client.controller;

import com.globant.got.client.feign.client.CharacterClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class CharacterController {

    @Value("${globant.client.host.url}")
    private String url;

    private final CharacterClient client;

    public CharacterController(CharacterClient client) {
        this.client = client;
    }

    @GetMapping("/characters")
    public List<Character> getBooks(@RequestParam(required = false) Map<String, String> queryParams) {
        return client.all(queryParams);
    }

    @GetMapping("/characters/{id}")
    public Character getBook(@RequestParam("id") int id) {
        return client.one(id);
    }
}