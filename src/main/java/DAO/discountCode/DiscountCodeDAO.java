package DAO.discountCode;

import model.DiscountCode;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static config.SingletonConnection.getConnection;

public class DiscountCodeDAO implements IDiscountCodeDAO {
    @Override
    public List<DiscountCode> findAll() {
        return null;
    }



    @Override
    public DiscountCode findById(int id) {
        DiscountCode discountCodeFind  = null;
        try(
                Connection connection = getConnection();
                PreparedStatement pstm = connection.prepareStatement(
                        "select * from ma_khuyen_mai where id = ?"
                )
                ) {
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()){
                String discountCode = rs.getString("khuyen_mai_code");
                int discountPrice = rs.getInt("gia_khuyen_mai");
                discountCodeFind = new DiscountCode(id, discountCode, discountPrice);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return discountCodeFind;
    }

    @Override
    public DiscountCode findByName(String name) {
        return null;
    }

    @Override
    public boolean update(DiscountCode discountCode) {
        return false;
    }

    @Override
    public boolean save(DiscountCode discountCode) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }
}
