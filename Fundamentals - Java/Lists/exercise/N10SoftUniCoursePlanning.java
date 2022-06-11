package List.exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class N10SoftUniCoursePlanning {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputInitialLessons = scanner.nextLine();
        List<String> coursePlan = Arrays.stream(inputInitialLessons.split(", "))
                .collect(Collectors.toList());

        String commands = scanner.nextLine();

        while (!commands.equals("course start")) {
            String[] commandsSplit = commands.split(":");
            String command = commandsSplit[0];
            String lessonTitle = commandsSplit[1];

            switch (command) {
                case "Add":
                    if (!coursePlan.contains(lessonTitle)) {
                        coursePlan.add(lessonTitle);
                    }
                    break;
                case "Insert":
                    int indexToAdd =Integer.parseInt(commandsSplit[2]);
                    if (!coursePlan.contains(lessonTitle)) {
                        coursePlan.add(indexToAdd, lessonTitle);
                    }
                    break;
                case "Remove":
                    coursePlan.remove(lessonTitle);
                    coursePlan.remove(lessonTitle+"-Exercise");

                    break;
                case "Swap":
                    String secondLesson = commandsSplit[2];
                    switchCourses(lessonTitle,secondLesson,coursePlan);
                    break;

                case "Exercise":
                    String exercise = lessonTitle+"-Exercise";
                    addExerciseAndOrLesson(lessonTitle,exercise,coursePlan);
                    break;
            }


            commands = scanner.nextLine();
        }

        for (int i = 0; i < coursePlan.size(); i++) {
            System.out.printf("%d.%s%n", i + 1, coursePlan.get(i));
        }

    }
    public static void switchCourses(String lessonTitle,String secondLesson,List<String> coursePlan){
        String firstExercise = lessonTitle + "-Exercise";
        String secondExercise = secondLesson + "-Exercise";

        if (coursePlan.contains(lessonTitle) && coursePlan.contains(secondLesson)) {
            int indexOfFirstLessonToSwitch = coursePlan.indexOf(lessonTitle);
            int indexOfSecondLessonToSwitch = coursePlan.indexOf(secondLesson);
            coursePlan.add(indexOfSecondLessonToSwitch, lessonTitle);
            coursePlan.remove(secondLesson);
            coursePlan.remove(lessonTitle);
            coursePlan.add(indexOfFirstLessonToSwitch, secondLesson);
        }

        if (coursePlan.contains(firstExercise)) {
            coursePlan.remove(firstExercise);
            coursePlan.add(coursePlan.indexOf(lessonTitle) + 1, firstExercise);

        }


        if (coursePlan.contains(secondExercise)) {
            coursePlan.remove(secondExercise);
            coursePlan.add(coursePlan.indexOf(secondLesson) + 1, secondExercise);

        }
    }

    public static void addExerciseAndOrLesson(String lessonTitle, String exercise, List<String> coursePlan){
        if (coursePlan.contains(lessonTitle) && !coursePlan.contains(exercise)) {
            int indexOfLesson = coursePlan.indexOf(lessonTitle);
            coursePlan.add(indexOfLesson + 1, exercise);

        } else if (!coursePlan.contains(lessonTitle)) {
            coursePlan.add(lessonTitle);
            coursePlan.add(lessonTitle + "-Exercise");
        }
    }
}
