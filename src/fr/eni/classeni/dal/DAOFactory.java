package fr.eni.classeni.dal;

import fr.eni.classeni.dal.jdbc.ClasseDaoImpl;
import fr.eni.classeni.dal.jdbc.PersonneDAOImpl;

public class DAOFactory {
  public static ClasseDAO getClasseDAO() {
    return new ClasseDaoImpl();
  }

  public static PersonneDAO getPersonneDAO() {
    return new PersonneDAOImpl();
  }
}
