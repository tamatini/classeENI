package fr.eni.classeni.bo;

/**
 * @author TEAHUI Jeffrey
 */
abstract public class Personne {
  private int idPersonne;
  private String nom;
  private String prenom;

  /**
   * @return l'id de la personne
   */
  public int getIdPersonne() {
    return idPersonne;
  }

  /**
   * Enregistre l'id de la personne
   * @param idPersonne l'id de la personne
   */
  public void setIdPersonne(int idPersonne) {
    this.idPersonne = idPersonne;
  }

  /**
   * @return le nom de la personne
   */
  public String getNom() {
    return nom;
  }

  /**
   * enregistre le nom de la personne
   * @param nom le nom de la personne
   */
  public void setNom(String nom) {
    this.nom = nom;
  }

  /**
   * @return le prenom de la personne
   */
  public String getPrenom() {
    return prenom;
  }

  /**
   * enregistre le nom de la personne
   * @param prenom le prenom de la personne
   */
  public void setPrenom(String prenom) {
    this.prenom = prenom;
  }

  /**
   * Constructeur de la classe personne sans passer d'id
   * @param nom le nom
   * @param prenom le prénom
   */
  public Personne(String nom, String prenom) {
    this.setNom(nom);
    this.setPrenom(prenom);
  }

  /**
   * Constructeur de la classe personne en passant l'id en paramètre
   * @param idPersonne l'id
   * @param nom le nom
   * @param prenom le prénom
   */
  public Personne(int idPersonne, String nom, String prenom) {
    this(nom, prenom);
    this.setIdPersonne(idPersonne);
  }

  @Override
  public String toString() {
    return "Personne [" + this.getNom() + " " + this.getPrenom() + "]";
  }
}