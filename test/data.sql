insert into users ("address", "birthday", "email", "firstname", lastname, mobile_phone, password) VALUES ('A', '2019-10-10', 'admin@office.com', 'Stefan', 'Ilic', '+40255333', 'XXX');
insert into users ("address", "birthday", "email", "firstname", lastname, mobile_phone, password) VALUES ('A', '2019-10-10', 'clinic_admin@office.com', 'Branko', 'Maric', '+40255333', 'XXX');
insert into users ("address", "birthday", "email", "firstname", lastname, mobile_phone, password) VALUES ('A', '2019-10-10', 'doctor@office.com', 'Tamara', 'Ignjatovic', '+40255333', 'XXX');
insert into users ("address", "birthday", "email", "firstname", lastname, mobile_phone, password) VALUES ('A', '2019-10-10', 'nurse@office.com', 'Bozica', 'Ruzic', '+40255333', 'XXX');
insert into users ("address", "birthday", "email", "firstname", lastname, mobile_phone, password) VALUES ('A', '2019-10-10', 'patient@office.com', 'Aleksandar', 'Ivanov', '+40255333', 'XXX');

insert into care_type ("id", "name") values (100, 'Medicinski radnik');
insert into clinic ("address", "description", "location_lat", "location_lon", "name") values ('Obradoviceva 64', 'Studentska klinika', 21.0, 15.20, 'Studentska klinika');




insert into administrator ("id", "user_id") values (10, 1);
insert into clinic_administrator ("id", "user_id", "clinic_id") values (10, 2, 1);
insert into doctor ("id", "user_id", "years_of_experience", "care_type_id", "clinic_id") values (10, 3, 5, 100, 1);
insert into nurse ("id", "user_id") values (10, 4);
insert into patient ("id", "insuranceid", "user_id") values (10, '156156156', 5);

insert into registration_request ("approved", "time", "patient_id") values (true, '2019-10-10', 10);
insert into room ("title", "capacity", "clinic_id") values ('Soba 23', 10, 1);

