package WorkingWithAbstraction.StudentSystem;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        StudentSystem studentSystem = new StudentSystem();

        Scanner scanner = new Scanner(System.in);
        String[] data = scanner.nextLine().split("\\s+");


        while (!data[0].equals("Exit")) {
            String command = data[0];

            switch (command) {

                case "Create":
                    studentSystem.create(data);
                    break;

                case "Show":
                    System.out.println(studentSystem.show(data));
                    break;
            }

            data = scanner.nextLine().split("\\s+");
        }

    }
}
