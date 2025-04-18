package Bdd;

import java.sql.*;

public class FactureBdd {
    public void addFacture(String nomclient, String nomentraineur, String service) {
        BddManager bddManager = new BddManager();
        Connection connection = bddManager.connection();
        String sql_request = "INSERT INTO facture (nomclient, nomentraineur, service) VALUES (?, ?, ?)";

        try (PreparedStatement pstmt = connection.prepareStatement(sql_request)) {
            pstmt.setString(1, nomclient);
            pstmt.setString(2, nomentraineur); // Corrigé : nomentraineur en 2ème position
            pstmt.setString(3, service);       // Corrigé : service en 3ème position

            pstmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public ResultSet getFacture() {
        BddManager bdd = new BddManager();
        Connection connection = bdd.connection();
        String sql_request = "SELECT * FROM facture";

        try {
            Statement stmt = connection.createStatement();
            return stmt.executeQuery(sql_request);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
