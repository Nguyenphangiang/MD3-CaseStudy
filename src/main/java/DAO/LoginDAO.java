package DAO;

import config.SingletonConnection;
import entity.Account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDAO {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    public Account checkLogin(String user, String pass){
        try{
            String query = "select *from admin where account=? and password=?;";
            connection =  SingletonConnection.getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,user);
            preparedStatement.setString(2,pass);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Account a = new Account(resultSet.getString(1), resultSet.getString(2));
                return a;
            }
        }catch (Exception e){

        }
        return null;
    }
}
