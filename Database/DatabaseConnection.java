package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:postgresql://localhost:5432/gym_management";
    private static final String USER = "keyin";
    private static final String PASSWORD = "";

    public static Connection getConnection() throws SQLException {
        try { Class.forName("org.postgresql.Driver"); } catch (ClassNotFoundException ignored) {}
        // DEBUG: one-time print so we can verify which DB we’re hitting
        System.out.println("[DB] Connecting to: " + URL + " as " + USER);
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
