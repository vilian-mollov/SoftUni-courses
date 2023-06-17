
SELECT 
    u.name,
    c.name,
    u.address,
    CASE
        WHEN tuition_fee < 800 THEN 'cheap'
        WHEN tuition_fee >= 800 AND tuition_fee < 1200 THEN 'normal'
        WHEN tuition_fee >= 1200 AND tuition_fee < 2500 THEN 'high'
        ELSE 'expensive'
    END AS price_rank,
    tuition_fee
FROM universities AS u
join cities AS c on c.id = u.city_id
ORDER BY tuition_fee ASC;
