USE soft_uni;

-- some employees have middle name, some do not have
SELECT
concat_ws(' ', first_name, middle_name, last_name ) AS `employee full name`
FROM employees;
