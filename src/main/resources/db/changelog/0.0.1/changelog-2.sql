-- changeset UladzislauKholad:2
-- comment Inserting initial test data
insert into public.users (user_name, first_name, last_name, email)
values
('nexer', 'Uladzislau','Kholad', '123@mail.ru'),
('razdva','Stepan','Ivanov', 'test@mail.ru');

insert into public.trips (title, description, start_date, end_date)
values
('Trip to Spain', 'A lovely trip to Spain', '2023-01-01 10:00:00', '2023-01-15 18:00:00'),
('Trip to France', 'A beautiful trip to France', '2023-02-01 10:00:00', '2023-02-15 18:00:00');

insert into public.place (trip_id, title, description, country, visit_date, photo_url)
values
((SELECT id FROM public.trips WHERE title='Trip to Spain'), 'Barcelona', 'Visit to Barcelona', 'Spain', '2023-01-02 12:00:00', 'http://example.com/barcelona.jpg'),
((SELECT id FROM public.trips WHERE title='Trip to France'), 'Paris', 'Visit to Paris', 'France', '2023-02-02 12:00:00', 'http://example.com/paris.jpg');

insert into public.trip_participant (trip_id, user_id)
values
((SELECT id FROM public.trips WHERE title='Trip to Spain'), (SELECT id FROM public.users WHERE user_name='razdva')),
((SELECT id FROM public.trips WHERE title='Trip to France'), (SELECT id FROM public.users WHERE user_name='nexer'));

-- rollback statements
--rollback TRUNCATE TABLE public.trip_participant;
--rollback TRUNCATE TABLE public.place;
--rollback TRUNCATE TABLE public.trips;
--rollback TRUNCATE TABLE public.users;