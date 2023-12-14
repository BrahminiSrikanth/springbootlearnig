insert into user_details(id,birth_date,name) values (1001,current_date(),'Ranga');
insert into user_details(id,birth_date,name) values (1002,current_date(),'Rama');

insert into post(id,description,user_id) values(200001,'I want to learn AWS',1001);
insert into post(id,description,user_id) values(200002,'I want to learn AWS Devops',1001);
insert into post(id,description,user_id) values(200003,'I want to learn AWS',1002);
insert into post(id,description,user_id) values(200004,'I want to learn Azure',1002);