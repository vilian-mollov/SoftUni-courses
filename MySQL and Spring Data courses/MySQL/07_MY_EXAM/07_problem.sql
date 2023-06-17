
select count(*) as students_count, u.name as university_name from courses c
join students_courses as sc on sc.course_id = c.id
join universities as u on u.id = c.university_id
group by university_id
having students_count >= 8
order by students_count desc, university_name desc;
