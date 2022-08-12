package PracticingForEXAM_04_04_2020;

import java.util.Scanner;

public class PasswordReset {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String password = scanner.nextLine();

        String input = scanner.nextLine();

        while (!input.equals("Done")) {
            String[] commandsData = input.split(" ");
            String command = commandsData[0];

            switch (command) {
                case "TakeOdd":
                    password = takeOnlyTheOddIndices(password);
                    System.out.println(password);
                    break;
                case "Cut":
                    password = cutAGivenSubstring(password, commandsData);
                    System.out.println(password);
                    break;
                case "Substitute":
                    password = replaceSubstring(password, commandsData);
                    break;

            }


            input = scanner.nextLine();
        }
        System.out.println("Your password is: " + password);

    }

    private static String replaceSubstring(String password, String[] commandsData) {
        String substringToReplace = commandsData[1];
        String substitute = commandsData[2];
        if (!password.contains(substringToReplace)) {
            System.out.println("Nothing to replace!");
            return password;
        }

        String newPassword = password.replaceAll(substringToReplace, substitute);
        System.out.println(newPassword);
        return newPassword;
    }

    private static String cutAGivenSubstring(String password, String[] commandsData) {
        int start = Integer.parseInt(commandsData[1]);
        int length = Integer.parseInt(commandsData[2]);
        StringBuilder sb = new StringBuilder(password);
        sb.delete(start,start+length);
                
        return sb.toString();
    }

    private static String takeOnlyTheOddIndices(String password) {
        char[] arr = password.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            if (i % 2 != 0) {
                sb.append(arr[i]);
            }
        }


        return sb.toString();
    }
}
