package com.globant.got.client.controller;

import com.globant.got.client.model.House;
import com.globant.got.client.service.HouseService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.internal.verification.VerificationModeFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(value = HouseController.class)
public class HouseControllerIT {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private HouseService service;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void givenHouses_whenGetHouses_thenReturnJsonArray() throws Exception {
        List<House> books = Stream.of("test1", "test2").sequential().map(s-> {
            House house = new House();
            house.setName(s);
            return  house;
        }).collect(Collectors.toList());

        given(service.all(Mockito.any())).willReturn(books);

        mvc.perform(get("/houses").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].name", is("test1")))
                .andExpect(jsonPath("$[1].name", is("test2")));
        verify(service, VerificationModeFactory.times(1)).all(Mockito.any());
        reset(service);
    }

    @Test
    public void whenGetOne_thenReturnJson() throws Exception {
        House house = new House();
        house.setName("test");
        given(service.one(anyInt())).willReturn(house);

        mvc.perform(get("/houses/1").contentType(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andExpect(jsonPath("$.name", is("test")));
        verify(service, VerificationModeFactory.times(1)).one(anyInt());
        reset(service);
    }



}