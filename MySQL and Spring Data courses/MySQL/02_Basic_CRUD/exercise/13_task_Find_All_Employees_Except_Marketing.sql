USE soft_uni;

-- Write a SQL query to find the first and last names of all employees whose department ID is different from 4.

SELECT first_name, last_name 
FROM employees
WHERE department_id = 4;
