package DAO.Dish;

import DAO.IDAO;
import model.Dish;

public interface IDishDAO extends IDAO<Dish> {
     void save(Dish dish, int[] tags);

    boolean update(Dish dish, int[] tags);
}
