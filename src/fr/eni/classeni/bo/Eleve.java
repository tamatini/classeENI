package fr.eni.classeni.bo;

/**
 * @author TEAHUI Jeffrey
 */
public class Eleve extends Personne {
  /**
   * Constructeur de la classe élève sans id
   * @param nom le nom de l'élève
   * @param prenom le prénom de l'élève
   */
  public Eleve(String nom, String prenom) {
    super(nom, prenom);
  }

  /**
   * Constructeur de la classe élève en passant l'id
   * @param idPersonne l'identifiant
   * @param nom le nom de l'élève
   * @param prenom le prénom de l'élève
   */
  public Eleve(int idPersonne, String nom, String prenom) {
    super(idPersonne, nom, prenom);
  }

  @Override
  public String toString() {
    return super.toString() + " Elève";
  }
}
