USE hotel;

-- raise maganers salaries with 10%
UPDATE employees
SET salary = salary * 1.10
WHERE job_title = 'Manager';


SELECT * FROM employees;
