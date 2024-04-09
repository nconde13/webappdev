CREATE TABLE restaurant
(
    restaurant_id INT AUTO_INCREMENT PRIMARY KEY,
    name          VARCHAR(255),
    street        VARCHAR(255),
    city          VARCHAR(255),
    province      VARCHAR(255),
    postal_code   VARCHAR(20),
    country       VARCHAR(255),
    cuisine_type  VARCHAR(255)
);
