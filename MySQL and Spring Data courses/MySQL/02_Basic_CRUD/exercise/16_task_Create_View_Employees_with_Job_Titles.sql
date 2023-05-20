USE soft_uni;

CREATE VIEW v_employee_job_titles AS
SELECT concat_ws( ' ', first_name, middle_name, last_name ) AS `full employee name`, job_title from employees;

SELECT * FROM v_employee_job_titles;
