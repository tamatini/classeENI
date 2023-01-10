package fr.eni.classeni.dal;

import fr.eni.classeni.bo.Classe;

public interface ClasseDAO extends DAO<Classe> {
  public void ajouterEleve(int idEleve, int idClasse) throws DALException;
}
