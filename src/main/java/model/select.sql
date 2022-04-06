use trua_nay_an_gi;
select mon_an.id as id, mon_an.name as name, mon_an.image as image, mon_an.note as note, mon_an.price as price,
       mkm.id as id_discount, mkm.gia_khuyen_mai as discountPrice,
       t.id as id_tag, t.tagName as tagName,
       nh.id as id_restaurant, nh.name as restaurant, nh.phone as restaurantPhone, nh.address
from mon_an
    join ma_khuyen_mai mkm on mon_an.khuyen_mai_id = mkm.id
    join the t on mon_an.tag_id = t.id
    join nha_hang nh on nh.id = mon_an.nha_hang_id

