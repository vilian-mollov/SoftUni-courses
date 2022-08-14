package PracticingForEXAM.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class TreasureFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> key = Arrays.asList(scanner.nextLine().split("\\s+"))
                .stream().map(Integer::parseInt).collect(Collectors.toList());

        List<String> strings = new ArrayList<>();
        String input = scanner.nextLine();
        while (!input.equals("find")) {
            strings.add(input);

            input = scanner.nextLine();
        }
        int keyLength = key.size();
        int index = 0;
        decryptTheCode(key, strings, keyLength, index);

        for (String string : strings) {
            String[] word = string.split("&");
            String[] coordinates = string.split("[<>]");
            System.out.println("Found "+word[1]+" at "+coordinates[1]);
        }

    }

    private static void decryptTheCode(List<Integer> key, List<String> strings, int keyLength, int index) {
        for (int i = 0; i < strings.size(); i++) {
            char[] textAsCharArr = strings.get(i).toCharArray();

            for (int charIndex = 0; charIndex < textAsCharArr.length; charIndex++) {
                if (index == keyLength) {
                    index = 0;
                }
                char symbol = textAsCharArr[charIndex];
                int value = symbol - key.get(index);
                textAsCharArr[charIndex] = (char) value;
                index++;
            }

            strings.set(i, String.valueOf(textAsCharArr));
            index =0;
        }
    }
}
