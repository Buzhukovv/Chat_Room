CREATE TABLE chatroom (
                          id SERIAL PRIMARY KEY,
                          name VARCHAR(255) NOT NULL UNIQUE,
                          is_group_chat BOOLEAN DEFAULT FALSE
);
