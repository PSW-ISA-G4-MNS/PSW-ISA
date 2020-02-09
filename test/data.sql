insert into users ("id","address", "birthday", "email", "firstname", lastname, mobile_phone, password, number_of_logins) VALUES ('1','A', '2019-10-10', 'admin@office.com', 'Stefan', 'Ilic', '+40255333', 'XXX', 0);
insert into users ("id","address", "birthday", "email", "firstname", lastname, mobile_phone, password, number_of_logins) VALUES ('2','A', '1995-10-10', 'clinic_admin@office.com', 'Branko', 'Maric', '+40255333', 'XXX', 0);
insert into users ("id","address", "birthday", "email", "firstname", lastname, mobile_phone, password, number_of_logins) VALUES ('3','A', '2019-10-10', 'clinic_admin2@office.com', 'Isidor', 'Ilic', '+40255333', 'XXX', 0);
insert into users ("id","address", "birthday", "email", "firstname", lastname, mobile_phone, password, number_of_logins) VALUES ('4','A', '2019-10-10', 'clinic_admin3@office.com', 'John', 'Jones', '+40255333', 'XXX', 0);
insert into users ("id","address", "birthday", "email", "firstname", lastname, mobile_phone, password, number_of_logins) VALUES ('5','A', '1942-10-10', 'clinic_admin4@office.com', 'Orfelije', 'Onjegin', '+40255333', 'XXX', 0);
insert into users ("id","address", "birthday", "email", "firstname", lastname, mobile_phone, password, number_of_logins) VALUES ('6','A', '2019-10-10', 'doctor@office.com', 'Tamara', 'Ignjatovic', '+40255333', 'XXX', 0);
insert into users ("id","address", "birthday", "email", "firstname", lastname, mobile_phone, password, number_of_logins) VALUES ('7','A', '2019-10-10', 'doctor1@office.com', 'Milica', 'Mitrovic', '+40255333', 'XXX', 0);
insert into users ("id","address", "birthday", "email", "firstname", lastname, mobile_phone, password, number_of_logins) VALUES ('8','A', '2019-10-10', 'doctor2@office.com', 'Ljubinka', 'Ilic', '+40255333', 'XXX', 0);
insert into users ("id","address", "birthday", "email", "firstname", lastname, mobile_phone, password, number_of_logins) VALUES ('9','A', '2019-10-10', 'doctor3@office.com', 'Branko', 'Perisic', '+40255333', 'XXX', 0);
insert into users ("id","address", "birthday", "email", "firstname", lastname, mobile_phone, password, number_of_logins) VALUES ('10','A', '2019-10-10', 'doctor4@office.com', 'Miroljub', 'Marinkovic', '+40255333', 'XXX', 0);
insert into users ("id","address", "birthday", "email", "firstname", lastname, mobile_phone, password, number_of_logins) VALUES ('11','A', '2019-10-10', 'doctor5@office.com', 'Dzenan', 'Loncarevic', '+40255333', 'XXX', 0);
insert into users ("id","address", "birthday", "email", "firstname", lastname, mobile_phone, password, number_of_logins) VALUES ('12','A', '2019-10-10', 'nurse@office.com', 'Bozica', 'Ruzic', '+40255333', 'XXX', 0);
insert into users ("id","address", "birthday", "email", "firstname", lastname, mobile_phone, password, number_of_logins) VALUES ('13','A', '2019-10-10', 'nurse1@office.com', 'Anastasija', 'Anic', '+40255333', 'XXX', 0);
insert into users ("id","address", "birthday", "email", "firstname", lastname, mobile_phone, password, number_of_logins) VALUES ('14','A', '2019-10-10', 'nurse2@office.com', 'Nevena', 'Ninic', '+40255333', 'XXX', 0);
insert into users ("id","address", "birthday", "email", "firstname", lastname, mobile_phone, password, number_of_logins) VALUES ('15','A', '2019-10-10', 'nurse3@office.com', 'Darko', 'Arnaut', '+40255333', 'XXX', 0);
insert into users ("id","address", "birthday", "email", "firstname", lastname, mobile_phone, password, number_of_logins) VALUES ('16','A', '2019-10-10', 'patient@office.com', 'Aleksandar', 'Ivanov', '+40255333', 'XXX', 0);
insert into users ("id","address", "birthday", "email", "firstname", lastname, mobile_phone, password, number_of_logins) VALUES ('17','A', '2019-10-10', 'susajunior@gmail.com', 'Miroslav', 'Susa', '+40255333', 'XXX', 0);
insert into users ("id","address", "birthday", "email", "firstname", lastname, mobile_phone, password, number_of_logins) VALUES ('18','A', '2019-10-10', 'patient3@office.com', 'Nemanja', 'Nemic', '+40255333', 'XXX', 0);
insert into users ("id","address", "birthday", "email", "firstname", lastname, mobile_phone, password, number_of_logins) VALUES ('19','A', '2019-10-10', 'patient2@office.com', 'Stefan', 'Nozinic', '+40255333', 'XXX', 0);
insert into users ("id","address", "birthday", "email", "firstname", lastname, mobile_phone, password, number_of_logins) VALUES ('20','A', '2019-10-10', 'kajzapfk@gmail.com', 'Nemanja', 'Kajzer', '+40255333', 'XXX', 0);

insert into administrator ("id", "user_id") values (1, 1);


insert into patient ("id", "insuranceid", "user_id","activated") values (3, '3331354425296', 16,true);
insert into patient ("id", "insuranceid", "user_id","activated") values (2, '2258354325278', 17,false);
insert into patient ("id", "insuranceid", "user_id","activated") values (1, '1561354325248', 18, true);
insert into patient ("id", "insuranceid", "user_id","activated") values (4, '0221354325235', 19,true);
insert into patient ("id", "insuranceid", "user_id","activated") values (5, '6697354325221', 20, false);

insert into clinic ("id","address", "description", "location_lat", "location_lon", "name") values ('1','Obradoviceva 64', 'Studentska klinika leci', 21.0, 15.20, 'Studentska klinika');
insert into clinic ("id","address", "description", "location_lat", "location_lon", "name") values ('2','Obradoviceva 64', 'Klinicki centar', 23.0, 18.20, 'Klinicki centar');
insert into clinic ("id","address", "description", "location_lat", "location_lon", "name") values ('3','Obradoviceva 64', 'Defanzivna klinika', 20.0, 13.20, 'Defanzivna klinika');


insert into clinic_administrator("id","clinic_id", "user_id") values('1','1','2');
insert into clinic_administrator("id","clinic_id", "user_id") values('2','2','3');

insert into care_type ("id", "name") values (1, 'Opsta praksa');
insert into care_type ("id", "name") values (2, 'Zubar');
insert into care_type ("id", "name") values (3, 'Hirurg');
insert into care_type ("id", "name") values (4, 'Pulmolog');


insert into doctor ("id", "user_id", "years_of_experience", "care_type_id", "clinic_id") values (1, 6, 5, 1, 1);
insert into doctor ("id", "user_id", "years_of_experience", "care_type_id", "clinic_id") values (2, 7, 10, 2, 2);
insert into doctor ("id", "user_id", "years_of_experience", "care_type_id", "clinic_id") values (3, 8, 15, 3, 3);
insert into doctor ("id", "user_id", "years_of_experience", "care_type_id", "clinic_id") values (4, 9, 13, 4, 1);
insert into doctor ("id", "user_id", "years_of_experience", "care_type_id", "clinic_id") values (5, 10, 14, 1, 2);
insert into doctor ("id", "user_id", "years_of_experience", "care_type_id", "clinic_id") values (6, 11, 3, 3, 3);


insert into nurse ("id", "user_id") values (1, 12);
insert into nurse ("id", "user_id") values (2, 13);
insert into nurse ("id", "user_id") values (3, 14);
insert into nurse ("id", "user_id") values (4, 15);


insert into room ("id","title", "capacity", "clinic_id") values ('1','Soba 23', 10, 1);
insert into room ("id","title", "capacity", "clinic_id") values ('2','Soba 85', 10, 2);
insert into room ("id","title", "capacity", "clinic_id") values ('3','Soba 3', 12, 3);
insert into room ("id","title", "capacity", "clinic_id") values ('4','Soba 4', 3, 1);
insert into room ("id","title", "capacity", "clinic_id") values ('5','Soba 55', 8, 2);
insert into room ("id","title", "capacity", "clinic_id") values ('6','Soba 10', 17, 3);
insert into room ("id","title", "capacity", "clinic_id") values ('7','Soba 12', 10, 1);
insert into room ("id","title", "capacity", "clinic_id") values ('8','Soba 17', 10, 2);


insert into registration_request ("approved", "time","rejected", "patient_id") values (false, '2020-10-10',false, 5);
insert into registration_request ("approved", "time","rejected", "patient_id") values (false, '2020-10-10',false, 2);


insert into public.operation_request (id,time,clinic_id,patient_id) values (1,null,1,3);
insert into public.operation_request (id,time,clinic_id,patient_id) values (2,null,2,1);
insert into public.operation_request (id,time,clinic_id,patient_id) values (3,null,3,4);
insert into public.operation_request (id,time,clinic_id,patient_id) values (4,null,1,1);

insert into vacation_type("id","title") values (1,'odmor');
insert into vacation_type("id","title") values (2,'bolovanje');
insert into vacation_type("id","title") values (3,'seminar');

insert into medicine ("id", "medicine") values(1,'Panadol');
insert into medicine ("id", "medicine") values(2,'Daktanol');
insert into medicine ("id", "medicine") values(3,'Ortanol');
insert into medicine ("id", "medicine") values(4,'Omeprazol');
insert into medicine ("id", "medicine") values(5,'Reglan');
insert into medicine ("id", "medicine") values(6,'Pasetron');
insert into medicine ("id", "medicine") values(7,'Lidrosek');
insert into medicine ("id", "medicine") values(8,'Imunol');
insert into medicine ("id", "medicine") values(9,'Sirup za kasalj');


insert into diagnosis("id", "diagnosis") values(1,'Upala pluca');
insert into diagnosis("id", "diagnosis") values(2,'Astma');
insert into diagnosis("id", "diagnosis") values(3,'Bronhitis');
insert into diagnosis("id", "diagnosis") values(4,'Gripa');
insert into diagnosis("id", "diagnosis") values(5,'Aritmija');
insert into diagnosis("id", "diagnosis") values(6,'Upala zuba');
insert into diagnosis("id", "diagnosis") values(7,'Rak');

insert into public.care (id, price, start_time, end_time, care_type_id,  doctor_id,approved,patient_id) values (1, 200,CAST(N'2020-03-10 10:30:00.000' AS timestamp), CAST(N'2020-03-10 11:00:00.000' AS timestamp), 1, 1,true,1);
insert into public.care (id, price, start_time, end_time, care_type_id, doctor_id,approved,patient_id) values (2, 400, CAST(N'2020-03-10 11:00:00.000' AS timestamp), CAST(N'2020-03-10 11:30:00.000' AS timestamp), 1, 1,true,4);
insert into public.care (id, price, start_time, end_time, care_type_id,  doctor_id,approved,patient_id) values (3, 200,CAST(N'2020-03-10 11:30:00.000' AS timestamp), CAST(N'2020-03-10 12:00:00.000' AS timestamp), 1, 1,true,3);
insert into public.care (id, price, start_time, end_time, care_type_id, doctor_id,approved,patient_id) values (4, 400, CAST(N'2020-03-10 12:00:00.000' AS timestamp), CAST(N'2020-03-10 12:30:00.000' AS timestamp), 1, 1,true,4);


insert into public.care (id, price, start_time, end_time, care_type_id,  doctor_id,approved,patient_id) values (5, 200,CAST(N'2020-03-10 10:30:00.000' AS timestamp), CAST(N'2020-03-10 11:00:00.000' AS timestamp), 2, 2,true,3);
insert into public.care (id, price, start_time, end_time, care_type_id, doctor_id,approved,patient_id) values (6, 400, CAST(N'2020-03-10 11:00:00.000' AS timestamp), CAST(N'2020-03-10 11:30:00.000' AS timestamp), 2, 2,true,1);
insert into public.care (id, price, start_time, end_time, care_type_id,  doctor_id,approved,patient_id) values (7, 200,CAST(N'2020-03-10 11:30:00.000' AS timestamp), CAST(N'2020-03-10 12:00:00.000' AS timestamp), 2, 2,true,4);
insert into public.care (id, price, start_time, end_time, care_type_id, doctor_id,approved,patient_id) values (8, 400, CAST(N'2020-03-10 12:00:00.000' AS timestamp), CAST(N'2020-03-10 12:30:00.000' AS timestamp), 2, 2,true,3);


insert into public.care (id, price, start_time, end_time, care_type_id,  doctor_id,approved,patient_id) values (9, 200,CAST(N'2020-01-10 10:30:00.000' AS timestamp), CAST(N'2020-01-10 11:00:00.000' AS timestamp), 1, 1,true,1);
insert into public.care (id, price, start_time, end_time, care_type_id, doctor_id,approved,patient_id) values (10, 400, CAST(N'2020-01-09 11:00:00.000' AS timestamp), CAST(N'2020-01-09 11:30:00.000' AS timestamp), 1, 1,true,1);
insert into public.care (id, price, start_time, end_time, care_type_id,  doctor_id,approved,patient_id) values (11, 200,CAST(N'2020-01-07 10:30:00.000' AS timestamp), CAST(N'2020-01-07 11:00:00.000' AS timestamp), 1, 1,true,1);



insert into public.care (id, price, start_time, end_time, care_type_id, doctor_id,approved,patient_id) values (12, 400, CAST(N'2020-03-04 11:00:00.000' AS timestamp), CAST(N'2020-03-04 11:30:00.000' AS timestamp), 2, 2,true,null);
insert into public.care (id, price, start_time, end_time, care_type_id,  doctor_id,approved,patient_id) values (13, 200,CAST(N'2020-03-04 10:30:00.000' AS timestamp), CAST(N'2020-03-04 11:00:00.000' AS timestamp), 1, 1,true,null);
insert into public.care (id, price, start_time, end_time, care_type_id, doctor_id,approved,patient_id) values (14, 400, CAST(N'2020-03-04 11:00:00.000' AS timestamp), CAST(N'2020-03-04 11:30:00.000' AS timestamp), 1, 1,true,null);
insert into public.care (id, price, start_time, end_time, care_type_id, doctor_id,approved,patient_id) values (15, 400, CAST(N'2020-03-04 11:00:00.000' AS timestamp), CAST(N'2020-03-04 11:30:00.000' AS timestamp), 2, 2,true,null);
insert into public.care (id, price, start_time, end_time, care_type_id,  doctor_id,approved,patient_id) values (16, 200,CAST(N'2020-03-08 15:30:00.000' AS timestamp), CAST(N'2020-03-08 16:00:00.000' AS timestamp), 2, 2,true,null);
insert into public.care (id, price, start_time, end_time, care_type_id, doctor_id,approved,patient_id) values (17, 400, CAST(N'2020-03-02 11:00:00.000' AS timestamp), CAST(N'2020-03-01 11:30:00.000' AS timestamp), 1, 1,true,null);
insert into public.care (id, price, start_time, end_time, care_type_id, doctor_id,approved,patient_id) values (18, 400, CAST(N'2020-03-02 16:00:00.000' AS timestamp), CAST(N'2020-03-02 16:30:00.000' AS timestamp), 2, 2,true,null);
insert into public.care (id, price, start_time, end_time, care_type_id, doctor_id,approved,patient_id) values (19, 400, CAST(N'2020-03-02 11:00:00.000' AS timestamp), CAST(N'2020-03-03 11:30:00.000' AS timestamp), 1, 1,true,null);
insert into public.care (id, price, start_time, end_time, care_type_id, doctor_id,approved,patient_id) values (20, 400, CAST(N'2020-04-02 13:00:00.000' AS timestamp), CAST(N'2020-03-02 13:30:00.000' AS timestamp), 2, 2,true,null);


