USE restaurant;
-- Write a query to count the number of employees in each department by id. Order the information by
-- deparment_id, then by Number of employees.

SELECT department_id, count(*) FROM employees
GROUP BY department_id;
