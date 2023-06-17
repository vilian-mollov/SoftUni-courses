DELIMITER $$

CREATE function udf_average_alumni_grade_by_course_name(course_name VARCHAR(60))
RETURNS DECIMAL(19, 2)
deterministic
BEGIN
    DECLARE avg_grade DECIMAL(19, 2);
    
    SELECT AVG(students_courses.grade) INTO avg_grade
    FROM courses
    JOIN students_courses ON students_courses.course_id = courses.id
    JOIN students ON students.id = students_courses.student_id
    WHERE courses.name = course_name AND students.is_graduated = 1;
    
    RETURN ROUND(avg_grade,1);
END$$

SELECT courses.name, udf_average_alumni_grade_by_course_name('Quantum Physics') as average_alumni_grade 
FROM courses
WHERE courses.name = 'Quantum Physics';
