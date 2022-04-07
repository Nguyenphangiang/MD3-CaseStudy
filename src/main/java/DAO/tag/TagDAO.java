package DAO.tag;

import config.SingletonConnection;
import model.Tag;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TagDAO implements ITagDAO{
    Connection connection = SingletonConnection.getConnection();

    @Override
    public Tag findById(int id) {
        return null;
    }

    @Override
    public Tag findByName(String name) {
        return null;
    }

    @Override
    public boolean update(Tag tag) {
        return false;
    }

    @Override
    public boolean save(Tag tag) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public List<Tag> findAll() {
        List<Tag> tags = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(
                "select id, tagName from the; "
        )){
           ResultSet rs = preparedStatement.executeQuery();
           while (rs.next()){
               int id = rs.getInt("id");
               String tagName = rs.getString("tagName");
               Tag tag = new Tag(id, tagName);
               tags.add(tag);
           }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tags;
    }
    public List<Tag> findMaxAddNumber(){
        List<Tag> tags = new ArrayList<>();
        try( PreparedStatement preparedStatement = connection.prepareStatement(
                "select tagName, luot_them from the order by luot_them DESC limit 0,3;"
                )) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String tagName = resultSet.getString("tagName");
                int addNumber = resultSet.getInt("luot_them");
                Tag tag = new Tag(tagName, addNumber);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tags;
    }

    public static void main(String[] args) {
        ITagDAO tagDAO = new TagDAO();
        System.out.println(tagDAO.findMaxAddNumber());
    }




    @Override
    public List<Tag> findAllByDishId(int dish_id) {
        List<Tag> tags = new ArrayList<>();

        try (PreparedStatement pstm = connection.prepareStatement(
                "select id, tagName, luot_them, luot_xem, mat.mon_an_id as dishName from the " +
                        "join mon_an_tag mat on the.id = mat.the_id and mat.mon_an_id = ?;"))
        {
            pstm.setInt(1, dish_id);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id");
                String tagName = rs.getString("tagName");
                int viewNumber = rs.getInt("luot_xem");
                int addNumber = rs.getInt("luot_them");

                Tag tag = new Tag(id, tagName, viewNumber, addNumber);
                tags.add(tag);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tags;
    }



}
