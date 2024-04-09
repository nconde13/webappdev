CREATE TABLE student
(
    student_id  INT AUTO_INCREMENT PRIMARY KEY,
    name        VARCHAR(255),
    email       VARCHAR(255),
    phone       VARCHAR(20),
    street      VARCHAR(255),
    city        VARCHAR(255),
    province    VARCHAR(255),
    postal_code VARCHAR(20),
    country     VARCHAR(255),
    program     VARCHAR(255),
    semester    VARCHAR(255)
);
