package com.globant.got.client.mapper;


import com.globant.got.client.dto.HouseDTO;
import com.globant.got.client.model.House;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface HouseMapper {

    HouseMapper INSTANCE = Mappers.getMapper(HouseMapper.class);

    HouseDTO toDTO(House model);

}