package Database;

import java.util.List;
import java.util.ArrayList;
import Classes.GymMerch;

public class GymMerchData {
    private List<GymMerch> merchList = new ArrayList<>();

    public void addMerch(GymMerch merch) {
        merchList.add(merch);
    }

    public GymMerch getMerchById(int id) {
        for (GymMerch merch : merchList) {
            if (merch.getId() == id) {
                return merch;
            }
        }
        return null;
    }

    public List<GymMerch> getAllMerch() {
        return merchList;
    }

    public void removeMerch(int id) {
        merchList.removeIf(merch -> merch.getId() == id);
    }
}
