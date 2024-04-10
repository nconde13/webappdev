CREATE TABLE payment
(
    payment_id    INT AUTO_INCREMENT PRIMARY KEY,
    order_amount  DECIMAL(10,2),
    payment_type  VARCHAR(50)
);
