package fr.eni.classeni.dal.jdbc;

import fr.eni.classeni.dal.Settings;

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
      Class.forName(Settings.getProperties("driver"));
    } catch (ClassNotFoundException e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * @return la connexion au serveur SQL
   */
  public static Connection getConnection() throws SQLException {
    String uri, port, dbName, username, password;
    // Import des paramètres
      uri = Settings.getProperties("uri");
      port = Settings.getProperties("port");
      dbName = Settings.getProperties("dbName");
      username = Settings.getProperties("username");
      password = Settings.getProperties("password");
      conn = DriverManager.getConnection(
              uri + ":" + port + ";databaseName=" + dbName + ";trustServerCertificate=true;",
              username,
              password
      );
      System.out.println("Connected to database");
    return conn;
  }
}
