use world;
create table member(
id varchar(20) primary key,
pwd varchar(20) not null,
name varchar(20) not null,
email varchar(50) not null,
type varchar(20)
);