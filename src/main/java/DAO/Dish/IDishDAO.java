package DAO.Dish;

import DAO.IDAO;
import model.Dish;

public interface IDishDAO extends IDAO<Dish> {
    public void save(Dish dish, int[] categories);
}
