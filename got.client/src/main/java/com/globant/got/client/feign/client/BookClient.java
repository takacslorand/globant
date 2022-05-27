package com.globant.got.client.feign.client;

import com.globant.got.client.feign.client.error.FeignClientExceptionHandler;
import com.globant.got.client.feign.client.error.HandleFeignException;
import com.globant.got.client.model.Book;
import feign.Headers;
import feign.Param;
import feign.QueryMap;
import feign.RequestLine;

import java.util.List;
import java.util.Map;

public interface BookClient {

    @RequestLine(value = "GET /books")
    @Headers("Content-Type: application/json")
    @HandleFeignException(FeignClientExceptionHandler.class)
    List<Book> all(@QueryMap Map<String, String> queryMap);

    @RequestLine(value = "GET /books/{id}")
    @Headers("Content-Type: application/json")
    @HandleFeignException(FeignClientExceptionHandler.class)
    Book one(@Param int id);
}