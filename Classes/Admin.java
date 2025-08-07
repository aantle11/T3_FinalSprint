package Classes;

public class Admin extends User {
    public Admin(int id, String name, String email, String password, String address, String phoneNumber) {
        super(id, name, email, password, "Admin", address, phoneNumber);
    }
}
