package TextProcessing.lab;

import java.util.*;

public class N5DigitsLettersAndOther {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();

        List<Integer> digit = new ArrayList<>();
        List<String> letters = new ArrayList<>();
        List<String> symbols = new ArrayList<>();

        StringBuilder currentNumber = new StringBuilder();
        StringBuilder currentLetter = new StringBuilder();
        StringBuilder currentSymbol = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            if(text.charAt(i)>=48 && text.charAt(i)<=57){
                currentNumber.append(text.charAt(i));
            }else if(text.charAt(i)>=65 && text.charAt(i)<=90 || text.charAt(i)>=97 && text.charAt(i)<=122){
                currentLetter.append(text.charAt(i));
                }else if(text.charAt(i)>=32 && text.charAt(i)<=47 || text.charAt(i)>=58 && text.charAt(i)<=64 || text.charAt(i)>=91 && text.charAt(i)<=96 || text.charAt(i)>=123 && text.charAt(i)<=127){
                currentSymbol.append(text.charAt(i));
            }
            if(currentLetter.length()>0) {
                letters.add(currentLetter.toString());
                currentLetter.setLength(0);
            }
            if(currentNumber.length()>0) {
                digit.add(Integer.parseInt(currentNumber.toString()));
                currentNumber.setLength(0);

            }
            if(currentSymbol.length()>0){
                symbols.add(currentSymbol.toString());
                currentSymbol.setLength(0);
            }
        }
        if(currentNumber.length()>0){
            digit.add(Integer.parseInt(currentNumber.toString()));
        }
        if(currentLetter.length()>0){
            letters.add(currentLetter.toString());
        }
        if(currentSymbol.length()>0){
            symbols.add(currentSymbol.toString());
        }

        for (Integer num : digit) {
            System.out.print(num);
        }
        System.out.println();
        for (String s : letters) {
            System.out.print(s);
        }
        System.out.println();
        for (String symbol : symbols) {
            System.out.print(symbol);
        }


    }
}
