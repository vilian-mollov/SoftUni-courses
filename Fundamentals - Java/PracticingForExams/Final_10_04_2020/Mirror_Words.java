package PracticingForEXAM_10_04_2020;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Mirror_Words {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        List<String> pairs = new ArrayList<>();
        List<String> mirror = new ArrayList<>();

        Pattern pattern = Pattern.compile("([@#])[A-Za-z]{3,}\\1\\1[A-Za-z]{3,}\\1");
        Matcher matcher = pattern.matcher(input);

        boolean isFound = matcher.find();

        while (isFound) {
            String pair = matcher.group();
            pairs.add(pair);

            isFound = matcher.find();
        }
        if (!pairs.isEmpty()) {
            for (String pair : pairs) {
                String[] onePair = pair.split("[@#]+");
                String first = onePair[1];
                String second = onePair[2];
                String toCheck = new StringBuilder(second).reverse().toString();
                if (first.equals(toCheck)) {
                    mirror.add(pair);
                }
            }

        }
        if (pairs.isEmpty()) {
            System.out.println("No word pairs found!");
            System.out.println("No mirror words!");
            return;
        }

        System.out.println(pairs.size() + " word pairs found!");
        if (mirror.isEmpty()) {
            System.out.println("No mirror words!");
            return;
        }
        System.out.println("The mirror words are:");
        for (int i = 0; i < mirror.size(); i++) {
            String words = mirror.get(i);
            String[] arr = words.split("[@#]+");
           String first = arr[1];
           String second = arr[2];
            if (i == mirror.size() - 1) {
                System.out.print(first + " <=> " + second);
                break;
            }

            System.out.print(first + " <=> " + second + ", ");


        }


    }
}
