drop table students if exists;

create table students if not exists
(
    id   bigserial,
    name varchar2(256) not null,
    mark int           not null,
    constraint STUDENTS_PK
        primary key (id)
);

insert into students (name, mark)
VALUES ('Bob', 5);
