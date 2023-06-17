
select concat_ws(' ',first_name, last_name) as full_name, substring(email, 2, 10) as usermane, REVERSE(phone) as password  from students
left join students_courses on student_id = students.id
where course_id is null
order by password desc;
