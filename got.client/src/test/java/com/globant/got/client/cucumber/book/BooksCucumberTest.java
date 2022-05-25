package com.globant.got.client.cucumber.book;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features/books",
        plugin = {"pretty", "html:target/cucumber/books"},
        extraGlue = "com.globant.got.client.cucumber.common")
public class BooksCucumberTest {
}