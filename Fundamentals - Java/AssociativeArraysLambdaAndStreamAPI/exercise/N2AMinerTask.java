package AssociativeArraysLambdaAndStreamAPI.exercise;

import java.util.*;

public class N2AMinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
       String mineral = scanner.nextLine();
       int quantity = Integer.parseInt(scanner.nextLine());

Map<String,Integer> myMap = new LinkedHashMap<>();

        while (!mineral.equals("stop")){
            if(!myMap.containsKey(mineral)){
                myMap.put(mineral,0);
            }
            myMap.put(mineral,myMap.get(mineral)+quantity);

            mineral = scanner.nextLine();
            if(mineral.equals("stop")){
                break;
            }
            quantity = Integer.parseInt(scanner.nextLine());

        }
        for (Map.Entry<String, Integer> entry : myMap.entrySet()) {
            System.out.println(entry.getKey()+" -> "+entry.getValue());
        }

// "{resource} –> {quantity}".
    }
}
