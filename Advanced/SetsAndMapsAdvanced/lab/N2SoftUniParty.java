package SetsAndMapsAdvanced.lab;

import java.util.*;

public class N2SoftUniParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<String> gests = new TreeSet<>();
        String input = scanner.nextLine();

        while (!input.equals("PARTY")) {
            gests.add(input);
            input = scanner.nextLine();
        }

        while (!input.equals("END")) {
            gests.remove(input);
            input = scanner.nextLine();
        }

        System.out.println(gests.size());
        for (String gest : gests) {
            System.out.println(gest);
        }


    }
}
