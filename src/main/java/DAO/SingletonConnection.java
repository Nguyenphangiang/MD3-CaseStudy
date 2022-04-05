package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SingletonConnection {
    private SingletonConnection() {
    }

    private static Connection getConnection(){
    Connection connection = null;
    try {
        Class.forName("com.mysql.jdbc.Driver");
        connection =  DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/trua_nay_an_gi",
                "root",
                "2512"
        );
        System.out.println("thanh cong");
    } catch (ClassNotFoundException e) {
        System.out.println("that bai");
        e.printStackTrace();
    } catch (SQLException e) {
        System.out.println("that bai");
        e.printStackTrace();
    }
    return connection;
}

//    public static void main(String[] args) {
//        getConnection();
//    }
}
