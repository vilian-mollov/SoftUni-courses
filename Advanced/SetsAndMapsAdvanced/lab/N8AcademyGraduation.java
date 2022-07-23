package SetsAndMapsAdvanced.lab;

import java.util.*;

public class N8AcademyGraduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String, List<Double>> studentsMap = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            String name = scanner.nextLine();
            String[] grades = scanner.nextLine().split("\\s+");
            studentsMap.putIfAbsent(name,new ArrayList<>());
            for (int j = 0; j < grades.length; j++) {
                studentsMap.get(name).add(Double.parseDouble(grades[j]));
            }
        }

        for (Map.Entry<String, List<Double>> entry : studentsMap.entrySet()) {
            double avgScore = 0.0;
            for (int i = 0; i < entry.getValue().size(); i++) {
                avgScore+=entry.getValue().get(i);
            }
            System.out.println(entry.getKey()+" is graduated with "+ avgScore/entry.getValue().size());
        }

    }
}
