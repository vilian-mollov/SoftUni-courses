package PracticingForEXAM_04_04_2020;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FancyBarcodes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        List<String> barcodes = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String text = scanner.nextLine();
            Pattern pattern = Pattern.compile("^@#+[A-Z][A-Za-z\\d]{4,}[A-Z]@#+$");
            Matcher matcher = pattern.matcher(text);
            boolean isFound = matcher.find();
            if(isFound){
                String barcode = matcher.group();
                Pattern patternOne = Pattern.compile("\\d");
                Matcher matcherOne = patternOne.matcher(barcode);
                boolean isFoundDigit = matcherOne.find();
                String digits ="";
                if(!isFoundDigit){
                    digits = "00";
                    System.out.println("Product group: "+digits);
                    continue;
                }
                while (isFoundDigit){
                   digits = digits.concat(matcherOne.group());
                    isFoundDigit = matcherOne.find();
                }
                System.out.println("Product group: "+digits);
            }else{
                System.out.println("Invalid barcode");
            }
        }


    }
}
