create table if not exists public.students
(
    id   bigserial              not null,
    name character varying(256) not null,
    age  int,
    primary key (id)
);

insert into students(name, age)
values ('Bob', 22),
       ('Jack', 21),
       ('Max', 24),
       ('Alice', 21);