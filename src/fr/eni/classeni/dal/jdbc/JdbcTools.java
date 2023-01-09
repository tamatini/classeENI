package fr.eni.classeni.dal.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author TEAHUI Jeffrey
 */
public class JdbcTools {
  static Connection conn;
  static {
    try {
      // TO-DO externaliser la configuration
      conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=CLASSES_DB;trustServerCertificate=true;", "sa", "password");
      System.out.println("Connected to database");
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  /**
   * @return la connexion au serveur SQL
   */
  public static Connection getConnection() {
    return conn;
  }
}
