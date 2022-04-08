package DAO;

import config.SingletonConnection;
import model.Total;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.SimpleTimeZone;

public class TotalDAO {
    Connection connection = SingletonConnection.getConnection();
    public Total sum(){
        Total total1 = null;
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("select SUM(gh.so_luong * ma.price) as total from gio_hang gh join mon_an ma on gh.mon_an_id = ma.id");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                int total = rs.getInt("total");
                total1 = new Total(total);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return total1;
    }
}
