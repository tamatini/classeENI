## Classe ENI

1. [Informations](#informations)
2. [Contraintes](#contraintes)

Exercice personnel sur la programmation d'application en couche, n'inclus pas la partie ihm.

### Informations
L'application est décomposée en utilisant le pattern DAO, dans le cas présent DAL, BLL, BO,
le code est basé sur le tp de l'école avec quelques contraintes supplémentaire.

### Contraintes
- La partie BO s'appuie sur 2 tables de données, ici Classe et Personne.
- Eleve et Coach héritent de Personne
- Un coach peut être assigné à plusieurs classes et les classes peuvent avoir plusieurs élèves
- Il faut pouvoir ajouter un élève à une classe et une classe à un coach

### Notes
L'application est développée en utilisant Microsoft SQL, certaines est requêtes sont donc prévues en Transact SQL