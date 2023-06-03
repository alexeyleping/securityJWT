create table if not exists appuser
(
    id       uuid primary key,
    username varchar(255),
    password text
);

create table if not exists approles
(
    id   uuid primary key,
    name varchar(255)
);

create table if not exists appuser_approles
(
    appuser_id  uuid references appuser (id),
    approles_id uuid references approles (id),
    CONSTRAINT appuser_approles_pkey PRIMARY KEY (appuser_id, approles_id)
);

insert into appuser
values ('3ba8bcc4-cafe-11ed-afa1-0242ac120002', 'admin', '$2a$12$RPb3mUhFdzlAgvvmYBdP/.iLCYfLbp1baJl.nh./jn9E03/61gnga');
insert into appuser
values ('504d9da6-e9d1-11ed-a05b-0242ac120003', 'manager', '$2a$12$RPb3mUhFdzlAgvvmYBdP/.iLCYfLbp1baJl.nh./jn9E03/61gnga');
insert into approles
values ('64863d7e-cafe-11ed-afa1-0242ac120002', 'ROLE_ADMIN');
insert into approles
values ('504da508-e9d1-11ed-a05b-0242ac120003', 'ROLE_MANAGER');
insert into appuser_approles
values ('3ba8bcc4-cafe-11ed-afa1-0242ac120002', '64863d7e-cafe-11ed-afa1-0242ac120002');
insert into appuser_approles
values ('504d9da6-e9d1-11ed-a05b-0242ac120003', '504da508-e9d1-11ed-a05b-0242ac120003');