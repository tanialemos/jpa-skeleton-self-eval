TRUNCATE TABLE USERS;

INSERT INTO USERS (id, name) VALUES (USERS_SEQUENCE.NEXTVAL, 'Niels');
INSERT INTO USERS (id, name) VALUES (USERS_SEQUENCE.NEXTVAL, 'Piels');
INSERT INTO USERS (id, name) VALUES (USERS_SEQUENCE.NEXTVAL, 'Stiels');

insert into BUILDING_TYPES(BUILDING_CODE, BUILDING_TYPE)
values('U', 'Underground');

insert into BUILDING_TYPES(BUILDING_CODE, BUILDING_TYPE)
values('A', 'Above ground');

insert into POSTALCODE(POSTALCODE, POSTALCODE_LABEL)
values(1000, 'Bruxelles');

insert into DIVISIONS(DIVISION_ID,DIVISION_NAME, division_originalname, division_director)
values(DIVISION_SEQ.NEXTVAL, 'Operations', 'Previous Operations', 'John Smith');

insert into CONTACT_PERSONS(CONTACTPERSON_ID, CP_FIRSTNAME, CP_lastname, cp_mobile_phone, cp_fixed_phone, cp_email, cp_street_name, cp_street_number, cp_postalcode)
values(
    CONTACTPERSON_SEQ.NEXTVAL, 'Barack', 'Obama', '0479454842', '022125246', 'barack.obama@gmail.com', 'Rue de la tristesse', '18', 1000);

insert into PARKING_LOTS(PARKINGLOT_ID, pl_name, pl_division, pl_buildingtype, pl_capacity, pl_contactperson, pl_street_name, pl_street_number, pl_postalcode, pl_hourly_price)
values(parkinglot_seq.nextval, 'Central Parking', 1, 'U', 250, 2, 'Boulevard du chagrin', '65', 1000, 1.5);