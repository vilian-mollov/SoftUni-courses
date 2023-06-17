
INSERT INTO courses (name, duration_hours, start_date, teacher_name, description, university_id)
SELECT concat(teacher_name, ' course'), (length(name) / 10), DATE_ADD(start_date, INTERVAL 5 DAY), reverse(teacher_name), CONCAT('Course ', teacher_name, REVERSE(description)), DAY(start_date)
FROM courses
WHERE id <= 5;
