package com.example.demo.services.impl;

import com.example.demo.dto.MessageDto;
import com.example.demo.mapper.MessageMapper;
import com.example.demo.model.ChatRoom;
import com.example.demo.model.Message;
import com.example.demo.model.User;
import com.example.demo.repository.ChatRoomRepository;
import com.example.demo.repository.MessageRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.services.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class MessageServiceImpl implements MessageService {

    private final MessageRepository messageRepository;
    private final MessageMapper messageMapper;
    private final ChatRoomRepository chatRoomRepository;
    private final UserRepository userRepository;

    @Override
    public MessageDto sendMessage(MessageDto messageDto) {
        Message message = messageMapper.toEntity(messageDto);

        ChatRoom chatRoom = chatRoomRepository.findById(messageDto.getChatRoomId())
                .orElseThrow(() -> new RuntimeException("Chat room not found"));
        User user = userRepository.findById(messageDto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Проверка принадлежности пользователя к чат-комнате
        if (!chatRoom.getUsers().contains(user)) {
            throw new RuntimeException("User does not belong to the chat room");
        }

        message.setChatRoom(chatRoom);
        message.setUser(user);
        message.setTimestamp(LocalDateTime.now()); // Установите текущее время

        Message savedMessage = messageRepository.save(message);
        return messageMapper.toDto(savedMessage);
    }


    @Override
    public MessageDto getMessageById(Long id) {
        Message message = messageRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Message not found"));
        return messageMapper.toDto(message);
    }

    @Override
    public List<MessageDto> getAllMessagesByChatRoomId(Long chatRoomId) {
        return messageRepository.findAllByChatRoomId(chatRoomId).stream()
                .map(messageMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteMessage(Long id) {
        messageRepository.deleteById(id);
    }
}



//
//@Service
//@RequiredArgsConstructor
//public class MessageServiceImpl implements MessageService {
//
//    private final MessageRepository messageRepository;
//    private final MessageMapper messageMapper;
//
//    @Override
//    public MessageDto sendMessage(MessageDto messageDto) {
//        Message message = messageMapper.toEntity(messageDto);
//        Message savedMessage = messageRepository.save(message);
//        return messageMapper.toDto(savedMessage);
//    }
//
//    @Override
//    public MessageDto getMessageById(Long id) {
//        Message message = messageRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("Message not found"));
//        return messageMapper.toDto(message);
//    }
//
//    @Override
//    public List<MessageDto> getAllMessagesByChatRoomId(Long chatRoomId) {
//        return StreamSupport.stream(messageRepository.findAll().spliterator(), false)
//                .filter(message -> message.getChatRoom().getId().equals(chatRoomId))
//                .map(messageMapper::toDto)
//                .collect(Collectors.toList());
//    }
//
//    @Override
//    public void deleteMessage(Long id) {
//        messageRepository.deleteById(id);
//    }
//}
