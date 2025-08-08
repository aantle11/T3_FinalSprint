package Services;

import Classes.GymMerch;
import java.util.ArrayList;
import java.util.List;

public class GymMerchService {
    private List<GymMerch> merchList = new ArrayList<>();

    public void addMerch(GymMerch merch) {
        merchList.add(merch);
        System.out.println("New merch added: " + merch.getName());
    }

    public List<GymMerch> getAllMerch() {
        System.out.println("Fetching all merchandise.");
        return merchList;
    }

    public void printStockReport() {
        System.out.println("Printing stock report:");
        for (GymMerch merch : merchList) {
            System.out.println("Name: " + merch.getName()
                    + " | Price: $" + merch.getPrice()
                    + " | Stock: " + merch.getStock());
        }
    }

    public double getTotalMerchValue() {
        double total = 0;
        for (GymMerch merch : merchList) {
            total += merch.getPrice() * merch.getStock();
        }
        System.out.println("Total merch value calculated: $" + total);
        return total;
    }
}
