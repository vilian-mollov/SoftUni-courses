package RegularExpressions.lab;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class N2MatchPhoneNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        Pattern pattern = Pattern.compile("\\+359([\\s-])2\\1\\d{3}\\1\\d{4}\\b");
        Matcher matcher = pattern.matcher(text);
        boolean isFound = matcher.find();
        while(isFound){
            System.out.print(matcher.group());
            isFound = matcher.find();
            if(isFound) {
                System.out.print(", ");
            }
        }

    }
}
