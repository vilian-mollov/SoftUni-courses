package AssociativeArraysLambdaAndStreamAPI.exercise;

import java.util.*;

public class N7StudentAcademy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String,List<Double>> studentsGrades = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String studentName = scanner.nextLine();
            double grade = Double.parseDouble(scanner.nextLine());

            List<Double> value = studentsGrades.get(studentName);
            if(value == null){
                studentsGrades.put(studentName,new ArrayList<>());
            }
            studentsGrades.get(studentName).add(grade);
        }

        for (Map.Entry<String,List<Double>> entry : studentsGrades.entrySet()){
            int numberOfGrades = entry.getValue().size();
            double collectGrades = 0.0;
            for (int i = 0; i < numberOfGrades; i++) {
                collectGrades+=entry.getValue().get(i);
            }
            collectGrades/=numberOfGrades;
            if(collectGrades>=4.50){
                System.out.printf("%s -> %.2f%n",entry.getKey(),collectGrades);
            }
        }



    }
}
