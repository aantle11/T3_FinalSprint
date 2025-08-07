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

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSchedule() {
        return schedule;
    }

    public String getTrainerName() {
        return trainerName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public void setTrainerName(String trainerName) {
        this.trainerName = trainerName;
    }
}
