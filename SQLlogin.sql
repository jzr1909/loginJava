create database login; 
use login; 

create table cliente(
id int primary key auto_increment, 
nombres varchar(40) not null,
apellidos varchar (40) not null,
correo varchar(50) not null
); 