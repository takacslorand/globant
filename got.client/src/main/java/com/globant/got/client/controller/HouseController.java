package com.globant.got.client.controller;

import com.globant.got.client.feign.client.HouseClient;
import com.globant.got.client.model.House;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class HouseController {

    @Value("${globant.client.host.url}")
    private String url;

    private final HouseClient client;

    public HouseController(HouseClient client) {
        this.client = client;
    }

    @GetMapping("/houses")
    public List<House> getBooks(@RequestParam(required=false) Map<String,String> queryParams) {
        return client.all(queryParams);
    }

    @GetMapping("/houses/{id}")
    public House getBook(@RequestParam("id") int id) {
        return client.one(id);
    }
}