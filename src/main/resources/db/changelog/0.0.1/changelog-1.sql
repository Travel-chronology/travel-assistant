--liquibase formatted sql

--changeset UladzislauKholad:1
--comment first migration
CREATE TABLE public.users(
	id serial PRIMARY KEY,
	user_name varchar(255) not null unique,
	first_name varchar(255),
	last_name varchar(255),
	email varchar(255),
	password varchar(255) not null
);

insert into public.users (user_name, first_name, last_name, email, password)
values ('nexer', 'Uladzislau','kholad', '123@mail.ru','123'),
       ('razdva','Stepan','Ivanov', 'test@mail.ru','123123');
--rollback truncate table customer;