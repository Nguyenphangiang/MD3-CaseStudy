insert into nha_hang (name, address, phone, open_time, close_time)
values ('nha hang a','my dinh','091','07:00:00','23:00:00');
insert into the(tagName)
values ('bua trua');
insert into ma_khuyen_mai( khuyen_mai_code, gia_khuyen_mai)
values ('km01','5000');
insert into mon_an (name, image, note, price, khuyen_mai_id, tag_id, nha_hang_id)
values ('thit cho','con cho','ruou man','40000','1','1','1');
insert into nguoi_dung( name, phone, address)
values ('Canh','0123','my dinh');
insert into hoa_don( hoa_don_code, ngay_thang, nguoi_dung_id)
values ('hd1','2022-5-4',1);
insert into chi_tiet_hoa_don( nguoi_dung_id, mon_an_id, so_luong)
values (1,1,4);
insert into ma_khuyen_mai(khuyen_mai_code, gia_khuyen_mai)
values ('km02', 12000),
       ('km3', 25000);
insert into the(tagName)
values ('Pho'),
       ('Com'),
       ('Fast Food');
insert into nha_hang(name, address, phone, open_time, close_time)
values ('A Chau', 'Tu Liem', '0978', '09:00:00', '22:00:00' ),
       ('Bun Ba Minh', 'Moncity', '0786', '09:00:00', '22:00:00');
insert into mon_an(name, image, note, price, khuyen_mai_id, tag_id, nha_hang_id)
values ('Bun cha', 'hjkjkj', 'nuoc cham tuyet dinh', 25000, 2, 2, 2),
       ('Bun Bo', 'hkjl', 'Bo tu nong trai xanh', 35000, 3, 2, 3);


