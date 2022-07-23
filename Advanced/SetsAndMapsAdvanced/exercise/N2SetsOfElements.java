package SetsAndMapsAdvanced.exercise;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class N2SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] initialInput = scanner.nextLine().split("\\s+");
        int[] lengths = new int[2];
        collect(initialInput, lengths);

        Set<Integer> firstSet = new LinkedHashSet<>();
        Set<Integer> secondSet = new LinkedHashSet<>();
        fillSets(scanner, lengths, firstSet, secondSet);

        Set<Integer> result = new LinkedHashSet<>();
        result = fillResult(firstSet, secondSet, result);

        printResult(result);


    }

    private static void printResult(Set<Integer> result) {
        for (Integer integer : result) {
            System.out.print(integer + " ");
        }
    }

    private static void fillSets(Scanner scanner, int[] lengths, Set<Integer> firstSet, Set<Integer> secondSet) {
        for (int i = 0; i < lengths[0] + lengths[1]; i++) {
            int n = Integer.parseInt(scanner.nextLine());
            if (i + 1 <= lengths[0]) {
                firstSet.add(n);
            } else {
                secondSet.add(n);
            }
        }
    }

    private static Set<Integer> fillResult(Set<Integer> firstSet, Set<Integer> secondSet, Set<Integer> result) {
        for (Integer integer : firstSet) {
            if (secondSet.contains(integer)) {
                result.add(integer);
            }
        }
        return result;
    }

    private static int checkTheLength(int[] lengths) {
        int shortLength;
        if (lengths[0] >= lengths[1]) {
            shortLength = lengths[1];
        } else {
            shortLength = lengths[0];
        }
        return shortLength;
    }

    private static void collect(String[] initialInput, int[] lengths) {
        lengths[0] = Integer.parseInt(initialInput[0]);
        lengths[1] = Integer.parseInt(initialInput[1]);
    }
}
