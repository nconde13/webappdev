INSERT INTO tracking (tracking_id, time_remaining, order_status, created_at, created_by, updated_at, updated_by)
VALUES
    (1, 120, 'Processing', NOW(), 'system', NOW(), 'system'),
    (2, 60, 'In Transit', NOW(), 'system', NOW(), 'system'),
    (3, 30, 'Out for Delivery', NOW(), 'system', NOW(), 'system'),
    (4, 0, 'Delivered', NOW(), 'system', NOW(), 'system');

INSERT INTO payment (payment_id, order_amount, payment_type)
VALUES
    (1, 100.00, 'Credit Card'),
    (2, 50.50, 'Debit Card'),
    (3, 150.75, 'PayPal'),
    (4, 200.00, 'Credit Card');

INSERT INTO customer (name, email, phone, street, city, province, postal_code, country)
VALUES
    ('John Doe', 'johndoe@example.com', '123-456-7890', '123 Maple Street', 'Springfield', 'Illinois', '62701', 'USA');

INSERT INTO orders (customer_id, tracking_id, payment_id, user_id)
VALUES
    (1, 1, 1, 1),
    (1, 2, 2, 1),
    (1, 3, 3, 1),
    (1, 4, 4, 1);