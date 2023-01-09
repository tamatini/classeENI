package fr.eni.classeni.bo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author TEAHUI Jeffrey
 */
public class Classe {
  List<Eleve> eleves = new ArrayList<>();
  List<Coach> coaches = new ArrayList<>();
  String nom;
  int idClasse;

  /**
   * Constructeur de la classe Classe sans id
   * @param nom le nom de la classe
   */
  public Classe(String nom) {
    this.setNom(nom);
  }

  /**
   * Constructeur de la classe Classe en passant l'id
   * @param idClasse l'id de la classe
   * @param nom le nom de la classe
   */
  public Classe(int idClasse, String nom) {
    this(nom);
    this.setIdClasse(idClasse);
  }

  public List<Coach> getCoaches() {
    return coaches;
  }

  public void setCoaches(List<Coach> coaches) {
    this.coaches = coaches;
  }

  /**
   * @return la liste des élèves associer à la classe
   */
  public List<Eleve> getEleves() {
    return eleves;
  }

  public void setEleves(List<Eleve> eleves) {
    this.eleves = eleves;
  }

  /**
   * @return le nom de la classe
   */
  public String getNom() {
    return nom;
  }

  /**
   * Ajoute le nom de la classe
   * @param nom le nom de la classe
   */
  public void setNom(String nom) {
    this.nom = nom;
  }

  /**
   * @return l'id de la classe
   */
  public int getIdClasse() {
    return idClasse;
  }

  /**
   * Ajoute l'id de la classe
   * @param idClasse l'id de la classe
   */
  public void setIdClasse(int idClasse) {
    this.idClasse = idClasse;
  }

  /**
   * Ajoute un élève à la classe
   * @param eleve l'élève
   */
  public void ajouterEleve(Eleve eleve) {
    this.getEleves().add(eleve);
  }

  public void ajouterCoach(Coach coach) {
    coach.ajouterClasse(this);
    this.getCoaches().add(coach);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("Classe: ").append(this.getNom()).append("\n");
    if (this.getEleves().size() > 0) {
      sb.append("Liste des élèves: ").append("\n");
      for (Eleve eleve : this.getEleves()) {
        sb.append("  ").append(eleve.getNom()).append(" ").append(eleve.getPrenom()).append("\n");
      }
    }
    if (this.getCoaches().size() > 0) {
      sb.append("Liste des coaches: ").append("\n");
      for (Coach coach : this.getCoaches()) {
        sb.append("  ").append(coach.getNom()).append(" ").append(coach.getPrenom()).append("\n");
      }
    }
    return sb.toString();
  }
}
