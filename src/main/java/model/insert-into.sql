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
delete from deal where id = ?;
select deal.id, deal.name, image, description, deal_price, nh.id, nh.name, nh.address, nh.phone, nh.open_time, nh.close_time from deal join nha_hang nh where deal.id = 2;