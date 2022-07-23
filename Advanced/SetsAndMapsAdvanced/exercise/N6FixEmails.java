package SetsAndMapsAdvanced.exercise;

import java.util.*;

public class N6FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<String,String> emailsUsersMap = new LinkedHashMap<>();

        while(!input.equals("stop")){
            String email = scanner.nextLine();
            emailsUsersMap.putIfAbsent(input,email);

            input = scanner.nextLine();
        }
        printUsersAndEmails(emailsUsersMap);


    }

    private static void printUsersAndEmails(Map<String, String> emailsUsersMap) {
        for (var entry : emailsUsersMap.entrySet()) {
           List<String> emailData = Arrays.asList(entry.getValue().split("\\."));
           String extension = emailData.get(emailData.size()-1);

            if(!extension.equals("com") && !extension.equals("us") && !extension.equals("uk")) {
                System.out.println(entry.getKey() + " -> " + entry.getValue());
            }
        }
    }
}
