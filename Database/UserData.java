package Database;

import java.util.List;
import java.util.ArrayList;
import Classes.User;

public class UserData {
    private List<User> users = new ArrayList<>();

    public void addUser(User user) {
        users.add(user);
    }

    public User findUserByUsername(String username) {
        for (User user : users) {
            if (user.getName().equals(username)) {
                return user;
            }
        }
        return null;
    }

    public void removeUser(String username) {
        users.removeIf(user -> user.getName().equals(username));
    }
}
