package com.globant.got.client.service;

import com.globant.got.client.feign.client.GoTCharacterClient;
import com.globant.got.client.model.GoTCharacter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class GoTCharacterService {

    @Value("${globant.client.host.url}")
    private String url;
    private final GoTCharacterClient client;

    public List<GoTCharacter> all(Map<String, String> queryParams) {
        return client.all(queryParams);
    }

    public GoTCharacter one(int id) {
        return client.one(id);
    }
}
