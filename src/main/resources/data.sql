insert into course (id, full_name,created_date,last_updated_date) values 
(10001,'Java',sysdate(),sysdate());
insert into course (id, full_name,created_date,last_updated_date) values (20001,'spring',
sysdate(),sysdate());
insert into course (id, full_name,created_date,last_updated_date) values (30001,'hibernate',
sysdate(),sysdate());

insert into passport(id,number)
values(40001,'P256325');
insert into passport(id,number)
values(40002,'N123457');
insert into passport(id,number)
values(40003,'L1238901');

insert into student(id,name,passport_id)
values(20001,'Ranga',40001);
insert into student(id,name,passport_id)
values(20002,'Adam',40002);
insert into student(id,name,passport_id)
values(20003,'Jane',40003);

insert into review(id,rating,description,course_id)
values(50001,'5','Great Course',10001);
insert into review(id,rating,description,course_id)
values(50002,'4','Wonderful Course',10001);
insert into review(id,rating,description,course_id)
values(50003,'5','Awesome Course',30001);

insert into student_course(student_id,course_id)
values(20001,10001);
insert into student_course(student_id,course_id)
values(20002,10001);
insert into student_course(student_id,course_id)
values(20003,10001);
insert into student_course(student_id,course_id)
values(20001,30001);


