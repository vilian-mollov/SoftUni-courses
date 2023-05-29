USE soft_uni;

-- Write a SQL query to find the first and last names of all employees whose job titles does not contain "engineer".

SELECT * FROM employees
WHERE job_title NOT REGEXP 'Engineer';
