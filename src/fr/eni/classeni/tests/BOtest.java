package fr.eni.classeni.tests;

import fr.eni.classeni.bo.Classe;
import fr.eni.classeni.bo.Coach;
import fr.eni.classeni.bo.Eleve;

public class BOtest {
  public static void main(String[] args) {
    // Ajout d'un élève
    System.out.println("***** Ajout d'un élève *****");
    Eleve eleve = new Eleve("TEAHUI", "Tamatini");
    System.out.println(eleve);
    System.out.println("****************************");

    // Ajout de plusieurs élèves à ajouter à une classe
    Eleve e1 = new Eleve("Teahui", "Anuatai");
    Eleve e2 = new Eleve("Omar", "Ovatea");
    Eleve e3 = new Eleve("Van Bastolaer", "Teavaroa");

    // Ajout d'une nouvelle classe
    System.out.println("***** Ajout d'un classe *****");
    Classe classe = new Classe("Lune");

    // Ajout des élèves dans la classe
    classe.ajouterEleve(eleve);
    classe.ajouterEleve(e1);
    classe.ajouterEleve(e2);
    classe.ajouterEleve(e3);
    System.out.println("Les élèves ont été ajouté dans la classe");
    System.out.println(classe);
    System.out.println("******************************");

    // Ajout d'un coach
    System.out.println("****** Ajout d'un coach ******");
    Coach coach = new Coach("Seto","Kaiba" );
    System.out.println(coach);
    System.out.println("******************************");

    System.out.println(classe);

    System.out.println("******************************");
    // Ajout du coach à la classe
    classe.ajouterCoach(coach);
    System.out.println(classe);

    System.out.println("Classe associer au coach");
    System.out.println(coach.getClasse());
  }
}
