USE  soft_uni;

-- Write a query to get information about the addresses in the database, which are in San Francisco, Sofia or 
-- Carnation. Retrieve town_id, town_name, address_text. Order the result by town_id, then by address_id.

SELECT  t.town_id, t.name, address_text FROM towns AS t
JOIN addresses AS a ON t.town_id = a.town_id
WHERE t.name = 'San Francisco' OR t.name = 'Sofia' OR t.name = 'Carnation'
ORDER BY t.town_id, a.address_id;
