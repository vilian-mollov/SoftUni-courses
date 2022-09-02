package FunctionalProgramming.exercise;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class N1ConsumerPrint {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println();

        String[] stringArr = scanner.nextLine().split("\\s+");

        Consumer<String> consumer = System.out::println;

        Arrays.stream(stringArr)
                .forEach(consumer);

    }
}
