drop table books cascade constraints;
drop table genres cascade constraints;
drop table cathegory cascade constraints;
drop table authors cascade constraints;
drop table authors_work cascade constraints;
drop table languages cascade constraints;
drop table book_translations cascade constraints;

drop sequence autoincrementBooks;
drop sequence autoincrementGenre;
drop sequence autoincrementAuthors;
drop sequence autoincrementLanguages;

create sequence autoincrementBooks increment by 1 start with 1 nomaxvalue;
create sequence autoincrementGenre increment by 1 start with 1 nomaxvalue;
create sequence autoincrementAuthors increment by 1 start with 1 nomaxvalue;
create sequence autoincrementLanguages increment by 1 start with 1 nomaxvalue;

create table books
(
    id           varchar2(10) not null primary key,
    title        varchar2(100),
    release_date date,
    nr_pages     integer,
    score        double precision check ( score >= 0 and score <= 10 )
);
create table genres
(
    id   varchar2(10) not null primary key,
    name varchar2(30)
);
create table cathegory
(
    id_book varchar2(10) references books (id),
    id_genre varchar2(10) references genres (id)
);

create table authors
(
    id          varchar2(10) not null primary key,
    name        varchar2(30)
);

create table authors_work
(
    id_author varchar2(10) references authors (id),
    id_book       varchar2(10) references books (id)
);

create table languages
(
    id   varchar2(10) not null primary key,
    name varchar2(30)
);

create table book_translations
(
    id_book varchar2(10) references books (id),
    id_language varchar2(10) references languages (id)
);

insert into books
values (autoincrementBook.nextval,
        'It',
        '1-Mar-2010',
        114,
        7.5);
insert into books
values (autoincrementBook.nextval,
        'Hamlet',
        '25-Feb-1710',
        128,
        7.1);
insert into books
values (autoincrementBook.nextval,
        'HarryPotter',
        '18-Dec-2002',
        179,
        8.2);

insert into genres
values (autoincrementGenre.nextval,
        'Drama');

insert into genres
values (autoincrementGenre.nextval,
        'Thriller');

insert into genres
values (autoincrementGenre.nextval,
        'Mystery');

insert into genres
values (autoincrementGenre.nextval,
        'Romance');

insert into cathegory
values ('1',
        '1');
insert into cathegory
values ('3',
        '2');
insert into cathegory
values ('3',
        '3');
insert into cathegory
values ('2',
        '1');
insert into cathegory
values ('2',
        '4');

insert into authors
values (autoincrementAuthors.nextval,
        'William Shakespeare');
insert into authors
values (autoincrementAuthors.nextval,
        'JK Rowling',);
insert into authors
values (autoincrementAuthors.nextval,
        'Stephen King');
insert into authors
values (autoincrementAuthors.nextval,
        'George RR Martin');

insert into authors_work
values ('1',
        '2');
insert into authors_work
values ('2',
        '3');
insert into authors_work
values ('4',
        '3');
insert into authors_work
values ('3',
        '1');

insert into languages
values (autoincrementLanguages.nextval,
        'Italian');
insert into languages
values (autoincrementLanguages.nextval,
        'English');
insert into languages
values (autoincrementLanguages.nextval,
        'Romanian');
insert into languages
values (autoincrementLanguages.nextval,
        'French');

insert into book_translations
values ('3',
        '1');
insert into book_translations
values ('1',
        '2');
insert into book_translations
values ('2',
        '3');
insert into book_translations
values ('4',
        '2');