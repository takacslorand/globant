package com.globant.got.client.controller;

import com.globant.got.client.model.Book;
import com.globant.got.client.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@AllArgsConstructor
public class BookController {

    private BookService service;

    @GetMapping("/books")
    public List<Book> getBooks(@RequestParam(required = false) Map<String, String> queryParams) {
        return service.all(queryParams);
    }

    @GetMapping("/books/{id}")
    public Book getBook(@PathVariable("id") int id) {
        return service.one(id);
    }
}