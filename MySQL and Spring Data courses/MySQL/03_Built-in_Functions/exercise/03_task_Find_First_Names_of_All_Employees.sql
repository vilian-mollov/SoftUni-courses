USE soft_uni;

-- Write a SQL query to find the first names of all employees in the departments 
-- with ID 3 or 10 and whose hire year is between 1995 and 2005 inclusively.

SELECT first_name FROM employees
WHERE ( department_id = 3 OR department_id = 10 ) AND ( YEAR( hire_date ) >= 1995 AND YEAR( hire_date ) <= 2005 )
ORDER BY employee_id;

