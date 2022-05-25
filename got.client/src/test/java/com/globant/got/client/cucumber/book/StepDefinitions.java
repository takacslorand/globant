package com.globant.got.client.cucumber.book;

import com.globant.got.client.cucumber.common.GoTHttpClient;
import com.globant.got.client.model.Book;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;
import java.util.stream.Stream;

import static org.junit.Assert.*;

public class StepDefinitions {

    @Autowired
    private GoTHttpClient httpClient;

    @Given("^A list of books is available$")
    public void list_is_not_empty() {
        Book[] books = httpClient.getAll();
        assertFalse(books.length <= 0);
    }

    @When("^If the book with id (\\d+) exists$")
    public void book_with_id_exists(final int id) {
        Book book = httpClient.getOne(id);
        assertNotNull(book);
    }

    @When("^If the book with id (\\d+) not exists$")
    public void book_with_id_not_exists(final int id) {
        Book book = httpClient.getOne(id);
        assertNull(book);
    }

    @Then("^Books with id (\\d+) is in list$")
    public void book_is_in_list(final int id) {
        Book[] books = httpClient.getAll();
        Book book = httpClient.getOne(id);
        Optional<Book> optionalBook = Stream.of(books).filter(b -> b.getIsbn().compareTo(book.getIsbn()) == 0).findFirst();
        assertTrue(optionalBook.isPresent());
    }

    @Then("^Books with id (\\d+) is not in list$")
    public void book_is_not_in_list(final int id) {
        Book[] books = httpClient.getAll();
        Book book = httpClient.getOne(id);
        assertNull(book);
    }
}