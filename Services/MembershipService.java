package Services;

import Classes.Membership;
import java.util.ArrayList;
import java.util.List;

public class MembershipService {
    private List<Membership> memberships = new ArrayList<>();

    public void createMembership(Membership m) {
        memberships.add(m);
        System.out.println("Membership created.");
    }

    public List<Membership> getAllMemberships() {
        return memberships;
    }

    public double calculateTotalRevenue() {
        System.out.println("NOTE: This sample doesn't track cost, so revenue = count of memberships.");
        return memberships.size();
    }
}
