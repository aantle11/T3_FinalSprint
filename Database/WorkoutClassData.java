package Database;

import java.util.List;
import java.util.ArrayList;
import Classes.WorkoutClass;

public class WorkoutClassData {
    private List<WorkoutClass> classList = new ArrayList<>();

    public void addWorkoutClass(WorkoutClass wc) {
        classList.add(wc);
    }

    public WorkoutClass getWorkoutClassById(int id) {
        for (WorkoutClass wc : classList) {
            if (wc.getId() == id) {
                return wc;
            }
        }
        return null;
    }

    public List<WorkoutClass> getAllWorkoutClasses() {
        return classList;
    }

    public void removeWorkoutClass(int id) {
        classList.removeIf(wc -> wc.getId() == id);
    }
}
