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
    public static final String SQL_SELECT_TAG = "select * from the;";
    private Connection connection = SingletonConnection.getConnection();
    public static final String SQL_SELECT_TAG_BY_ID = "select t.tagName,t.luot_them,t.luot_xem from the t where id = ?;";
    public static final String SQL_SELECT_BY_NAME = "select t.tagName,t.luot_them,t.luot_xem from the t where tagName = ?;";

    @Override
    public Tag findById(int id) {
        Tag tag = null;
        try(Connection connection = SingletonConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_TAG_BY_ID)) {
        preparedStatement.setInt(1,id);
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()){
            String tagName = rs.getString("tagName");
            int addTagNumber = rs.getInt("luot_them");
            int viewTagNumber = rs.getInt("luot_xem");
            tag = new Tag(id,tagName,addTagNumber,viewTagNumber);
            return tag;
        }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tag ;
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
        List<Tag> tagList = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(SQL_SELECT_TAG);
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("tagName");
                int addNumber = rs.getInt("luot_them");
                int addView = rs.getInt("luot_xem");
                Tag newTag = new Tag(id,name,addNumber,addView);
                tagList.add(newTag);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tagList;
    }

    @Override
    public List<Tag> findAllByDishId(int dish_id) {
        List<Tag> tags = new ArrayList<>();
        Connection connection = SingletonConnection.getConnection();
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
