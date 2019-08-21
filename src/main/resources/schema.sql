drop table if exists material
create table material (id bigint not null auto_increment, material_comment varchar(20) not null, material_desc varchar(50) not null, material_name varchar(20) not null, point integer not null, primary key (id)) engine=MyISAM
