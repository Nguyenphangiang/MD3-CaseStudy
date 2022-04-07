package DAO.collab;

import controller.RegistrationCollab;
import model.Collab;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static config.SingletonConnection.getConnection;

public class CollabDAO implements ICollabDAO{

//    private static final String INSERT_COLLAB_SQL = "INSERT INTO ctv (name, email, password) VALUES (?, ?, ?)";
//    private static final String SAVE_COLLAB_SQL = "SELECT (name, email, password) from ctv";

    @Override
    public List<Collab> findAll() {
        return null;
    }

    @Override
    public Collab findById(int id) {
        return null;
    }

    @Override
    public Collab findByName(String name) {
        return null;
    }

    @Override
    public boolean update(Collab collab) {
        return false;
    }

//    public void insertCollab(Collab collab){
//        System.out.println(INSERT_COLLAB_SQL);
//        try(Connection connection = getConnection();
//            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_COLLAB_SQL)
//        ){
//            preparedStatement.setString(1,collab.getCollabName());
//            preparedStatement.setString(2, collab.getCollabEmail());
//            preparedStatement.setString(3, collab.getCollabPassword());
//            System.out.println(preparedStatement);
//            preparedStatement.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }

    @Override
    public boolean save(Collab collab) {
        try(
                Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(
                        "insert into ctv(name, email, password) value (?, ?, ?)"
                )
                ){
            preparedStatement.setString(1, collab.getCollabName());
            preparedStatement.setString(2, collab.getCollabEmail());
            preparedStatement.setString(3, collab.getCollabPassword());

            return preparedStatement.executeUpdate()>0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }
    public List<Collab> selectAllCollab(){
        List<Collab> collabs = new ArrayList<>();
        try(
                Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement("select *from ctv");
                ){
            System.out.println(preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
//                int id = resultSet.getInt("id");
                String collabName = resultSet.getString("name");
                String collabEmail = resultSet.getString("email");
                String collabPassword = resultSet.getString("password");
                collabs.add(new Collab(collabName,collabEmail,collabPassword));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return collabs;
    }
}
