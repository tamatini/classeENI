package fr.eni.classeni.bll;

import fr.eni.classeni.bo.Personne;
import fr.eni.classeni.dal.DALException;
import fr.eni.classeni.dal.DAOFactory;
import fr.eni.classeni.dal.PersonneDAO;

import java.util.List;

public class PersonneManager {
  PersonneDAO personneDAO;
  public PersonneManager() {
    personneDAO = DAOFactory.getPersonneDAO();
  }

  public Personne getPersonne(int id) throws BLLException {
    Personne personne;
    try {
      personne = personneDAO.selectById(id);
    } catch (DALException e) {
      throw new BLLException("Cette personne n'existe pas");
    }
    return personne;
  }

  public List<Personne> getPersonnes() throws BLLException {
    List<Personne> personnes;
    try {
      personnes = personneDAO.selectAll();
    } catch (DALException e) {
      throw new BLLException("Aucune personne");
    }
    return personnes;
  }

  public void addPersonne(Personne p) throws BLLException {
    try {
      personneDAO.insert(p);
    } catch (DALException e) {
      throw new BLLException("Echec de l'ajout", e);
    }
  }

  public void updatePersonne(Personne p) throws BLLException {
    try {
      personneDAO.update(p);
    } catch (DALException e) {
      throw new BLLException("Echec de la mise à jour", e);
    }
  }

  public void deletePersonne(int id) throws BLLException {
    try {
      personneDAO.delete(id);
    } catch (DALException e) {
      throw new BLLException("Echec de la suppression", e);
    }
  }
}
