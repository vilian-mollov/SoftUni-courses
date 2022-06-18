package AssociativeArraysLambdaAndStreamAPI;

import java.text.DecimalFormat;
import java.util.*;

public class N1 {
    public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);
        Map<Double , Integer> myMap = new TreeMap<>();
        String[] data = scanner.nextLine().split("\\s+");
        List<Double> numbers = new ArrayList<Double>();
        setTheNumbersList(data, numbers);

        for (Double number : numbers) {

          if(!myMap.containsKey(number)) {
              myMap.put(number,0);
          }
              myMap.put(number,myMap.get(number)+1);
        }

        for (Map.Entry<Double, Integer> entry : myMap.entrySet()) {
            DecimalFormat df = new DecimalFormat("#.######");
            System.out.printf("%s -> %d%n",df.format(entry.getKey()), entry.getValue());
        }


    }

    private static void setTheNumbersList(String[] data, List<Double> numbers) {
        for (int i = 0; i < data.length; i++) {
            numbers.add(Double.parseDouble(data[i]));
        }
    }
}