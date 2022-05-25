package com.globant.got.client.service;

import com.globant.got.client.feign.client.HouseClient;
import com.globant.got.client.model.House;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class HouseService {
    @Value("${globant.client.host.url}")
    private String url;

    private final HouseClient client;

    public List<House> all(Map<String, String> queryParams) {
        return client.all(queryParams);
    }

    public House one(int id) {
        return client.one(id);
    }
}
