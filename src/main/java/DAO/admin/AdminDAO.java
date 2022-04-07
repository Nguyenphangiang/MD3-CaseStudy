package DAO.admin;

import model.Admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static config.SingletonConnection.getConnection;

public class AdminDAO implements IAdminDAO {


    @Override
    public List<Admin> findAll() {
        return null;
    }

    @Override
    public Admin findById(int id) {
        Admin admin = null;
        try(
                Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement("SELECT *from admin where id=?")
                ) {
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String account = resultSet.getString("account");
                String password = resultSet.getString("password");
                admin = new Admin(id,account,password);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return admin;
    }

    @Override
    public Admin findByName(String name) {
        return null;
    }

    @Override
    public boolean update(Admin admin) {
        return false;
    }

    @Override
    public boolean save(Admin admin) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }
}
