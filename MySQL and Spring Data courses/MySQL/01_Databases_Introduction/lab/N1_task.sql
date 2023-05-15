-- Creating schema

CREATE SCHEMA softuni;

-- Using the schema

USE softuni;

-- Creating tables

CREATE TABLE employees (
    id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    first_name VARCHAR(50),
    last_name VARCHAR(50)
);



CREATE TABLE categories (
    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(50) NOT NULL
);

CREATE TABLE products (
    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(50) NOT NULL,
    category_id INT,
    FOREIGN KEY (category_id) REFERENCES categories(id)
);


-- Inserting data in the tables

INSERT INTO employees (first_name, last_name) VALUES('Pesho', 'Peshev');

INSERT INTO employees (first_name, last_name) VALUES('Mitko', 'Ivanov');

INSERT INTO employees (first_name, last_name) VALUES('Dimchou', 'Dimaro');


DELETE FROM employees;


DROP SCHEMA softuni; 

