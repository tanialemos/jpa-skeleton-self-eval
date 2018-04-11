create table USERS(
    ID number not null,
    NAME varchar2(65),
    constraint user_pk primary key (ID)
);

create SEQUENCE USERS_SEQUENCE start with 1 INCREMENT by 1;