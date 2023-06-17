
select first_name, last_name, age, phone, email from students
where age >= 21
order by first_name desc, email, id
limit 10;
