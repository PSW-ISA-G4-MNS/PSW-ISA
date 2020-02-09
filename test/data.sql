insert into users ("id","address", "birthday", "email", "firstname", lastname, mobile_phone, password, number_of_logins) VALUES ('101','A', '2019-10-10', 'admin@office.com', 'Stefan', 'Ilic', '+40255333', 'XXX', 0);
insert into users ("id","address", "birthday", "email", "firstname", lastname, mobile_phone, password, number_of_logins) VALUES ('102','A', '1995-10-10', 'clinic_admin@office.com', 'Branko', 'Maric', '+40255333', 'XXX', 0);
insert into users ("id","address", "birthday", "email", "firstname", lastname, mobile_phone, password, number_of_logins) VALUES ('103','A', '2019-10-10', 'clinic_admin2@office.com', 'Isidor', 'Ilic', '+40255333', 'XXX', 0);
insert into users ("id","address", "birthday", "email", "firstname", lastname, mobile_phone, password, number_of_logins) VALUES ('104','A', '2019-10-10', 'clinic_admin3@office.com', 'John', 'Jones', '+40255333', 'XXX', 0);
insert into users ("id","address", "birthday", "email", "firstname", lastname, mobile_phone, password, number_of_logins) VALUES ('105','A', '1942-10-10', 'clinic_admin4@office.com', 'Orfelije', 'Onjegin', '+40255333', 'XXX', 0);
insert into users ("id","address", "birthday", "email", "firstname", lastname, mobile_phone, password, number_of_logins) VALUES ('106','A', '2019-10-10', 'doctor@office.com', 'Tamara', 'Ignjatovic', '+40255333', 'XXX', 0);
insert into users ("id","address", "birthday", "email", "firstname", lastname, mobile_phone, password, number_of_logins) VALUES ('107','A', '2019-10-10', 'doctor1@office.com', 'Milica', 'Mitrovic', '+40255333', 'XXX', 0);
insert into users ("id","address", "birthday", "email", "firstname", lastname, mobile_phone, password, number_of_logins) VALUES ('108','A', '2019-10-10', 'doctor2@office.com', 'Ljubinka', 'Ilic', '+40255333', 'XXX', 0);
insert into users ("id","address", "birthday", "email", "firstname", lastname, mobile_phone, password, number_of_logins) VALUES ('109','A', '2019-10-10', 'doctor3@office.com', 'Branko', 'Perisic', '+40255333', 'XXX', 0);
insert into users ("id","address", "birthday", "email", "firstname", lastname, mobile_phone, password, number_of_logins) VALUES ('110','A', '2019-10-10', 'doctor4@office.com', 'Miroljub', 'Marinkovic', '+40255333', 'XXX', 0);
insert into users ("id","address", "birthday", "email", "firstname", lastname, mobile_phone, password, number_of_logins) VALUES ('111','A', '2019-10-10', 'doctor5@office.com', 'Dzenan', 'Loncarevic', '+40255333', 'XXX', 0);
insert into users ("id","address", "birthday", "email", "firstname", lastname, mobile_phone, password, number_of_logins) VALUES ('112','A', '2019-10-10', 'nurse@office.com', 'Bozica', 'Ruzic', '+40255333', 'XXX', 0);
insert into users ("id","address", "birthday", "email", "firstname", lastname, mobile_phone, password, number_of_logins) VALUES ('113','A', '2019-10-10', 'nurse1@office.com', 'Anastasija', 'Anic', '+40255333', 'XXX', 0);
insert into users ("id","address", "birthday", "email", "firstname", lastname, mobile_phone, password, number_of_logins) VALUES ('114','A', '2019-10-10', 'nurse2@office.com', 'Nevena', 'Ninic', '+40255333', 'XXX', 0);
insert into users ("id","address", "birthday", "email", "firstname", lastname, mobile_phone, password, number_of_logins) VALUES ('115','A', '2019-10-10', 'nurse3@office.com', 'Darko', 'Arnaut', '+40255333', 'XXX', 0);
insert into users ("id","address", "birthday", "email", "firstname", lastname, mobile_phone, password, number_of_logins) VALUES ('116','A', '2019-10-10', 'patient@office.com', 'Aleksandar', 'Ivanov', '+40255333', 'XXX', 0);
insert into users ("id","address", "birthday", "email", "firstname", lastname, mobile_phone, password, number_of_logins) VALUES ('117','A', '2019-10-10', 'susajunior@gmail.com', 'Miroslav', 'Susa', '+40255333', 'XXX', 0);
insert into users ("id","address", "birthday", "email", "firstname", lastname, mobile_phone, password, number_of_logins) VALUES ('118','A', '2019-10-10', 'patient3@office.com', 'Nemanja', 'Nemic', '+40255333', 'XXX', 0);
insert into users ("id","address", "birthday", "email", "firstname", lastname, mobile_phone, password, number_of_logins) VALUES ('119','A', '2019-10-10', 'patient2@office.com', 'Stefan', 'Nozinic', '+40255333', 'XXX', 0);
insert into users ("id","address", "birthday", "email", "firstname", lastname, mobile_phone, password, number_of_logins) VALUES ('120','A', '2019-10-10', 'kajzapfk@gmail.com', 'Nemanja', 'Kajzer', '+40255333', 'XXX', 0);

insert into administrator ("id", "user_id") values (101, 101);


insert into patient ("id", "insuranceid", "user_id","activated") values (103, '3331354425296', 116,true);
insert into patient ("id", "insuranceid", "user_id","activated") values (102, '2258354325278', 117,false);
insert into patient ("id", "insuranceid", "user_id","activated") values (101, '1561354325248', 118, true);
insert into patient ("id", "insuranceid", "user_id","activated") values (104, '0221354325235', 119,true);
insert into patient ("id", "insuranceid", "user_id","activated") values (105, '6697354325221', 120, false);

insert into clinic ("id","address", "description", "location_lat", "location_lon", "name") values ('101','Obradoviceva 64', 'Studentska klinika leci', 21.0, 15.20, 'Studentska klinika');
insert into clinic ("id","address", "description", "location_lat", "location_lon", "name") values ('102','Obradoviceva 64', 'Klinicki centar', 23.0, 18.20, 'Klinicki centar');
insert into clinic ("id","address", "description", "location_lat", "location_lon", "name") values ('103','Obradoviceva 64', 'Defanzivna klinika', 20.0, 13.20, 'Defanzivna klinika');


insert into clinic_administrator("id","clinic_id", "user_id") values('101','101','102');
insert into clinic_administrator("id","clinic_id", "user_id") values('102','102','103');

insert into care_type ("id", "name") values (101, 'Opsta praksa');
insert into care_type ("id", "name") values (102, 'Zubar');
insert into care_type ("id", "name") values (103, 'Hirurg');
insert into care_type ("id", "name") values (104, 'Pulmolog');


insert into doctor ("id", "user_id", "years_of_experience", "care_type_id", "clinic_id") values (101, 106, 5,  101, 101);
insert into doctor ("id", "user_id", "years_of_experience", "care_type_id", "clinic_id") values (102, 107, 10, 102, 102);
insert into doctor ("id", "user_id", "years_of_experience", "care_type_id", "clinic_id") values (103, 108, 15, 103, 103);
insert into doctor ("id", "user_id", "years_of_experience", "care_type_id", "clinic_id") values (104, 109, 13, 104, 101);
insert into doctor ("id", "user_id", "years_of_experience", "care_type_id", "clinic_id") values (105, 110, 14, 101, 102);
insert into doctor ("id", "user_id", "years_of_experience", "care_type_id", "clinic_id") values (106, 111, 3,  103, 103);


insert into nurse ("id", "user_id") values (101, 112);
insert into nurse ("id", "user_id") values (102, 113);
insert into nurse ("id", "user_id") values (103, 114);
insert into nurse ("id", "user_id") values (104, 115);


insert into room ("id","title", "capacity", "clinic_id") values ('101','Soba 23', 10, 101);
insert into room ("id","title", "capacity", "clinic_id") values ('102','Soba 85', 10, 102);
insert into room ("id","title", "capacity", "clinic_id") values ('103','Soba 3', 12,  103);
insert into room ("id","title", "capacity", "clinic_id") values ('104','Soba 4', 3,   101);
insert into room ("id","title", "capacity", "clinic_id") values ('105','Soba 55', 8,  102);
insert into room ("id","title", "capacity", "clinic_id") values ('106','Soba 10', 17, 103);
insert into room ("id","title", "capacity", "clinic_id") values ('107','Soba 12', 10, 101);
insert into room ("id","title", "capacity", "clinic_id") values ('108','Soba 17', 10, 102);


insert into registration_request ("approved", "time","rejected", "patient_id") values (false, '2020-10-10',false, 105);
insert into registration_request ("approved", "time","rejected", "patient_id") values (false, '2020-10-10',false, 102);
insert into registration_request ("approved", "time","rejected", "patient_id") values (true, '2020-10-10',false, 101);

insert into public.operation_request (id,time,clinic_id,patient_id) values (101,null,101,103);
insert into public.operation_request (id,time,clinic_id,patient_id) values (102,null,102,101);
insert into public.operation_request (id,time,clinic_id,patient_id) values (103,null,103,104);
insert into public.operation_request (id,time,clinic_id,patient_id) values (104,null,101,101);

insert into vacation_type("id","title") values (101,'odmor');
insert into vacation_type("id","title") values (102,'bolovanje');
insert into vacation_type("id","title") values (103,'seminar');

insert into medicine ("id", "medicine") values(101,'Panadol');
insert into medicine ("id", "medicine") values(102,'Daktanol');
insert into medicine ("id", "medicine") values(103,'Ortanol');
insert into medicine ("id", "medicine") values(104,'Omeprazol');
insert into medicine ("id", "medicine") values(105,'Reglan');
insert into medicine ("id", "medicine") values(106,'Pasetron');
insert into medicine ("id", "medicine") values(107,'Lidrosek');
insert into medicine ("id", "medicine") values(108,'Imunol');
insert into medicine ("id", "medicine") values(109,'Sirup za kasalj');


insert into diagnosis("id", "diagnosis") values(101,'Upala pluca');
insert into diagnosis("id", "diagnosis") values(102,'Astma');
insert into diagnosis("id", "diagnosis") values(103,'Bronhitis');
insert into diagnosis("id", "diagnosis") values(104,'Gripa');
insert into diagnosis("id", "diagnosis") values(105,'Aritmija');
insert into diagnosis("id", "diagnosis") values(106,'Upala zuba');
insert into diagnosis("id", "diagnosis") values(107,'Rak');

insert into public.care (id, price, start_time, end_time, care_type_id,  doctor_id,approved,patient_id) values (101, 200,CAST(N'2020-03-10 10:30:00.000' AS timestamp), CAST(N'2020-03-10 11:00:00.000' AS timestamp), 101, 101,true,101);
insert into public.care (id, price, start_time, end_time, care_type_id, doctor_id,approved,patient_id) values ( 102, 400, CAST(N'2020-03-10 11:00:00.000' AS timestamp), CAST(N'2020-03-10 11:30:00.000' AS timestamp),101, 101,true,104);
insert into public.care (id, price, start_time, end_time, care_type_id,  doctor_id,approved,patient_id) values (103, 200,CAST(N'2020-03-10 11:30:00.000' AS timestamp), CAST(N'2020-03-10 12:00:00.000' AS timestamp), 101, 101,true,103);
insert into public.care (id, price, start_time, end_time, care_type_id, doctor_id,approved,patient_id) values ( 104, 400, CAST(N'2020-03-10 12:00:00.000' AS timestamp), CAST(N'2020-03-10 12:30:00.000' AS timestamp),101, 101,true,104);


insert into public.care (id, price, start_time, end_time, care_type_id,  doctor_id,approved,patient_id) values (105, 200,CAST(N'2020-03-10 10:30:00.000' AS timestamp), CAST(N'2020-03-10 11:00:00.000' AS timestamp), 102, 102,true,103);
insert into public.care (id, price, start_time, end_time, care_type_id, doctor_id,approved,patient_id) values ( 106, 400, CAST(N'2020-03-10 11:00:00.000' AS timestamp), CAST(N'2020-03-10 11:30:00.000' AS timestamp),102, 102,true,101);
insert into public.care (id, price, start_time, end_time, care_type_id,  doctor_id,approved,patient_id) values (107, 200,CAST(N'2020-03-10 11:30:00.000' AS timestamp), CAST(N'2020-03-10 12:00:00.000' AS timestamp), 102, 102,true,104);
insert into public.care (id, price, start_time, end_time, care_type_id, doctor_id,approved,patient_id) values ( 108, 400, CAST(N'2020-03-10 12:00:00.000' AS timestamp), CAST(N'2020-03-10 12:30:00.000' AS timestamp),102, 102,true,103);


insert into public.care (id, price, start_time, end_time, care_type_id,  doctor_id,approved,patient_id, diagnosis_id) values (109, 200,CAST(N'2020-01-10 10:30:00.000' AS timestamp), CAST(N'2020-01-10 11:00:00.000' AS timestamp), 101, 101,true,101 , 101);
insert into public.care (id, price, start_time, end_time, care_type_id, doctor_id,approved,patient_id , diagnosis_id) values ( 110, 400, CAST(N'2020-01-09 11:00:00.000' AS timestamp), CAST(N'2020-01-09 11:30:00.000' AS timestamp),101, 101,true,101, 101);
insert into public.care (id, price, start_time, end_time, care_type_id,  doctor_id,approved,patient_id, diagnosis_id) values (111, 200,CAST(N'2020-01-07 10:30:00.000' AS timestamp), CAST(N'2020-01-07 11:00:00.000' AS timestamp), 101, 101,true,101 , 101);


insert into public.care (id, price, start_time, end_time, care_type_id, doctor_id,approved,patient_id) values (112, 400, CAST(N'2020-03-04 11:00:00.000' AS timestamp), CAST(N'2020-03-04 11:30:00.000' AS timestamp),102, 102,true,null);
insert into public.care (id, price, start_time, end_time, care_type_id,  doctor_id,approved,patient_id) values(113, 200,CAST(N'2020-03-04 10:30:00.000' AS timestamp), CAST(N'2020-03-04 11:00:00.000' AS timestamp), 101, 101,true,null);
insert into public.care (id, price, start_time, end_time, care_type_id, doctor_id,approved,patient_id) values (114, 400, CAST(N'2020-03-04 11:00:00.000' AS timestamp), CAST(N'2020-03-04 11:30:00.000' AS timestamp),101, 101,true,null);
insert into public.care (id, price, start_time, end_time, care_type_id, doctor_id,approved,patient_id) values (115, 400, CAST(N'2020-03-04 11:00:00.000' AS timestamp), CAST(N'2020-03-04 11:30:00.000' AS timestamp),102, 102,true,null);
insert into public.care (id, price, start_time, end_time, care_type_id,  doctor_id,approved,patient_id) values(116, 200,CAST(N'2020-03-08 15:30:00.000' AS timestamp), CAST(N'2020-03-08 16:00:00.000' AS timestamp), 102, 102,true,null);
insert into public.care (id, price, start_time, end_time, care_type_id, doctor_id,approved,patient_id) values (117, 400, CAST(N'2020-03-02 11:00:00.000' AS timestamp), CAST(N'2020-03-01 11:30:00.000' AS timestamp),101, 101,true,null);
insert into public.care (id, price, start_time, end_time, care_type_id, doctor_id,approved,patient_id) values (118, 400, CAST(N'2020-03-02 16:00:00.000' AS timestamp), CAST(N'2020-03-02 16:30:00.000' AS timestamp),102, 102,true,null);
insert into public.care (id, price, start_time, end_time, care_type_id, doctor_id,approved,patient_id) values (119, 400, CAST(N'2020-03-02 11:00:00.000' AS timestamp), CAST(N'2020-03-03 11:30:00.000' AS timestamp),101, 101,true,null);
insert into public.care (id, price, start_time, end_time, care_type_id, doctor_id,approved,patient_id) values (120, 400, CAST(N'2020-04-02 13:00:00.000' AS timestamp), CAST(N'2020-03-02 13:30:00.000' AS timestamp),102, 102,true,null);


