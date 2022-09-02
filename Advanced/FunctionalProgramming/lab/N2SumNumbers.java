package FunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class N2SumNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Function<List<Integer>, String> countFormatter = list -> String.format("Count = " + list.size());
        Function<List<Integer>, Integer> sumAllElements = list -> list.stream().mapToInt(e -> e).sum();

        Function<Integer, String> sumFormatter = num -> "Sum = " + num;

        System.out.println(countFormatter.apply(numbers));

        String sumOutput = sumFormatter.apply(sumAllElements.apply(numbers));
        System.out.println(sumOutput);

    }
}
