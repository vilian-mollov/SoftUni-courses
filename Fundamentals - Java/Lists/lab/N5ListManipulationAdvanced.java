package List.lab;

import java.util.List;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class N5ListManipulationAdvanced {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String text = input.replaceAll(" ", " ");
//2 13 43 876 342 23 543
        List<Integer> listOfNumbers = Arrays.stream(text.split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());
        String commands = scanner.nextLine();
        while (!commands.equals("end")) {
            String[] commandsSplitted = commands.split("\\s+");

            switch (commandsSplitted[0]) {

                case "Contains":
                    if (listOfNumbers.contains((Integer) Integer.parseInt(commandsSplitted[1]))) {
                        System.out.println("Yes");
                    } else {
                        System.out.println("No such number");
                    }
                    break;
                case "Print":

                    if (commandsSplitted[1].equals("even")) {
                        for (int i = 0; i < listOfNumbers.size(); i++) {
                            if (listOfNumbers.get(i) % 2 == 0) {
                                System.out.print(listOfNumbers.get(i) + " ");
                            }
                        }
                        System.out.println();
                    } else if (commandsSplitted[1].equals("odd")) {
                        for (int i = 0; i < listOfNumbers.size(); i++) {
                            if (listOfNumbers.get(i) % 2 != 0) {
                                System.out.print(listOfNumbers.get(i) + " ");
                            }
                        }
                        System.out.println();
                    }
                    break;
                case "Get":
                    if (commandsSplitted[1].equals("sum")) {
                        int sum = 0;
                        for (int i = 0; i < listOfNumbers.size(); i++) {
                            sum += listOfNumbers.get(i);
                        }
                        System.out.println(sum);
                    }
                    break;
                case "Filter":
                    if (commandsSplitted[1].equals("<")) {
                        for (int i = 0; i < listOfNumbers.size(); i++) {
                            if (listOfNumbers.get(i) < Integer.parseInt(commandsSplitted[2])) {
                                System.out.print(listOfNumbers.get(i) + " ");
                            }
                        }
                        System.out.println();

                    } else if (commandsSplitted[1].equals(">")) {
                        for (int i = 0; i < listOfNumbers.size(); i++) {
                            if (listOfNumbers.get(i) > Integer.parseInt(commandsSplitted[2])) {
                                System.out.print(listOfNumbers.get(i) + " ");
                            }
                        }
                        System.out.println();

                    } else if (commandsSplitted[1].equals(">=")) {
                        for (int i = 0; i < listOfNumbers.size(); i++) {
                            if (listOfNumbers.get(i) >= Integer.parseInt(commandsSplitted[2])) {
                                System.out.print(listOfNumbers.get(i) + " ");
                            }
                        }
                        System.out.println();

                    } else if (commandsSplitted[1].equals("<=")) {
                        for (int i = 0; i < listOfNumbers.size(); i++) {
                            if (listOfNumbers.get(i) <= Integer.parseInt(commandsSplitted[2])) {
                                System.out.print(listOfNumbers.get(i) + " ");
                            }
                        }
                        System.out.println();
                    }
                    break;

            }

            commands = scanner.nextLine();
        }

    }
}
