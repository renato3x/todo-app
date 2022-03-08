package dao.facotry;

import dao.Dao;
import dao.impl.ToDoDaoImpl;
import entities.ToDo;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DaoFactory {

  private static final EntityManagerFactory factory = Persistence.createEntityManagerFactory("todo_app");

  public static Dao<ToDo, Integer> createToDoDao() {
    return new ToDoDaoImpl(factory);
  }
}
