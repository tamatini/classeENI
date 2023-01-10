package fr.eni.classeni.bll;

import fr.eni.classeni.bo.Classe;
import fr.eni.classeni.dal.ClasseDAO;
import fr.eni.classeni.dal.DALException;
import fr.eni.classeni.dal.DAO;
import fr.eni.classeni.dal.DAOFactory;

import java.util.List;

public class ClasseManager {
  ClasseDAO DAO;
  public ClasseManager() {
    DAO = (ClasseDAO)DAOFactory.getClasseDAO();
  }

  public List<Classe> getClasses() throws BLLException {
    List<Classe> classes;
    try {
      classes = DAO.selectAll();
    } catch (DALException e) {
      throw new BLLException("Aucune classe");
    }
    return classes;
  }

  public void addClasse(Classe c) throws BLLException {
    try {
      DAO.insert(c);
    } catch (DALException e) {
      throw new BLLException("Echec de l'ajout", e);
    }
  }

  public void updateClasse(Classe c) throws BLLException {
    try {
      DAO.update(c);
    } catch (DALException e) {
      throw new BLLException("Echec de la mise à jour", e);
    }
  }

  public Classe getClasse(int id) throws BLLException {
    Classe classe;
    try {
      classe = DAO.selectById(id);
    } catch (DALException e) {
      throw new BLLException("Cette classe n'existe pas", e);
    }
    return classe;
  }

  public void deleteClasse(int id) throws BLLException {
    try {
      DAO.delete(id);
    } catch (DALException e) {
      throw new BLLException("Echec de la suppression", e);
    }
  }
  
  public void addEleve(int idEleve, int idClasse) throws BLLException {
    try {
      DAO.ajouterEleve(idEleve, idClasse);
    } catch (DALException e) {
      throw new BLLException("Echec de l'ajout", e);
    }
  }
}
