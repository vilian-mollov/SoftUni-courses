package SetsAndMapsAdvanced.lab;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class N4CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<Double, Integer> myMap = new LinkedHashMap<>();

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToDouble(Double::parseDouble)
                .forEach(key -> {

                    if (myMap.containsKey(key)) {
                        int oldCount = myMap.get(key);
                        int newCount = oldCount + 1;
                        myMap.put(key, newCount);
                    } else {
                        myMap.put(key, 1);
                    }

                });
        for (var entry : myMap.entrySet()) {
            System.out.println(String.format("%.1f -> %d", entry.getKey(), entry.getValue()));
        }
    }
}