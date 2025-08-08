package DAO;

import Classes.WorkoutClass;
import java.util.ArrayList;
import java.util.List;

public class WorkoutClassDAO {
    private List<WorkoutClass> classList = new ArrayList<>();

    public void addWorkoutClass(WorkoutClass wc) {
        classList.add(wc);
    }

    public List<WorkoutClass> getAllWorkoutClasses() {
        return classList;
    }

    public void updateWorkoutClass(int id, String newType, String newDesc, String trainerName) {
        for (WorkoutClass wc : classList) {
            if (wc.getId() == id) {
                wc.setName(newType);
                wc.setSchedule(newDesc);
                wc.setTrainerName(trainerName);
                break;
            }
        }
    }

    public void deleteWorkoutClass(int id) {
        classList.removeIf(wc -> wc.getId() == id);
    }

    public List<WorkoutClass> getClassesByTrainer(String trainerName) {
        List<WorkoutClass> result = new ArrayList<>();
        for (WorkoutClass wc : classList) {
            if (wc.getTrainerName().equals(trainerName)) {
                result.add(wc);
            }
        }
        return result;
    }
}
