package Bdd;

import java.sql.*;
import Models.Planning;

public class PlanningBdd {

    public void addPlanning(String client, String entraineur, Timestamp dateTime) {
        BddManager bddManager = new BddManager();
        Connection connection = bddManager.connection();

        // Vérifier si le client est déjà occupé à cette date/heure
        String checkClientSql = "SELECT * FROM planning WHERE dateheure = ? AND client = ?";
        try (PreparedStatement psClient = connection.prepareStatement(checkClientSql)) {
            psClient.setTimestamp(1, dateTime);
            psClient.setString(2, client);
            ResultSet rsClient = psClient.executeQuery();
            if (rsClient.next()) {
                // Si le client a déjà un entrainement à ce créneau, on lève une exception
                throw new SQLException("Client déjà occupé à cette date/heure.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Client déjà occupé à cette date/heure.");
        }

        // Vérifier si l'entraîneur est déjà occupé à cette date/heure
        String checkEntraineurSql = "SELECT * FROM planning WHERE dateheure = ? AND entraineur = ?";
        try (PreparedStatement psEntraineur = connection.prepareStatement(checkEntraineurSql)) {
            psEntraineur.setTimestamp(1, dateTime);
            psEntraineur.setString(2, entraineur);
            ResultSet rsEntraineur = psEntraineur.executeQuery();
            if (rsEntraineur.next()) {
                throw new SQLException("Entraîneur déjà occupé à cette date/heure.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Entraîneur déjà occupé à cette date/heure.");
        }

        // Aucune collision détectée, on peut insérer le planning
        String sql_request = "INSERT INTO planning (client, entraineur, dateheure) VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql_request)) {
            pstmt.setString(1, client);
            pstmt.setString(2, entraineur);
            pstmt.setTimestamp(3, dateTime);
            int result = pstmt.executeUpdate();
            System.out.println("Résultat de l'insertion : " + result);
            if (result == 0) {
                System.err.println("Aucune ligne insérée.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erreur lors de l'ajout en base de données : " + e.getMessage());
        }
    }

    public ResultSet getPlanning() {
        BddManager bddManager = new BddManager();
        Connection connection = bddManager.connection();
        String sql_request = "SELECT * FROM planning";
        try {
            Statement stmt = connection.createStatement();
            return stmt.executeQuery(sql_request);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erreur lors de la récupération du planning : " + e.getMessage());
        }
    }
}
