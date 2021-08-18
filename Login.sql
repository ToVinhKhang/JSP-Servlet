create database accounts;
use accounts;
create table login
(
	email varchar(40),
    password varchar(40),
    primary key (email)
);
create table nhanvien (
	MaNV char(10) ,
    tenNV nvarchar(50),
    ChucVu nvarchar(20),
    taikhoan char(50),
    matkhau char(50),
    primary key(MaNV)
);
insert into login values('thinh@gmail.com','123456');
insert into login values('minh@gmail.com','123456');
insert into login values('khang@gmail.com','123456');
select * from login;

use accounts;
SELECT * FROM login;

insert into nhanvien values('GD',N'Nguyễn Văn Nam',N'giám đốc','nguyenvannam123','12345');  
insert into nhanvien values('PGD',N'Nguyễn Văn Hùng',N'giám đốc','nguyenvanhung123','12345');  
insert into nhanvien values('TP',N'Nguyễn Gia Lâm ',N'trưởng phong','nguyengialam','12345');  
insert into nhanvien values('TK',N'Nguyễn Bích Vân',N'Thư kí ','nguyenbichvan','12345');  
select * from nhanvien;