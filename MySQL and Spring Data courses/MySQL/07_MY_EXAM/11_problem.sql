DELIMITER $$

CREATE PROCEDURE udp_graduate_all_students_by_year(IN year_started INT)
BEGIN
    UPDATE students
    SET is_graduated = 1
    WHERE id IN (
        SELECT students_courses.student_id
        FROM courses
        JOIN students_courses ON courses.id = students_courses.course_id
        WHERE YEAR(courses.start_date) = year_started
    );
END$$

CALL udp_graduate_all_students_by_year(2017);
