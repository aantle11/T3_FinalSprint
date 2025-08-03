package Classes;

public class GymMerch {
    private int id;
    private String name;
    private double price;
    private int stock;

    public GymMerch(int id, String name, double price, int stock) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    // Getters & Setters
    public int getId() {return id;}
    public String getName() {return name;}
    public double getPrice() {return price;}
    public int getStock() {return stock;}

    public void setStock(int stock) { this.stock = stock;}

    @Override
    public String toString() {
        return name + " ($" + price + ") - Stock: " + stock;
    }
}
