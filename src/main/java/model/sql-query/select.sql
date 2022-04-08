select t.tagName,t.luot_them,t.luot_xem from the t where tagName = ?;

insert into mon_an (name, image, note, price, nha_hang_id)values (?,?,?,?,?);
insert into mon_an_tag(the_id, mon_an_id) values (?,?);
update the set luot_them = (luot_them + 1) where id = ?;
select * from the;

select t.id, t.tagName,t.luot_them,t.luot_xem from the t where id = ?;