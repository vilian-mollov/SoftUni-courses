USE soft_uni;

-- Write SQL query to find first name, last name and salary about 5 best paid Employees ordered descending by their salary.

SELECT first_name, last_name, salary FROM employees
ORDER BY salary DESC
LIMIT 5;
