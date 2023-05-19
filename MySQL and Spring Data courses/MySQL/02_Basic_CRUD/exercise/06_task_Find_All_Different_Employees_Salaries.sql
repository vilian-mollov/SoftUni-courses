USE soft_uni;

SELECT concat_ws( ' ', first_name, last_name ) AS employee , salary
FROM employees;
