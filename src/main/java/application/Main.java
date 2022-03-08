package application;

import dao.Dao;
import dao.facotry.DaoFactory;
import entities.ToDo;

public class Main {
  public static void main(String[] args) {

    Dao<ToDo, Integer> dao = DaoFactory.createToDoDao();
    dao.insert(new ToDo(null, "Study Angular"));
    System.out.println("Todo created!");
    dao.deleteById(1);
    System.out.println("Todo deleted!");
  }
}
