USE soft_uni;

-- Write a SQL query to find last 7 hired employees.
SELECT first_name, last_name, hire_date 
FROM employees
ORDER BY hire_date DESC
LIMIT 7;
