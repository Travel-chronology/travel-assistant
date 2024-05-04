--liquibase formatted sql

--changeset UladzislauKholad:1
--comment first migration
CREATE TABLE public.customer(
	id int not null,
	first_name varchar(255),
	last_name varchar(255),
	email varchar(255),
	password varchar(255),
	PRIMARY KEY (id)
);

insert into public.customer
values (1, 'Uladzislau','kholad', '123@mail.ru','123'),
       (2, 'Stepan','Ivanob', 'test@mail.ru','123123');
--rollback truncate table customer;