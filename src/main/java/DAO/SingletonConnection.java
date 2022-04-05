package DAO;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SingletonConnection {
    private SingletonConnection() {
    }

    public static final String JDBC_URL = "jdbc:mysql://localhost:3306/trua_nay_an_gi";
    public static final String JDBC_USER = "root";
    public static final String JDBC_PASSWORD = "Giangpro123";

    private static Connection getConnection(){
     Connection connection = null;
     try {
         Class.forName("com.mysql.jdbc.Driver");
         connection = DriverManager.getConnection(JDBC_URL,
                 JDBC_USER, JDBC_PASSWORD);
         System.out.println("OK");
     } catch (SQLException e) {
         e.printStackTrace();
     } catch (ClassNotFoundException e) {
         e.printStackTrace();
     }
     return connection;
 }

    public static void main(String[] args) {
        getConnection();
    }
}
