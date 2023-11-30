create table employee(
  id int primary key auto_increment ,
  name varchar(55),
  phone int,
  address varchar(55),
  birthday date,
  sex bit(1) ,
  salary double not null
);

create database employee;

use employee;
create
    procedure PAGI_EMOPL(IN _limit int, IN no_page int, OUT total int)
BEGIN
    declare _offset int;
    SET _offset = (no_page - 1) * _limit;
    SET  total = CEIL((SELECT count(*) FROM employee) / _limit);
    SELECT * FROM employee LIMIT _limit OFFSET _offset;
end;


delimiter //
create procedure SELECTEMPLOYEE()
begin
    select *from employee;
end;
//

delimiter //
create procedure find_by_id(in _id int)
begin
    select *from employee where id=_id;
end;
//

delimiter //
create procedure CREATE_EMPLOYEE
(in _name varchar(55),in _phone int,in _address varchar(55) ,in _birthday date,in _sex bit(1),in _salary double)
begin
    insert into employee(name, phone, address, birthday, sex, salary) values (_name,_phone,_address,_birthday,_sex,_salary);
end;
//

delimiter //
create procedure UPDATE_EMPLOYEE(in _id int,in _name varchar(55),in _phone int,in _address varchar(55) ,in _birthday date,in _sex bit(1),in _salary double)
begin
    update employee set name=_name,phone=_phone,address=_address,birthday=_birthday,sex=_sex,salary=_salary where id=_id;
end;
//

delimiter //
create procedure DELETE_EMPLOYEE(in _id int)
begin
    DELETE FROM employee where id=_id;
end;
//