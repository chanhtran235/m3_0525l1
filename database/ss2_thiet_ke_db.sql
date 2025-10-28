create database if not exists m3_c0525l1;
use m3_c0525l1;
create table jame(
username varchar(50) primary key,
password varchar(50)
);
create table class(
id int primary key auto_increment,
name varchar(50)
);
create table student(
id int primary key auto_increment,
name varchar(50),
birthday date,
gender boolean,
mail varchar(50),
score float,
class_id int,
username varchar(50) unique,
foreign key (username) references jame(username),
foreign key (class_id) references class(id)
);

create table phone(
phone_number varchar(20),
student_id int,
foreign key (student_id) references student(id)
);

create table instructor(
id int primary key auto_increment,
name varchar(50),
birthday date,
salary float
);

create table instructor_class(
instructor_id int ,
class_id int,
start_time date,
end_time date,
primary key (instructor_id,class_id),
foreign key (class_id) references class(id),
foreign key (instructor_id) references instructor(id)
);



