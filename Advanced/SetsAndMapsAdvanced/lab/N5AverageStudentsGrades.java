package SetsAndMapsAdvanced.lab;

import java.util.*;

public class N5AverageStudentsGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, List<Double>> studentsMap = new TreeMap<>();
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] dataForStudent = scanner.nextLine().split("\\s+");
            String student = dataForStudent[0];
            double grade = Double.parseDouble(dataForStudent[1]);
            studentsMap.putIfAbsent(student,new ArrayList<>());
            studentsMap.get(student).add(grade);
        }

        for (var entry : studentsMap.entrySet()) {
            double sum = 0.0;
            System.out.print(entry.getKey()+" -> ");
            for (Double aDouble : entry.getValue()) {
                System.out.printf("%.2f ",aDouble);
                sum += aDouble;
            }
            System.out.printf("(avg: %.2f)",sum/entry.getValue().size());
            System.out.println();
        }

    }
}