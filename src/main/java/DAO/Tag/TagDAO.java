package DAO.Tag;

import DAO.Restaurant.RestaurantDAO;
import model.DiscountCode;
import model.Tag;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static config.SingletonConnection.getConnection;

public class TagDAO implements ITagDAO{
    @Override
    public List<Tag> findAll() {
        return null;
    }


    @Override
    public Tag findById(int id) {
        Tag tag  = null;
        try(
                Connection connection = getConnection();
                PreparedStatement pstm = connection.prepareStatement(
                        "select * from the where id = ?"
                )
        ) {
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()){
                String tagName = rs.getString("tagName");
                tag = new Tag(id, tagName);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tag;
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
}
