package com.globant.got.client.controller;

import com.globant.got.client.feign.client.BookClient;
import com.globant.got.client.model.Book;
import feign.Feign;
import feign.form.spring.SpringFormEncoder;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {

    @Value("${globant.client.host.url}")
    private String url;

    @GetMapping("/books")
    public List<Book> getBooks() {
        BookClient resource = Feign.builder()
                .encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder())
                .target(BookClient.class, url);
        return resource.all();
    }

    @GetMapping("/books/{id}")
    public Book getBook(@PathVariable("id") int id) {
        BookClient resource = Feign.builder()
                .encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder())
                .target(BookClient.class, url);
        return resource.one(id);
    }
}