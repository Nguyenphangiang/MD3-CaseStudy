package DAO.Dish;

import DAO.IDAO;
import model.Dish;

import java.util.List;

public interface IDishDAO extends IDAO<Dish> {
     void save(Dish dish, int[] tags);

    boolean update(Dish dish, int[] tags);

    List<Dish> getListDishByPage(List<Dish> dishes, int start, int end);
}
