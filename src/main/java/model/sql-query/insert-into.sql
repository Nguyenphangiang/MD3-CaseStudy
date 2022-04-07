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
values ('bun',0,0),('grill',0,0),('pho',0,0),('com',0,0),('banh',0,0),('my',0,0),
       ('do uong',0,0),('trang mieng',0,0),('pizza',0,0),('burger',0,0),('japan',0,0),
       ('korean',0,0),('thailand',0,0),('italy',0,0),('hongkong',0,0),('fries',0,0);
insert into mon_an(name, image, note, price, nha_hang_id)
values ('bun hai san','https://img-global.cpcdn.com/recipes/65e122e42382061a/680x482cq70/bun-h%E1%BA%A3i-s%E1%BA%A3n-recipe-main-photo.jpg','su ket hop cua tom,muc,be be tao nen huong vi kho quen',60000,1),
       ('my xao hai san','https://cdn.tgdd.vn/2021/11/CookDishThumb/cach-lam-mi-xao-hai-san-hap-dan-la-mieng-cho-ca-nha-thumb-620x620.jpg','sot hai san voi soi my dai dai, lua chon hoan hao cua ban',55000,1),
       ('com hai san','https://cdn.tgdd.vn/2021/01/CookRecipe/Avatar/com-chien-hai-san-sot-xo-thumbnail.jpg','hat com mem duoc dung voi tom,muc,so diep goi nho ve tai nguyen bien',55000,1),
       ('nuoc ep tao','https://www.disneycooking.com/wp-content/uploads/2019/11/nuoc-ep-tao.jpg ','su chon loc ky luong tu nhung qua tao ngon nhat',10000,1),
       ('tra dao','https://cdn-www.vinid.net/2020/04/61d97550-tr%C3%A0-%C4%91%C3%A0o-cam-s%E1%BA%A3.jpg','huong vi kho quen den tu nhung qua dao chin mong',12000,1),
       ('my udon','https://i.ex-cdn.com/giadinhonline.vn/files/content/2020/12/22/mi-udon-16393616.jpg','soi my to cung vs nuoc dung katsuo cuc ky thom ngon bo duong',40000,2),
       ('my soba','https://japan.net.vn/images/uploads/2018/04/18/5-mi-yakisoba-nhat-ban.jpg','my soba tuong trung cho su truong tho trong van hoa Nhat Ban',40000,2),
       ('sushi','https://haisantrungnam.vn/wp-content/uploads/2020/04/sushi-la-gi-1.jpg','nhac den Nhat ban ko the thieu duoc mon sushi',80000,2),
       ('omuraisu','https://thumbs.dreamstime.com/b/japanese-omurice-omelette-rice-chicken-vegetables-close-up-plate-horizontal-clos-125714711.jpg','mon com chien voi trung chien kieu Nhat',35000,2),
       ('tra o long','https://images.japancentre.com/images/pics/2143/original/original.jpg?1548744035','thanh loc co the voi vi ngon cua tung la tra',10000,2),
       ('banh mochi','https://cdn.tgdd.vn/2020/07/CookProduct/157263421739499900-1200x676.jpg','duoc lam tu nhung hat gao nep ngon nhat',30000,2),
       ('pad thai','https://thailansensetravel.com/view-800/at_den-thai-lan-thuong-thuc-mon-pad-thai-ngon-dung-dieu_d54e0bc5d16445fe765a68b94afe41a6.jpg','mon an duong pho noi tieng cua Thai',40000,3),
       ('tom yum','https://vcdn-dulich.vnecdn.net/2022/01/06/thai-tom-yum-milky-soup-1-jpeg-2425-6503-1641457305.jpg','duoc lam tu cot tom yum noi tieng ngot cay dam gia vi',50000,3),
       ('nom du du','https://vnn-imgs-f.vgcloud.vn/2019/04/13/10/phat-sot-voi-mon-nom-du-du-chuan-vi-thai-lan.jpg','cot chanh ket hop voi du du xanh tao nen kiet tac mang phong cach Thai',25000,3),
       ('che sau thai','https://higlum.com/wp-content/uploads/2020/11/mon-che-thai-ngon.jpg','tu nhung qua sau rieng ngon nhat the gioi den tu Thai',25000,3),
       ('xoi xoai','https://thptchuyenlamson.vn/wp-content/uploads/2020/04/xoi-xoai-kieu-thai.jpg','mot mon an duong pho dam chat Thai',25000,3),
       ('my tuong den','https://wikiohana.net/wp-content/uploads/2019/08/mi-tuong-den.jpg','mon my tron don gian nhung rat ngon cua Han Quoc',35000,4),
       ('kimbap','https://upload.wikimedia.org/wikipedia/commons/thumb/5/56/Vegetable_gimbap.jpg/1200px-Vegetable_gimbap.jpg','com quan rong bien voi nhan thanh dam rat de an mang sac dac trung cua Han Quoc',25000,4),
       ('bibimbap','https://upload.wikimedia.org/wikipedia/commons/6/63/Korean_cuisine-Bibimbap-08.jpg','com tron rau cu va thit cuc ky ngon mieng',35000,4),
       ('ga ran HQ','https://vcdn-dulich.vnecdn.net/2016/06/08/anh1-8251-1465360558.jpg','chon loc nhung con ga ngon nhat va nuoc sot cay cay cua HQ',50000,4),
       ('my lanh ','https://pastaxi-manager.onepas.vn/content/uploads/articles/2amthuc/monngon/mylanhhanquoc/mi-lanh-han-quoc-1.jpg','mon my thanh dam, mat lanh phu hop cho thoi tiet nong',30000,4),
       ('nuoc gao','https://minhcaumart.vn/media/com_eshop/products/8801382124528.jpg','nuoc than thanh den tu Han Quoc lam cho da cua ban trang nhu nguoi Han',15000,4),
       ('my y','https://image.shutterstock.com/image-photo/delicious-spaghetti-served-on-black-260nw-413580649.jpg','mot mon pasta truyen thong cua Y dam vi Y',35000,5),
       ('pizza classic','https://img.freepik.com/free-photo/classic-italian-pepperoni-pizza-black-background-top-view-high-quality-photo_275899-626.jpg','pizza truyen thong cua y voi nguyen lieu vo cung thom ngon',70000,5),
       ('suon nuong','https://bizweb.dktcdn.net/100/004/714/articles/suon-nuong.jpg?v=1571816495980','mon suon nuong dam sot BBQ dem lai trai nghiem moi',80000,5),
       ('risotto','https://cdn2.photostockeditor.com/t/2612/food-risotto-on-white-ceramic-plate-meal-meal-image.jpg','ban da bao gio thu an com kieu Y chua?',40000,5),
       ('cocacola','https://thegioidouong.net/wp-content/uploads/2021/06/coca-300ml-chai-nhua.jpg','thuc uong than thanh qua thang nam',12000,5),
       ('mien xao HongKong','https://www.googleapis.com/download/storage/v1/b/rabbitcookingnet.appspot.com/o/RECIPES%2F%2Frang-xao%2Ftom-xao-mien-hong-kong-Pq4n6U9oT0w5rT91AK8pjYRB0yz8FiTrFAm90OF1.jpg?generation=1612408416773766&alt=media','ngon mieng, it tinh bot, tot cho vi giac va vong eo',35000,6),
       ('dimsum','https://cdn.tgdd.vn/Files/2020/08/27/1284281/dimsum-la-gi-nguon-goc-cua-dimsum-10-mon-an-dimsum-pho-bien-ma-ai-cung-biet-202008271106221169.jpg','hay con goi la diem tam, cuc ky juicy',30000,6),
       ('lau kho HongKong','https://channel.mediacdn.vn/thumb_w/640/2019/12/6/photo-2-15756093802501364682429.jpg','ngon choang ngop cuc ky la lau kho hong kong 4 nguoi an ok',300000,6);
insert into mon_an(name, image, note, price, nha_hang_id)
values
       ('banh bao xa xiu','https://cdn.daylambanh.edu.vn/wp-content/uploads/2019/10/banh-bao-xa-xiu-dinh-duong.jpg','cuc ky juicy, thi uop dam vi',15000,6),
       ('tart trung ','https://cdn.huongnghiepaau.com/wp-content/uploads/2018/05/6ce8174e82984e94a7a98889b7c17e32.jpg','thom ngon beo ngay vi trung an la nho',15000,6),
       ('chao ca Hong Kong','https://cdn.beptruong.edu.vn/wp-content/uploads/2018/11/chao-ca-chep.jpg','thit ca cuc gion, ngot tao huong vi bien nho',35000,6),
       ('banh my thap cam','https://xebanhmithonhiky.com.vn/wp-content/uploads/2019/03/banh-mi-kep-trung-duoc-thom-ngon.jpg','banh my truyen thong luon lam ta va ban be the gioi no bung',30000,7),
       ('banh my xa xiu','https://29foods.com/media/news/199_banh_mi_xa_xiu.jpg','thit xa xiu uop gia vi dac biet an mot lan la nghien',30000,7),
       ('banh my bo kho','https://kenh14cdn.com/2018/7/10/1010-15312139934151691587926.jpg','su ket hop moi me tao ra huong vi dac biet',30000,7),
       ('banh my trung ','https://images.foody.vn/res/g100/991883/prof/s640x400/foody-upload-api-foody-mobile-120-200306105935.jpg','don gian, nhe nhang nhung day du duong chat cho buoi sang',20000,7),
       ('mini pizza','https://lambanhngon.com/news_pictures/ojk1359220734.jpg','van la pizza ,nhung ma vua du nhe',20000,7),
       ('sua ngo','https://phunuketnoi.com/wp-content/uploads/2020/04/nau-sua-bap-1.jpg','duoc lam tu nhung bap ngo non tuyet voi',10000,7),
       ('burger bo','https://toinayangi.vn/wp-content/uploads/2014/12/hamburger-bo.jpg','thit bo nuong than va hun khoi cuc ky thom ngon',40000,8),
       ('burger ga','http://product.hstatic.net/1000242782/product/burger_ga_xe_180cd087a1bf4e8885b85071cfebeeac_grande.jpg','ga duoc chien ron ket hop voi banh burger sieu dinh',35000,8),
       ('burger double cheese','https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTnuNJ1PfJM-jdovhqa36ZVVhbVa0pXOK6xZw&usqp=CAU','tin do cheese ko the bo qua vi ... qua ngon',45000,8),
       ('khoai tay chien','https://iweb.tatthanh.com.vn/pic/3175/thumb/large/product/khoai%20t%C3%A2y%20c%E1%BB%8Dng.jpg','duoc chon lua tu nhung cu khoai beo ngon nhat',25000,8),
       ('cocacola ','https://thegioidouong.net/wp-content/uploads/2021/06/coca-300ml-chai-nhua.jpg','nuoc uong than thanh qua thang nam',10000,8),
       ('com thit kho','https://afamilycdn.com/zoom/640_400/2019/1/1/com-trua-6-15463129193431456643416-crop-15463130819111963577388.jpg','thit kho tau tam uot dam vi, ket hop mieng thit ba chi beo ngay voi nuoc cot dua',40000,9),
       ('com rang dua bo','https://pastaxi-manager.onepas.vn/content/uploads/articles/mon-an-vat-hai/com-rang-dua-bo/cach-lam-com-rang-dua-bo-1.jpg','dua muoi chin toi ket hop voi bo lan qua lua cuc ky tuyet voi',40000,9),
       ('com ga nam','https://image-us.eva.vn/upload/1-2020/images/2020-02-11/cach-lam-com-ga-nam-nhanh-gon-nhung-van-ngon-tuyet-dam-bao-an-mot-muon-an-hai-1-1581398796-215-width640height426.jpg','mot lua chon gay nghien, co the khien loai ga tuyet chung',40000,9),
       ('pho xao','https://cdn.daotaobeptruong.vn/wp-content/uploads/2021/05/pho-xao.jpg','van la pho nhung dem lai huong vi ngay ngon',40000,9),
       ('pho phap phong','https://cdn.tgdd.vn/2020/07/CookProductThumb/quefwwer-620x620.jpg','co them chia bia thi het nuoc cham...',50000,9),
       ('tra chanh','https://nguyenlieuphachehanoi.com/wp-content/uploads/2019/05/cong-thuc-sieu-pham-tra-chanh.jpg','tra man cuc ngon ket hop voi chanh tuoi xanh..het nuoc cham',15000,9),
       ('bun tron','https://image-us.eva.vn/upload/1-2019/images/2019-03-21/cach-lam-bun-tron-kieu-thai-ngon-van-nguoi-me-cach-lam-bun-tron-5-1553144010-868-width489height355.jpg','dam sac duong pho thai, ket hop chua cay man ngot',30000,10),
       ('pho tron','https://d1sag4ddilekf6.azureedge.net/compressed/items/VNGFVN000005me-CZJGNK2DRRDXGT/photo/menueditor_item_7921110a7d754b97880b1ee333fa518d_1624950898757711640.jpg','van la quoc dan Pho nhung su ket hop thanh mat nay lai dem den mot cuc pham',40000,10),
       ('my van than','https://vinairato.com/wp-content/uploads/2020/04/my-van-than-ngon.jpg','he,sui cao,gan,thit xa xiu ket hop nuoc leo ngot tu xuong...',35000,10),
       ('banh trang nuong','https://pastaxi-manager.onepas.vn/content/uploads/articles/vuonghoai/banh-trang-nuong/banh-trang-nuong-1.jpg','la mieng, pizza viet nam, cuc ky ngon ',20000,10),
       ('burger mini','https://i.pinimg.com/736x/00/a8/93/00a893ab2cc5b2488de0104db8ae02ae--mini-hamburgers-mini-burger.jpg','nho nhan, xinh xan nhung van giu duoc vi ngon',15000,10),
       ('tra chanh','https://file.hstatic.net/1000135323/file/tra-chanh-truyen-thong_299c6fc757e949a798cddc6bbbade8e8_grande.jpg','tra man ket hop chanh tuoi... het nuoc cham',15000,10),
       ('tra xa tac','https://thucthan.com/media/2019/06/tra-tac/hong-tra-tac.jpg','su ket hop moi me tac va xa ... het nuoc cham',15000,10);

