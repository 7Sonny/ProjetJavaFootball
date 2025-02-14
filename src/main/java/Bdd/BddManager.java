package Bdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BddManager {


        public Connection connection(){
            try {
                return DriverManager.getConnection("jdbc:mysql://localhost/footballtraining", "root", "");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    }


