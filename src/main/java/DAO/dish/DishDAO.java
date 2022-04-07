package DAO.dish;

import DAO.tag.ITagDAO;
import DAO.tag.TagDAO;
import config.SingletonConnection;
import model.Dish;
import model.Restaurant;
import model.Tag;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static config.SingletonConnection.getConnection;

public class DishDAO implements IDishDAO {
    Connection connection = SingletonConnection.getConnection();
    ITagDAO tagDAO = new TagDAO();

    @Override
    public void save(Dish dish, int[] tags) {
        int dish_id = 0;
        try {
            connection.setAutoCommit(false);
            PreparedStatement statement = connection.prepareStatement(
                    "insert into mon_an(name, image, note, price, nha_hang_id)\n" +
                            "VALUE (?,?,?,?,?,?)\n) ", Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, dish.getDishName());
            statement.setString(2, dish.getDishImage());
            statement.setString(3, dish.getDishNote());
            statement.setInt(4, dish.getDishPrice());
            statement.setInt(5, dish.getRestaurant().getId());

            int a1 = statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            while (resultSet.next()){
                System.out.println(resultSet);
                dish_id= resultSet.getInt(1);
                PreparedStatement statement1 = connection.prepareStatement("insert into mon_an_tag(the_id, mon_an_id) VALUE (?,?)");
                for (int tag_id: tags
                ) {
                    statement.setInt(1,tag_id);
                    statement.setInt(2,dish_id);
                    statement.executeUpdate();
                }
                connection.commit();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Dish> findAll() {
        List<Dish> dishes = new ArrayList<>();

        try (PreparedStatement preparedStatement = connection.prepareStatement(
                "select mon_an.id as id, mon_an.name as name, mon_an.image as image, mon_an.note as note, mon_an.price as price,\n" +
                        "nh.id as id_restaurant, nh.name as restaurant, nh.address as address, nh.phone,nh.open_time,nh.close_time \n" +
                        "from mon_an\n" +
                        "join nha_hang nh on nh.id = mon_an.nha_hang_id\n")
            ){
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String image = rs.getString("image");
                String note = rs.getString("note");
                int price = rs.getInt("price");

                List<Tag> tags = tagDAO.findAllByDishId(id);

                int id_restaurant = rs.getInt("id_restaurant");
                String restaurantName = rs.getString("restaurant");
                String restaurantAddress = rs.getString("address");
                String restaurantPhone = rs.getString("phone");
                Time openTime = rs.getTime("open_time");
                Time closeTime = rs.getTime("close_time");
                Restaurant restaurant = new Restaurant(id_restaurant, restaurantName, restaurantAddress, restaurantPhone, openTime, closeTime);
                Dish dish = new Dish(id, name, image, note, price, tags, restaurant);
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
        try(
                Connection connection = getConnection();
                PreparedStatement pstm = connection.prepareStatement(
                        "select ma.id as id, ma.name as name, ma.image as image, ma.note as note, ma.price as price, nh.id as id_restaurant, nh.name as restaurant from mon_an ma " +
                                "join nha_hang nh on ma.nha_hang_id = nh.id where ma.id = ?;"
                )
        ) {
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()){
                String name = rs.getString("name");
                String image = rs.getString("image");
                String note = rs.getString("note");
                int price = rs.getInt("price");

                List<Tag> tags = tagDAO.findAllByDishId(id);

                int id_restaurant = rs.getInt("id_restaurant");
                String restaurantName = rs.getString("restaurant");
                Restaurant restaurant = new Restaurant(id_restaurant, restaurantName);

                dish = new Dish(id, name, image, note, price, tags, restaurant);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dish;
    }

    public static void main(String[] args) {
        IDishDAO dishDAO = new DishDAO();
        System.out.println(dishDAO.findByName("bun hai san"));
    }

    @Override
    public Dish findByName(String name) {
        Dish dish  = null;
        try(
                Connection connection = getConnection();
                PreparedStatement pstm = connection.prepareStatement(
                        "select ma.id as id, ma.name as name, ma.image as image, ma.note as note, ma.price as price, nh.id as id_restaurant, nh.name as restaurant from mon_an ma " +
                                "join nha_hang nh on ma.nha_hang_id = nh.id where ma.name = ?;"
                )
        ) {
            pstm.setString(1, name);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id");
                String image = rs.getString("image");
                String note = rs.getString("note");
                int price = rs.getInt("price");

                List<Tag> tags = tagDAO.findAllByDishId(id);

                int id_restaurant = rs.getInt("id_restaurant");
                String restaurantName = rs.getString("restaurant");
                Restaurant restaurant = new Restaurant(id_restaurant, restaurantName);

                dish = new Dish(id, name, image, note, price, tags, restaurant);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dish;
    }

    @Override
    public boolean update(Dish dish) {
        boolean rowUpdated = false;

        return rowUpdated;
    }

    @Override
    public boolean save(Dish dish) {
        try(
                PreparedStatement preparedStatement = connection.prepareStatement(
                        "insert into mon_an(name, image, note, price, nha_hang_id)\\n\" +\n" +
                                "                            \"VALUE (?,?,?,?,?,?)\\n)")

        ){
            preparedStatement.setString(1, dish.getDishName());
            preparedStatement.setString(2, dish.getDishImage());
            preparedStatement.setString(3, dish.getDishNote());
            preparedStatement.setInt(4, dish.getDishPrice());
            preparedStatement.setInt(5, dish.getRestaurant().getId());
            return preparedStatement.executeUpdate()>0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        boolean rowDeleted = false;
        try {
            PreparedStatement preparedStatement1 = connection.prepareStatement(
                    ""
            );
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "delete from mon_an where id = ?"
            );
            preparedStatement.setInt(1, id);
            rowDeleted = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rowDeleted;
    }
}
