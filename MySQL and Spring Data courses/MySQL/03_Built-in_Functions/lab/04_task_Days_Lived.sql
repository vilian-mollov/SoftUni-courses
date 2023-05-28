USE book_library;

-- Write a SQL query to calculate the days that an author lived. Your query should return:
-- • Full Name – the full name of the author.
-- • Days Lived – days that he/she lived. NULL values mean that the author is still alive.

SELECT * FROM authors;

SELECT 	CONCAT_WS( ' ', first_name, last_name ) AS `Full Name`,
		TIMESTAMPDIFF(DAY, born, died) AS `Days Lived`
FROM authors; 

-- Bonus
SELECT 	CONCAT_WS( ' ', first_name, last_name ) AS `Full Name`,
		TIMESTAMPDIFF(YEAR, born, died) AS `Years Lived`
FROM authors;
