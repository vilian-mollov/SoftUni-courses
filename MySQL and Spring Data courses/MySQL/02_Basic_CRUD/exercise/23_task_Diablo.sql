USE diablo;

SELECT 
u.user_name AS `Username`,
concat_ws( ' ', u.first_name, u.last_name ) AS `Real name`,
c.name AS `Character`,
g.name AS `Game`,
u.ip_address
FROM users_games AS ug
JOIN users AS u ON  u.id = ug.id
JOIN games AS g ON  g.id = ug.game_id
JOIN characters AS c ON c.id = ug.character_id;
