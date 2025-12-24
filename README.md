# TP1 : Application Monolithique - Gestion de Cabinet Médical

Ce projet correspond au **TP1** du module "Systèmes Distribués Basés sur les Microservices". Il s'agit de la première phase d'un projet évolutif visant à développer une application de gestion de cabinet médical.

L'objectif de ce TP est de mettre en place une **architecture monolithique** en couches (Clean Architecture) utilisant l'écosystème **Spring Boot**.

## Contexte et Objectifs

Le but est de créer le noyau fonctionnel de l'application regroupant les services métiers essentiels dans un seul artefact déployable (`.jar`).

* **Architecture :** Monolithe modulaire.
* **Structuration :** Couches Controller, Service, Repository, Model (Entities).
* **Technologies :** Spring Boot 3, Spring Data JPA, H2 Database, Spring Web.

## Architecture Technique

Le projet respecte une architecture en couches stricte pour préparer le futur découpage en microservices :

1.  **Web (Controller) :** Expose les endpoints REST (API).
2.  **Service (Métier) :** Encapsule la logique métier et les règles de validation.
3.  **Repository (DAO) :** Gère l'accès aux données via Spring Data JPA.
4.  **Model (Entités) :** Représente les données persistantes (JPA Entities).

## Pré-requis

* Java 17 ou 21
* Maven
* Postman (pour les tests)

## Installation et Démarrage

1.  Cloner le dépôt :
    ```bash
    git clone [https://github.com/Ybl04/cabinet-medical-tp1.git](https://github.com/Ybl04/cabinet-medical-tp1.git)
    ```
2.  Compiler et lancer le projet :
    ```bash
    mvn spring-boot:run
    ```
3.  Accéder à la console H2 (Base de données) :
    * URL : `http://localhost:8080/h2-console`
    * JDBC URL : `jdbc:h2:mem:cabinetMedicalTp1DB`

---

## Documentation de l'API (Endpoints)

Voici la liste des endpoints REST développés dans ce TP.

### 1. Gestion des Médecins (`/api/v1/medecins`)
* **POST** `/` : Créer un nouveau médecin.
    ```json
    { "nom": "Dr. House", "specialite": "Diagnostic", "email": "house@hospital.com" }
    ```
* **GET** `/` : Lister tous les médecins.

### 2. Gestion des Patients (`/api/v1/patients`)
* **POST** `/` : Créer un nouveau patient.
    ```json
    { "nom": "Youssef", "dateNaissance": "1999-01-01", "genre": "Homme", "telephone": "0600000000" }
    ```
* **GET** `/` : Lister tous les patients.

### 3. Gestion des Rendez-Vous (`/api/v1/rendezvous`)
* **POST** `/` : Prendre un rendez-vous (utilise un DTO).
    ```json
    { "dateRdv": "2024-12-30", "patientId": 1, "medecinId": 1 }
    ```
* **GET** `/` : Lister tous les rendez-vous.

### 4. Gestion des Consultations (`/api/v1/consultations`)
* **POST** `/create-from/{rdvId}` : Créer une consultation pour un RDV existant.
    * *Body (Text)* : "Le patient présente une grippe saisonnière."
    * *Note* : Cette action passe automatiquement le statut du RDV à "CONSULTE".

---

## Captures d'écran des Tests

### 1. Création d'un Patient (POST)
![Test Create Patient](screenshots/CreatePatient.PNG)

### 2.  Création d'un Médecin (POST)
![Test Create Medecin](screenshots/CreateMedecin.PNG)

### 3.  Création d'un RendezVous (POST)
![Test Create RndezVous](screenshots/CreateRendezVous.PNG)

### 4.  Création d'une Consultation (POST)
![Test Create Consultation](screenshots/CreateConsultation.PNG)

### 5. Base de données H2
![H2 Console](screenshots/h2_console.PNG)

---

## 👤 Auteur
**Youssef Belfalah**
* Master IPS - Université Mohammed V de Rabat
* Module : Systèmes Distribués Basés sur les Microservices