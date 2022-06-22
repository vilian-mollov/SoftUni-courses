package AssociativeArraysLambdaAndStreamAPI.exercise;

import java.util.*;

public class N6Courses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String,List<String>> courses = new LinkedHashMap<>();
        String input = scanner.nextLine();
        while(!input.equals("end")){
            String[] inputData = input.split(" : ");
            String course = inputData[0];
            String studentName = inputData[1];
            List<String> value = courses.get(course);
            if(value==null){
                courses.put(course,new ArrayList<>());
                courses.get(course).add(studentName);
            }else{
                courses.get(course).add(studentName);
            }


            input = scanner.nextLine();
        }
        for (Map.Entry<String, List<String>> entry : courses.entrySet()) {
            System.out.println(entry.getKey()+": "+courses.get(entry.getKey()).size());
            for (int i = 0; i < entry.getValue().size(); i++) {
                System.out.println("-- "+entry.getValue().get(i));
            }
        }



    }
}
