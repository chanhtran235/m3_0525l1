create database if not exists m3_c0525l1;
use m3_c0525l1;
-- tạo bảng
create table students(
id int primary key auto_increment,
name varchar(50),
age int check (age>18),
gender boolean
);

-- alter table students add primary key (id);
-- thêm dư liệu cho bảng

insert into students(id,name,gender) values(1,'chánh',true);
insert into students values(2,'chánh2',true);
insert into students(id,name)
 values (3,'chánh2'),(4,'chánh4');
 
 -- lấy dữ liệu
 select id,name from students;
 select * from students;
 select * from students where gender =1;
 -- chỉnh sửa
 
 update students set name ='chánh3' where id =3;
 
 -- xoá dữ liệu
 delete from students where id = 4;
 
 -- xoá bảng 
 drop table students;
 
 drop database m3_c0525l1;
