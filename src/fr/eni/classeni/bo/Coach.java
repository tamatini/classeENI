package fr.eni.classeni.bo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author TEAHUI Jeffrey
 */
public class Coach extends Personne {
  private List<Classe> classes = new ArrayList<>();


  /**
   * Constructeur de la classe coach sans id
   * @param nom le nom du coach
   * @param prenom le prénom du coach
   */
  public Coach(String nom, String prenom) {
    super(nom, prenom);
  }

  public void ajouterClasse(Classe classe) {
    this.getClasse().add(classe);
  }

  public List<Classe> getClasse() {
    return classes;
  }

  /**
   * Constructeur de la classe coach avec id
   * @param idPersonne l'identifiant
   * @param nom le nom du coach
   * @param prenom le prénom du coach
   */
  public Coach(int idPersonne, String nom, String prenom) {
    super(idPersonne, nom, prenom);
  }

  @Override
  public String toString() {
    return super.toString() + " Coach";
  }
}
