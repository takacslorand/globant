package com.globant.got.client.controller;

import com.globant.got.client.model.House;
import com.globant.got.client.service.HouseService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@AllArgsConstructor
public class HouseController {
    private final HouseService service;

    @GetMapping("/houses")
    public List<House> houses(@RequestParam(required = false) Map<String, String> queryParams) {
        return service.all(queryParams);
    }

    @GetMapping("/houses/{id}")
    public House house(@PathVariable("id") int id) {
        return service.one(id);
    }
}