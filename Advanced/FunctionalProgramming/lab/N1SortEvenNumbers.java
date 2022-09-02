package FunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class N1SortEvenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

       List<Integer> numbers = Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .filter(n -> n % 2 ==0)
                .collect(Collectors.toList());


        String result = numbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));

        System.out.println(result);

        List<Integer> integersSorted = Arrays.stream(result.split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        System.out.println(integersSorted.stream()
                .sorted()
                .map(String::valueOf)
                .collect(Collectors.joining(", ")));


    }
}