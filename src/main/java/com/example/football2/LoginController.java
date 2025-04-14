package com.example.football2;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Label errorLabel;

    // Identifiants test (à remplacer par une base de données plus tard)
    private final String USERNAME = "admin";
    private final String PASSWORD = "Administrateur1234!";

    @FXML
    private void handleLogin(ActionEvent event) {
        String username = usernameField.getText();
        String password = passwordField.getText();

        if (username.equals(USERNAME) && password.equals(PASSWORD)) {
            // Connexion réussie, on charge la nouvelle scène
            errorLabel.setText("Connexion réussie !");
            errorLabel.setStyle("-fx-text-fill: green;");
            loadDashboard();
        } else {
            errorLabel.setText("Identifiants incorrects !");
            errorLabel.setStyle("-fx-text-fill: red;");
        }
    }

    private void loadDashboard() {
        try {
            // Charger le fichier FXML du dashboard
            FXMLLoader loader = new FXMLLoader(getClass().getResource("footballview2.fxml"));
            Parent root = loader.load();

            // Obtenir la scène actuelle et la modifier
            Stage stage = (Stage) usernameField.getScene().getWindow();
            stage.setScene(new Scene(root, 900, 600)); // Ajuster la taille
            stage.setTitle("logiciel entrainement");
        } catch (IOException e) {
            e.printStackTrace();
            errorLabel.setText("Erreur de chargement !");
        }
    }
}