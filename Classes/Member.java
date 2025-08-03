package Classes;

public class Member extends User {
    private String membershipType;
    private boolean isActive;

    public Member(int id, String name, String email, String password, String membershipType, boolean isActive) {
        super(id, name, email, password, "Member");
        this.membershipType = membershipType;
        this.isActive = isActive;
    }

    public String getMembershipType() {return membershipType;}
    public void setMembershipType(String membershipType) {this.membershipType = membershipType;}

    public boolean isActive() { return isActive;}
    public void setActive(boolean active) {isActive = active;}

    @Override
    public String toString() {
        return super.toString() + " | Membership: " + membershipType + " | Active: " + isActive;
    }
}
