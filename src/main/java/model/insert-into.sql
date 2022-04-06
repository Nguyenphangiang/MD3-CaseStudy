insert into nha_hang (name, address, phone, open_time, close_time)
values ('SeaFood','16 Ngoc Khanh','0911111111','9:00:00','23:59:59'),
 ('Tokyo','30 Kim Ma','0911111112','10:00:00','22:00:00'),
 ('ThaiFood','71 Thai Thinh','0911111113','10:00:00','22:00:00'),
 ('KoreanFood','211 Thai Ha','0911111114','11:00:00','22:00:00'),
 ('Peperoni pizza','1 Nguyen Cong Hoan','0911111115','9:00:00','22:00:00'),
 ('DimSum','2 Lang Ha','0911111116','8:00:00','22:00:00'),
 ('Huong Lan Bakery','300 Kim Ma','0911111117','6:00:00','21:00:00'),
 ('Burger Queen','211 Giang Vo','0911111118','10:00:00','23:00:00'),
 ('Binh Dan Quan','321 Cau Giay','0911111119','8:00:00','21:00:00'),
 ('Hell Kitchen','111 Tran Duy Hung','0911111120','11:00:00','23:59:59');
insert into ma_khuyen_mai( khuyen_mai_code, gia_khuyen_mai)
values ('None',0),('km10',10000),('km20',20000),('km30',30000),('km50',50000);
insert into the( tagName, luot_them, luot_xem)
values ('bun',0,0),('grill',0,0),('pho',0,0),('com',0,0),('banh my',0,0),('my',0,0),
       ('do uong',0,0),('trang mieng',0,0),('pizza',0,0),('burger',0,0),('japan',0,0),
       ('korean',0,0),('thailand',0,0),('italy',0,0),('hongkong',0,0),('fries',0,0);
insert into mon_an(name, image, note, price, nha_hang_id)
values ('bun hai san','jpg/bun-hai-san.jpg','su ket hop cua tom,muc,be be tao nen huong vi kho quen',60000,1),
       ('my xao hai san','jpg/my-xao-hai-san','sot hai san voi soi my dai dai, lua chon hoan hao cua ban',55000,1),
       ('com hai san','jpg/com-hai-san.jpg','hat com mem duoc dung voi tom,muc,so diep goi nho ve tai nguyen bien',55000,1),
       ('nuoc ep tao','jpg/nuoc-ep-tao.jpg','su chon loc ky luong tu nhung qua tao ngon nhat',10000,1),
       ('tra dao','jpg/tra-dao.jpg','huong vi kho quen den tu nhung qua dao chin mong',12000,1),
       ('my udon','jpg/my-udon.jpg','soi my to cung vs nuoc dung katsuo cuc ky thom ngon bo duong',40000,1),
