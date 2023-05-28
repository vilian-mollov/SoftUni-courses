USE book_library;

-- Write a SQL query to retrieve titles of all the Harry Potter books. Order the information by id.

SELECT title FROM books
WHERE title REGEXP '^Harry Potter'
ORDER BY id;
