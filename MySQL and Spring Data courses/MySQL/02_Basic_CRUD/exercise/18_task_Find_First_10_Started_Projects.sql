USE soft_uni;

-- Write a SQL query to find first 10 started projects.
SELECT * FROM projects
ORDER BY start_date
LIMIT 10;
