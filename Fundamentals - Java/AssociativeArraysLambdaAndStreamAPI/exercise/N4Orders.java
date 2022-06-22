package AssociativeArraysLambdaAndStreamAPI.exercise;

import java.util.*;

public class N4Orders {
    public static void main(String[] args) {
        Map<String, List<Double>> productMap = new LinkedHashMap<>();
                Scanner scanner = new Scanner(System.in);
String input = scanner.nextLine();

        while (!input.equals("buy")) {
            String[] productInfo = input.split("\\s+");
            String productName = productInfo[0];
            double price = Double.parseDouble(productInfo[1]);
            double quantity = Double.parseDouble(productInfo[2]);

            if (!productMap.containsKey(productName)) {
                productMap.put(productName,new ArrayList<>(Arrays.asList(0.0,0.0)));
            }

            double currentQuantity = productMap.get(productName).get(1)+quantity;
            List <Double> resultList = new ArrayList<>(Arrays.asList(price,currentQuantity));
            productMap.put(productName,resultList);

//price,productMap.get(productName).get(1)+quantity)
            input = scanner.nextLine();
        }


        for (Map.Entry<String, List<Double>> entry : productMap.entrySet()) {
            System.out.printf("%s -> %.2f%n",entry.getKey(),entry.getValue().get(0) * entry.getValue().get(1));
        }


        //"{productName} -> {totalPrice}"
        //Format the average total price to the 2nd decimal place.
    }
}

