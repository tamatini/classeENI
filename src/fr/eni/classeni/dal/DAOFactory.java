package fr.eni.classeni.dal;

import fr.eni.classeni.bo.Classe;
import fr.eni.classeni.bo.Personne;
import fr.eni.classeni.dal.jdbc.ClasseDaoImpl;
import fr.eni.classeni.dal.jdbc.PersonneDAOImpl;

public class DAOFactory {
  public static  DAO<Classe> getClasseDAO() {
    return new ClasseDaoImpl();
  }

  public static DAO<Personne> getPersonneDAO() {
    return new PersonneDAOImpl();
  }
}
