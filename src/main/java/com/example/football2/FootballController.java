package com.example.football2;

import Bdd.ClientBdd;
import Bdd.EntrainementBdd;
import Bdd.EntraineurBdd;
import Bdd.FactureBdd;
import Models.Client;
import Models.Entrainement;
import Models.Entraineur;
import Models.Factures;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfPCell;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.security.Provider;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import javax.swing.*;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

public class FootballController {
    @FXML
    private TextField Sporttype;

    @FXML
    private Button addEntrainement;

    @FXML
    private TextArea adresse;

    @FXML
    private TextArea adresseEntraineur;

    @FXML
    private ChoiceBox<Client> clientChoice;

    @FXML
    private ListView<Client> clientList;

    @FXML
    private ChoiceBox<Client> clientRetake;

    @FXML
    private TextField email;

    @FXML
    private TextField emailEntraineur;

    @FXML
    private ChoiceBox<Entraineur> entraineursretake;

    @FXML
    private TextField firstname;

    @FXML
    private ListView<Entrainement> EntrainementList;

    @FXML
    private TextField name;

    @FXML
    private TextField nomEntraineur;

    @FXML
    private Label num_facture;

    @FXML
    private TextField prenomEntraineur;

    @FXML
    private ChoiceBox<String> serviceChoice;

    @FXML
    private ListView<Entraineur> EntraineurList;

    @FXML
    private ListView<Factures> Entrainementajouter;

    @FXML
    private ListView<?> serviceListOnFacture;

    @FXML
    private ChoiceBox<Entraineur> entraineurChoice;

    @FXML
    private ObservableList<Entrainement> items = FXCollections.observableArrayList();
    private ObservableList<Client> items2 = FXCollections.observableArrayList();
    private ObservableList<Entraineur> itemsEntraineur = FXCollections.observableArrayList();
    private ObservableList<Factures> itemsFactures = FXCollections.observableArrayList();
    private ObservableList<String> ServiceItems = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        //lier items à la listeView au démarrage
        clientList.setItems(items2);
        EntraineurList.setItems(itemsEntraineur);
        EntrainementList.setItems(items);
        Entrainementajouter.setItems(itemsFactures);


        //charger les services initiaux (optionnel)

        loadClients();
        loadEntraineur();
        loadService();
        loadFacture();

        //load_info_entreprise();
    }

    @FXML
    private void add_client(ActionEvent event) {
        String firstname = this.firstname.getText();
        String name = this.name.getText();
        String adresse = this.adresse.getText();
        String email = this.email.getText();


        if (firstname.isEmpty() || name.isEmpty() || adresse.isEmpty() || email.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Veuillez remplir tous les champs avec des informations valides", "Erreur de saisie", JOptionPane.ERROR_MESSAGE);
        } else if (!email.matches("^(.+)@(.+)$")) {
            JOptionPane.showMessageDialog(null, "Veuillez entrer une adresse email valide", "Erreur d'email", JOptionPane.ERROR_MESSAGE);
        } else {
            ClientBdd cm = new ClientBdd();
            cm.addClient(firstname, name, adresse, email);
            this.loadClients();
        }


    }



    private void loadClients() {
        this.items2.clear();

        try {
            ClientBdd cm = new ClientBdd();
            ResultSet rs = cm.getClients();


            while (rs.next()) {
                int id = rs.getInt("id");
                String firstname = rs.getString("firstname");
                String name = rs.getString("name");
                String adresse = rs.getString("adresse");
                String email = rs.getString("email");

                Client client = new Client(id, firstname, name, adresse, email);
                this.items2.add(client);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void add_entraineur(ActionEvent actionEvent) {
        String nomEntraineur = this.nomEntraineur.getText();
        String prenomEntraineur = this.prenomEntraineur.getText();
        String adresseEntraineur = this.adresseEntraineur.getText();
        String emailEntraineur = this.emailEntraineur.getText();

        if (nomEntraineur.isEmpty() || prenomEntraineur.isEmpty() || adresseEntraineur.isEmpty() || emailEntraineur.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Veuillez remplir tous les champs avec des informations valides", "Erreur de saisie", JOptionPane.ERROR_MESSAGE);
        } else if (!emailEntraineur.matches("^(.+)@(.+)$")) {
            JOptionPane.showMessageDialog(null, "Veuillez entrer une adresse email valide", "Erreur d'email", JOptionPane.ERROR_MESSAGE);
        } else {
            EntraineurBdd eb = new EntraineurBdd();
            eb.addEntraineur(nomEntraineur, prenomEntraineur, adresseEntraineur, emailEntraineur);
            this.loadEntraineur();
        }


    }

    private void loadEntraineur() {
        // this.itemsEntraineur.clear(); // Essayez de commenter cette ligne pour voir si ça fonctionne

        try {
            EntraineurBdd eb = new EntraineurBdd();
            ResultSet rs = eb.getEntraineur();

            while (rs.next()) {
                int id = rs.getInt("id");
                String nomEntraineur = rs.getString("name");
                String prenomEntraineur = rs.getString("firstname");
                String adresseEntraineur = rs.getString("adresse");
                String emailEntraineur = rs.getString("email");

                Entraineur entraineur = new Entraineur(id, nomEntraineur, prenomEntraineur, adresseEntraineur, emailEntraineur);
                this.itemsEntraineur.add(entraineur);
            }

            // Rafraîchir la ListView si nécessaire
            EntraineurList.setItems(null);
            EntraineurList.setItems(itemsEntraineur);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void tabFactureChanged(Event e) {

        this.entraineursretake.setItems(this.itemsEntraineur);
        this.clientRetake.setItems(this.items2);
        this.clientChoice.setItems(this.items2);
        this.entraineurChoice.setItems(this.itemsEntraineur);

        loadEntraineur();
        loadClients();
    }

    public void loadService() {
        ServiceItems.clear();
        ServiceItems.addAll("Cardio", "Entrainement", "Match");
        serviceChoice.setItems(ServiceItems);
    }

    public void add_entrainement(ActionEvent actionEvent) {
        String sport = this.Sporttype.getText();
        String entraineurs = this.entraineursretake.getItems().toString();
        String clients = this.clientRetake.getItems().toString();
        EntrainementBdd eb = new EntrainementBdd();
        eb.addEntrainement(sport, entraineurs, clients);
        this.loadEntrainement();
    }

    public void loadEntrainement() {
        try {
            EntraineurBdd eb = new EntraineurBdd();
            ResultSet rs = eb.getEntraineur();

            while (rs.next()) {
                int id = rs.getInt("id");
                String sport = rs.getString("sport");
                String entraineurs = rs.getString("entraineur");
                String clients = rs.getString("clients");

                Entrainement entrainement = new Entrainement(id, sport, entraineurs, clients);
                this.items.add(entrainement);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public void generatePDF(ActionEvent actionEvent) {
        // 📌 Récupérer l'élément sélectionné dans la liste
        Factures selectedFacture = Entrainementajouter.getSelectionModel().getSelectedItem();

        if (selectedFacture == null) {
            JOptionPane.showMessageDialog(null, "Aucune facture sélectionnée !", "Erreur", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Document document = new Document();

        try {
            // 📂 Définir un chemin de fichier temporaire pour éviter des problèmes de répertoires complexes
            String filePath = System.getProperty("user.dir") + "/Facture_" + selectedFacture.getId() + ".pdf";
            System.out.println("Chemin du fichier PDF : " + filePath);  // Journal de débogage

            PdfWriter.getInstance(document, new FileOutputStream(filePath));

            // ✨ Ouvrir le document PDF
            document.open();

            // 🏆 Ajouter un titre stylisé
            Font titleFont = new Font(Font.FontFamily.HELVETICA, 22, Font.BOLD, BaseColor.BLUE);
            Paragraph title = new Paragraph("FACTURE", titleFont);
            title.setAlignment(Element.ALIGN_CENTER);
            document.add(title);
            document.add(new Paragraph("\n"));

            // 🎨 Ajouter un cadre pour la facture
            PdfPTable table = new PdfPTable(2);
            table.setWidthPercentage(100);
            table.setSpacingBefore(10f);
            table.setSpacingAfter(10f);

            // 🏷️ Définition du style des cellules
            Font cellFont = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD);

            PdfPCell cell1 = new PdfPCell(new Phrase("Détails de la facture", cellFont));
            cell1.setColspan(2);
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell1.setBackgroundColor(BaseColor.LIGHT_GRAY);
            table.addCell(cell1);

            table.addCell("Nom du Client :");
            table.addCell(selectedFacture.getNomclient());

            table.addCell("Nom de l'Entraîneur :");
            table.addCell(selectedFacture.getNomentraineur());

            table.addCell("Service :");
            table.addCell(selectedFacture.getService());

            table.addCell("Prix :");
            table.addCell("25 €");

            document.add(table);

            // ✍️ Ajouter la signature
            Font signatureFont = new Font(Font.FontFamily.HELVETICA, 14, Font.ITALIC, BaseColor.DARK_GRAY);
            Paragraph signature = new Paragraph("\nTraining Entreprise", signatureFont);
            signature.setAlignment(Element.ALIGN_RIGHT);
            document.add(signature);

            // 📄 Fermer le document
            document.close();
            System.out.println("✅ PDF généré avec succès : " + filePath);

            // 🎉 Notification de succès
            JOptionPane.showMessageDialog(null, "PDF généré avec succès : " + filePath, "Succès", JOptionPane.INFORMATION_MESSAGE);

            // 🚀 **Ne pas ouvrir le fichier pour l'instant** - Testons sans ouvrir automatiquement le PDF
            // openPdfFile(filePath);  // Décommentez si vous voulez tester l'ouverture manuelle

        } catch (Exception e) {
            // Gestion des erreurs
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erreur lors de la génération du PDF : " + e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Fonction pour ouvrir automatiquement le PDF (à tester uniquement après avoir vérifié que le PDF est généré correctement)
    private void openPdfFile(String filePath) {
        File pdfFile = new File(filePath);
        if (pdfFile.exists()) {
            try {
                if (Desktop.isDesktopSupported()) {
                    Desktop.getDesktop().open(pdfFile);
                } else {
                    System.out.println("⚠️ Impossible d'ouvrir automatiquement le fichier !");
                }
            } catch (IOException ex) {
                System.out.println("⚠️ Erreur lors de l'ouverture du fichier PDF : " + ex.getMessage());
                ex.printStackTrace();
            }
        } else {
            System.out.println("⚠️ Le fichier PDF n'existe pas à l'emplacement spécifié : " + filePath);
        }
    }






    public void addEntrainementOnFacture(ActionEvent actionEvent) {
        String nomclient = String.valueOf(clientChoice.getValue());
        String nomentraineur = serviceChoice.getValue();
        String service = String.valueOf(entraineurChoice.getValue());

        FactureBdd fb = new FactureBdd();
        fb.addFacture(nomclient, nomentraineur, service);
        loadFacture();



    }

    public void loadFacture(){
        itemsFactures.clear();

        try {
            FactureBdd fb = new FactureBdd();
            ResultSet rs = fb.getFacture();

            while (rs.next()) {
                int id = rs.getInt("id");
                String nomclient = rs.getString("nomclient");
                String nomentraineur = rs.getString("nomentraineur");
                String service = rs.getString("service");

                Factures facture = new Factures(nomclient, nomentraineur, service);
                this.itemsFactures.add(facture);

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }



}


