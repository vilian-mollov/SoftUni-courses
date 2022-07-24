package SetsAndMapsAdvanced.exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class N5Phonebook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<String, String> phonebook = new LinkedHashMap<>();

        while (!input.equals("search")) {
            String[] userData = input.split("-");
            String name = userData[0];
            String phone = userData[1];
            phonebook.put(name, phone);

            input = scanner.nextLine();
        }
        input = scanner.nextLine();

        while (!input.equals("stop")) {
            printResultOfSearch(input, phonebook);
            input = scanner.nextLine();
        }
    }

    private static void printResultOfSearch(String input, Map<String, String> phonebook) {
        if(phonebook.containsKey(input)){
            System.out.println(input +" -> "+ phonebook.get(input));
        }else{
            System.out.println("Contact "+ input +" does not exist.");
        }
    }
}
