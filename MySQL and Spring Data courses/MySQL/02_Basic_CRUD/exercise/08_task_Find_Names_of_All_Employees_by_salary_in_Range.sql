USE soft_uni;

SELECT 
	concat_ws( ' ', first_name, middle_name, last_name ) AS `Employee name`,
    job_title,
    salary
FROM employees
WHERE salary > 20000 AND salary < 30000
ORDER BY salary DESC;
