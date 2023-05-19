USE soft_uni;

-- Write a SQL query to find the full name of all employees whose salary is 25000, 14000, 12500 or 23600.

SELECT concat_ws( ' ', first_name, middle_name, last_name ) AS `Employee name`,
	   salary
FROM employees
WHERE salary = 25000 OR 
	  salary = 14000 OR 
	  salary = 12500 OR 
	  salary = 23600;
