package DAO.Tag;

import DAO.Restaurant.RestaurantDAO;
import config.SingletonConnection;
import model.DiscountCode;
import model.Tag;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static config.SingletonConnection.getConnection;

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
