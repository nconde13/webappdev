CREATE TABLE item (
    item_id INT AUTO_INCREMENT PRIMARY KEY,
    restaurant_id INT,
    item_name VARCHAR(255),
    item_cost DECIMAL(10, 2),
    FOREIGN KEY (restaurant_id) REFERENCES restaurant(restaurant_id)
);
