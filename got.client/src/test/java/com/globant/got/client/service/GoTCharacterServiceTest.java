package com.globant.got.client.service;

import com.globant.got.client.model.GoTCharacter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GoTCharacterServiceTest {

    @Autowired
    private GoTCharacterService service;

    @Test
    public void whenSpringContextIsBootstrapped_thenNoExceptions() {
    }

    @Test
    public void whenGetAll_thenListSizeGreaterThanZero() {

        List<GoTCharacter> all = service.all(new HashMap<>());

        assertFalse(all.isEmpty());
    }

    @Test
    public void whenGetGoTCharacterById_thenGoTCharacterExist() {

        GoTCharacter one = service.one(1);

        assertNotNull(one);
    }

}