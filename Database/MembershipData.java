package Database;

import java.util.List;
import java.util.ArrayList;
import Classes.Membership;

public class MembershipData {
    private List<Membership> memberships = new ArrayList<>();

    public void addMembership(Membership m) {
        memberships.add(m);
    }

    public Membership getMembershipById(int id) {
        for (Membership m : memberships) {
            if (m.getId() == (id)) {
                return m;
            }
        }
        return null;
    }

    public List<Membership> getAllMemberships() {
        return memberships;
    }

    public void removeMembership(int id) {
        memberships.removeIf(m -> m.getId() == (id));
    }
}
