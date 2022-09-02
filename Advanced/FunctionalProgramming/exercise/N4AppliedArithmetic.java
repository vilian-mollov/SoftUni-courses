package FunctionalProgramming.exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class N4AppliedArithmetic {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        UnaryOperator<List<Integer>> addFunction = nums -> nums.stream().map(e -> e + 1).collect(Collectors.toList());
        UnaryOperator<List<Integer>> subtractFunction = nums -> nums.stream().map(e -> e - 1).collect(Collectors.toList());
        UnaryOperator<List<Integer>> multiplyFunction = nums -> nums.stream().map(e -> e * 2).collect(Collectors.toList());

        Consumer<List<Integer>> printer = list -> list.stream().forEach(e -> System.out.print(e + " "));

        String command = scanner.nextLine();
        while (!command.equals("end")) {

            numbers = getIntegers(numbers, addFunction, subtractFunction, multiplyFunction, printer, command);

            command = scanner.nextLine();
        }

    }

    private static List<Integer> getIntegers(List<Integer> numbers, UnaryOperator<List<Integer>> addFunction, UnaryOperator<List<Integer>> subtractFunction, UnaryOperator<List<Integer>> multiplyFunction, Consumer<List<Integer>> printer, String command) {

        switch (command) {
            case "add":
                numbers = addFunction.apply(numbers);
                break;
            case "multiply":
                numbers = multiplyFunction.apply(numbers);
                break;
            case "subtract":
                numbers = subtractFunction.apply(numbers);
                break;
            case "print":
                printer.accept(numbers);
                System.out.print(System.lineSeparator());
                break;
        }
        return numbers;
    }
}
