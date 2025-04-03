# Projet de Gestion de Clients, Entraîneurs et Entraînements

Ce projet Java permet de gérer des clients, des entraîneurs et des séances d'entraînement à travers une interface JavaFX conviviale. Il intègre une base de données MySQL pour le stockage des informations et utilise iText pour la génération de factures au format PDF.

## Fonctionnalités

- **Gestion des Clients** : Ajouter, modifier et supprimer des clients dans la base de données.
- **Gestion des Entraîneurs** : Ajouter, modifier et supprimer des entraîneurs.
- **Gestion des Séances d'Entraînement** : Planifier et gérer les séances d'entraînement.
- **Facturation** : Générer des factures PDF détaillées associant clients, entraîneurs et séances d'entraînement.
- **Authentification** : Système de connexion sécurisé pour accéder à l'application.

## Structure du Projet
ProjetJavaFootball/ │ ├── .idea/ # Configuration spécifique à l'IDE IntelliJ IDEA ├── .mvn/ # Wrapper Maven pour une utilisation simplifiée │ └── wrapper/ ├── src/ │ └── main/ │ ├── java/ │ │ └── com/ │ │ └── exemple/ │ │ ├── controller/ # Contrôleurs JavaFX pour la gestion de l'interface utilisateur │ │ ├── dao/ # Classes d'accès aux données pour interagir avec la base de données │ │ ├── model/ # Classes représentant les entités du domaine (Client, Entraîneur, Séance) │ │ └── util/ # Classes utilitaires, par exemple pour la génération de PDF │ └── resources/ │ ├── images/ # Ressources images utilisées dans l'application │ ├── fxml/ # Fichiers FXML pour la définition de l'interface utilisateur │ └── styles/ # Feuilles de style CSS pour la personnalisation de l'UI ├── .gitignore # Fichiers et répertoires à ignorer par Git ├── footballtraining.sql # Script SQL pour la création et l'initialisation de la base de données ├── mvnw # Wrapper Maven pour Linux/Mac ├── mvnw.cmd # Wrapper Maven pour Windows ├── pom.xml # Fichier de configuration Maven contenant les dépendances et les plugins └── README.md # Ce fichier


## Dépendances

Le projet utilise Maven pour la gestion des dépendances. Les principales dépendances sont :

- **JavaFX** : Framework pour la création d'interfaces utilisateur riches en Java.
- **MySQL Connector** : Permet la connexion et l'interaction avec la base de données MySQL.
- **iText PDF** : Bibliothèque pour la création et la manipulation de documents PDF.

## Configuration de la Base de Données

Avant de lancer l'application, assurez-vous d'avoir une instance MySQL en cours d'exécution. Utilisez le fichier `footballtraining.sql` pour créer la base de données et les tables nécessaires. Ce script peut être exécuté via un client MySQL ou un outil d'administration comme phpMyAdmin.

## Lancement de l'Application

1. **Clonez le repository** :

   ```bash
   git clone https://github.com/7Sonny/ProjetJavaFootball.git
Naviguez vers le répertoire du projet :
cd ProjetJavaFootball

Compilez et exécutez l'application avec Maven :

Sur Linux/Mac :
./mvnw javafx:run

Sur Windows :
mvnw.cmd javafx:run


Auteur

Développé par Verra Sonny.

Licence

Ce projet est sous licence MIT. Voir le fichier LICENSE pour plus de détails.
