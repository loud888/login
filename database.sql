CREATE DATABASE login_demo;
USE login_demo;

CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

INSERT INTO users (username, password) VALUES 
('admin', '$2y$10$z3X8k9p2mQw7rJv5tBnY8uG4hL6nFsA1eDcRiTxPyOvZbMjKuQwSe'), -- 123456
('user1', '$2y$10$XkP9mQw7rJv5tBnY8uG4hL6nFsA1eDcRiTxPyOvZbMjKuQwSeX8k9'); -- user123
