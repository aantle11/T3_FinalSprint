package Services;

import Classes.*;
import DAO.UserDAO;
import Utils.HashUtil;

import java.util.List;

public class UserService {
    private final UserDAO userDAO = new UserDAO();

    public boolean register(String name, String email, String password, String role) {
        try {
            if (name == null || email == null || password == null) {
                System.out.println("Name, email and password are required.");
                return false;
            }

            String normalizedEmail = email.trim().toLowerCase();
            String normalizedRole = (role == null) ? "Member" : role.trim();
            if (normalizedRole.equalsIgnoreCase("administrator")) normalizedRole = "Admin";
            else if (normalizedRole.equalsIgnoreCase("trainer")) normalizedRole = "Trainer";
            else if (normalizedRole.equalsIgnoreCase("admin")) normalizedRole = "Admin";
            else normalizedRole = "Member";

            if (userDAO.findByEmail(normalizedEmail) != null) {
                System.out.println("Email already registered.");
                return false;
            }

            // Hash the password once at registration
            String hashed = HashUtil.sha256(password);

            // Constructors must match your concrete classes:
            // Admin(int id, String name, String email, String password, String address, String phoneNumber)
            // Trainer(int id, String name, String email, String password, String address, String phoneNumber)
            // Abstract User requires role, address, phone in its 7-arg ctor; use anonymous subclass for Member if you don't have a Member class
            User newUser;
            if ("Admin".equals(normalizedRole)) {
                newUser = new Admin(0, name, normalizedEmail, hashed, "", "");
            } else if ("Trainer".equals(normalizedRole)) {
                newUser = new Trainer(0, name, normalizedEmail, hashed, "", "");
            } else {
                // No concrete Member class shown, so use an anonymous subclass of User with role = "Member"
                newUser = new User(0, name, normalizedEmail, hashed, "Member", "", "") {};
            }

            userDAO.registerUser(newUser);
            System.out.println("User registered in DB: " + normalizedEmail);
            return true;

        } catch (Exception e) {
            System.out.println("Error registering user: " + e.getMessage());
            return false;
        }
    }

    public User login(String email, String password) {
        try {
            if (email == null || password == null) {
                System.out.println("Email and password are required.");
                return null;
            }

            String normalizedEmail = email.trim().toLowerCase();
            User user = userDAO.findByEmail(normalizedEmail);
            if (user == null) {
                System.out.println("No account found with that email.");
                return null;
            }

            String hashedInput = HashUtil.sha256(password);
            if (hashedInput.equals(user.getPassword())) {
                System.out.println("Login successful. Welcome, " + user.getName() + " (" + user.getRole() + ")");
                return user;
            } else {
                System.out.println("Incorrect password.");
                return null;
            }
        } catch (Exception e) {
            System.out.println("Error during login: " + e.getMessage());
            return null;
        }
    }

    // Only used if your menus call it
    public void printAllUsers() {
        try {
            List<User> users = userDAO.getAllUsers();
            for (User u : users) {
                System.out.println(u.getId() + " | " + u.getName() + " | " + u.getEmail() + " | " + u.getRole());
            }
        } catch (Exception e) {
            System.out.println("Error listing users: " + e.getMessage());
        }
    }
}
