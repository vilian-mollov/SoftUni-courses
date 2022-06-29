package RegularExpressions.lab;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class N1MatchFullName {
    public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);
        Pattern pattern = Pattern.compile("\\b[A-Z][a-z]+ [A-Z][a-z]+\\b");

        String text = scanner.nextLine();

        Matcher matcher = pattern.matcher(text);

        boolean isFound = matcher.find();
        while (isFound){
            System.out.print(matcher.group()+" ");
            isFound = matcher.find();
        }


    }
}
