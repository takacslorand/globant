package com.globant.got.client.cucumber.house;

import com.globant.got.client.cucumber.common.GoTHttpClient;
import com.globant.got.client.model.House;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;
import java.util.stream.Stream;

import static org.junit.Assert.*;

public class StepDefinitions {

    private Exception caughtException;

    @Autowired
    private GoTHttpClient httpClient;

    @Given("^A list of houses is available$")
    public void list_is_not_empty() {
        House[] houses = httpClient.getAllHouses();
        assertFalse(houses.length <= 0);
    }

    @When("^If the house with id (\\d+) exists$")
    public void house_with_id_exists(final int id) {
        House House = httpClient.getOneHouse(id);
        assertNotNull(House);
    }


    @When("^If the house with id (\\d+) not exists$")
    public void house_with_id_not_exists(final int id) {
        House house;
        try {
            house = httpClient.getOneHouse(id);
        } catch (Exception e) {
            house = null;
        }
        assertNull(house);
    }

    @When("^If the house with id (\\d+) not exists throws exception$")
    public void house_with_id_not_exists_throwException(final int id){
        try {
            House house = httpClient.getOneHouse(id);
        } catch (Exception e) {
            caughtException = e;
        }
    }

    @Then("^House with id (\\d+) is in list$")
    public void house_is_in_list(final int id) {
        House[] houses = httpClient.getAllHouses();
        House house = httpClient.getOneHouse(id);
        Optional<House> optionalHouse = Stream.of(houses).filter(b -> b.getName().compareTo(house.getName()) == 0).findFirst();
        assertTrue(optionalHouse.isPresent());
    }

    @Then("^House with id (\\d+) is not in list$")
    public void house_is_not_in_list(final int id) {
        House house = httpClient.getOneHouse(id);
        assertNull(house);
    }

    @Then("^I got exception (.+)")
    public void exception_is_thrown(String ex){
        assertEquals("Exception MissMatch", ex, caughtException.getClass().getSimpleName());
    }
}