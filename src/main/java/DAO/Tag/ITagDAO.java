package DAO.Tag;

import DAO.IDAO;
import model.Tag;

import java.util.List;

public interface ITagDAO extends IDAO<Tag> {
    List<Tag> findAllByDishId(int dish_id);

}
