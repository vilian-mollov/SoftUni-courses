USE softuni;

ALTER TABLE employees
ADD COLUMN middle_name VARCHAR(50) AFTER first_name;

INSERT INTO employees (first_name, middle_name, last_name)
VALUES('John', 'Doe', 'Smith');
