use softuni;

alter table employees
ADD COLUMN middle_name varchar(50) after first_name;

insert into employees (first_name, middle_name, last_name)
values('John', 'Doe', 'Smith');
