package fr.eni.classeni.dal.jdbc;

import fr.eni.classeni.bo.Classe;
import fr.eni.classeni.dal.ClasseDAO;
import fr.eni.classeni.dal.DALException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author TEAHUI Jeffrey
 */
public class ClasseDaoImpl implements ClasseDAO {
  /**
   * Fonction qui insère une nouvelle classe dans la base de données
   * @param classe la classe à passer en paramètre
   */
  @Override
  public void insert(Classe classe) throws DALException {
    int idClasse;
    String request = "INSERT INTO Classes VALUES (?)";
    try (Connection conn = JdbcTools.getConnection(); PreparedStatement ps = conn.prepareStatement(request, Statement.RETURN_GENERATED_KEYS)) {
      ps.setString(1,classe.getNom());
      ps.executeUpdate();
      ResultSet rs = ps.getGeneratedKeys();
      if (rs.next()) {
        idClasse = rs.getInt(1);
        classe.setIdClasse(idClasse);
      }
    } catch (SQLException e) {
      throw new DALException("Une erreur s'est produite", e);
    }
  }

  /**
   * Méthode pour récupérer une classe en utilisant son identifiant
   * @param id l'identifiant de la classe
   * @return la classe
   */
  @Override
  public Classe selectById(int id) throws DALException {
    Classe classe = null;
    String nom;
    int idClasse;
    String request = "SELECT idClasse, nom FROM Classes WHERE idClasse = ?";
    try (Connection conn = JdbcTools.getConnection(); PreparedStatement ps = conn.prepareStatement(request)) {
      ps.setInt(1, id);
      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        idClasse = rs.getInt("idClasse");
        nom = rs.getString("nom");
        classe = new Classe(idClasse, nom);
      }
    } catch (SQLException e) {
      throw new DALException("Cette classe n'existe pas", e);
    }
    return classe;
  }

  /**
   * @return toutes les classes de la base de données
   */
  @Override
  public List<Classe> getAllClasses() throws DALException {
    String nom;
    Classe classe;
    List<Classe> response = new ArrayList<>();
    String request = "SELECT * FROM Classes";
    try (Connection conn = JdbcTools.getConnection(); PreparedStatement ps = conn.prepareStatement(request)) {
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        nom = rs.getString("nom");
        classe = new Classe(nom);
        response.add(classe);
      }
    } catch (SQLException e) {
      throw new DALException("Une erreur s'est produite", e);
    }
    return response;
  }

  /**
   * Function pour supprimer une classe de la base de données
   * @param id l'identifiant de la classe
   */
  @Override
  public void delete(int id) throws DALException {
    String request = "DELETE FROM Classes WHERE idClasse = ?";
    try (Connection conn = JdbcTools.getConnection(); PreparedStatement ps = conn.prepareStatement(request)) {
      ps.setInt(1,id);
      ps.executeUpdate();
    } catch (SQLException e) {
      throw new DALException("Une erreur s'est produit", e);
    }
  }

  /**
   * Fonction pour mettre à jour une classe dans la base de données
   * @param classe la classe à modifier
   */
  @Override
  public void update(Classe classe) throws DALException {
    String request = "UPDATE Classes SET nom = ? WHERE idClasse = ?";
    try (Connection conn = JdbcTools.getConnection(); PreparedStatement ps = conn.prepareStatement(request)) {
      ps.setInt(2,classe.getIdClasse());
      ps.setString(1,classe.getNom());
      ps.executeUpdate();
    } catch (SQLException e) {
      throw new DALException("Une erreur s'est produite", e);
    }
  }

  /**
   * Assigne un élève à une classe déjà existante
   * @param idEleve id de l'élève
   * @param idClasse id de la classe
   * @throws DALException récupère les erreurs sql
   */
  @Override
  public void addEleve(int idEleve, int idClasse) throws DALException {
    String request = "UPDATE Personnes SET idClasse=? WHERE idPersonne = ?";
    try (Connection conn = JdbcTools.getConnection(); PreparedStatement ps = conn.prepareStatement(request)) {
      ps.setInt(2, idEleve);
      ps.setInt(1, idClasse);
      ps.executeUpdate();
    } catch (SQLException e) {
      throw new DALException("Une erreur s'est produite", e);
    }
  }
}
