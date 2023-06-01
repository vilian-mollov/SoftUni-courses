USE restaurant;
-- Write a query to retrieve information about the departments grouped by department_id with minimum salary
-- higher than 800. Round the salary result to two digits after the decimal point.

SELECT department_id, ROUND(MIN(salary), 2) AS min_salary FROM employees
GROUP BY department_id
HAVING min_salary > 800
ORDER BY min_salary
LIMIT 1;
