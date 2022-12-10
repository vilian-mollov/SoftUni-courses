package Exam_25_June_2022.workout;

import java.util.ArrayList;
import java.util.List;

public class Workout {

    String type;
    int exerciseCount;
    List<Exercise> exercises;

    public Workout(String type, int exerciseCount) {
        this.type = type;
        this.exerciseCount = exerciseCount;
        exercises = new ArrayList<>();
    }

    public void addExercise(Exercise exercise) {
        if(exercises.size() < exerciseCount){
            exercises.add(exercise);
        }
    }

    public boolean removeExercise(String name, String muscle) {
        Exercise exerciseToRemove = null;
        boolean isFound = false;
        for (Exercise exercise : exercises) {
            if (exercise.getName().equals(name) && exercise.getMuscle().equals(muscle)) {
                exerciseToRemove = exercise;
                isFound = true;
            }
        }
        exercises.remove(exerciseToRemove);

        return isFound;
    }

    public Exercise getExercise(String name, String muscle) {
        Exercise exercise = null;
        for (Exercise e : exercises) {
            if (e.getName().equals(name) && e.getMuscle().equals(muscle)) {
                exercise = e;
            }
        }
        return exercise;
    }

    public Exercise getMostBurnedCaloriesExercise() {
        Exercise exercise = null;
        int caloriesBurned = Integer.MIN_VALUE;
        for (Exercise e : exercises) {
            if (e.getBurnedCalories() > caloriesBurned) {
                caloriesBurned = e.getBurnedCalories();
                exercise = e;
            }
        }
        return exercise;
    }

    public int getExerciseCount() {
        //return exerciseCount;//todo may be wrong
        return exerciseCount;
    }

    public String getStatistics() {
        StringBuilder result = new StringBuilder(String.format("Workout type: %s%n", type));

        for (int i = 0; i < exercises.size(); i++) {
            result.append(String.format("%s%n",exercises.get(i)));
        }

        return result.toString();
    }

}
