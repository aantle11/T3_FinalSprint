package DAO;

import Classes.User; 
import Classes.Admin; 
import Classes.Trainer; 
import Classes.Member;  
import java.sql.*;      
import java.util.List;   
import java.util.ArrayList; 
import Database.DatabaseConnection;

public class UserDAO {
    private final String url = "jdbc:postgresql://localhost:5432/gymdb";
    private final String user = "keyin";
    private final String password = "Keyin2024";

    public Connection connect() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    public void registerUser(User userObj) {
        String sql = "INSERT INTO users (name, email, password, role, phone_number, address) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, userObj.getName());
            pstmt.setString(2, userObj.getEmail());
            pstmt.setString(3, userObj.getPassword());
            pstmt.setString(4, userObj.getRole());
            pstmt.setString(5, "123-456-7890"); // default placeholder
            pstmt.setString(6, "123 Main St");  // default placeholder
            pstmt.executeUpdate();
            System.out.println("User registered in DB: " + userObj.getEmail());
        } catch (SQLException e) {
            System.out.println("Error registering user: " + e.getMessage());
        }
    }

    public User findByEmail(String email) {
        String sql = "SELECT * FROM users WHERE email = ?";
        try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, email);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String role = rs.getString("role");
                String password = rs.getString("password");

                // Create based on role
                if (role.equals("Admin")) {
                    return new Member(id, name, email, password, role, "");
                } else if (role.equals("Trainer")) {
                    return new Trainer(id, name, email, password, role, "");
                } else {
                    return new Member(id, name, email, password, role, "");
                }
            }
        } catch (SQLException e) {
            System.out.println("Error finding user by email: " + e.getMessage());
        }
        return null;
    }

    public List<User> getAllUsers() {
    List<User> users = new ArrayList<>();
    String sql = "SELECT * FROM users";

    try (Connection conn = DatabaseConnection.getConnection();
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(sql)) {

        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            String email = rs.getString("email");
            String password = rs.getString("password");
            String role = rs.getString("role");
            String phone = rs.getString("phone");

            switch (role) {
                case "Admin" -> users.add(new Admin(id, name, email, password, role, phone));
                case "Trainer" -> users.add(new Trainer(id, name, email, password, role, phone));
                default -> users.add(new Member(id, name, email, password, role, phone));
            }
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return users;
}

}
