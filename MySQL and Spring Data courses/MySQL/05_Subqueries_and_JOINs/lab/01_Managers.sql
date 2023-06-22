USE  soft_uni;

-- Write a query to retrieve information about the managers – id, full_name, deparment_id and
-- department_name. Select the first 5 departments ordered by employee_id.

SELECT 
    e.employee_id,
    CONCAT_WS(' ', e.first_name, e.last_name) AS full_name,
    d.department_id,
    d.name
FROM
    departments AS d
        JOIN
    employees AS e ON e.employee_id = d.manager_id
ORDER BY e.employee_id
LIMIT 5;
