package Bdd;

import java.sql.*;

    public class ClientBdd {

        public void addClient(String firstname, String name, String adresse, String email) {
            BddManager bddManager = new BddManager();
            Connection connection = bddManager.connection();
            String sql_request = "INSERT INTO client (firstname, name, adresse, email) VALUES (?, ?, ?, ?)";

            try (PreparedStatement pstmt = connection.prepareStatement(sql_request)) {
                pstmt.setString(1, firstname);
                pstmt.setString(2, name);
                pstmt.setString(3, adresse);
                pstmt.setString(4, email);
                pstmt.execute();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        public ResultSet getClients() {
            BddManager bdd = new BddManager();
            Connection connection = bdd.connection();
            String sql_request = "SELECT * FROM client";

            try {
                Statement stmt = connection.createStatement();
                return stmt.executeQuery(sql_request);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }


