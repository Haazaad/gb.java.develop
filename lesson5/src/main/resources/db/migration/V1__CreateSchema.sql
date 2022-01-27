create table if not exists public.students
(
    id   bigserial              not null,
    name character varying(128) not null,
    mark int,
    primary key (id)
);