create schema universities_db;

use universities_db;

-- positive_value INT CHECK (positive_value >= 0) --------------------------------------------------------

create table countries (
	id int primary key auto_increment,
    name varchar(40) not null UNIQUE 
);

create table cities(
id int primary key auto_increment,
name varchar(40) not null unique,
population int,
country_id int,
FOREIGN KEY (country_id) REFERENCES countries(id)
);

create table universities(
id int primary key auto_increment,
name varchar(60) not null unique,
address varchar(80) not null unique,
tuition_fee DECIMAL(19, 2) not null,
number_of_staff int,
city_id int,
FOREIGN KEY (city_id) REFERENCES cities(id)
);

-- 0 row(s) affected, 1 warning(s): 1681 Integer display width is deprecated and will be removed in a future release.


create table students(
id int primary key auto_increment,
first_name varchar(40) not null,
last_name varchar(40) not null,
age int,
phone varchar(20) not null unique,
email varchar(255) not null unique,
is_graduated tinyint(1) not null,
city_id int,
FOREIGN KEY (city_id) REFERENCES cities(id)
);



create table courses(
id int primary key auto_increment,
name varchar(40) not null unique,
duration_hours DECIMAL(19, 2),
start_date date,
teacher_name varchar(60) not null unique,
description text,
university_id int,
FOREIGN KEY (university_id) REFERENCES universities(id));


create table students_courses(
grade DECIMAL(19, 2) not null, 
student_id int not null,
course_id int not null,
FOREIGN KEY (student_id) REFERENCES students(id),
FOREIGN KEY (course_id) REFERENCES courses(id));


-- drop schema universities_db
