package ExamTraining.random;

import java.util.Scanner;

public class ActivationKeys {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        //StringBuilder sb = new StringBuilder(input);

        String inputCommands = scanner.nextLine();
        while (!inputCommands.equals("Generate")) {
            String[] commands = inputCommands.split(">>>");
            String command = commands[0];
            switch (command) {
                case "Contains":
                    printIfContainsSubstring(input, commands);
                    break;
                case "Flip":
                    input = upperOrLowerCaseSubstring(input, commands);
                    System.out.println(input);
                    break;
                case "Slice":
                    input = deleteFromRawActivationKey(input, commands);
                    System.out.println(input);
                    break;
            }


            inputCommands = scanner.nextLine();
        }
        System.out.println("Your activation key is: " + input);
    }

    private static String deleteFromRawActivationKey(String input, String[] commands) {
        int start = Integer.parseInt(commands[1]);
        int end = Integer.parseInt(commands[2]);
        StringBuilder sb = new StringBuilder();
        sb.append(input);
        sb.delete(start, end);
        input = sb.toString();
        return input;
    }

    private static String upperOrLowerCaseSubstring(String input, String[] commands) {
        int start = Integer.parseInt(commands[2]);
        int end = Integer.parseInt(commands[3]);
        if (commands[1].equals("Lower")) {
            input = input.replace(input.substring(start, end), input.substring(start, end).toLowerCase());
        } else {
            input = input.replace(input.substring(start, end), input.substring(start, end).toUpperCase());
        }
        return input;
    }

    private static void printIfContainsSubstring(String input, String[] commands) {
        if (input.contains(commands[1])) {
            System.out.println(input + " contains " + commands[1]);
        } else {
            System.out.println("Substring not found!");
        }
    }
}
