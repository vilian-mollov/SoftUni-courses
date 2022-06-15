package ObjectsAndClasses.exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class N5Students {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Student> listOfStudents = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            input=input.replaceAll(" "," ");
            String[] inputArr = input.split("\\s+");
            Student student = new Student(inputArr[0],inputArr[1],Double.parseDouble(inputArr[2]));
            listOfStudents.add(student);
        }
        listOfStudents.stream().sorted((p1,p2)-> Double.compare(p2.grade,p1.grade))
                .forEach(System.out::println);


    }


    static class Student{
        String firstName;
        String lastName;
        double grade;
        Student(String firstName,String lastName, double grade){
            this.firstName=firstName;
            this.lastName = lastName;
            this.grade = grade;
        }
    @Override
        public String toString(){
            return String.format("%s %s: %.2f",this.firstName,this.lastName,this.grade);
    }

    }
}
