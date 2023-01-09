package fr.eni.classeni.dal;

import java.sql.SQLException;

public class DALException extends SQLException {
  public DALException() {
    super();
  }

  public DALException(String msg, Throwable error) {
    super(msg, error);
  }
}
