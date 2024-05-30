package com.example.demo.mapper;

import com.example.demo.dto.MessageDto;
import com.example.demo.model.Message;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface MessageMapper {
    @Mappings({
            @Mapping(target = "chatRoomId", source = "chatRoom.id"),
            @Mapping(target = "userId", source = "user.id")
    })
    MessageDto toDto(Message message);
    Message toEntity(MessageDto messageDto);
}