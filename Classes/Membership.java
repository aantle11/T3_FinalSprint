package Classes;

public class Membership {
    private int id;
    private int memberId;
    private String type;
    private String startDate;
    private String endDate;

    public Membership(int id, int memberId, String type, String startDate, String endDate) {
       this.id = id;
       this.memberId = memberId;
       this.type = type;
       this.startDate = startDate;
       this.endDate = endDate; 
    } 

    // Setters & Getters
    public int getId() {return id;}
    public int getMemberid() {return memberId;}
    public String getType() {return type;}
    public String getStartDate() {return startDate;}
    public String getEndDate() {return endDate;}

    @Override
    public String toString() {
        return "Membership (" + type + ") from " + startDate + " to " + endDate;
    }
}
