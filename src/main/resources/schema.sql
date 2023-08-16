DROP TABLE customer IF EXISTS;

CREATE TABLE customer (
    person_id BIGINT PRIMARY KEY auto_increment,
    first_name VARCHAR(20),
    last_name VARCHAR(20),
    birthday DATE,
    gender CHAR(1),
    married BOOLEAN);