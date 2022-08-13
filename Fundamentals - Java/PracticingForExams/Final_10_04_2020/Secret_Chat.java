package PracticingForEXAM_10_04_2020;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Secret_Chat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String concealedMessage = scanner.nextLine();

        String input = scanner.nextLine();
        while (!input.equals("Reveal")) {
            String[] commandsInfo = input.split(":\\|:");
            String command = commandsInfo[0];

            switch (command) {
                case "InsertSpace":
                    int index = Integer.parseInt(commandsInfo[1]);
                    StringBuilder sb = new StringBuilder(concealedMessage);
                    sb.insert(index, " ");
                    concealedMessage = sb.toString();
                    System.out.println(concealedMessage);
                    break;
                case "Reverse":
                    String substring = commandsInfo[1];
                    if (concealedMessage.contains(substring)) {
                        String forReplace = new StringBuilder(substring).reverse().toString();
                        concealedMessage = concealedMessage.replaceFirst(Pattern.quote(substring),"")+forReplace;

                        System.out.println(concealedMessage);
                    } else {
                        System.out.println("error");
                    }
                    break;
                case "ChangeAll":
                    String substringToReplace = commandsInfo[1];
                    String replacement = commandsInfo[2];
                    concealedMessage = concealedMessage.replaceAll(substringToReplace,replacement);
                    System.out.println(concealedMessage);
                    break;
            }
            input = scanner.nextLine();
        }
        System.out.println("You have a new text message: "+ concealedMessage);

    }

}
