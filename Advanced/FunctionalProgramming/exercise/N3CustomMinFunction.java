package FunctionalProgramming.exercise;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class N3CustomMinFunction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());


        Function<List<Integer>, Integer > function = nums -> nums.stream()
                .mapToInt(e -> e)
                .min().orElseThrow(NoSuchElementException::new);

        Integer theSmallestNumber = function.apply(numbers);

        System.out.println(theSmallestNumber);


    }
}
