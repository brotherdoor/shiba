--drop table customer_tb;

create table customer_tb(
id varchar2(20) primary key,
passwd varchar2(30) not null,
name varchar2(50),
age number(3),
address varchar2(128));

insert into customer_tb values('kkjin@nextree.co.kr', '1234', 'Jin', 20, '서울');
insert into customer_tb values('jypark@nextree.co.kr', '1111', 'Park', 25, '인천');
insert into customer_tb values('eykim@nextree.co.kr', '7979', 'Kim', 22, '서울');
insert into customer_tb values('tksong@nextree.co.kr', '0001', 'Song', 19, '부산');
insert into customer_tb values('yhh@nextree.co.kr', '3535', 'Ha', 20, '대전');





