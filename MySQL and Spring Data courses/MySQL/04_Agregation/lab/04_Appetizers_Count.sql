USE restaurant;

-- Write a query to retrieve the count of all appetizers (category id = 2) with price higher than 8.

SELECT category_id, categories.name, price  FROM products
JOIN categories ON categories.id = products.category_id
WHERE price > 8
GROUP BY category_id
ORDER BY category_id;
