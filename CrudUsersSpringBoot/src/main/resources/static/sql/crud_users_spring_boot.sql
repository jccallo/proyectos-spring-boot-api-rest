create database crud_users_spring_boot;
use crud_users_spring_boot;

create table users (
	id int not null AUTO_INCREMENT,
	name varchar(191),
	email varchar(191),
	password varchar(191),
	constraint pk_users primary key (id)
);

insert into users 
(name,email,password)
values
('Armando','amorales@gmail.com',12345678),
('Angel','aperes@gmail.com',12345678);

