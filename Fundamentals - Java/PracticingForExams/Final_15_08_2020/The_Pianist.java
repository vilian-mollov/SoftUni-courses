package ExamTraining.Final_15_08_2020;

import java.util.*;

public class The_Pianist {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        Map<String, List<String>> mapOfPiecesAuthorsAndKeys = new LinkedHashMap<>();
        fillTheMapOfPiecesAuthorsAndKeys(scanner, n, mapOfPiecesAuthorsAndKeys);

        String commands = scanner.nextLine();

        while (!commands.equals("Stop")) {
            String[] commandsSeparated = commands.split("[\\|]");
            String theCommand = commandsSeparated[0];
            String piece = commandsSeparated[1];

            switch (theCommand) {
                case "Add":
                    String composer = commandsSeparated[2];
                    String key = commandsSeparated[3];
                    addOperations(mapOfPiecesAuthorsAndKeys, piece, composer, key);
                    break;
                case "Remove":
                    removeOperations(mapOfPiecesAuthorsAndKeys, piece);
                    break;
                case "ChangeKey":
                    changeKeyOperations(mapOfPiecesAuthorsAndKeys, commandsSeparated, piece);
                    break;
            }
            commands = scanner.nextLine();
        }

        printTheWholeMapOfPicesAuthorsAndKeys(mapOfPiecesAuthorsAndKeys);
    }

    private static void printTheWholeMapOfPicesAuthorsAndKeys(Map<String, List<String>> mapOfPiecesAuthorsAndKeys) {
        for (var entry : mapOfPiecesAuthorsAndKeys.entrySet()) {
            String composer = entry.getValue().get(0);
            String key = entry.getValue().get(1);
            System.out.print(entry.getKey()+" -> Composer: "+composer+", Key: "+key);

            System.out.print(System.lineSeparator());
        }
    }

    private static void fillTheMapOfPiecesAuthorsAndKeys(Scanner scanner, int n, Map<String, List<String>> mapOfPiecesAuthorsAndKeys) {
        for (int i = 0; i < n; i++) {
            String data = scanner.nextLine();
            String[] dataSeparated = data.split("[\\|]");
            String piece = dataSeparated[0];
            String author =dataSeparated[1];
            String key =dataSeparated[2];

            mapOfPiecesAuthorsAndKeys.putIfAbsent(piece, new ArrayList<>());
            mapOfPiecesAuthorsAndKeys.get(piece).add(author);
            mapOfPiecesAuthorsAndKeys.get(piece).add(key);
        }
    }

    private static void addOperations(Map<String, List<String>> mapOfPiecesAuthorsAndKeys, String piece, String composer, String key) {
        if (mapOfPiecesAuthorsAndKeys.containsKey(piece)) {
            System.out.println(piece + " is already in the collection!");
        } else {
            mapOfPiecesAuthorsAndKeys.put(piece, new ArrayList<>());
            mapOfPiecesAuthorsAndKeys.get(piece).add(composer);
            mapOfPiecesAuthorsAndKeys.get(piece).add(key);
            System.out.println(piece + " by " + composer + " in " + key + " added to the collection!");
        }
    }

    private static void changeKeyOperations(Map<String, List<String>> mapOfPiecesAuthorsAndKeys, String[] commandsSeparated, String piece) {
        if (!mapOfPiecesAuthorsAndKeys.containsKey(piece)) {
            System.out.println("Invalid operation! " + piece + " does not exist in the collection.");
        } else {
            mapOfPiecesAuthorsAndKeys.get(piece).remove(1);
            mapOfPiecesAuthorsAndKeys.get(piece).add(commandsSeparated[2]);
            System.out.println("Changed the key of " + piece + " to " + commandsSeparated[2] + "!");
        }
    }

    private static void removeOperations(Map<String, List<String>> mapOfPiecesAuthorsAndKeys, String piece) {
        if (!mapOfPiecesAuthorsAndKeys.containsKey(piece)) {
            System.out.println("Invalid operation! " + piece + " does not exist in the collection.");
        } else {
            mapOfPiecesAuthorsAndKeys.remove(piece);
            System.out.println("Successfully removed "+ piece +"!");
        }
    }
}
