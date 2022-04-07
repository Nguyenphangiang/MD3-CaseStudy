package DAO.restaurant;



import config.SingletonConnection;
import model.Restaurant;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static config.SingletonConnection.getConnection;

public class RestaurantDAO implements IRestaurantDAO {
    //
    private static final String SELECT_RESTAURANT = "select * from nha_hang where id = ?";
    private static final String INSERT_INTO_RESTAURANT = "insert into nha_hang ( name, address, phone, open_time, close_time) values (?, ?, ?, ?, ?);";
    private static final String UPDATE_DEAL = "update nha_hang set name = ?, address = ?, phone = ?, open_time = ?, close_time = ? where id = ?;";
    private static final String DELETE_RESTAURANT = "delete from nha_hang where id = ?";

    @Override
    public List<Restaurant> findAll() {
        List<Restaurant> restaurantList = new ArrayList<>();
        Connection connection = getConnection();
        try (
                PreparedStatement preparedStatement = connection.prepareStatement("select * from nha_hang")
        ) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
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
        try (
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_RESTAURANT)
        ) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
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
        boolean rowUpdated;
        Connection connection = getConnection();
        try (
                PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_DEAL);
        ) {
            preparedStatement.setString(1, restaurant.getRestaurantName());
            preparedStatement.setString(2, restaurant.getRestaurantAddress());
            preparedStatement.setString(3, restaurant.getRestaurantPhone());
            preparedStatement.setTime(4, restaurant.getOpenTime());
            preparedStatement.setTime(5, restaurant.getCloseTime());
            preparedStatement.setInt(6, restaurant.getId());

            rowUpdated = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean save(Restaurant restaurant) {
        try (
                Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO_RESTAURANT)
        ) {
            preparedStatement.setString(1, restaurant.getRestaurantName());
            preparedStatement.setString(2, restaurant.getRestaurantAddress());
            preparedStatement.setString(3, restaurant.getRestaurantPhone());
            preparedStatement.setTime(4, restaurant.getOpenTime());
            preparedStatement.setTime(5, restaurant.getCloseTime());
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        boolean rowDeleted;
        Connection connection = getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(DELETE_RESTAURANT);) {
            preparedStatement.setInt(1, id);
            rowDeleted = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
