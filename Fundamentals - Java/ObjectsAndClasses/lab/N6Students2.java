package ObjectsAndClasses.lab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class N6Students2 {
    static class Student {
        String firstName;
        String lastName;
        int age;
        String homeTown;

        void setAll(String firstName, String lastName, int age, String homeTown) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
            this.homeTown = homeTown;
        }

        String getFirstName() {
            return this.firstName;
        }

        String getLastName() {
            return this.lastName;
        }

        String getInfo() {
            return String.format("%s %s is %d years old", this.firstName, this.lastName, this.age);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputOfStudents = scanner.nextLine();
        List<Student> students = new ArrayList<>();
        boolean isNewStudent = true;
        int positionOfTheSameStudent = -1;
        while (!inputOfStudents.equals("end")) {
            String[] studentInitialData = inputOfStudents.split("\\s+");
            String firstName = studentInitialData[0];
            String lastName = studentInitialData[1];
            int age = Integer.parseInt(studentInitialData[2]);
            String homeTown = studentInitialData[3];
            for (int i = 0; i < students.size(); i++) {
                if (students.get(i).getFirstName().equals(firstName) && students.get(i).getLastName().equals(lastName)) {
                    isNewStudent=false;
                    positionOfTheSameStudent=i;
                }

            }

            if (isNewStudent) {
                students.add(new Student());
                students.get(students.size() - 1).setAll(firstName, lastName, age, homeTown);
            } else {
                students.get(positionOfTheSameStudent).setAll(firstName, lastName, age, homeTown);
            }

            inputOfStudents = scanner.nextLine();
            isNewStudent=true;
        }
        String homeTownToChooseStudentFrom = scanner.nextLine();
        for (Student student : students) {
            if (student.homeTown.equals(homeTownToChooseStudentFrom)) {
                System.out.println(student.getInfo());
            }
        }

    }
}
