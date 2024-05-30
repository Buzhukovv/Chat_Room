CREATE TABLE message (
                         id SERIAL PRIMARY KEY,
                         content TEXT NOT NULL,
                         timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                         chatroom_id INTEGER NOT NULL,
                         user_id INTEGER NOT NULL,
                         FOREIGN KEY (chatroom_id) REFERENCES chatroom(id) ON DELETE CASCADE,
                         FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
);
