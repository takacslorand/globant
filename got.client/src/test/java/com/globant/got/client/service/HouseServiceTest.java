package com.globant.got.client.service;

import com.globant.got.client.model.House;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HouseServiceTest {

    @Autowired
    private HouseService service;

    @Test
    public void whenSpringContextIsBootstrapped_thenNoExceptions() {
    }

    @Test
    public void whenGetAll_thenListSizeGreaterThanZero() {

        List<House> all = service.all(new HashMap<>());

        assertFalse(all.isEmpty());
    }


    @Test
    public void whenFilterByQueryParams_thenValueIsCorrect() {
        Map queryParams = new HashMap<String, String>();

        queryParams.put("hasDiedOut", "true");
        List<House> all = service.all(queryParams);
        assertFalse(all.isEmpty());
        assertNotNull(all.get(0).getDiedOut());
        assertTrue(!all.get(0).getDiedOut().isEmpty());

        queryParams.put("hasDiedOut", "false");
        all = service.all(queryParams);
        assertFalse(all.isEmpty());
        assertNotNull(all.get(0).getDiedOut());
        assertTrue(all.get(0).getDiedOut().isEmpty());
    }

    @Test
    public void whenGetHouseById_thenHouseExist() {

        House one = service.one(1);

        assertNotNull(one);
    }

}