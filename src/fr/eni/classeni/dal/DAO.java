package fr.eni.classeni.dal;

import java.util.List;

public interface DAO<T> {
  void insert(T data) throws DALException;
  T selectById(int data) throws DALException;
  List<T> selectAll() throws DALException;
  void update(T data) throws DALException;
  void delete(int data) throws DALException;
}
