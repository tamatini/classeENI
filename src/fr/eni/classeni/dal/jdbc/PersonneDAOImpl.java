package fr.eni.classeni.dal.jdbc;

import fr.eni.classeni.bo.Coach;
import fr.eni.classeni.bo.Eleve;
import fr.eni.classeni.bo.Personne;
import fr.eni.classeni.dal.DALException;
import fr.eni.classeni.dal.DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author TEAHUI Jeffrey
 */
public class PersonneDAOImpl implements DAO<Personne> {
  private String nom, prenom;

  /**
   * Ajoute une nouvelle personne à la base de données
   * @param personne la personne à ajouter
   * @throws DALException récupère les erreurs sql
   */
  @Override
  public void insert(Personne personne) throws DALException {
    String request = "INSERT INTO Personnes VALUES (?, ?, ?)";
    try (Connection conn = JdbcTools.getConnection(); PreparedStatement ps = conn.prepareStatement(request, Statement.RETURN_GENERATED_KEYS)) {
      ps.setString(1, personne.getNom());
      ps.setString(1, personne.getPrenom());
      if (personne instanceof Eleve) {
        ps.setString(3, "élève");
      } else {
        ps.setString(3,"coach");
      }
      ps.executeUpdate();
      ResultSet rs = ps.getGeneratedKeys();
      if (rs.next()) {
        personne.setIdPersonne(rs.getInt(1));
      }
    } catch (SQLException e) {
      throw new DALException("Une erreur s'est produite", e);
    }
  }

  /**
   * Retourne une personne à partir de la base de données en fonction de son id
   * @param id l'identifiant de la personne
   * @return retourne une personne
   * @throws DALException récupère les erreurs sql
   */
  @Override
  public Personne selectById(int id) throws DALException {
    Personne personne = null;
    String request = "SELECT nom, prenom, type FROM Personnes WHERE idPersonne = ?";
    try (Connection conn = JdbcTools.getConnection(); PreparedStatement ps = conn.prepareStatement(request)) {
      ps.setInt(1, id);
      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        nom = rs.getString("nom");
        prenom = rs.getString("prenom");
        if (rs.getString("type").equals("élève".trim())) {
          personne = new Eleve(nom, prenom);
        } else {
          personne = new Coach(nom, prenom);
        }
      }
    } catch (SQLException e) {
      throw new DALException("Une erreur s'est produite", e);
    }
    return personne;
  }

  /**
   * @return la liste de toutes les personnes
   * @throws DALException récupère les erreurs sql
   */
  @Override
  public List<Personne> selectAll() throws DALException {
    List<Personne> personnes = new ArrayList<>();
    Personne personne;
    String request = "SELECT nom, prenom, type FROM Personnes";
    try (Connection conn = JdbcTools.getConnection(); PreparedStatement ps = conn.prepareStatement(request)) {
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        nom = rs.getString("nom");
        prenom = rs.getString("prenom");
        if (rs.getString("type").equals("élève".trim())) {
          personne = new Eleve(nom, prenom);
        } else {
          personne = new Coach(nom, prenom);
        }
        personnes.add(personne);
      }
    } catch (SQLException e) {
      throw new DALException("Une erreur s'est produite", e);
    }
    return personnes;
  }

  /**
   * Met à jour les informations d'une personne
   * @param personne la personne à mettre à jour
   * @throws DALException Récupère les erreurs sql
   */
  @Override
  public void update(Personne personne) throws DALException {
    String request = "UPDATE Personnes SET (nom=?, prenom=?) WHERE idPersonne = ?";
    try (Connection conn = JdbcTools.getConnection(); PreparedStatement ps = conn.prepareStatement(request)) {
      ps.setString(1, personne.getNom());
      ps.setString(2, personne.getPrenom());
      ps.executeUpdate();
    } catch (SQLException e) {
      throw new DALException("Une erreur s'est produite", e);
    }
  }

  /**
   * Supprime une personne de la base de données
   * @param id l'identifiant de la personne
   * @throws DALException récupère les erreurs sql
   */
  @Override
  public void delete(int id) throws DALException {
    String request = "DELETE FROM Personnes WHERE idPersonne = ?";
    try (Connection conn = JdbcTools.getConnection(); PreparedStatement ps = conn.prepareStatement(request)) {
      ps.setInt(1, id);
      ps.executeUpdate();
    } catch (SQLException e) {
      throw new DALException("Une erreur s'est produite", e);
    }
  }
}