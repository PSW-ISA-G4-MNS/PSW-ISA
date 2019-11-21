for each test do:
database run 
database setup
backend run
npm install 
npm run-script build 
frontend run


insert into users ("address", "birthday", "email", "firstname", lastname, mobile_phone, password) VALUES ('A', '2019-10-10', 'office@email.com', 'Stefan', 'Johnson', '+40255333', 'XXX');
insert into patient ("insuranceid", "user_id") values ('156156156', 1);
	does not produce an error whhere id is not set automatically for patient

GET /me/
	set JSESSION cookie
	content type is json

curl -i localhost:9000/registrationRequests/all
	empty list 

insert into users ("address", "birthday", "email", "firstname", lastname, mobile_phone, password) VALUES ('A', '2019-10-10', 'office@email.com', 'Stefan', 'Johnson', '+40255333', 'XXX');
insert into patient ("id", "insuranceid", "user_id") values (1, '156156156', 1);
insert into registration_request ("approved", "time", "patient_id") values (true, '2019-10-10', 1);
curl -i localhost:9000/registrationRequests/all
	returns list of one item 
	request id is set 


insert into users ("address", "birthday", "email", "firstname", lastname, mobile_phone, password) VALUES ('A', '2019-10-10', 'office@email.com', 'Stefan', 'Johnson', '+40255333', 'XXX');
insert into patient ("id", "insuranceid", "user_id") values (1, '156156156', 1);
insert into registration_request ("approved", "time", "patient_id") values (true, '2019-10-10', 1);
curl localhost:9000/login -X POST -d '{"email": "office@email.com", "password": "XXX"}'
	returns JSESSION cookie
