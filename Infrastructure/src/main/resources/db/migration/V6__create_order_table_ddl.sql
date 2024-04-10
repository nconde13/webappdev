CREATE TABLE `order` (
    order_id INT AUTO_INCREMENT PRIMARY KEY,
    customer_id INT,
    tracking_id INT,
    payment_id INT,
    FOREIGN KEY (tracking_id) REFERENCES tracking (tracking_id),
    FOREIGN KEY (payment_id) REFERENCES payment (payment_id),
    FOREIGN KEY (customer_id) REFERENCES customer (customer_id)
);
