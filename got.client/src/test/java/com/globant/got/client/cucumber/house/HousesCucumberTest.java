package com.globant.got.client.cucumber.house;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features/houses",
        plugin = {"pretty", "html:target/cucumber/houses"},
        extraGlue = "com.globant.got.client.cucumber.common")
public class HousesCucumberTest {
}