package AssociativeArraysLambdaAndStreamAPI.lab;

import java.util.*;
import java.util.stream.Collectors;

public class N3OddOccurrences {
    public static void main(String[] args) {
        List<String> data = Arrays.asList(new Scanner(System.in).nextLine().split(" "));

        Map<String, Integer> myMap = new LinkedHashMap<>();
        data = data.stream()
                .map(String::toLowerCase)
                .collect(Collectors.toList());
        for (String s : data) {
            if (!myMap.containsKey(s)) {
                myMap.put(s, 0);
            }
            myMap.put(s, myMap.get(s) + 1);

        }
List<String> odds = new ArrayList<>();
        collectOdds(myMap, odds);
        printResult(odds);


    }

    private static void collectOdds(Map<String, Integer> myMap, List<String> odds) {
        for (Map.Entry<String, Integer> entry : myMap.entrySet()) {
                if (entry.getValue() % 2 != 0) {
                   odds.add(entry.getKey());
                }
            }
    }

    private static void printResult(List<String> odds) {
        for (int i = 0; i< odds.size(); i++) {
            System.out.print(odds.get(i));
            if(i< odds.size()-1){
                System.out.print(", ");
            }
        }
    }


}


