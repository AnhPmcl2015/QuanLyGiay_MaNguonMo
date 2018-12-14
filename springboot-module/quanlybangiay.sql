drop database if exists quanlygiay;
create database quanlygiay;
ALTER DATABASE quanlygiay CHARACTER SET utf8 COLLATE utf8_general_ci;

use quanlygiay;

create table giay(
id_giay int not null auto_increment,
ma_giay char(255) not null unique,
ten_giay char(100) not null,
gia_ban int(11) not null,
ghi_chu text,
img1 text,
img2 text,
img3 text,
img4 text,
so_luong_ban int,
id_loai_giay int not null,
id_gioi_tinh int not null,
xoa_flag bit default 0,
primary key(id_giay)
);

create table gioi_tinh(
id_gioi_tinh int not null,
ten_gioi_tinh char(50) not null,
primary key(id_gioi_tinh)
);


create table chi_tiet_giay(
id_chi_tiet_giay int not null unique auto_increment,
size int not null, 
so_luong int not null default 0,
id_giay int not null,
xoa_flag bit default 0,
primary key(id_chi_tiet_giay)
);

create table loai_giay(
id_loai_giay int not null auto_increment,
ten_loai_giay char(100) not null,
id_hang_san_xuat int not null,
xoa_flag bit default 0,
primary key(id_loai_giay)
);

create table hang_san_xuat(
id_hang_san_xuat int not null auto_increment,
ten_hang_san_xuat char(100),
xoa_flag bit default 0,
primary key(id_hang_san_xuat)
);

create table phieu_nhap(
id_phieu_nhap int not null auto_increment,
ngay_nhap datetime not null,
tong_so_luong int not null default 0,
id_hang_san_xuat int not null,
primary key(id_phieu_nhap)
);

create table chi_tiet_phieu_nhap(
id_chi_tiet_phieu_nhap int not null auto_increment,
id_phieu_nhap int not null,
id_chi_tiet_giay int not null, 
so_luong int not null default 0,
gia_von int(11) default 0,
primary key(id_chi_tiet_phieu_nhap)
);

create table khach_hang(
id_khach_hang int not null auto_increment,
ten_khach_hang char(100) not null,
dia_chi text not null,
so_dien_thoai int(10) not null,
id_user int,
primary key(id_khach_hang)
);

create table don_hang(
id_don_hang int not null auto_increment,
ngay_dat datetime  not null,
ngay_giao datetime  not null,
id_tinh_trang int not null,
id_khach_hang int not null,
tong_tien int(11) not null default 0,
primary key(id_don_hang)
);

create table tinh_trang_don_hang(
id_tinh_trang int not null auto_increment,
ten_tinh_trang char(50),
primary key(id_tinh_trang)
);

create table chi_tiet_don_hang(
id_chi_tiet_don_hang int not null auto_increment,
id_don_hang int not null,
id_chi_tiet_giay int not null,
so_luong int not null,
thanh_tien int(11) not null,
primary key(id_chi_tiet_don_hang)
);
create table user_roles(
user_id int,
role_id int
);
create table users(
id_user int auto_increment primary key,
email varchar(45) unique,
username varchar(45) unique,
password varchar(256) not null
);
-- Foreign key
alter table giay add foreign key(id_gioi_tinh) references gioi_tinh(id_gioi_tinh);
alter table giay add foreign key(id_loai_giay) references loai_giay(id_loai_giay);
alter table loai_giay add foreign key(id_hang_san_xuat) references hang_san_xuat(id_hang_san_xuat);
alter table phieu_nhap add foreign key(id_hang_san_xuat) references hang_san_xuat(id_hang_san_xuat);
alter table chi_tiet_phieu_nhap add foreign key(id_chi_tiet_giay) references chi_tiet_giay(id_chi_tiet_giay);
alter table chi_tiet_phieu_nhap add foreign key(id_phieu_nhap) references phieu_nhap(id_phieu_nhap);
alter table don_hang add foreign key(id_tinh_trang) references tinh_trang_don_hang(id_tinh_trang);
alter table don_hang add foreign key(id_khach_hang) references khach_hang(id_khach_hang);
alter table chi_tiet_don_hang add foreign key(id_don_hang) references don_hang(id_don_hang);
alter table chi_tiet_don_hang add foreign key(id_chi_tiet_giay) references chi_tiet_giay(id_chi_tiet_giay);
alter table chi_tiet_giay add foreign key(id_giay) references giay(id_giay);
alter table khach_hang add foreign key(id_user) references users(id_user);
commit;
