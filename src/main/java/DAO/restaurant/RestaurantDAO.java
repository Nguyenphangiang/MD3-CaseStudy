package DAO.restaurant;

import model.Restaurant;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static config.SingletonConnection.getConnection;

public class RestaurantDAO implements IRestaurantDAO{

    private static final String SELECT_RESTAURANT = "select * from nha_hang where id = ?";
    @Override
    public List<Restaurant> findAll() {
        List<Restaurant> restaurantList = new ArrayList<>();
        Connection connection = getConnection();
        try(
                PreparedStatement preparedStatement = connection.prepareStatement("select * from nha_hang")
                )
        {
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String address = resultSet.getString("address");
                String phone = resultSet.getString("phone");
                Time openTime = resultSet.getTime("open_time");
                Time closeTime = resultSet.getTime("close_time");
                Restaurant restaurant = new Restaurant(id, name, address, phone, openTime, closeTime);
                restaurantList.add(restaurant);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return restaurantList;
    }

    @Override
    public Restaurant findById(int id) {
        Restaurant restaurant = null;
        Connection connection = getConnection();
        try(
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_RESTAURANT)
                )
        {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                String name = resultSet.getString("name");
                String address = resultSet.getString("address");
                String phone = resultSet.getString("phone");
                Time openTime = resultSet.getTime("open_time");
                Time closeTime = resultSet.getTime("close_time");
                restaurant = new Restaurant(id, name, address, phone, openTime, closeTime);
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
