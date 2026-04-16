# language: fr
Feature: Connexion utilisateur

  En tant qu'utilisateur, je veux pouvoir me connecter à l'application
  afin d'accéder à mes fonctionnalités personnelles.

  Scenario: Connexion réussie
    Given je suis sur la page de connexion
    When je saisis mon nom d'utilisateur "testuser"
    And je saisis mon mot de passe "password123"
    And je clique sur le bouton "Se connecter"
    Then je suis redirigé vers la page d'accueil
    And je vois le message "Bienvenue testuser"
