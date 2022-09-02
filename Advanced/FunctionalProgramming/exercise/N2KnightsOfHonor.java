package FunctionalProgramming.exercise;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class N2KnightsOfHonor {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] knights = scanner.nextLine().split("\\s+");

        Consumer<String> consumer = k -> System.out.println("Sir " + k);


        Arrays.stream(knights)
                .forEach(consumer);

    }
}
