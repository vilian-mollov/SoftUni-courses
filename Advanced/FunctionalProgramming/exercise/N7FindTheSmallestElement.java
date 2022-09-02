package FunctionalProgramming.exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class N7FindTheSmallestElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Function<List<Integer>, Integer> findIndexOfTheSmallestInteger = list -> getIndexMethod(list);

            int index = findIndexOfTheSmallestInteger.apply(numbers);

        System.out.println(index);
    }

    private static Integer getIndexMethod(List<Integer> list) {
        int minValue = Integer.MAX_VALUE;
        int minIndex = -1;

        for (int i = 0; i < list.size(); i++) {

            if (list.get(i) <= minValue) {
                minValue = list.get(i);
                minIndex = i;
            }

        }

        return minIndex;

    }
}
