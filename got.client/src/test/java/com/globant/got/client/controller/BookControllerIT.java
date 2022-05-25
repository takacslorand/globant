package com.globant.got.client.controller;

import com.globant.got.client.model.Book;
import com.globant.got.client.service.BookService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.internal.verification.VerificationModeFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(value = BookController.class)
public class BookControllerIT {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private BookService service;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void givenBooks_whenGeBooks_thenReturnJsonArray() throws Exception {
        List<Book> books = Stream.of("test1", "test2").sequential().map( s-> {
            Book book = new Book();
            book.setName(s);
            return  book;
        }).collect(Collectors.toList());

        given(service.all(Mockito.any())).willReturn(books);

        mvc.perform(get("/books").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].name", is("test1")))
                .andExpect(jsonPath("$[1].name", is("test2")));
        verify(service, VerificationModeFactory.times(1)).all(Mockito.any());
        reset(service);
    }

    @Test
    public void whenGetOne_thenReturnJson() throws Exception {
        Book book = new Book();
        book.setName("test");
        given(service.one(Mockito.any())).willReturn(book);

        mvc.perform(get("/books/1").contentType(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andExpect(jsonPath("$.name", is("test")));
        verify(service, VerificationModeFactory.times(1)).one(Mockito.any());
        reset(service);
    }



}