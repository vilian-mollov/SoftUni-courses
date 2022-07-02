package RegularExpressions.lab;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class N3MatchDates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String datesStrings = scanner.nextLine();
        String regEx = "\\b(?<Days>\\d{2})([.\\-/])(?<Month>[A-Z][a-z]{2})\\2(?<Year>\\d{4})\\b";
        Pattern pattern = Pattern.compile(regEx);
        Matcher dates = pattern.matcher(datesStrings);

        while(dates.find()){
            String day = dates.group("Days");
            String month = dates.group("Month");
            String year = dates.group("Year");

            System.out.printf("Day: %s, Month: %s, Year: %s\n",day,month,year);
        }

    }
}
