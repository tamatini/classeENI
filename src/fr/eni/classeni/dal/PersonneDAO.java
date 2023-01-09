package fr.eni.classeni.dal;

import fr.eni.classeni.bo.Personne;

import java.util.List;

public interface PersonneDAO {
  void insert (Personne personne) throws DALException;

  Personne selectById(int id) throws DALException;

  List<Personne> selectAll() throws DALException;

  void update(Personne personne) throws DALException;

  void delete(int id) throws DALException;

}
