CREATE DATABASE db_miercoles;
USE db_miercoles;

CREATE TABLE users(
	fullname VARCHAR(20) NOT NULL,
    id INT NOT NULL PRIMARY KEY,
    birthday VARCHAR(20)
);

SELECT * FROM users;

INSERT INTO users VALUES ("Juan", 101840, "12-05-1995");