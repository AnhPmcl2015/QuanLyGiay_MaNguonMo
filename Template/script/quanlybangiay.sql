create database quanlygiay;
ALTER DATABASE quanlygiay CHARACTER SET utf8 COLLATE utf8_general_ci;

use quanlygiay;

create table giay(
id_giay int not null,
ma_giay char(50) not null unique,
ten_giay char(50) not null unique,
id_loai_giay int not null,
so_luong_ban int not null,
gia_ban long not null,
ghi_chu text,
id_gioi_tinh int,
img text,
primary key(id_giay)
);

create table gioi_tinh(
id_gioi_tinh int not null,
ten_gioi_tinh char(50) not null,
primary key(id_gioi_tinh)
);


create table chi_tiet_giay(
id_chi_tiet_giay int not null,
size int not null, 
so_luong int not null,
id_giay int not null,
primary key(id_chi_tiet_giay)
);

create table loai_giay(
id_loai_giay int not null auto_increment,
ma_loai_giay char(50),
ten_loai_giay char(50) not null,
id_hang_san_xuat int not null,
primary key(id_loai_giay)
);

create table hang_san_xuat(
id_hang_san_xuat int not null,
ten_hang_san_xuat char(100),
primary key(id_hang_san_xuat)
);

create table phieu_nhap(
id_phieu_nhap int not null,
ngay_nhap datetime not null,
tong_so_luong int not null,
id_hang_san_xuat int not null,
primary key(id_phieu_nhap)
);

create table chi_tiet_phieu_nhap(
id_chi_tiet_phieu_nhap int not null,
id_phieu_nhap int not null,
id_chi_tiet_giay int not null, 
so_luong int not null,
gia_von long,
primary key(id_chi_tiet_phieu_nhap)
);

create table khach_hang(
id_khach_hang int not null,
ten_khach_hang char(100) not null,
dia_chi text not null,
so_dien_thoai long not null,
tai_khoan char(100) unique not null,
mat_khau text not null,
primary key(id_khach_hang)
);

create table don_hang(
id_don_hang int not null,
ngay_dat date  not null,
id_tinh_trang int not null,
tong_tien long not null,
primary key(id_don_hang)
);

create table tinh_trang_don_hang(
id_tinh_trang int not null,
ten_tinh_trang char(50),
primary key(id_tinh_trang)
);

create table chi_tiet_don_hang(
id_chi_tiet_don_hang int not null,
id_don_hang int not null,
id_chi_tiet_giay int not null,
so_luong int not null,
thanh_tien long not null,
primary key(id_chi_tiet_don_hang)
);

-- Foreign key
alter table giay add foreign key(id_gioi_tinh) references gioi_tinh(id_gioi_tinh);
alter table chi_tiet_giay add foreign key (id_giay) references giay(id_giay);
alter table giay add foreign key(id_loai_giay) references loai_giay(id_loai_giay);
alter table loai_giay add foreign key(id_hang_san_xuat) references hang_san_xuat(id_hang_san_xuat);
alter table phieu_nhap add foreign key(id_hang_san_xuat) references hang_san_xuat(id_hang_san_xuat);
alter table chi_tiet_phieu_nhap add foreign key(id_phieu_nhap) references phieu_nhap(id_phieu_nhap);
alter table chi_tiet_phieu_nhap add foreign key(id_chi_tiet_giay) references chi_tiet_giay(id_chi_tiet_giay);
alter table don_hang add foreign key(id_tinh_trang) references tinh_trang_don_hang(id_tinh_trang);
alter table chi_tiet_don_hang add foreign key(id_don_hang) references don_hang(id_don_hang);
alter table chi_tiet_don_hang add foreign key(id_chi_tiet_giay) references chi_tiet_giay(id_chi_tiet_giay);


-- hang san xuat
insert into hang_san_xuat(id_hang_san_xuat, ten_hang_san_xuat) values
(1, "Air Jordans"),
(2, "Nike"),
(3, "Adidas"),
(4, "Yeezy"),
(5, "Vans");

-- loai giay
-- Air Jordans
insert into loai_giay(ma_loai_giay, ten_loai_giay, id_hang_san_xuat) values
("AJ01","Air Jordan 1", 1),
("AJ02","Air Jordan 2", 1),
("AJ03","Air Jordan 3", 1),
("AJ04","Air Jordan 4", 1),

-- Nike
("NiBA","Blazer", 2),
("NiCB","Charles Barkley", 2),
("NiKD","Kevin Durant", 2),
("NiKB","Kobe Bryant", 2),

-- Adidas
("AdUB","Ultra Boost", 3),
("AdYz","Yeezy", 3),
("AdNM","NMD", 3),
("AdPH","Pharell", 3),

-- Yeezy
("YzYz", "Yeezy", 4),

-- Vans
("VaVa","Vans", 5);

-- Gioi tinh
insert into gioi_tinh(id_gioi_tinh, ten_gioi_tinh) values
(1, "Nam"),
(2, "Nữ");

-- Tình Trạng

insert into tinh_trang_don_hang(id_tinh_trang, ten_tinh_trang) values
(1, "Chưa xác nhận"),
(2, "Xác nhận"),
(3, "Đang xử lý"),
(4, "Hoàn thành"), 
(5, "Hủy");

commit;
