drop table material if exists
drop table user if exists
create table material (id bigint generated by default as identity, material_comment varchar(20) not null, material_desc varchar(50) not null, material_name varchar(20) not null, point integer not null, primary key (id))
create table user (id bigint generated by default as identity, avatar varchar(200), email varchar(50) not null, name varchar(20) not null, password varchar(100) not null, username varchar(20) not null, primary key (id))
alter table user add constraint UK_ob8kqyqqgmefl0aco34akdtpe unique (email)
alter table user add constraint UK_sb8bbouer5wak8vyiiy4pf2bx unique (username)