package DAO.Restaurant;



import config.SingletonConnection;
import model.Restaurant;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static config.SingletonConnection.getConnection;

public class RestaurantDAO implements IRestaurantDAO {
    public static final String SQL_SELECT_RESTAURANT = "select * from nha_hang;";
    private Connection connection = SingletonConnection.getConnection();
    @Override
    public List<Restaurant> findAllByDishId(int id) {
        return null;
    }

    @Override
    public List<Restaurant> findAll() {
        List<Restaurant> restaurantList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_RESTAURANT);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String address = rs.getString("address");
                String phone = rs.getString("phone");
                Time openTime = rs.getTime("open_time");
                Time closeTime = rs.getTime("close_time");
                Restaurant newRestaurant = new Restaurant(id,name,address,phone,openTime,closeTime);
                restaurantList.add(newRestaurant);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return restaurantList;
    }


    @Override
    public Restaurant findById(int id) {
        Restaurant restaurant  = null;
        try(
                Connection connection = getConnection();
                PreparedStatement pstm = connection.prepareStatement(
                        "select * from nha_hang where id = ?"
                )
        ) {
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()){
                String restaurantName = rs.getString("name");
                String restaurantAddress = rs.getString("address");
                String restaurantPhone = rs.getString("phone");
                Time openTime = rs.getTime("open_time");
                Time closeTime = rs.getTime("close_time");

                restaurant = new Restaurant(id, restaurantName, restaurantAddress, restaurantPhone, openTime, closeTime);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return restaurant;
    }

    @Override
    public Restaurant findByName(String name) {
        return null;
    }

    @Override
    public boolean update(Restaurant restaurant) {
        return false;
    }

    @Override
    public boolean save(Restaurant restaurant) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }
}
