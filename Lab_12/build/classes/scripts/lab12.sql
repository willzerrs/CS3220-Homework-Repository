drop table if exists faculty;

create table faculty(
	name				varchar(255),
    departmentName		varchar(255),
    isChair 			boolean
);

drop table if exists department;

create table department(
    name	varchar(255)
);

insert into department (name) values ('Computer Science');
insert into department (name) values ('Electrical and Computer Engineering');