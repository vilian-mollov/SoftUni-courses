package ExamTraining.Final_15_08_2020;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ad_Astra {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String data = scanner.nextLine();
        List<String> listOfItemsAndData = new ArrayList<>();

        Pattern pattern = Pattern.compile("([#?\\|?]{1})[a-zA-Z\\s]+\\1[\\d]{2}\\/[\\d]{2}\\/[\\d]{2}\\1[\\d]{1,5}\\1");
        Matcher matcher = pattern.matcher(data);
        fillTheListOfItemsAndData(listOfItemsAndData, matcher);

        System.out.printf("You have food to last you for: %d days!\n", getTotalCalories(listOfItemsAndData) / 2000);

        List<String> items = new ArrayList<>();
        fillItels(listOfItemsAndData, items);

        int count = items.size() / 3;
        int index = 0;
        for (int i = 0; i < count; i++) {
            System.out.printf("Item: %s, Best before: %s, Nutrition: %s\n", items.get(index), items.get(index + 1), items.get(index + 2));
            index += 3;
        }


    }

    private static void fillItels(List<String> listOfItemsAndData, List<String> items) {
        for (String s : listOfItemsAndData) {
            String[] arr = s.split("[#?\\|?]");
            String item = arr[1];
            String date = arr[2];
            String calories = arr[3];
            items.add(item);
            items.add(date);
            items.add(calories);
        }
    }

    private static int getTotalCalories(List<String> listOfItemsAndData) {
        int totalCalories = 0;
        for (String s : listOfItemsAndData) {
            s = s.trim();
            String[] arr = s.split("[#?\\|?]");
            totalCalories += Integer.parseInt(arr[3]);
        }
        return totalCalories;
    }

    private static void fillTheListOfItemsAndData(List<String> listOfItemsAndData, Matcher matcher) {
        boolean isFound = matcher.find();
        while (isFound) {
            listOfItemsAndData.add(matcher.group());
            isFound = matcher.find();
        }
    }
}
