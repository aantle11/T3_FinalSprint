package Services;

import DAO.WorkoutClassDAO;
import Classes.WorkoutClass;
import java.util.List;
import java.util.ArrayList;

public class WorkoutClassService {
    private final WorkoutClassDAO workoutClassDAO = new WorkoutClassDAO();

    public void addWorkoutClass(WorkoutClass wc) {
        workoutClassDAO.addWorkoutClass(wc);
    }

    public List<WorkoutClass> getAllWorkoutClasses() {
        return workoutClassDAO.getAllWorkoutClasses();
    }

    public void updateWorkoutClass(int id, String newType, String newDesc, String trainerName) {
        workoutClassDAO.updateWorkoutClass(id, newType, newDesc, trainerName);
    }

    public void deleteWorkoutClass(int id) {
        workoutClassDAO.deleteWorkoutClass(id);
    }

    public List<WorkoutClass> getClassesByTrainer(String trainerName) {
        return workoutClassDAO.getClassesByTrainer(trainerName);
    }
}
