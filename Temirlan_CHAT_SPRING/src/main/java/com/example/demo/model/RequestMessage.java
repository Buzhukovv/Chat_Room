package com.example.demo.model;

import lombok.Data;

@Data
public class RequestMessage {

    private String content;
    private Long chatRoomId;

    // Constructors, getters, and setters
}
