package dao.impl;

import dao.Dao;
import entities.ToDo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

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
  public void deleteById(Integer id) {
    EntityManager manager = entityManager();

    try {
      ToDo todo = manager.find(ToDo.class, id);

      if (todo != null) {
        manager.getTransaction().begin();
        manager.remove(todo);
        manager.getTransaction().commit();
      }
    } catch (Exception error) {
      manager.getTransaction().rollback();
      throw new RuntimeException("Cannot delete ToDo");
    } finally {
      manager.close();
    }
  }

  @Override
  public List<ToDo> all() {
    EntityManager manager = entityManager();

    return manager.createQuery("FROM todos", ToDo.class).getResultList();
  }

  private EntityManager entityManager() {
    return factory.createEntityManager();
  }
}
