create database campusquestdb;

use campusquestdb;

create table users
(
id integer auto_increment primary key,
uname varchar(100) not null,
email varchar(50) not null unique,
year char not null,
passwd varchar(20) not null
);

