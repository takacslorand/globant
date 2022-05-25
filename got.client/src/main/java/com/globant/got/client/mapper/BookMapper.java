package com.globant.got.client.mapper;


import com.globant.got.client.dto.BookDTO;
import com.globant.got.client.model.Book;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface BookMapper {

    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

    BookDTO toDTO(Book model);

}