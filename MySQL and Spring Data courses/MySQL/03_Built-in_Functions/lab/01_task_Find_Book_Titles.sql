USE book_library;

-- Write a SQL query to find books which titles start with "The". Order the result by id.

-- variant 1
SELECT title FROM books
WHERE title like 'The%';

-- variant 2 
SELECT title FROM books
WHERE title regexp '^The';
