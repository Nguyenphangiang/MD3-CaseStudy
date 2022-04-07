package DAO;

import java.util.List;

public interface IDAO<T> {
   List<T> findAll();

   T findById(int id);

   T findByName(String name);

   boolean update(T t);

   boolean save (T t);

   boolean delete(int id);

   List<T> findAllByDishId(int id);
}
