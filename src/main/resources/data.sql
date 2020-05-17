DROP TABLE IF EXISTS student;

CREATE TABLE student
(
    id            INT AUTO_INCREMENT PRIMARY KEY,
    surname       VARCHAR(50) NOT NULL,
    name          VARCHAR(50) NOT NULL,
    patronymic    VARCHAR(50) NOT NULL,
    assessment    BIGINT      NOT NULL,
    student_group BIGINT      NOT NULL
);