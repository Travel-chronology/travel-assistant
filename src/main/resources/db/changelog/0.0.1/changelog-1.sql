--liquibase formatted sql

--changeset UladzislauKholad:1
--comment Initial table creation
CREATE TABLE public.users (
    id serial PRIMARY KEY,
    user_name varchar(255) not null unique,
    first_name varchar(255),
    last_name varchar(255),
    email varchar(255),
    password varchar(255) not null
);

CREATE TABLE public.trip (
    id serial PRIMARY KEY,
    user_id int not null,
    title varchar(255),
    description text,
    start_date timestamp,
    end_date timestamp,
    FOREIGN KEY (user_id) REFERENCES public.users(id)
);

CREATE TABLE public.place (
    id serial PRIMARY KEY,
    trip_id int,
    title varchar(255),
    description text,
    country varchar(255),
    visit_date timestamp,
    photo_url varchar(255),
    FOREIGN KEY (trip_id) REFERENCES public.trip(id)
);

CREATE TABLE public.trip_participant (
    trip_id int not null,
    user_id int not null,
    FOREIGN KEY (trip_id) REFERENCES public.trip(id),
    FOREIGN KEY (user_id) REFERENCES public.users(id)
);

-- rollback statements
--rollback drop table public.trip_participant;
--rollback drop table public.place;
--rollback drop table public.trip;
--rollback drop table public.users;