USE soft_uni;

-- Write a SQL query to find first and last names about those employees that does not have a manager.

SELECT first_name, last_name FROM employees
WHERE manager_id is null;
