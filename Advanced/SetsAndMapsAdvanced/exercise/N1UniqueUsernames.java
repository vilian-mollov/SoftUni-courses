package SetsAndMapsAdvanced.exercise;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class N1UniqueUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<String> usernames = new LinkedHashSet<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String username = scanner.nextLine();
            usernames.add(username);
        }

        for (String user : usernames) {
            System.out.println(user);
        }
    }
}
