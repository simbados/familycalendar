Drop Schema if exists family;
Create Schema family;
Drop table if exists member;
CREATE TABLE member(id BIGINT PRIMARY KEY, surname VARCHAR(100) NOT NULL, name VARCHAR(100) NOT NULL,
email VARCHAR(100) UNIQUE NOT NULL, username VARCHAR(100) UNIQUE NOT NULL, password VARCHAR(100) NOT NULL);