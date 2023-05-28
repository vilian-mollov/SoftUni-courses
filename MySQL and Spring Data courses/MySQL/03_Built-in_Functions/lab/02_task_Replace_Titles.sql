USE book_library;

-- Write a SQL query to find books which titles start with "The" and replace the substring with 3 asterisks.

-- VARIANT 1
SELECT CONCAT( '***', SUBSTRING( title, 4 ) ) FROM books
where title like 'The%';

-- VARIANT 2
SELECT  REPLACE( title, 'The' , '***') FROM books
WHERE title REGEXP '^The';
