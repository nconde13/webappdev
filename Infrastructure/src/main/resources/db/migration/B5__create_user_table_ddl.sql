CREATE TABLE Users
(
    id       INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255) UNIQUE NOT NULL,
    password VARCHAR(255)        NOT NULL,
    roles    VARCHAR(50)         NOT NULL
);
