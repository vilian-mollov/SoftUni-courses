USE soft_uni;

-- Write a SQL query to find first and last names of all employees whose last name contains "ei" (case insensitively). 

SELECT first_name, last_name FROM employees
WHERE last_name LIKE '%ei%';
