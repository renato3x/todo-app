package dao.impl;

import dao.Dao;
import entities.ToDo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public class ToDoDaoImpl implements Dao<ToDo, Integer> {

  private EntityManagerFactory factory;

  public ToDoDaoImpl(EntityManagerFactory factory) {
    this.factory = factory;
  }

  @Override
  public void insert(ToDo object) {
    EntityManager manager = entityManager();

    try {
      manager.getTransaction().begin();
      manager.persist(object);
      manager.getTransaction().commit();
    } catch (Exception error) {
      throw new RuntimeException("ToDo not saved");
    } finally {
      manager.close();
    }
  }

  @Override
  public void deleteById(Integer integer) {

  }

  @Override
  public List<ToDo> all() {
    return null;
  }

  private EntityManager entityManager() {
    return factory.createEntityManager();
  }
}
