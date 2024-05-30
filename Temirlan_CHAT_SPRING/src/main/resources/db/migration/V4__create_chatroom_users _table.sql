CREATE TABLE chatroom_users (
                                chatroom_id INTEGER NOT NULL,
                                user_id INTEGER NOT NULL,
                                PRIMARY KEY (chatroom_id, user_id),
                                FOREIGN KEY (chatroom_id) REFERENCES chatroom(id) ON DELETE CASCADE,
                                FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
);
