package com.globant.got.client.controller;

import com.globant.got.client.model.GoTCharacter;
import com.globant.got.client.service.GoTCharacterService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@AllArgsConstructor
public class GoTCharacterController {

    private final GoTCharacterService service;

    @GetMapping("/characters")
    public List<GoTCharacter> characters(@RequestParam(required = false) Map<String, String> queryParams) {
        return service.all(queryParams);
    }

    @GetMapping("/characters/{id}")
    public GoTCharacter character(@PathVariable("id") int id) {
        return service.one(id);
    }
}