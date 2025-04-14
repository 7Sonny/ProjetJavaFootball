# Projet de Gestion de Clients, Entraîneurs et Entraînements

Ce projet Java permet de gérer des clients, des entraîneurs et des séances d'entraînement à travers une interface JavaFX conviviale. Il intègre une base de données MySQL pour le stockage des informations et utilise iText pour la génération de factures au format PDF.

## Fonctionnalités

- **Gestion des Clients** : Ajouter, modifier et supprimer des clients dans la base de données.
- **Gestion des Entraîneurs** : Ajouter, modifier et supprimer des entraîneurs.
- **Gestion des Séances d'Entraînement** : Planifier et gérer les séances d'entraînement.
- **Facturation** : Générer des factures PDF détaillées associant clients, entraîneurs et séances d'entraînement.
- **Authentification** : Système de connexion sécurisé pour accéder à l'application.

## Structure du Projet
```
recepter/
├── .idea/                   # Fichiers de configuration IntelliJ IDEA
├── src/
│   └── main/
│       ├── java/
│       │   ├── bdd/         # Gestion des bases de données
│       │   │   ├── BddManager
│       │   │   ├── ClientManager
│       │   │   ├── FactureManager
│       │   │   └── ServiceManager
│       │   ├── com.example.recepter/  # Package principal
│       │   │   ├── Recepter
│       │   │   └── RecepterController
│       │   ├── Models/      # Modèles pour les entités métier
│       │   │   ├── Client
│       │   │   └── Service
│       │   ├── tools/       # Outils divers
│       │   │   └── Generator
│       │   └── module-info.java # Fichier de module Java
│       └── resources/       # Fichiers de ressources (FXML, configurations)
├── mvnw                     # Script Unix pour Maven Wrapper
├── mvnw.cmd                 # Script Windows pour Maven Wrapper
├── pom.xml                  # Fichier de configuration Maven
├── README.md                # Documentation du projet
├── recepter.sql             # Script SQL pour la base de données
└── External Libraries/       # Bibliothèques externes utilisées
```


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
