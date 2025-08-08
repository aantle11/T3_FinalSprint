package Services;

import Classes.User;
import Classes.Admin;
import Classes.Trainer;
import DAO.UserDAO;
import Classes.Member;
import java.util.List;
import Utils.HashUtil;

public class UserService {
    private final UserDAO userDAO = new UserDAO();

    public boolean register(String name, String email, String password, String role) {
        if (userDAO.findByEmail(email) != null) {
            System.out.println("Email already registered.");
            return false;
        }

        String hashedPassword = password; 

        User newUser;

    if (role.equalsIgnoreCase("Admin")) {
        newUser = new Admin(0, name, email, hashedPassword, "Admin", "");
    } else if (role.equalsIgnoreCase("Trainer")) {
        newUser = new Trainer(0, name, email, hashedPassword, "Trainer", "");
    } else {
        newUser = new Member(0, name, email, hashedPassword, "Member", "");
    }

        userDAO.registerUser(newUser);
        return true;
    }

    public User login(String email, String password) {
        User user = userDAO.findByEmail(email);
        if (user == null) {
            System.out.println("No account found with that email.");
            return null;
        }

        // Hash input password for comparison
        String hashedInput = HashUtil.hashPassword(password);

        if (user.getPassword().equals(hashedInput)) {
            System.out.println("Login successful. Welcome, " + user.getName() + " (" + user.getRole() + ")");
            return user;
        } else {
            System.out.println("Incorrect password.");
            return null;
        }
    }

public void printAllUsers() {
    List<User> users = userDAO.getAllUsers();
    users.forEach(System.out::println);
}
}
