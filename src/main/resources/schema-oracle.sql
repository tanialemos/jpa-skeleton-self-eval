-- USERS
DROP TABLE USERS;
CREATE TABLE USERS(
    ID number not null,
    NAME varchar2(65),
    constraint user_pk primary key (ID)
);

-- SEQUENCE USERS
DROP SEQUENCE USERS_SEQUENCE;
CREATE SEQUENCE USERS_SEQUENCE start with 1 INCREMENT by 1;

-- POSTALCODE
DROP TABLE POSTALCODE;
create table postalcode(
    postalcode      number(4) not null,
    postalcode_label varchar2(255) not null
);
alter table postalcode
add constraint pk_postalcode primary key (postalcode);

-- BUILDING TYPES
DROP TABLE building_types;
create table building_types(
    building_code   char(1) not null,
    building_type   varchar2(255) not null
);
alter table building_types
add constraint pk_buildingtype primary key (building_code);


-- DIVISIONS
ALTER TABLE PARKING_LOTS
DROP CONSTRAINT  fk_parkinglot_division;
DROP TABLE divisions;
create table divisions(
    division_id     number(2) not null,
    name   varchar2(255) not null,
    originalname   varchar2(255),
    director   varchar2(255) not null
);
alter table divisions
add constraint pk_division primary key (division_id);
DROP SEQUENCE division_seq;
create sequence division_seq
    start with 1
    increment by 1;

-- CONTACT PERSONS
ALTER TABLE PARKING_LOTS
DROP CONSTRAINT  fk_parkinglot_contactperson;
DROP TABLE contact_persons;
create table contact_persons(
    contactperson_id       number(6) not null,
    first_name    varchar2(255) not null,
    last_name     varchar2(255) not null,
    mobile_phone varchar2(20),
    fixed_phone  varchar2(20),
    email        varchar2(255) not null,
    street_name  varchar2(255) not null,
    street_number  varchar2(10) not null,
    postalcode   number(4) not null
);
alter table contact_persons
add constraint pk_contactperson primary key (contactperson_id);
alter table contact_persons
add constraint fk_contactperson_postalcode foreign key (postalcode) references postalcode(postalcode);
drop sequence contactperson_seq;
create sequence contactperson_seq
    start with 1
    increment by 1;


-- PARKING LOTS
drop table parking_lots;
create table parking_lots(
    parkinglot_id       number(6) not null,
    name         varchar2(255) not null,
    division     number(2) not null,
    buildingtype char(1) not null,
    capacity     number(6) not null,
    contactperson    number(6) not null,
    street_name  varchar2(255) not null,
    street_number  varchar2(10) not null,
    postalcode   number(4) not null,
    hourly_price number(4,2) not null
);
alter table parking_lots
add constraint pk_parkinglot primary key (parkinglot_id);
alter table parking_lots
add constraint fk_parkinglot_division foreign key (division) references divisions(division_id);
alter table parking_lots
add constraint fk_parkinglot_buildingtype foreign key (buildingtype) references building_types(building_code);
alter table parking_lots
add constraint fk_parkinglot_contactperson foreign key (contactperson) references contact_persons(contactperson_id);
alter table parking_lots
add constraint fk_parkinglot_postalcode foreign key (postalcode) references postalcode(postalcode);
drop sequence parkinglot_seq;
create sequence parkinglot_seq
    start with 1
    increment by 1;
