CREATE TABLE IF NOT EXISTS public.show_time
(
    id         bigserial              NOT NULL,
    start_time time without time zone NOT NULL,
    end_time   time without time zone NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS public.films
(
    film_id     bigserial              NOT NULL,
    description character varying(256) NOT NULL,
    duration    time without time zone NOT NULL,
    PRIMARY KEY (film_id)
);

CREATE TABLE IF NOT EXISTS public.ticket_types
(
    tcktp_id   bigserial NOT NULL,
    tckt_price numeric   NOT NULL,
    PRIMARY KEY (tcktp_id)
);

CREATE TABLE IF NOT EXISTS public.shedule
(
    id         bigserial NOT NULL,
    show_id    bigint    NOT NULL references show_time (id),
    film_id    bigint    NOT NULL references films (film_id),
    tcktp_id   bigint    NOT NULL references ticket_types (tcktp_id),
    start_date timestamp default current_timestamp,
    end_date   timestamp default '2099-01-01 00:00:00',
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS public.users
(
    id          bigserial              NOT NULL,
    username    character varying(256) NOT NULL,
    create_date timestamp default current_timestamp,
    update_date timestamp default current_timestamp,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS public.tickets
(
    id         bigserial NOT NULL,
    tcktp_id   bigint    NOT NULL references ticket_types (tcktp_id),
    user_id    bigint    NOT NULL references users (id),
    film_id    bigint    NOT NULL references films (film_id),
    order_date timestamp default current_timestamp,
    PRIMARY KEY (id)
);

insert into show_time (start_time, end_time)
values ('00:00', '01:00'),
       ('01:00', '02:00'),
       ('02:00', '03:00'),
       ('03:00', '04:00'),
       ('04:00', '05:00'),
       ('05:00', '06:00'),
       ('06:00', '07:00'),
       ('08:00', '09:00'),
       ('09:00', '10:00'),
       ('10:00', '11:00'),
       ('11:00', '12:00'),
       ('12:00', '13:00'),
       ('13:00', '14:00'),
       ('14:00', '15:00'),
       ('15:00', '16:00'),
       ('17:00', '18:00'),
       ('18:00', '19:00'),
       ('19:00', '20:00'),
       ('20:00', '21:00'),
       ('21:00', '22:00'),
       ('22:00', '23:00'),
       ('23:00', '00:00'),
       ('00:00', '01:30'),
       ('01:30', '03:00'),
       ('03:00', '04:30'),
       ('04:30', '06:00'),
       ('06:00', '07:30'),
       ('07:30', '09:00'),
       ('09:00', '10:30'),
       ('10:30', '12:00'),
       ('12:00', '13:30'),
       ('13:30', '15:00'),
       ('15:00', '16:30'),
       ('16:30', '18:00'),
       ('18:00', '19:30'),
       ('19:30', '21:00'),
       ('21:00', '22:30'),
       ('22:30', '00:00'),
       ('00:00', '02:00'),
       ('02:00', '04:00'),
       ('04:00', '06:00'),
       ('06:00', '08:00'),
       ('08:00', '10:00'),
       ('10:00', '12:00'),
       ('12:00', '14:00'),
       ('14:00', '16:00'),
       ('16:00', '18:00'),
       ('18:00', '20:00'),
       ('20:00', '22:00'),
       ('22:00', '00:00');

insert into films (description, duration)
values ('Matrix', '02:00'),
       ('Kung Fu Panda', '01:30'),
       ('Kin-Dza-Dza', '02:00'),
       ('Three Heroes', '01:00');

insert into ticket_types (tckt_price)
values (50),
       (100),
       (150.99),
       (250),
       (320.50);

insert into shedule (show_id, film_id, tcktp_id)
values (47, 1, 5),
       (33, 3, 2),
       (25, 4, 1),
       (13, 2, 3),
       (45, 3, 5),
       (23, 3, 1);

insert into users (username)
values ('Bob'),
       ('Jhon');

insert into tickets (tcktp_id, user_id, film_id)
values (1, 1, 1),
       (3, 1, 3),
       (5, 2, 4),
       (2, 2, 2);