USE soft_uni;

-- Write a SQL query to find first and last names of all employees whose 
-- first name starts with "Sa" (case insensitively). Order the information by id.

SELECT first_name, last_name FROM employees
WHERE first_name REGEXP '^Sa';
