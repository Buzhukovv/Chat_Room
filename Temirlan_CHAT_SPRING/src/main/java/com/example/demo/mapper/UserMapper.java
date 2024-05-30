package com.example.demo.mapper;

import com.example.demo.dto.UsersDto;
import com.example.demo.model.User;
//import org.mapstruct.Mapper;
//import org.mapstruct.factory.Mappers;

//@Mapper(componentModel = "spring")
public interface UserMapper {
    UsersDto toDto(User user);
    User toEntity(UsersDto usersDto);
}