package dao;

import java.util.List;

public interface Dao<T, ID> {

  void insert(T object);

  void deleteById(ID id);

  List<T> all();
}
