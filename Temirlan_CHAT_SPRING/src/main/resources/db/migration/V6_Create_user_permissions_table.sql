CREATE TABLE user_permissions (
                                  user_id INTEGER NOT NULL,
                                  permission_id INTEGER NOT NULL,
                                  PRIMARY KEY (user_id, permission_id),
                                  FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE,
                                  FOREIGN KEY (permission_id) REFERENCES permission(id) ON DELETE CASCADE
);
