package ExamTraining.Final_09_08_2020;

import java.util.Scanner;

public class WorldTour {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String stops = scanner.nextLine();

        String input = scanner.nextLine();
        while (!input.equals("Travel")) {
            String[] commandsData = input.split("\\:");
            String command = commandsData[0];

            switch (command) {
                case "Add Stop":
                    stops = addingASubstringInStops(stops, commandsData);
                    System.out.println(stops);
                    break;
                case "Remove Stop":
                    stops = removingASubstring(stops, commandsData);
                    System.out.println(stops);
                    break;
                case "Switch":
                    stops = switchingOldWithNewStrings(stops, commandsData);
                    System.out.println(stops);
                    break;
            }

            input = scanner.nextLine();
        }
        System.out.println("Ready for world tour! Planned stops: " + stops);
    }

    private static String switchingOldWithNewStrings(String stops, String[] commandsData) {
        String oldString = commandsData[1];
        String newString = commandsData[2];
        stops = stops.replaceAll(oldString, newString);

        return stops;
    }

    private static String removingASubstring(String stops, String[] commandsData) {
        int startIndex = Integer.parseInt(commandsData[1]);
        int endIndex = Integer.parseInt(commandsData[2]);

        if (startIndex >= 0 && startIndex < stops.length() && endIndex >= 0 && endIndex < stops.length()) {
            String firstHalf = stops.substring(0, startIndex);
            String secondHalf = stops.substring(endIndex+1);

            stops = firstHalf + secondHalf;
        }

        return stops;
    }

    private static String addingASubstringInStops(String stops, String[] commandsData) {
        int index = Integer.parseInt(commandsData[1]);
        String substringToAdd = commandsData[2];

        if (index >= 0 && index < stops.length()) {
            String firstHalf = stops.substring(0, index);
            String secondHalf = stops.substring(index);

            stops = firstHalf + substringToAdd + secondHalf;
        }
        return stops;
    }


}
