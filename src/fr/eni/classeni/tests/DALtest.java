package fr.eni.classeni.tests;

import fr.eni.classeni.bo.Classe;
import fr.eni.classeni.dal.DALException;
import fr.eni.classeni.dal.jdbc.ClasseDaoImpl;

public class DALtest {
  public static void main(String[] args) throws DALException {
    // Ajout d'une nouvelle classe
    System.out.println("Ajout d'une nouvelle classe: ");
    Classe c1 = new Classe("Lune");
    ClasseDaoImpl classeDao = new ClasseDaoImpl();
    classeDao.insert(c1);
    System.out.println("Classe ajouter avec succès.");

    // Test retourne une classe avec son identifiant
    System.out.println("=============================================");
    System.out.println("Sélectionne la classe grace à son identifiant");
    System.out.println("Identifiant de la classe : " + c1.getIdClasse());
    System.out.println(classeDao.selectById(c1.getIdClasse()));
    System.out.println("=============================================");

    // Test retourne toutes les classes insérer
    System.out.println("=============================================");
    System.out.println("Retourne le liste de toutes les classes");
    System.out.println(classeDao.getAllClasses());
    System.out.println("=============================================");

    // Test update classe
    Classe c2 = new Classe("Mars");
    System.out.println("Ajout d'une nouvelle classe");
    classeDao.insert(c2);
    System.out.println(classeDao.selectById(c2.getIdClasse()));
    System.out.println("=============================================");
    System.out.println("Mise à jour du nom de la classe");
    c2.setNom("Nouveau nom");
    classeDao.update(c2);
    System.out.println("Le nom de la classe à été mis à jour");
    System.out.println(classeDao.selectById(c2.getIdClasse()));
    System.out.println("=============================================");

    // Test supprime un élément
    Classe classeEfface = new Classe("Effacer");
    classeDao.insert(classeEfface);
    System.out.println("La classe " + '"' +classeDao.selectById(classeEfface.getIdClasse()).getNom() + '"' + " à été ajouter.");
    System.out.println("Suppression de la classe");
    classeDao.delete(classeEfface.getIdClasse());
    if (classeDao.selectById(classeEfface.getIdClasse()) == null) {
      System.out.println("La classe à été effacer");
    }
    // Fin du test
    System.out.println("Fin");


  }
}