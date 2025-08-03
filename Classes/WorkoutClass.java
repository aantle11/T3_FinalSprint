package Classes;

public class WorkoutClass {
    private int id;
    private String name;
    private String schedule;
    private String trainerName;

    public WorkoutClass(int id, String name, String schedule, String trainerName) {
        this.id = id;
        this.name = name;
        this.schedule = schedule;
        this.trainerName = trainerName;
    }

    // Getters & Setters
    public int getId() {return id;}
    public String getName() {return name;}
    public String getSchedule() {return schedule;}
    public String getTrainerName() {return trainerName;}

    @Override
    public String toString() {
        return name + " with " + trainerName + " at " + schedule;
    }
}
