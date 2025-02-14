package Bdd;

import java.sql.*;

public class EntrainementBdd {
    public void addEntrainement(String sport, String entraineur, String client) {
        BddManager bddManager = new BddManager();
        Connection connection = bddManager.connection();
        String sql_request = "INSERT INTO entrainement (sport, entraineur, client) VALUES (?, ?, ?)";

        try (PreparedStatement pstmt = connection.prepareStatement(sql_request)) {
            pstmt.setString(1, sport);
            pstmt.setString(2, entraineur);
            pstmt.setString(3,  client);


            pstmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public ResultSet getEntrainement() {
        BddManager bdd = new BddManager();
        Connection connection = bdd.connection();
        String sql_request = "SELECT * FROM entrainement";

        try {
            Statement stmt = connection.createStatement();
            return stmt.executeQuery(sql_request);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
