package DAO.cart;

import DAO.IDAO;
import model.Cart;

public interface ICartDAO extends IDAO<Cart> {
    int getDishId(int id);
}
