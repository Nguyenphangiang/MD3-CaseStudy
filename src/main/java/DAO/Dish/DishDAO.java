package DAO.Dish;

import config.SingletonConnection;
import model.DiscountCode;
import model.Dish;
import model.Restaurant;
import model.Tag;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static config.SingletonConnection.getConnection;

public class DishDAO implements IDishDAO {

    @Override
    public List<Dish> findAll() {
        List<Dish> dishes = new ArrayList<>();
        Connection connection = SingletonConnection.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(
                "select mon_an.id as id, mon_an.name as name, mon_an.image as image, mon_an.note as note, mon_an.price as price,\n" +
                        "       mkm.id as id_discount, mkm.gia_khuyen_mai as discountPrice,\n" +
                        "       t.id as id_tag, t.tagName as tagName,\n" +
                        "       nh.id as id_restaurant, nh.name as restaurant, nh.phone as restaurantPhone, nh.address\n" +
                        "from mon_an\n" +
                        "    join ma_khuyen_mai mkm on mon_an.khuyen_mai_id = mkm.id\n" +
                        "    join the t on mon_an.tag_id = t.id\n" +
                        "    join nha_hang nh on nh.id = mon_an.nha_hang_id")
            ){
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String image = rs.getString("image");
                String note = rs.getString("note");
                int price = rs.getInt("price");
                int id_discount = rs.getInt("id_discount");
                int discountPrice = rs.getInt("discountPrice");
                DiscountCode discountCode = new DiscountCode(id_discount, discountPrice);
                int id_tag = rs.getInt("id_tag");
                String tagName = rs.getString("tagName");
                Tag tag = new Tag(id_tag, tagName);
                int id_restaurant = rs.getInt("id_restaurant");
                String restaurantName = rs.getString("restaurant");
                String restaurantPhone = rs.getString("phone");
                String restaurantAddress = rs.getString("address");
                Restaurant restaurant = new Restaurant(id_restaurant, restaurantName, restaurantPhone, restaurantAddress);
                Dish dish = new Dish(id, name, image, note, price, discountCode, tag, restaurant);
                dishes.add(dish);
            }
            } catch (SQLException e) {
            e.printStackTrace();
        }
        return dishes;
        }




    @Override
    public Dish findById(int id) {
        Dish dish  = null;
//        try(
//                Connection connection = getConnection();
//                PreparedStatement pstm = connection.prepareStatement(
//                        "select * from mon_an where id = ?"
//                )
//        ) {
//            pstm.setInt(1, id);
//            ResultSet rs = pstm.executeQuery();
//            while (rs.next()){
//                String name = rs.getString("name");
//                String img = rs.getString("img");
//                String note = rs.getString("note");
//                int price = rs.getInt("price");
//                int id_discount = rs.getInt("khuyen_mai_id");
//                int id_tag = rs.getInt("tag_id");
//                int id_restaurant = rs.getInt("nha_hang_id");
//                dish = new Dish(id, name, img, note, price, )


//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        return dish;

    }

    @Override
    public Dish findByName(String name) {
        return null;
    }

    @Override
    public boolean update(Dish dish) {
        return false;
    }

    @Override
    public boolean save(Dish dish) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }
}
