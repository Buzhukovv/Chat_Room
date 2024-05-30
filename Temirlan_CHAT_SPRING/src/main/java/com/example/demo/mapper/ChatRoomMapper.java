package com.example.demo.mapper;

import com.example.demo.dto.ChatRoomDto;
import com.example.demo.model.ChatRoom;
import com.example.demo.model.User;
import org.mapstruct.*;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.mapstruct.NullValueCheckStrategy.ALWAYS;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ChatRoomMapper {
    @Mappings({
            @Mapping(target = "userIds", source = "users", qualifiedByName = "toUsersId")
    })
    ChatRoomDto toDto(ChatRoom chatRoom);

    @Named("toUsersId")
    default List<Long> toUsersId(List<User> users) {
        return users.stream().map(User::getId).collect(Collectors.toList());
    }
}


//
//    @Mappings({
//            @Mapping(target = "userIds", source = "users", qualifiedByName = "toUsersId")
//    })
//    ChatRoomDto toDto(ChatRoom chatRoom);
//
//    @Mapping(target = "users", source = "userIds", qualifiedByName = "toUsers")
//    ChatRoom toEntity(ChatRoomDto chatRoomDto);
//
//    @Named("toUsersId")
//    default Set<Long> toUsersId(Set<User> users) {
//        return users.stream().map(User::getId).collect(Collectors.toSet());
//    }
//
//    @Named("toUsers")
//    default Set<User> toUsers(Set<Long> userIds) {
//        // This method will be implemented in the service to map user IDs to User entities
//        return userIds.stream().map(id -> {
//            User user = new User();
//            user.setId(id);
//            return user;
//        }).collect(Collectors.toSet());
//}


//
//
//    void toEntity(ChatRoomDto dto, @MappingTarget ChatRoom chatRoom);
//    @Mappings({
//            @Mapping(target = "userIds", source = , qualifiedByName = "toUsersId")
//    })
//    ChatRoomDto toDto(ChatRoom chatRoom);
//
//    @Named("toUsersId")
//    default Set<Long> toUsersId(Set<User> users) {
//        return users.stream().map(User::getId).collect(Collectors.toSet());
//    }

