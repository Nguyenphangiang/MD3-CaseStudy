use trua_nay_an_gi;
select mon_an.id as id, mon_an.name as name, mon_an.image as image, mon_an.note as note, mon_an.price as price,
       mkm.id as id_discount, mkm.khuyen_mai_code as discountCode, mkm.gia_khuyen_mai as discountPrice,
       nh.id as id_restaurant, nh.name as restaurant, nh.address as address, nh.phone,nh.open_time,nh.close_time
from mon_an
    join ma_khuyen_mai mkm on mon_an.khuyen_mai_id = mkm.id
    join nha_hang nh on nh.id = mon_an.nha_hang_id;
insert into the(tagName, luot_them, luot_xem)
values ('Pho', 2, 2),
('Com', 3, 1),
('Chao', 2, 1);

insert into mon_an_tag(the_id, mon_an_id)
values (1, 1),
       (2,1),
       (1, 2),
       (3, 2);
insert into nha_hang (name, address, phone, open_time, close_time)
values('A chau', 'moncity','0912', '08:00:00', '22:00:00' ),
('Mien Tay', 'moncity','0912', '08:00:00', '22:00:00' ),
('Canh ', 'moncity','0912', '08:00:00', '22:00:00' ),
('Phan Giang', 'moncity','0912', '08:00:00', '22:00:00' );
insert into ma_khuyen_mai(khuyen_mai_code, gia_khuyen_mai)
values ('km01', 20000),
       ('km02', 10000),
       ('km03', 15000);
insert into mon_an(name, image, note, price, khuyen_mai_id, nha_hang_id) values
('com tho', 'jhk', 'com cha trung', 50000, 1, 2),
('Bun bo', 'hgj', 'nuoc ham cu qua', 35000, 2, 3),
('Bun mong', 'hghfj', 'ngon het nuoc cham', 60000, 2, 4);
# select id, tagName, luot_them, luot_xem, mat.mon_an_id as dishName from the join mon_an_tag mat on the.id = mat.the_id and mat.mon_an_id = 1;
# select mon_an.id as id, mon_an.name as name, mon_an.image as image, mon_an.note as note, mon_an.price as price," +
#                                 "nh.name as restaurant" +
#                                 "from mon_an" +
#                                 "join nha_hang nh on nh.id = mon_an.nha_hang_id where id =?;se
select ma.id as id, ma.name as name, ma.image as image, ma.note as note, ma.price as price, nh.id as id_restaurant, nh.name as restaurant from mon_an ma join nha_hang nh on ma.nha_hang_id = nh.id where ma.id = 1;



