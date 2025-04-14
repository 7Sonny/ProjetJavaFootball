package com.example.football2;

import Bdd.ClientBdd;
import Bdd.EntrainementBdd;
import Bdd.EntraineurBdd;
import Bdd.FactureBdd;
import Bdd.PlanningBdd;
import Models.Client;
import Models.Entrainement;
import Models.Entraineur;
import Models.Factures;
import Models.Planning;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

import javax.swing.JOptionPane;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class FootballController {

    // FXML - Onglet Clients, Entraineur, Entrainement, Factures
    @FXML private TextField Sporttype;
    @FXML private Button addEntrainement;
    @FXML private TextArea adresse;
    @FXML private TextArea adresseEntraineur;
    @FXML private ChoiceBox<Client> clientChoice;
    @FXML private ListView<Client> clientList;
    @FXML private ChoiceBox<Client> clientRetake;
    @FXML private TextField email;
    @FXML private TextField emailEntraineur;
    @FXML private ChoiceBox<Entraineur> entraineursretake;
    @FXML private TextField firstname;
    @FXML private ListView<Entrainement> EntrainementList;
    @FXML private TextField name;
    @FXML private TextField nomEntraineur;
    @FXML private Label num_facture;
    @FXML private TextField prenomEntraineur;
    @FXML private ChoiceBox<String> serviceChoice;
    @FXML private ListView<Entraineur> EntraineurList;
    @FXML private ListView<Factures> Entrainementajouter;
    @FXML private ListView<?> serviceListOnFacture;
    @FXML private ChoiceBox<Entraineur> entraineurChoice;

    // FXML - Nouvel onglet Planning
    @FXML private ListView<Planning> planningList;
    @FXML private ChoiceBox<Client> planningClientChoice;
    @FXML private ChoiceBox<Entraineur> planningEntraineurChoice;
    @FXML private DatePicker planningDate;
    @FXML private TextField planningTime; // format "HH:mm"

    // ObservableLists pour stocker les données
    @FXML private ObservableList<Entrainement> items = FXCollections.observableArrayList();
    private ObservableList<Client> items2 = FXCollections.observableArrayList();
    private ObservableList<Entraineur> itemsEntraineur = FXCollections.observableArrayList();
    private ObservableList<Factures> itemsFactures = FXCollections.observableArrayList();
    private ObservableList<String> ServiceItems = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        // Liaison des ListView existantes
        clientList.setItems(items2);
        EntraineurList.setItems(itemsEntraineur);
        EntrainementList.setItems(items);
        Entrainementajouter.setItems(itemsFactures);

        // Chargement des données clients, entraineurs, services et factures
        loadClients();
        loadEntraineur();
        loadService();
        loadFacture();

        // Pour le planning, on utilise les mêmes listes que pour les clients et entraineurs
        planningClientChoice.setItems(items2);
        planningEntraineurChoice.setItems(itemsEntraineur);

        // Chargement des plannings existants
        loadPlanning();
    }

    @FXML
    private void add_client(ActionEvent event) {
        String firstnameVal = this.firstname.getText();
        String nameVal = this.name.getText();
        String adresseVal = this.adresse.getText();
        String emailVal = this.email.getText();

        if (firstnameVal.isEmpty() || nameVal.isEmpty() || adresseVal.isEmpty() || emailVal.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Veuillez remplir tous les champs avec des informations valides", "Erreur de saisie", JOptionPane.ERROR_MESSAGE);
        } else if (!emailVal.matches("^(.+)@(.+)$")) {
            JOptionPane.showMessageDialog(null, "Veuillez entrer une adresse email valide", "Erreur d'email", JOptionPane.ERROR_MESSAGE);
        } else {
            ClientBdd cm = new ClientBdd();
            cm.addClient(firstnameVal, nameVal, adresseVal, emailVal);
            loadClients();
        }
    }

    private void loadClients() {
        items2.clear();
        try {
            ClientBdd cm = new ClientBdd();
            ResultSet rs = cm.getClients();
            while (rs.next()) {
                int id = rs.getInt("id");
                String firstnameVal = rs.getString("firstname");
                String nameVal = rs.getString("name");
                String adresseVal = rs.getString("adresse");
                String emailVal = rs.getString("email");

                Client client = new Client(id, firstnameVal, nameVal, adresseVal, emailVal);
                items2.add(client);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void add_entraineur(ActionEvent actionEvent) {
        String nomEntraineurVal = this.nomEntraineur.getText();
        String prenomEntraineurVal = this.prenomEntraineur.getText();
        String adresseEntraineurVal = this.adresseEntraineur.getText();
        String emailEntraineurVal = this.emailEntraineur.getText();

        if (nomEntraineurVal.isEmpty() || prenomEntraineurVal.isEmpty() || adresseEntraineurVal.isEmpty() || emailEntraineurVal.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Veuillez remplir tous les champs avec des informations valides", "Erreur de saisie", JOptionPane.ERROR_MESSAGE);
        } else if (!emailEntraineurVal.matches("^(.+)@(.+)$")) {
            JOptionPane.showMessageDialog(null, "Veuillez entrer une adresse email valide", "Erreur d'email", JOptionPane.ERROR_MESSAGE);
        } else {
            EntraineurBdd eb = new EntraineurBdd();
            eb.addEntraineur(nomEntraineurVal, prenomEntraineurVal, adresseEntraineurVal, emailEntraineurVal);
            loadEntraineur();
        }
    }

    private void loadEntraineur() {
        // Optionnel : itemsEntraineur.clear();
        try {
            EntraineurBdd eb = new EntraineurBdd();
            ResultSet rs = eb.getEntraineur();
            while (rs.next()) {
                int id = rs.getInt("id");
                String nomEntraineurVal = rs.getString("name");
                String prenomEntraineurVal = rs.getString("firstname");
                String adresseEntraineurVal = rs.getString("adresse");
                String emailEntraineurVal = rs.getString("email");

                Entraineur entraineur = new Entraineur(id, nomEntraineurVal, prenomEntraineurVal, adresseEntraineurVal, emailEntraineurVal);
                itemsEntraineur.add(entraineur);
            }
            EntraineurList.setItems(null);
            EntraineurList.setItems(itemsEntraineur);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void tabFactureChanged(Event e) {
        entraineursretake.setItems(itemsEntraineur);
        clientRetake.setItems(items2);
        clientChoice.setItems(items2);
        entraineurChoice.setItems(itemsEntraineur);
        loadEntraineur();
        loadClients();
    }

    public void loadService() {
        ServiceItems.clear();
        ServiceItems.addAll("Cardio", "Entrainement", "Match");
        serviceChoice.setItems(ServiceItems);
    }

    public void add_entrainement(ActionEvent actionEvent) {
        String sportVal = Sporttype.getText();
        String entraineursVal = entraineursretake.getItems().toString();
        String clientsVal = clientRetake.getItems().toString();
        EntrainementBdd eb = new EntrainementBdd();
        eb.addEntrainement(sportVal, entraineursVal, clientsVal);
        loadEntrainement();
    }

    public void loadEntrainement() {
        try {
            EntraineurBdd eb = new EntraineurBdd();
            ResultSet rs = eb.getEntraineur();
            while (rs.next()) {
                int id = rs.getInt("id");
                String sportVal = rs.getString("sport");
                String entraineursVal = rs.getString("entraineur");
                String clientsVal = rs.getString("clients");
                Entrainement entrainement = new Entrainement(id, sportVal, entraineursVal, clientsVal);
                items.add(entrainement);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void generatePDF(ActionEvent actionEvent) {
        // Récupération de la facture sélectionnée
        Factures selectedFacture = Entrainementajouter.getSelectionModel().getSelectedItem();
        if (selectedFacture == null) {
            System.out.println("Aucune facture sélectionnée !");
            return;
        }

        Document document = new Document();
        try {
            // Définir un chemin de fichier simple
            String filePath = System.getProperty("user.dir") + "/Facture_" + selectedFacture.getId() + ".pdf";
            System.out.println("Chemin du fichier PDF : " + filePath);

            PdfWriter.getInstance(document, new FileOutputStream(filePath));
            document.open();

            // Titre stylisé
            Font titleFont = new Font(Font.FontFamily.HELVETICA, 24, Font.BOLD, BaseColor.BLUE);
            Paragraph title = new Paragraph("FACTURE", titleFont);
            title.setAlignment(Element.ALIGN_CENTER);
            document.add(title);
            document.add(new Paragraph(" ")); // Ligne vide pour espacer

            // Création d'un tableau à deux colonnes pour afficher les données
            PdfPTable table = new PdfPTable(2);
            table.setWidthPercentage(100);
            table.setSpacingBefore(10f);
            table.setSpacingAfter(10f);

            // Entête du tableau
            Font headerFont = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD, BaseColor.WHITE);
            PdfPCell headerCell = new PdfPCell(new Phrase("Détails de la Facture", headerFont));
            headerCell.setColspan(2);
            headerCell.setHorizontalAlignment(Element.ALIGN_CENTER);
            headerCell.setBackgroundColor(BaseColor.DARK_GRAY);
            headerCell.setPadding(10f);
            table.addCell(headerCell);

            // Définition des polices pour les libellés et les valeurs
            Font labelFont = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD);
            Font valueFont = new Font(Font.FontFamily.HELVETICA, 12, Font.NORMAL);

            // Récupération sécurisée des données
            String nomClient = (selectedFacture.getNomclient() != null) ? selectedFacture.getNomclient() : "";
            String nomEntraineur = (selectedFacture.getNomentraineur() != null) ? selectedFacture.getNomentraineur() : "";
            String service = (selectedFacture.getService() != null) ? selectedFacture.getService() : "";

            // Ligne 1 : Nom du Client
            PdfPCell cellLabel = new PdfPCell(new Phrase("Nom du Client :", labelFont));
            cellLabel.setBackgroundColor(BaseColor.LIGHT_GRAY);
            cellLabel.setPadding(5f);
            table.addCell(cellLabel);
            PdfPCell cellValue = new PdfPCell(new Phrase(nomClient, valueFont));
            cellValue.setPadding(5f);
            table.addCell(cellValue);

            // Ligne 2 : Nom de l'Entraîneur (affiché avec la valeur stockée dans le champ service)
            cellLabel = new PdfPCell(new Phrase("Nom de l'Entraîneur :", labelFont));
            cellLabel.setBackgroundColor(BaseColor.LIGHT_GRAY);
            cellLabel.setPadding(5f);
            table.addCell(cellLabel);
            cellValue = new PdfPCell(new Phrase(service, valueFont));
            cellValue.setPadding(5f);
            table.addCell(cellValue);

            // Ligne 3 : Service (affiché avec la valeur stockée dans le champ nomEntraîneur)
            cellLabel = new PdfPCell(new Phrase("Service :", labelFont));
            cellLabel.setBackgroundColor(BaseColor.LIGHT_GRAY);
            cellLabel.setPadding(5f);
            table.addCell(cellLabel);
            cellValue = new PdfPCell(new Phrase(nomEntraineur, valueFont));
            cellValue.setPadding(5f);
            table.addCell(cellValue);

            // Ligne 4 : Prix
            cellLabel = new PdfPCell(new Phrase("Prix :", labelFont));
            cellLabel.setBackgroundColor(BaseColor.LIGHT_GRAY);
            cellLabel.setPadding(5f);
            table.addCell(cellLabel);
            cellValue = new PdfPCell(new Phrase("25 €", valueFont));
            cellValue.setPadding(5f);
            table.addCell(cellValue);

            document.add(table);
            document.close();

            System.out.println("PDF généré avec succès : " + filePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }










    private void openPdfFile(String filePath) {
        File pdfFile = new File(filePath);
        if (pdfFile.exists()) {
            try {
                if (Desktop.isDesktopSupported()) {
                    Desktop.getDesktop().open(pdfFile);
                } else {
                    System.out.println("Impossible d'ouvrir automatiquement le fichier !");
                }
            } catch (IOException ex) {
                System.out.println("Erreur lors de l'ouverture du fichier PDF : " + ex.getMessage());
                ex.printStackTrace();
            }
        } else {
            System.out.println("Le fichier PDF n'existe pas à l'emplacement spécifié : " + filePath);
        }
    }

    public void addEntrainementOnFacture(ActionEvent actionEvent) {
        String nomclient = String.valueOf(clientChoice.getValue());
        String nomentraineur = String.valueOf(entraineurChoice.getValue());
        String service = String.valueOf(serviceChoice.getValue());
        FactureBdd fb = new FactureBdd();
        System.out.println("nom entraineur :"+ nomentraineur);
        System.out.println("nom client "+ nomclient);
        System.out.println("service:" + service);
        fb.addFacture(nomclient, nomentraineur, service);
        loadFacture();
    }

    public void loadFacture() {
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
                itemsFactures.add(facture);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // Méthode pour ajouter une entrée dans le planning
    public void addPlanning(ActionEvent event) {
        Client selectedClient = planningClientChoice.getValue();
        Entraineur selectedEntraineur = planningEntraineurChoice.getValue();
        if (selectedClient == null || selectedEntraineur == null || planningDate.getValue() == null || planningTime.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText(null);
            alert.setContentText("Veuillez remplir tous les champs du planning.");
            alert.showAndWait();
            return;
        }
        try {
            LocalDate date = planningDate.getValue();
            LocalTime time = LocalTime.parse(planningTime.getText()); // format "HH:mm"
            LocalDateTime dateTime = LocalDateTime.of(date, time);
            Timestamp timestamp = Timestamp.valueOf(dateTime);
            System.out.println("Ajout planning : client = " + selectedClient +
                    ", entraineur = " + selectedEntraineur +
                    ", dateheure = " + timestamp);
            PlanningBdd planningBdd = new PlanningBdd();
            planningBdd.addPlanning(selectedClient.toString(), selectedEntraineur.toString(), timestamp);
            loadPlanning();
        } catch (RuntimeException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Alerte");
            alert.setHeaderText("Conflit de planning");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }



    // Méthode pour charger le planning
    public void loadPlanning() {
        ObservableList<Planning> planningItems = FXCollections.observableArrayList();
        PlanningBdd planningBdd = new PlanningBdd();
        try {
            ResultSet rs = planningBdd.getPlanning();
            while (rs.next()) {
                int id = rs.getInt("id_time");
                String client = rs.getString("client");
                String entraineur = rs.getString("entraineur");
                Timestamp datetime = rs.getTimestamp("dateheure");
                Planning planning = new Planning(id, client, entraineur, datetime);
                planningItems.add(planning);
            }
            System.out.println("Nombre d'entrées planning récupérées : " + planningItems.size());
            planningList.setItems(planningItems);
            planningList.refresh();
        } catch (SQLException e) {
            System.err.println("Erreur lors du chargement du planning : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
