DELIMITER $$

CREATE FUNCTION udf_average_alumni_grade_by_course_name(course_name VARCHAR(60))
RETURNS DECIMAL(4, 2)
BEGIN
    DECLARE avg_grade DECIMAL(4, 2);
    
    SELECT AVG(sc.grade) INTO avg_grade
    FROM courses AS c
    join student_courses AS sc ON sc.course_id = c.id
    WHERE c.name = course_name AND is_graduated = 1;
    
    RETURN avg_grade;
END$$
