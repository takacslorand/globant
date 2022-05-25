package com.globant.got.client.feign.client;

import com.globant.got.client.model.Book;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

import java.util.List;

public interface BookClient {

    @RequestLine(value = "GET /books")
    @Headers("Content-Type: application/json")
    List<Book> all();

    @RequestLine(value = "GET /books/{id}")
    @Headers("Content-Type: application/json")
    Book one(@Param int id);
}