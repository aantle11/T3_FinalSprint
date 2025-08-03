package Services;

import Classes.User;
import Classes.Member;
import Database.UserData;

public class UserService {
    private UserData userData;

    public UserService(UserData userData) {
        this.userData = userData;
    }

    public boolean registerUser(int id, String name, String password, String role) {
        if (name == null || password == null || name.isEmpty() || password.isEmpty()) {
            System.out.println("Name and password cannot be empty");
                return false;
    }

    if (userData.findUserByUsername(name) != null) {
        System.out.println("Username is already taken");
            return false;
    }

    String email = name.toLowerCase() + "@email.com";

    User newUser = new Member(id, name, email, password, "Standard", true);
    userData.addUser(newUser);
    System.out.println("Registered successfully");
    return true;
}

public User loginUser(String name, String password) {
    User user = userData.findUserByUsername(name);

    if (user != null && user.getPassword().equals(password)) {
        System.out.println("Welcome, " + user.getName() + "!");
        return user;
    }

    System.out.println("invalid username or password");
    return null;
}

 public boolean deleteUser(String name) {
    User user = userData.findUserByUsername(name);
    if (user != null) {
        userData.removeUser(name);
        System.out.println("User deleted");
        return true;
    }

    System.out.println("User not found");
    return false;
 }

 public User getUser(String name) {
    return userData.findUserByUsername(name);
 }
}