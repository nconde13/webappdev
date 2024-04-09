CREATE TABLE grade
(
    id         INT AUTO_INCREMENT PRIMARY KEY,
    student_id INT,
    course_id  INT,
    midterm_percentage DOUBLE,
    final_percentage DOUBLE,
    FOREIGN KEY (student_id) REFERENCES student (student_id),
    FOREIGN KEY (course_id) REFERENCES course (course_id)
);
