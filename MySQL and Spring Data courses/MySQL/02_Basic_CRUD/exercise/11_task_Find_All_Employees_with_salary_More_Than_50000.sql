USE soft_uni;

-- Write a SQL query to find first name, last name and salary of those employees who has salary more than 50000.
SELECT first_name, last_name, salary 
FROM employees 
WHERE salary > 50000;
