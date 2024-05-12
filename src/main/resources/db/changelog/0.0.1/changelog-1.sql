--liquibase formatted sql

--changeset UladzislauKholad:1
--comment first migration
CREATE TABLE public.user(
	id serial PRIMARY KEY,
	username varchar(255) not null unique,
	first_name varchar(255),
	last_name varchar(255),
	email varchar(255),
	password varchar(255) not null
);

insert into public.user (username, first_name, last_name, email, password)
values ('nexer', 'Uladzislau','kholad', '123@mail.ru','123'),
       ('razdva','Stepan','Ivanov', 'test@mail.ru','123123');
--rollback truncate table customer;