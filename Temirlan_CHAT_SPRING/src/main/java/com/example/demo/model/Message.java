package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "chatroom_id")
    private ChatRoom chatRoom;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String content;

    private LocalDateTime timestamp;

    // Дополнительный конструктор, если необходимо
    public Message(ChatRoom chatRoom, User user, String content, LocalDateTime timestamp) {
        this.chatRoom = chatRoom;
        this.user = user;
        this.content = content;
        this.timestamp = timestamp;
    }
}
