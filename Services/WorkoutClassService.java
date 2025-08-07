package Services;

import Classes.WorkoutClass;
import java.util.ArrayList;
import java.util.List;

public class WorkoutClassService {
    private List<WorkoutClass> classList = new ArrayList<>();
    private int nextId = 1;

    public void addWorkoutClass(WorkoutClass wc) {
        classList.add(wc);
        System.out.println("Workout class added: " + wc.getName());
    }

    public void updateWorkoutClass(int id, String newName, String newSchedule, String newTrainerName) {
        for (WorkoutClass wc : classList) {
            if (wc.getId() == id) {
                System.out.println("Workout class updated: ID " + id);
                return;
            }
        }
        System.out.println("Workout class update failed: ID " + id + " not found.");
    }

    public void deleteWorkoutClass(int id) {
        boolean match = classList.removeIf(wc -> wc.getId() == id);
        if (match) System.out.println("Workout class deleted: ID " + id);
    }

    public List<WorkoutClass> getAllClasses() {
        return classList;
    }
}
