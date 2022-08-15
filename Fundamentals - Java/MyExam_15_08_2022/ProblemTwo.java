package Exam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProblemTwo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            Pattern pattern = Pattern.compile("([*@])[A-Z][a-z]{2,}\\1: \\[[A-Za-z]]\\|\\[[A-Za-z]]\\|\\[[A-Za-z]]\\|$");
            Matcher matcher = pattern.matcher(input);
            boolean isFound = matcher.find();

            if(isFound){
                String foundedMessage = matcher.group();
                String[] messageSplitted = foundedMessage.split(": ");
                String tag = messageSplitted[0].substring(1,messageSplitted[0].length()-1);

                Pattern newPattern = Pattern.compile("\\w");
                Matcher newMatcher = newPattern.matcher(messageSplitted[1]);

                boolean isFoundNew = newMatcher.find();
                List<String> asciiCodes = new ArrayList<>();
                while (isFoundNew){
                    asciiCodes.add(newMatcher.group());
                isFoundNew = newMatcher.find();
                }
                System.out.print(tag+": ");
                for (int j = 0; j < asciiCodes.size(); j++) {
                   int code = asciiCodes.get(j).charAt(0);
                    System.out.print(code+" ");
                }
                System.out.println();

            }else{
                System.out.println("Valid message not found!");
            }



        }
    }
}
