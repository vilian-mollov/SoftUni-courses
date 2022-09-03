package FunctionalProgramming.exercise;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class N10PredicateParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> namesList = Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList());

        String input = scanner.nextLine();

        while (!input.equals("Party!")) {
            String[] commandParts = input.split("\\s+");
            String command = commandParts[0];
            String commandDescription = commandParts[1];
            String value = commandParts[2];

            Predicate<String> predicate = getPredicate(commandParts);

            switch (command) {
                case "Remove":
                    namesList.removeIf(predicate);
                    break;
                case "Double":
                    List<String> namesToAdd = new ArrayList<>();
                    namesList.stream().filter(predicate).forEach(namesToAdd::add);
                    namesList.addAll(namesToAdd);
                    break;
            }
            input = scanner.nextLine();
        }


        if(namesList.isEmpty()){
            System.out.println("Nobody is going to the party!");
        } else {
            Collections.sort(namesList);
            String result = String.join(", ", namesList) + " are going to the party!";
            System.out.println(result);
        }
    }

    public static Predicate<String> getPredicate(String[] commandParts) {
        String command = commandParts[1];
        String value = commandParts[2];

        switch (command) {
            case "StartsWith":
                return name -> name.startsWith(value);
            case "EndsWith":
                return name -> name.endsWith(value);
            case "Length":
                return name -> name.length() == Integer.parseInt(value);
        }

        return null;
    }

}
