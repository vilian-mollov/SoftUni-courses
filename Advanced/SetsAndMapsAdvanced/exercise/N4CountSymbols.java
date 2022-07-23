package SetsAndMapsAdvanced.exercise;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class N4CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputText = scanner.nextLine();
        char[] charArr = inputText.toCharArray();
        Map<Character, Integer> listOfElements = new TreeMap<>();

        for (char c : charArr) {
            listOfElements.putIfAbsent(c,0);
            listOfElements.put(c,listOfElements.get(c)+1);
        }
        for (Map.Entry<Character, Integer> entry : listOfElements.entrySet()) {
            System.out.println(entry.getKey()+": "+entry.getValue()+" time/s");
        }


    }
}
