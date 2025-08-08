package Classes;

public class Trainer extends User {
    public Trainer(int id, String name, String email, String password, String address, String phoneNumber) {
        super(id, name, email, password, "Trainer", address, phoneNumber);
    }
}
