package DAO.deal;


import model.Deal;
import model.Restaurant;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static config.SingletonConnection.getConnection;

public class DealDAO implements IDealDAO{
    private static final String SELECT_DEAL ="select deal.id, deal.name, image, description, deal_price, nh.id, nh.name, nh.address, nh.phone, nh.open_time, nh.close_time from deal join nha_hang nh on nh.id = deal.nha_hang_id;";
    private static final String INSEERT_INTO_DEAL = "insert into deal (name, image, description, deal_price, nha_hang_id) values ( ?, ?, ?, ?, ?);";
    private static final String DELETE_DEAL = "delete from deal where id = ?;";
    private static final String SELECT_DEAL_1 ="select deal.id, deal.name, image, description, deal_price, nh.id, nh.name, nh.address, nh.phone, nh.open_time, nh.close_time from deal join nha_hang nh where deal.id = ?;";
    private static final String UPDATE_DEAL = "update deal set name = ?, image = ?, description = ?, deal_price = ?, nha_hang_id = ? where id = ?;";
    @Override

    //danh sach deal mon an

    public List<Deal> findAll() {
        List<Deal> dealList = new ArrayList<>();
        Connection connection = getConnection();
        try
                (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_DEAL);)
            {
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()){
                    int idDeal = resultSet.getInt("deal.id");
                    String dealName = resultSet.getString("deal.name");
                    String image = resultSet.getString("image");
                    String description = resultSet.getString("description");
                    int dealPrice = resultSet.getInt("deal_price");
                    int idRestaurant = resultSet.getInt("nh.id");
                    String restaurantName = resultSet.getString("nh.name");
                    String restaurantAddress = resultSet.getString("nh.address");
                    String restaurantPhone = resultSet.getString("nh.phone");
                    Time openTime = resultSet.getTime("nh.open_time");
                    Time closeTime = resultSet.getTime("nh.close_time");
                    Restaurant restaurant = new Restaurant(idRestaurant, restaurantName, restaurantAddress, restaurantPhone, openTime, closeTime);
                    Deal deal = new Deal(idDeal, dealName, image, description, dealPrice, restaurant);
                    dealList.add(deal);
                }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dealList;
    }

    public static void main(String[] args) {
//        IDealDAO dealDAO = new DealDAO();
//        System.out.println(dealDAO.findAll());

    }

    @Override
    public Deal findById(int id) {
        Deal deal = null;
        Connection connection = getConnection();
        try(
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_DEAL_1)
        )
        {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                int idDeal = resultSet.getInt("deal.id");
                String dealName = resultSet.getString("deal.name");
                String image = resultSet.getString("image");
                String description = resultSet.getString("description");
                int dealPrice = resultSet.getInt("deal_price");
                int idRestaurant = resultSet.getInt("nh.id");
                String restaurantName = resultSet.getString("nh.name");
                String restaurantAddress = resultSet.getString("nh.address");
                String restaurantPhone = resultSet.getString("nh.phone");
                Time openTime = resultSet.getTime("nh.open_time");
                Time closeTime = resultSet.getTime("nh.close_time");
                Restaurant restaurant = new Restaurant(idRestaurant, restaurantName, restaurantAddress, restaurantPhone, openTime, closeTime);
                deal = new Deal(idDeal, dealName, image, description, dealPrice, restaurant);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return deal;
    }

    @Override
    public Deal findByName(String name) {
        return null;
    }

    @Override
    public boolean update(Deal deal) {
        boolean rowUpdated;
        Connection connection = getConnection();
        try (
                PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_DEAL);
                )
        {
            preparedStatement.setString(1, deal.getDealName());
            preparedStatement.setString(2, deal.getDealImage());
            preparedStatement.setString(3, deal.getDescription());
            preparedStatement.setInt(4, deal.getDealPrice());
            preparedStatement.setInt(5, deal.getRestaurant().getId());
            preparedStatement.setInt(6, deal.getId());
            rowUpdated = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
//        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL);) {
//            statement.setString(1, user.getName());
//            statement.setString(2, user.getEmail());
//            statement.setString(3, user.getCountry());
//            statement.setInt(4, user.getId());
//
//            rowUpdated = statement.executeUpdate() > 0;
//        }
        return false;
    }

    @Override
    public boolean save(Deal deal) {
        try (
                Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(INSEERT_INTO_DEAL)
                ){
            preparedStatement.setString(1, deal.getDealName());
            preparedStatement.setString(2, deal.getDealImage());
            preparedStatement.setString(3, deal.getDescription());
            preparedStatement.setInt(4, deal.getDealPrice());
            preparedStatement.setInt(5, deal.getRestaurant().getId());
            return preparedStatement.executeUpdate()>0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        boolean rowDeleted;
        Connection connection = getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(DELETE_DEAL);){
            preparedStatement.setInt(1, id);
            rowDeleted = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Deal> findAllByDishId(int id) {
        return null;
    }
}
