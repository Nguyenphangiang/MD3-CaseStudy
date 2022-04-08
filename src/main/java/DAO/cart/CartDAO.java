package DAO.cart;

import DAO.Dish.DishDAO;
import DAO.Dish.IDishDAO;
import config.SingletonConnection;
import model.Cart;
import model.Dish;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CartDAO implements ICartDAO {
    public static final String SQL_INSERT_INTO_CART = "insert into gio_hang (mon_an_id,so_luong) values (?,?);";
    public static final String SQL_SELECT_CART = "select * from gio_hang;";
    private IDishDAO dishDAO = new DishDAO();
    Connection connection = SingletonConnection.getConnection();
    @Override
    public List<Cart> findAll() {
        List<Cart> carts = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_CART);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                int cartId = rs.getInt("id");
                int dishId = rs.getInt("mon_an_id");
                int quantity = rs.getInt("so_luong");
                Dish cartDish = dishDAO.findById(dishId);
                Cart cart = new Cart(cartId,cartDish,quantity);
                carts.add(cart);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return carts;
    }

    @Override
    public Cart findById(int id) {
        Cart newCart = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from gio_hang where id = ?;");
            preparedStatement.setInt(1,id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                 int cartId = rs.getInt("id");
                 int dishId = rs.getInt("mon_an_id");
                 Dish dish = dishDAO.findById(dishId);
                 int quantity = rs.getInt("so_luong");
                 newCart = new Cart(cartId,dish,quantity);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return newCart;
    }

    @Override
    public Cart findByName(String name) {
        return null;
    }

    @Override
    public boolean update(Cart cart) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("update gio_hang set gio_hang.so_luong  = ? where id = ? ;");
            preparedStatement.setInt(1,cart.getQuantity());
            preparedStatement.setInt(2,cart.getId());
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean save(Cart cart) {
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT_INTO_CART);
            preparedStatement.setInt(1,cart.getDish().getId());
            preparedStatement.setInt(2,cart.getQuantity());
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }



    @Override
    public boolean delete(int id) {
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("delete from gio_hang where id=?;");
            preparedStatement.setInt(1,id);
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Cart> findAllByDishId(int id) {
        return null;
    }
    @Override
    public int getDishId(int id) {
        int dishId = 0;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select gio_hang.mon_an_id from gio_hang ;");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                dishId = rs.getInt("mon_an_id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
