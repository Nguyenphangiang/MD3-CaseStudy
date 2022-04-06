
delete from deal where id = ?;
select deal.id, deal.name, image, description, deal_price, nh.id, nh.name, nh.address, nh.phone, nh.open_time, nh.close_time from deal join nha_hang nh where deal.id = 2;