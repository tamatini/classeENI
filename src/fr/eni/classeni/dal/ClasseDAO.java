package fr.eni.classeni.dal;

import fr.eni.classeni.bo.Classe;
import fr.eni.classeni.bo.Eleve;

import java.util.List;
public interface ClasseDAO {

  void insert(Classe classe) throws DALException;

  Classe selectById(int id) throws DALException;

  List<Classe> getAllClasses() throws DALException;

  void delete(int id) throws DALException;

  void update(Classe classe) throws DALException;

  void addEleve(int idEleve, int idClasse) throws DALException;
}
