package ExamTraining.Final_15_08_2020;

import java.util.Scanner;

public class The_Imitation_Game {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String message = scanner.nextLine();

        StringBuilder sb = new StringBuilder();
        sb = sb.append(message);
        String input = scanner.nextLine();

        while (!input.equals("Decode")) {
            String[] data = input.split("\\|");
            String command = data[0];
            switch (command) {
                case "Move":
                    int firstLettersToMove = Integer.parseInt(data[1]);
                    String letters = sb.substring(0, firstLettersToMove);
                    sb.delete(0, firstLettersToMove);
                    sb.append(letters);

                    break;
                case "Insert":
                    int index = Integer.parseInt(data[1]);
                    String valueToInsert = data[2];
                    sb.insert(index, valueToInsert);

                    break;
                case "ChangeAll":
                    String toChange = data[1];
                    String changeWith = data[2];
                    int indexOfSubstring = sb.indexOf(toChange);
                    int lastIndexOfSubstring = indexOfSubstring + toChange.length();
                    while (indexOfSubstring >= 0) {
                        sb.replace(indexOfSubstring, lastIndexOfSubstring, changeWith);

                        indexOfSubstring = sb.indexOf(toChange);
                        lastIndexOfSubstring = indexOfSubstring + toChange.length();
                    }


                    break;
            }

            input = scanner.nextLine();
        }

        //todo print the message
        System.out.println("The decrypted message is: " + sb.toString());
    }
}
