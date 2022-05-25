package com.globant.got.client.service;

import com.globant.got.client.feign.client.BookClient;
import com.globant.got.client.model.Book;
import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class BookService {
    @Value("${globant.client.host.url}")
    private String url;

    public List<Book> all(Map<String, String> queryParams) {
        BookClient resource = Feign.builder()
                .encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder())
                .target(BookClient.class, url);
        return resource.all(queryParams);
    }


    public Book one(Integer id) {
        BookClient resource = Feign.builder()
                .encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder())
                .target(BookClient.class, url);
        return resource.one(id);
    }
}
