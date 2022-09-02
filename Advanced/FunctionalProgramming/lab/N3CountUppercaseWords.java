package FunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class N3CountUppercaseWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();

        Predicate<String> findUpperCaseWords = word -> !word.equals(word.toLowerCase());

        List<String> UpperCaseWords = Arrays.stream(text.split("\\s+"))
                .filter(findUpperCaseWords)
                .collect(Collectors.toList());

        System.out.println(UpperCaseWords.size());
        UpperCaseWords.stream().forEach(System.out::println);


    }
}
