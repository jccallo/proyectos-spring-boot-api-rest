create database crud_orm_spring_boot;
use crud_orm_spring_boot;

create table clients (
	id int not null AUTO_INCREMENT,
	firstName varchar(191),
	lastName varchar(191),
	constraint pk_clients primary key (id)
);

insert into clients 
(firstName,lastName)
values
('Armando','Morales'),
('Angel','Quispe');

