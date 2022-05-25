package com.globant.got.client.service;

import com.globant.got.client.feign.client.BookClient;
import com.globant.got.client.model.Book;
import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class BookService {
    @Value("${globant.client.host.url}")
    private String url;

    public List<Book> all(Map<String, String> queryParams) {
        log.info("Get all books, query params:", queryParams);
        BookClient resource = Feign.builder()
                .encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder())
                .target(BookClient.class, url);
        return resource.all(queryParams);
    }


    public Book one(Integer id) {
        log.info("Get book with id:", id);

        BookClient resource = Feign.builder()
                .encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder())
                .target(BookClient.class, url);
        try {
            return resource.one(id);
        } catch (Exception e) {
            return null;
        }
    }
}
