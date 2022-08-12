package ExamTraining.Final_09_08_2020;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DestinationMapper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        Pattern pattern = Pattern.compile("([=/])[A-Z][A-Za-z_]{2,}\\1");
        Matcher matcher = pattern.matcher(input);

        boolean isFound = matcher.find();

        List<String> destinations = new ArrayList<>();

        while (isFound) {
            String destination = matcher.group();
            destination = destination.substring(1, destination.length() - 1);
            destinations.add(destination);

            isFound = matcher.find();
        }

        long points = 0;
        System.out.print("Destinations: ");

        if(!destinations.isEmpty()) {
            points = calculatePoints(destinations);
            String destinationsText = String.join(", ", destinations);
            System.out.println(destinationsText);
        }else{
            System.out.println();
        }

        System.out.println("Travel Points: " + points);
    }

    private static long calculatePoints(List<String> destinations) {
        long points = 0;

        for (String s : destinations) {
            points += s.length();
        }
        return points;
    }
}
