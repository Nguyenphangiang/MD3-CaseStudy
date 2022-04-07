create database trua_nay_an_gi;
use trua_nay_an_gi;
create table admin(
                      id int primary key ,
                      account nvarchar(50),
                      password nvarchar(50)
);
create table nha_hang(
                         id int primary key auto_increment,
                         name nvarchar(50),
                         address nvarchar(50),
                         phone nvarchar(12),
                         open_time time,
                         close_time time
);
create table ctv(
                    id int primary key auto_increment,
                    name nvarchar(50),
                    email nvarchar(50),
                    password nvarchar(50),
                    nha_hang_id int,
                    foreign key (nha_hang_id) references nha_hang(id)
);
create table ma_khuyen_mai(
                              id int primary key auto_increment,
                              khuyen_mai_code nvarchar(255),
                              gia_khuyen_mai int
);
create table the(
                    id int auto_increment primary key ,
                    tagName nvarchar(50),
                    luot_them int,
                    luot_xem int
);
create table mon_an(
                       id int primary key  auto_increment,
                       name nvarchar(100),
                       image nvarchar(255),
                       note nvarchar(255),
                       price int,
                       nha_hang_id int,
                       foreign key (nha_hang_id) references  nha_hang(id)
);
create table deal(
                     id int primary key auto_increment,
                     name nvarchar(255),
                     image nvarchar(255),
                     description nvarchar(255),
                     deal_price int,
                     nha_hang_id int,
                     foreign key (nha_hang_id) references nha_hang(id)
);
create table nguoi_dung(
                           id int primary key  auto_increment,
                           name nvarchar(255),
                           phone nvarchar(12),
                           address nvarchar(255)
);
create table hoa_don(
                        id int primary key auto_increment,
                        hoa_don_code nvarchar(255),
                        ngay_thang datetime
);
create table chi_tiet_hoa_don(
    id int primary key auto_increment,
    nguoi_dung_id int,
    mon_an_id int,
    hoa_don_id int,
    so_luong int,
    ma_khuyen_mai_id int,
    foreign key (ma_khuyen_mai_id) references ma_khuyen_mai(id),
    foreign key (mon_an_id) references mon_an(id),
    foreign key (nguoi_dung_id)references nguoi_dung(id)
);
create table mon_an_tag(
    the_id int,
    mon_an_id int,
    PRIMARY KEY (the_id,mon_an_id),
    foreign key (the_id) references the(id),
    foreign key (mon_an_id)references mon_an(id)
);





