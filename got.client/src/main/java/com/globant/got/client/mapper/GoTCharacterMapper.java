package com.globant.got.client.mapper;


import com.globant.got.client.dto.GoTCharacterDTO;
import com.globant.got.client.model.GoTCharacter;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface GoTCharacterMapper {

    GoTCharacterMapper INSTANCE = Mappers.getMapper(GoTCharacterMapper.class);

    GoTCharacterDTO toDTO(GoTCharacter model);

}