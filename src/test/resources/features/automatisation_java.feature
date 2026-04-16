# language: fr
Feature: Automatisation du projet Java avec JetBrains AI

  En tant que développeur, je veux automatiser les étapes clés
  de mon projet Java Spring Boot via des prompts IA.

  Scenario: Generer la structure complete du projet Maven
    Given je demarre le projet avec Java et Maven
    When je genere la structure complete avec les dossiers src main et src test
    And j inclus un fichier pom xml avec les dependances JUnit 5 et Lombok
    Then une classe Main exemple est creee

  Scenario: Creer la configuration Docker Compose et le script SQL
    Given je dois configurer la base de donnees PostgreSQL
    When je cree un fichier Docker Compose pour PostgreSQL
    And je genere le script SQL schema sql pour initialiser la table Utilisateurs
    Then la table Utilisateurs contient des donnees de test

  Scenario: Ecrire le service Java CRUD pour les utilisateurs
    Given j ai besoin d un service Java pour gerer les utilisateurs
    When j ecris un service Java avec les methodes CRUD
    And j ajoute la validation des emails par Regex
    And j ajoute la gestion des exceptions personnalisees
    Then le service Java est operationnel

  Scenario: Creer le Mapper MapStruct entre User et UserDTO
    Given j ai une entite User et un UserDTO
    When je cree un Mapper automatique entre User et UserDTO en utilisant MapStruct
    Then la conversion de donnees entre User et UserDTO fonctionne

  Scenario: Generer un test d integration Spring Boot avec MockMvc
    Given j ai un UserController Spring Boot
    When je genere un test d integration pour l endpoint POST users avec MockMvc
    Then le code de retour est 201

  Scenario: Generer le fichier YAML GitHub Actions pour le CI CD
    Given je veux automatiser le deploiement a chaque modification
    When je genere un fichier YAML pour GitHub Actions
    And je compile le projet avec Java 21
    And je lance tous les tests JUnit
    And je verifie la qualite du code avec SonarCloud
    Then je cree un artefact JAR si les tests passent

  Scenario: Analyser et refactoriser un fichier pour le nettoyage
    Given j ai un fichier Java a analyser
    When j analyse ce fichier pour identifier les repetitions de code DRY
    And je suggere des optimisations de performance
    And je verifie que les conventions de nommage Java sont respectees
    Then je propose une version refactorisee
